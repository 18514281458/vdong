package com.vdong.restful.response;

import java.util.ArrayList;
import java.util.List;

/**
 * 全局json会还配置表
 * 
 * @author liangwei
 * @param <T>
 *
 */
public class Response {

	/**
	 * 请求状态
	 */
	private String state;

	/**
	 * 错误信息代码
	 */
	private List<ExceptionMessage> exceptionMessage;
	/**
	 * 返回数据包体
	 */
	private List<?> responseData;

	private Object responseBean;

	public Object getResponseBean() {
		return responseBean;
	}

	public void setResponseBean(Object responseBean) {
		this.responseBean = responseBean;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<ExceptionMessage> getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(List<ExceptionMessage> exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public List<?> getResponseData() {
		return responseData;
	}

	public void setResponseData(List<?> responseData) {
		this.responseData = responseData;
	}

	/**
	 * 返回集合封装的实体类
	 * 
	 * @param response
	 * @return
	 */
	public static Response successList(List<?> response) {
		Response Response = new Response();
		Response.setResponseData(response);

		Response.setState("success");
		return Response;
	}

	/**
	 * 返回bean封装的实体类
	 * 
	 * @param <T>
	 * 
	 * @param bean
	 * @return
	 */
	public static Response successBean(Object bean) {
		Response Response = new Response();
		Response.setResponseBean(bean);
		Response.setState("success");
		return Response;
	}

	/**
	 * 返回异常体
	 * 
	 * @param message
	 *            异常信息
	 * @return
	 */
	public static Response fail(List<ExceptionMessage> message) {
		Response exceptionResponse = new Response();
		exceptionResponse.setExceptionMessage(message);

		exceptionResponse.setState("fail");
		return exceptionResponse;
	}

	/**
	 * 返回异常体
	 * 
	 * @param message
	 *            异常信息
	 * @return
	 */
	public static Response failMessage(String type, String exceptionData) {
		List<ExceptionMessage> ls = new ArrayList<ExceptionMessage>();
		ls.add(ExceptionMessage.putMessage(type, exceptionData));
		Response exceptionResponse = new Response();
		exceptionResponse.setExceptionMessage(ls);

		exceptionResponse.setState("fail");
		return exceptionResponse;
	}

}
