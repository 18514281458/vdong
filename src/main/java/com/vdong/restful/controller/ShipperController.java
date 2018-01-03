package com.vdong.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vdong.restful.response.Response;
import com.vdong.restful.service.ShipperApiService;

@RestController
@RequestMapping("/shippe")
public class ShipperController {

	@Autowired
	private ShipperApiService shipperApiService;

	/**
	 * 查询服务商支持的快递公司
	 * 
	 * @param
	 * @return
	 */

	@RequestMapping(value = "/getListShipper.json")
	public Response findAllShipper() {
		return shipperApiService.findByApplicationId(1);

	}
}
