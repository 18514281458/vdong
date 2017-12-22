package com.vdong.restful.service;

import com.vdong.restful.response.Response;

public interface ShipperApiService {

	Response findByApplicationId(int applicationId);

}
