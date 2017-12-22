package com.vdong.restful.response;

import java.math.BigDecimal;

/**
 * 订单运费信息
 * 
 * @author liangwei
 *
 */
public class OrderFreightReponse {

	/**
	 * 订单id
	 */
	private String orderId;
	/**
	 * 使用的模板id
	 */
	private String templateId;
	/**
	 * 实际运费金额
	 */
	private BigDecimal actualAmount;
	/**
	 * 抵扣运费
	 */
	private BigDecimal deductibleAmount;

	private String sendAddress;

	public String getSendAddress() {
		return sendAddress;
	}

	public void setSendAddress(String sendAddress) {
		this.sendAddress = sendAddress;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	public BigDecimal getDeductibleAmount() {
		return deductibleAmount;
	}

	public void setDeductibleAmount(BigDecimal deductibleAmount) {
		this.deductibleAmount = deductibleAmount;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

}
