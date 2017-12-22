package com.vdong.restful.service;

import com.vdong.restful.response.Response;

/**
 *
 * 快递功能服务
 * 
 * @author liangwei
 *
 */
public interface ShipperFunctionService {

	/**
	 * 轨迹查询工能 1,签收状态会返回 id数据 2，签收状态数据不访问快递鸟，直接查数据库 3，
	 * 
	 * @param logisticsNumber
	 * @param shipperId
	 * @return
	 */
	Response trajectoryQuery(String logisticsNumber, int shipperId);

}
