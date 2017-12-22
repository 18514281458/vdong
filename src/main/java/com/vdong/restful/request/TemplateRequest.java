package com.vdong.restful.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.vdong.admin.model.enums.PayType;
import com.vdong.admin.model.enums.State;

/**
 * The persistent class for the template database table.
 * 
 */

public class TemplateRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "userId 不能为空")
	private String userId;

	private String monthCode;
	@NotBlank(message = "name 不能为空")
	private String name;
	@NotNull(message = "PayType 不能为空")
	private PayType payType;
	@NotBlank(message = "sendAddress 不能为空")
	private String sendAddress;

	private String sendArea;
	@NotBlank(message = "sendCity 不能为空")
	private String sendCity;
	@NotBlank(message = "sendMobile 不能为空")
	@Pattern(regexp = "^\\d{11}$", message = "sendMobile11位手机号")
	private String sendMobile;
	@NotBlank(message = "sendProvince 不能为空")
	private String sendProvince;
	@Valid
	@NotNull
	private List<TemplateCarryModeRequest> templateCarryModeRequest;
	@NotNull(message = "state 不能为空")
	private State state;

	public List<TemplateCarryModeRequest> getTemplateCarryModeRequest() {
		return templateCarryModeRequest;
	}

	public void setTemplateCarryModeRequest(List<TemplateCarryModeRequest> templateCarryModeRequest) {
		this.templateCarryModeRequest = templateCarryModeRequest;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMonthCode() {
		return monthCode;
	}

	public void setMonthCode(String monthCode) {
		this.monthCode = monthCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getSendArea() {
		return sendArea;
	}

	public void setSendArea(String sendArea) {
		this.sendArea = sendArea;
	}

	public String getSendCity() {
		return sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	public String getSendMobile() {
		return sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
	}

	public String getSendProvince() {
		return sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}