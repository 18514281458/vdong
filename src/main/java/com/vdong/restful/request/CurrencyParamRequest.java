package com.vdong.restful.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.vdong.admin.model.enums.State;

public class CurrencyParamRequest {

	@NotBlank(message = "logisticsNumber不能为空", groups = TrajectoryQuery.class)
	private String logisticsNumber;
	@NotNull(message = "shipperId不能为空", groups = TrajectoryQuery.class)
	private Integer shipperId;
	@NotBlank(message = "templateId不能为空", groups = { FindByTemplateId.class, SaveTemplateStateById.class })
	private String templateId;
	@NotBlank(message = "userId不能为空", groups = { FindByUserIdAndState.class, FindByUserId.class })
	private String userId;
	@NotNull(message = "state is null", groups = FindByUserIdAndState.class)
	private State state;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getLogisticsNumber() {
		return logisticsNumber;
	}

	public void setLogisticsNumber(String logisticsNumber) {
		this.logisticsNumber = logisticsNumber;
	}

	public Integer getShipperId() {
		return shipperId;
	}

	public void setShipperId(Integer shipperId) {
		this.shipperId = shipperId;
	}

	public interface FindByUserId {
	}

	public interface FindByUserIdAndState {
	}

	public interface TrajectoryQuery {
	}

	public interface FindByTemplateId {
	}

	public interface SaveTemplateStateById {

	}
}
