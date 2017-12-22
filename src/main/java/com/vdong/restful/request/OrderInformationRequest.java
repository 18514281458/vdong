package com.vdong.restful.request;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class OrderInformationRequest {

	@NotEmpty(message = "orderId 不能为空")
	private String orderId;

	/**
	 * 商品详情
	 */

	@Valid
	private List<GoodsRequest> goods;
	/**
	 * 用户id
	 */
	@NotBlank(message = "userId 不能为空")
	private String userId;

	/**
	 * 订单金额
	 */
	@NotNull(message = "orderAmount 不能为空")
	private BigDecimal orderAmount;

	/**
	 * 收件省
	 */
	@NotBlank(message = "recipientProvince 不能为空")
	private String recipientProvince;
	/**
	 * 收件市
	 */
	@NotBlank(message = "recipientCity 不能为空")
	private String recipientCity;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<GoodsRequest> getGoods() {
		return goods;
	}

	public void setGoods(List<GoodsRequest> goods) {
		this.goods = goods;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getRecipientProvince() {
		return recipientProvince;
	}

	public void setRecipientProvince(String recipientProvince) {
		this.recipientProvince = recipientProvince;
	}

	public String getRecipientCity() {
		return recipientCity;
	}

	public void setRecipientCity(String recipientCity) {
		this.recipientCity = recipientCity;
	}

}
