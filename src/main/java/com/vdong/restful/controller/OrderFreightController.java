package com.vdong.restful.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vdong.restful.request.CurrencyParamRequest;
import com.vdong.restful.request.CurrencyParamRequest.TrajectoryQuery;
import com.vdong.restful.request.OrderInformationRequest;
import com.vdong.restful.response.Response;
import com.vdong.restful.service.ShipperFunctionService;
import com.vdong.restful.service.TemplateApiService;

@RestController
@RequestMapping("/orderFreight")
public class OrderFreightController {

	@Autowired
	TemplateApiService templateApiService;
	@Autowired
	ShipperFunctionService shipperFunctionService;

	@RequestMapping(value = "/getOneOrderFreights.json", method = RequestMethod.POST)
	public Response getOrderFreighsts(@Valid @RequestBody OrderInformationRequest orderInformationRequest) {
		return templateApiService.freight(orderInformationRequest);

	}

	/**
	 * 
	 * @param logisticsNumber
	 *            快递单号
	 * @param shipperId
	 * @return
	 */
	@RequestMapping(value = "/getOnetrajectory.json")
	public Response trajectoryQuery(@Validated(TrajectoryQuery.class) CurrencyParamRequest currencyParamRequest) {
		return shipperFunctionService.trajectoryQuery(currencyParamRequest.getLogisticsNumber(),
				currencyParamRequest.getShipperId());
	}
}
