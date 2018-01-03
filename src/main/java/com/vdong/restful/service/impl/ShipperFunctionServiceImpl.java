package com.vdong.restful.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vdong.admin.model.AllTraces;
import com.vdong.admin.model.LogisticForm;
import com.vdong.admin.model.Shipper;
import com.vdong.admin.model.ShipperApplication;
import com.vdong.admin.model.enums.State;
import com.vdong.admin.service.LogisticFormService;
import com.vdong.admin.service.ShipperApplicationService;
import com.vdong.admin.service.ShipperService;
import com.vdong.restful.async.LogisticFormAsync;
import com.vdong.restful.response.AllTracesRequest;
import com.vdong.restful.response.LogisticFormRequest;
import com.vdong.restful.response.Response;
import com.vdong.restful.service.ShipperFunctionService;
import com.vdong.restful.staticVariable.GlobalStaticVariable;
import com.vdong.supplier.request.supplierbird.EbusinessOrderHandleRequest;
import com.vdong.supplier.request.supplierbird.EbusinessOrderHandleRequestDataRequest;
import com.vdong.supplier.response.supplierbird.EbusinessOrderHandleResponse;
import com.vdong.supplier.response.supplierbird.Traces;
import com.vdong.supplier.service.supplierbird.PostQueryClassService;

@Service
public class ShipperFunctionServiceImpl implements ShipperFunctionService {

	@Autowired
	private PostQueryClassService postQueryClassService;
	@Autowired
	private ShipperService shipperService;
	@Autowired
	private ShipperApplicationService shipperApplicationService;
	@Value("${kuaidn.requestType}")
	private String requestType;
	@Autowired
	private LogisticFormService logisticFormService;
	@Autowired
	private LogisticFormAsync logisticFormAsync;

	@Override

	public Response trajectoryQuery(String logisticsNumber, int shipperId) {
		ShipperApplication shipperApplication = shipperApplicationService.findById(1);
		Shipper shipper = shipperService.findById(shipperId);
		LogisticForm logisticForm = logisticFormService.findByShipperIdAndLogisticCode(shipperId, logisticsNumber);

		if (shipper != null) {
			if (shipper.getTrajectoryQuery() == State.OFF) {
				return Response.failMessage(GlobalStaticVariable.NO, "该快递公司不支持该接口功能");
			}

			if (logisticForm == null) // 快递鸟查询
			{

				EbusinessOrderHandleRequestDataRequest ebusinessOrderHandleRequestDataRequest = new EbusinessOrderHandleRequestDataRequest(
						"", shipper.getCode(), logisticsNumber);
				EbusinessOrderHandleRequest ebusinessOrderHandleRequest = new EbusinessOrderHandleRequest(
						ebusinessOrderHandleRequestDataRequest, shipperApplication.getAppid(), requestType,
						shipperApplication.getAppkey(), "2");
				EbusinessOrderHandleResponse e = postQueryClassService
						.EbusinessOrderHandle(ebusinessOrderHandleRequest);

				if (e != null) {
					LogisticFormRequest logisticFormRequest = new LogisticFormRequest();
					if (e.getState().equals("3"))// 已签收的数据保存
					{
						logisticForm = new LogisticForm();

						// BeanUtils.copyProperties(source, target);
						logisticForm.setLogisticCode(e.getLogisticCode());
						logisticForm.setShipperName(shipper.getName());
						logisticForm.setState(e.getState());
						logisticForm.setShipperId(shipperId);
						logisticForm.setCreateTime(LocalDateTime.now());
						logisticForm.setId(e.getLogisticCode() + shipperId);
						List<AllTraces> ls = new ArrayList<AllTraces>();
						for (Traces traces : e.getTraces()) {
							AllTraces allTraces = new AllTraces();
							allTraces.setAcceptStation(traces.getAcceptStation());
							allTraces.setAcceptTime(traces.getAcceptTime());
							allTraces.setLogisticFormId(e.getLogisticCode() + shipperId);
							ls.add(allTraces);
						}
						logisticForm.setTraces(ls);
						logisticFormAsync.saveLogisticForm(logisticForm);

					}
					logisticFormRequest.setId(e.getLogisticCode() + shipperId);
					List<AllTracesRequest> lsalTracesRequest = new ArrayList<AllTracesRequest>();

					for (Traces traces : e.getTraces()) {
						AllTracesRequest alTracesRequest = new AllTracesRequest();
						alTracesRequest.setAcceptStation(traces.getAcceptStation());
						alTracesRequest.setAcceptTime(traces.getAcceptTime());

						lsalTracesRequest.add(alTracesRequest);
					}

					logisticFormRequest.setLogisticCode(e.getLogisticCode());
					logisticFormRequest.setShipperId(shipperId);
					logisticFormRequest.setShipperName(shipper.getName());
					logisticFormRequest.setState(e.getState());
					logisticFormRequest.setTraces(lsalTracesRequest);
					return Response.successBean(logisticFormRequest);

				} else {
					return Response.failMessage(GlobalStaticVariable.EXCEPTION, "网络异常或不支持该业务查询");
				}

			} else {

				List<AllTracesRequest> lsalTracesRequest = new ArrayList<AllTracesRequest>();
				for (AllTraces traces : logisticForm.getTraces()) {
					AllTracesRequest alTracesRequest = new AllTracesRequest();
					alTracesRequest.setAcceptStation(traces.getAcceptStation());
					alTracesRequest.setAcceptTime(traces.getAcceptTime());

					lsalTracesRequest.add(alTracesRequest);
				}
				LogisticFormRequest logisticFormRequest = new LogisticFormRequest();
				logisticFormRequest.setLogisticCode(logisticForm.getLogisticCode());
				logisticFormRequest.setShipperId(shipperId);
				logisticFormRequest.setShipperName(shipper.getName());
				logisticFormRequest.setState(logisticForm.getState());
				logisticFormRequest.setTraces(lsalTracesRequest);
				logisticFormRequest.setId(logisticForm.getId());
				return Response.successBean(logisticFormRequest);
			}
		} else {

			return Response.failMessage(GlobalStaticVariable.EXCEPTION, "无该 shipperId ");

		}
	}

}
