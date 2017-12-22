package com.vdong.restful.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdong.admin.model.Shipper;
import com.vdong.admin.model.Template;
import com.vdong.admin.model.TemplateArea;
import com.vdong.admin.model.TemplateCarryMode;
import com.vdong.admin.model.enums.Mode;
import com.vdong.admin.model.enums.State;
import com.vdong.admin.service.ShipperService;
import com.vdong.admin.service.TemplateService;
import com.vdong.restful.request.OrderInformationRequest;
import com.vdong.restful.request.TemplateAreaRequest;
import com.vdong.restful.request.TemplateCarryModeRequest;
import com.vdong.restful.request.TemplateRequest;
import com.vdong.restful.response.ExceptionMessage;
import com.vdong.restful.response.OrderFreightReponse;
import com.vdong.restful.response.Response;
import com.vdong.restful.service.TemplateApiService;
import com.vdong.restful.staticVariable.GlobalStaticVariable;

@Service
public class TemplateApiServiceImpl implements TemplateApiService {

	@Autowired
	ShipperService shipperService;

	@Autowired
	TemplateService templateService;

	@Override
	public Response add(TemplateRequest templateRequest) {

		Template template = new Template();
		List<ExceptionMessage> lsExceptionMessage = new ArrayList<ExceptionMessage>();

		Set<String> templateAreaAllset = new HashSet<String>();
		List<String> templateAreaAlls = new ArrayList<String>();
		TemplateCarryMode t;
		TemplateArea ta;
		// 数据转换
		template.setCreateTime(LocalDateTime.now());
		template.setName(templateRequest.getName());
		template.setPayType(templateRequest.getPayType());
		template.setSendAddress(templateRequest.getSendAddress());
		template.setSendArea(templateRequest.getSendArea());
		template.setSendCity(templateRequest.getSendCity());
		template.setSendProvince(templateRequest.getSendProvince());
		template.setSendMobile(templateRequest.getSendMobile());
		template.setState(State.OFF);
		template.setUserId(templateRequest.getUserId());
		List<TemplateArea> templateAreas = new ArrayList<TemplateArea>();

		for (TemplateCarryModeRequest templateCarryModeRequest : templateRequest.getTemplateCarryModeRequest()) {
			t = new TemplateCarryMode();

			Shipper shipper = shipperService.findById(templateCarryModeRequest.getShipperId());
			if (shipper == null) {
				lsExceptionMessage.add(ExceptionMessage.putMessage(GlobalStaticVariable.VALIDATION, "没有查询到该快递公司或暂不支持"));
			}
			t.setActualAmount(templateCarryModeRequest.getActualAmount());
			t.setMinAmount(templateCarryModeRequest.getMinAmount());
			t.setMode(templateCarryModeRequest.getMode());
			t.setShipperId(templateCarryModeRequest.getShipperId());
			for (TemplateAreaRequest templateArearequest : templateCarryModeRequest.getTemplateAreaRequest()) {
				ta = new TemplateArea();
				ta.setCitiesName(templateArearequest.getCitiesName());
				ta.setProvincesName(templateArearequest.getProincesName());
				ta.setTemplate(template);
				ta.setTemplateCarryMode(t);
				templateAreas.add(ta);
				templateAreaAlls.add(templateArearequest.getCitiesName());
				templateAreaAllset.add(templateArearequest.getCitiesName());
			}

		}

		if (templateAreaAlls.size() != templateAreaAllset.size()) {
			/*
			 * List list = new ArrayList(templateAreaAllset);
			 * 
			 * templateAreaAlls.removeAll(list);
			 */
			lsExceptionMessage.add(ExceptionMessage.putMessage(GlobalStaticVariable.VALIDATION, "含有重复城市"));
		}

		if (lsExceptionMessage.size() > 0) {
			return Response.fail(lsExceptionMessage);
		} else {

			return Response.successBean(templateService.save(templateAreas));
		}

	}

	@Override
	public Response findByUserId(String userId) {
		List<Template> ls = templateService.findByUserId(userId);
		if (ls != null) {
			return Response.successList(ls);
		} else {
			return Response.failMessage(GlobalStaticVariable.VALIDATION, "匹配失败无数据");
		}

	}

	@Override
	public Response findByUserIdAndState(String userId, State state) {
		Template template = templateService.findByUserIdAndState(userId, State.ON);
		if (template != null) {
			return Response.successBean(template);
		} else {
			return Response.failMessage(GlobalStaticVariable.VALIDATION, "匹配失败无数据");
		}
	}

	@Override
	public Response findById(String templateId) {
		Template template = templateService.findById(templateId);

		if (template != null) {
			return Response.successBean(template);
		} else {
			return Response.failMessage(GlobalStaticVariable.VALIDATION, "匹配失败无数据");
		}

	}

	public Response freight(OrderInformationRequest orderInformationRequest) {
		OrderFreightReponse orderFreightReponse = new OrderFreightReponse();

		TemplateArea templateArea = templateService.findByCitiesNameAndProvincesNameAndTemplateId(
				orderInformationRequest.getRecipientCity(), orderInformationRequest.getRecipientProvince(),
				orderInformationRequest.getUserId());

		if (templateArea != null) {
			TemplateCarryMode t1 = templateArea.getTemplateCarryMode();
			Template template = templateArea.getTemplate();
			if (t1.getMode() == Mode.UNIFIED)// 固定
			{
				orderFreightReponse.setActualAmount(t1.getActualAmount());
				orderFreightReponse.setOrderId(orderInformationRequest.getOrderId());
				orderFreightReponse.setDeductibleAmount(new BigDecimal(0));
				orderFreightReponse.setTemplateId(template.getId());
				orderFreightReponse.setSendAddress(template.getSendProvince() + template.getSendCity()
						+ template.getSendArea() + template.getSendAddress());

			} else if (templateArea.getTemplateCarryMode().getMode() == Mode.STANDARD)// 满足包邮
			{ // 结果是:-1 小于,0 等于,1 大于免邮
				if (orderInformationRequest.getOrderAmount().compareTo(t1.getMinAmount()) >= 0) {
					orderFreightReponse.setActualAmount(new BigDecimal(0));
					orderFreightReponse.setDeductibleAmount(t1.getActualAmount());
				} else {
					orderFreightReponse.setActualAmount(t1.getActualAmount());
					orderFreightReponse.setDeductibleAmount(new BigDecimal(0));

				}

				orderFreightReponse.setOrderId(orderInformationRequest.getOrderId());

				orderFreightReponse.setTemplateId(template.getId());
				orderFreightReponse.setSendAddress(template.getSendProvince() + template.getSendCity()
						+ template.getSendArea() + template.getSendAddress());
			} else {
				return Response.failMessage(GlobalStaticVariable.NO, "暂时没开放");
			}
			return Response.successBean(orderFreightReponse);
		} else {
			return Response.failMessage(GlobalStaticVariable.VALIDATION, "用户下无可用模板或不支持该地区");
		}

	}

	public Response saveTemplateStateById(String templateId) {
		int i = templateService.updateStatusById(templateId);
		if (i == 1) {
			return Response.successBean(this.findById(templateId));
		} else {
			return Response.failMessage(GlobalStaticVariable.VALIDATION, "template_id匹配失败无数据");
		}

	}

	@Override
	public Response deleteByStateAndId(String templateId) {
		int i = templateService.deleteById(templateId);
		if (i == 1) {
			return Response.successBean(i);
		}
		return Response.failMessage(GlobalStaticVariable.VALIDATION, "删除失败，模板不存在或状态开启");
	}

}
