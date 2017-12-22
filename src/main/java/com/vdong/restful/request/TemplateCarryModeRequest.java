package com.vdong.restful.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.vdong.admin.model.enums.Mode;

/**
 * The persistent class for the template_carry_mode database table.
 * 
 */

public class TemplateCarryModeRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	@NotNull(message = "actualAmount 不能为空")
	private BigDecimal actualAmount;
	@NotNull(message = "minAmount 不能为空")
	private BigDecimal minAmount;
	@NotNull(message = "mode 不能为空")
	private Mode mode;

	@NotNull(message = "shipperId 不能为空")
	private Integer shipperId;

	@NotNull(message = "templateAreaRequest 不能为空")
	@Valid
	private List<TemplateAreaRequest> templateAreaRequest;

	public List<TemplateAreaRequest> getTemplateAreaRequest() {
		return templateAreaRequest;
	}

	public void setTemplateAreaRequest(List<TemplateAreaRequest> templateAreaRequest) {
		this.templateAreaRequest = templateAreaRequest;
	}

	public BigDecimal getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}

	public BigDecimal getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(BigDecimal minAmount) {
		this.minAmount = minAmount;
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public Integer getShipperId() {
		return shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

}