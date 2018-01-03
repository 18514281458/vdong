package com.vdong.restful.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vdong.admin.model.Shipper;
import com.vdong.admin.service.ShipperService;
import com.vdong.restful.response.Response;
import com.vdong.restful.service.ShipperApiService;

@Service
public class ShipperApiServiceImpl implements ShipperApiService {

	@Autowired
	private ShipperService shipperService;

	@Override
	public Response findByApplicationId(int applicationId) {

		List<Shipper> ls = shipperService.findByShipperApplicationId(applicationId);

		return Response.successList(ls);
	}

}
