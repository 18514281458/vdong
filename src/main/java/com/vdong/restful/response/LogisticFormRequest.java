package com.vdong.restful.response;

import java.util.List;

public class LogisticFormRequest {

	private String id;
	private String logisticCode;
	private String shipperName;
	private String state;
	private int shipperId;

	private List<AllTracesRequest> traces;

	public String getId() {
		return id;
	}

	public int getShipperId() {
		return shipperId;
	}

	public void setShipperId(int shipperId) {
		this.shipperId = shipperId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogisticCode() {
		return logisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<AllTracesRequest> getTraces() {
		return traces;
	}

	public void setTraces(List<AllTracesRequest> traces) {
		this.traces = traces;
	}

}
