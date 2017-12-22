package com.vdong.restful.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vdong.restful.request.CurrencyParamRequest;
import com.vdong.restful.request.CurrencyParamRequest.FindByTemplateId;
import com.vdong.restful.request.CurrencyParamRequest.FindByUserId;
import com.vdong.restful.request.CurrencyParamRequest.FindByUserIdAndState;
import com.vdong.restful.request.CurrencyParamRequest.SaveTemplateStateById;
import com.vdong.restful.request.TemplateRequest;
import com.vdong.restful.response.Response;
import com.vdong.restful.service.TemplateApiService;

@RestController
@RequestMapping("/template")
public class TemplateController {

	@Autowired
	TemplateApiService templateService;

	/**
	 * 添加模板
	 * 
	 * @param supplierTemplateAddRequest
	 * @param result
	 * @return
	 * @throws BindException
	 */
	@RequestMapping(value = "/addOneTeplate.json", method = RequestMethod.POST)
	public Response addTeplates(@Valid @RequestBody TemplateRequest templateRequest) {

		return templateService.add(templateRequest);

	}

	/**
	 * 通过userid获取所有模板
	 * 
	 * @param groupId
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/getListByUserId.json")
	public Response findByUserId(@Validated(FindByUserId.class) CurrencyParamRequest currencyParamRequest) {

		return templateService.findByUserId(currencyParamRequest.getUserId());

	}

	/**
	 * 通过userid获取在用模板
	 * 
	 * @param groupId
	 * @param state
	 * @return
	 */
	@RequestMapping(value = "/getOneByUserIdAndState.json")
	public Response findByUserIdAndState(
			@Validated(FindByUserIdAndState.class) CurrencyParamRequest currencyParamRequest) {

		return templateService.findByUserIdAndState(currencyParamRequest.getUserId(), currencyParamRequest.getState());

	}

	@RequestMapping(value = "/getOneByTemplateId.json")
	public Response findByTemplateId(@Validated(FindByTemplateId.class) CurrencyParamRequest currencyParamRequest) {

		return templateService.findById(currencyParamRequest.getTemplateId());

	}

	/**
	 * 删除暂停使用的模板
	 * 
	 * @param currencyParamRequest
	 * @return
	 */
	@RequestMapping(value = "/delOneStateByTemplateId.json")
	public Response deleteTemplate(@Validated(FindByTemplateId.class) CurrencyParamRequest currencyParamRequest) {
		return templateService.deleteByStateAndId(currencyParamRequest.getTemplateId());
	}

	/**
	 * 激活模板
	 * 
	 * @param currencyParamRequest
	 * @return
	 */
	@RequestMapping(value = "/getOneStateByTemplateId.json")
	public Response saveTemplateStateById(
			@Validated(SaveTemplateStateById.class) CurrencyParamRequest currencyParamRequest) {

		return templateService.saveTemplateStateById(currencyParamRequest.getTemplateId());
	}

}
