package com.vdong.restful.request;

import java.math.BigDecimal;

/**
 * 计算模式如下
 * 
 * @author liangwei
 *
 */
public class ExpressList {

	/**
	 * 首重价格
	 */
	private BigDecimal first = new BigDecimal(0);

	/*
	 * 首重重量
	 */
	private BigDecimal firstWeight = new BigDecimal(0);

	private BigDecimal additional = new BigDecimal(0);

	private BigDecimal additionalWeight = new BigDecimal(0);

	private String weihtformula;

	public BigDecimal getFirst() {
		return first;
	}

	public void setFirst(BigDecimal first) {
		this.first = first;
	}

	public BigDecimal getFirstWeight() {
		return firstWeight;
	}

	public void setFirstWeight(BigDecimal firstWeight) {
		this.firstWeight = firstWeight;
	}

	public BigDecimal getAdditional() {
		return additional;
	}

	public void setAdditional(BigDecimal additional) {
		this.additional = additional;
	}

	public BigDecimal getAdditionalWeight() {
		return additionalWeight;
	}

	public void setAdditionalWeight(BigDecimal additionalWeight) {
		this.additionalWeight = additionalWeight;
	}

	public String getWeihtformula() {
		return weihtformula;
	}

	public void setWeihtformula(String weihtformula) {
		this.weihtformula = weihtformula;
	}

}
