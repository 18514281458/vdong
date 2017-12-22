package com.vdong.restful.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.vdong.admin.model.enums.Mode;
import com.vdong.admin.model.enums.PayType;
import com.vdong.admin.model.enums.State;
import com.vdong.admin.model.enums.Type;

/**
 * 添加模板请求配置
 * 
 * @author liangwei
 *
 */
public class SupplierTemplateAddRequest {

	@NotBlank(message = "name 不能为空")
	private String name;
	@NotNull(message = "type 不能为空")
	private Type type;
	@NotNull(message = "mode 不能为空")
	private Mode mode;

	private BigDecimal minAmount = new BigDecimal(0);
	@NotNull(message = "actualAmount 不能为空")
	private BigDecimal actualAmount;
	@NotBlank(message = "sendArea 不能为空")
	@Pattern(regexp = "^\\d{6,7}$", message = "sendArea代码必须为6到7位数字")
	private String sendArea;
	@NotBlank(message = "sendCity 不能为空")
	@Pattern(regexp = "^\\d{6,7}$", message = "sendCity代码必须为6到7位数字")
	private String sendCity;
	@NotBlank(message = "sendProvince 不能为空")
	@Pattern(regexp = "^\\d{6,7}$", message = "sendProvince代码必须为6到7位数字")
	private String sendProvince;

	private String collectArea;
	@NotBlank(message = "collectCity 不能为空")
	@Pattern(regexp = "^\\d{6,7}$", message = "collectCity代码必须为6到7位数字")
	private String collectCity;
	@NotBlank(message = "collectProvince 不能为空")
	@Pattern(regexp = "^\\d{6,7}$", message = "collectProvince代码必须为6到7位数字")
	private String collectProvince;
	@NotNull(message = "state 不能为空")
	private State state;
	@NotBlank(message = "groupId 不能为空")
	private String groupId;
	@NotNull(message = "shipperId 不能为空")
	private Integer shipperId;
	@NotBlank(message = "sendAddress 不能为空")
	private String sendAddress;
	@NotBlank(message = "sendMobile 不能为空")
	@Length(min = 11, max = 11, message = "联系电话长度错误")
	private String sendMobile;

	private String sendTel;
	@NotNull(message = "payType 不能为空")
	private PayType payType;

	private String monthCode;

	private ExpressList expressList;

	public ExpressList getExpressList() {
		return expressList;
	}

	public void setExpressList(ExpressList expressList) {
		this.expressList = expressList;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {

		this.minAmount = minAmount;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
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

	public String getSendProvince() {
		return sendProvince;
	}

	public void setSendProvince(String sendProvince) {
		this.sendProvince = sendProvince;
	}

	public String getCollectArea() {
		return collectArea;
	}

	public void setCollectArea(String collectArea) {
		this.collectArea = collectArea;
	}

	public String getCollectCity() {
		return collectCity;
	}

	public void setCollectCity(String collectCity) {
		this.collectCity = collectCity;
	}

	public String getCollectProvince() {
		return collectProvince;
	}

	public void setCollectProvince(String collectProvince) {
		this.collectProvince = collectProvince;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Integer getShipperId() {
		return shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getSendMobile() {
		return sendMobile;
	}

	public void setSendMobile(String sendMobile) {
		this.sendMobile = sendMobile;
		// this.telOrPhone = checkMobileorTel(sendMobile, this.sendTel);
	}

	public String getSendTel() {
		return sendTel;
	}

	public void setSendTel(String sendTel) {
		this.sendTel = sendTel;
		// this.telOrPhone = checkMobileorTel(this.sendMobile, sendTel);
	}

	public PayType getPayType() {
		return payType;
	}

	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public String getMonthCode() {
		return monthCode;
	}

	public void setMonthCode(String monthCode) {
		this.monthCode = monthCode;
	}

}
