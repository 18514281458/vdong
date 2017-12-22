package com.vdong.restful.service;

import com.vdong.admin.model.enums.State;
import com.vdong.restful.request.OrderInformationRequest;
import com.vdong.restful.request.TemplateRequest;
import com.vdong.restful.response.Response;

/**
 * 模板服务
 * 
 * @author liangwei
 *
 */
public interface TemplateApiService {

	/**
	 * 验证shipper,支付方式cash时验证月结码。完成返回id
	 * 
	 * @param supplierTemplateAddRequest
	 * @return
	 * 
	 */
	Response add(TemplateRequest templateRequest);

	Response findByUserId(String userId);

	Response findById(String id);

	Response findByUserIdAndState(String userId, State state);

	Response freight(OrderInformationRequest orderInformationRequest);

	/**
	 * 激活模板。该模板用户下的所有版本都只为不可用
	 * 
	 * @param templateId
	 * @return
	 */
	Response saveTemplateStateById(String templateId);

	Response deleteByStateAndId(String templateId);
}
