package com.vdong.restful.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class GoodsRequest {

	/**
	 * 名称
	 */
	@NotNull(message = " name 不能为空")
	private String name;
	/**
	 * 体积
	 */
	@NotNull(message = " volome 不能为空")
	private BigDecimal volome;
	/**
	 * 商品重量
	 */
	@NotNull(message = " weight 不能为空")
	private BigDecimal weight;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getVolome() {
		return volome;
	}

	public void setVolome(BigDecimal volome) {
		this.volome = volome;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

}
