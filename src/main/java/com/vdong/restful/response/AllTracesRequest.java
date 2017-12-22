package com.vdong.restful.response;

import java.time.LocalDateTime;

public class AllTracesRequest {

	private String acceptStation;
	private LocalDateTime acceptTime;

	public String getAcceptStation() {
		return acceptStation;
	}

	public void setAcceptStation(String acceptStation) {
		this.acceptStation = acceptStation;
	}

	public LocalDateTime getAcceptTime() {
		return acceptTime;
	}

	public void setAcceptTime(LocalDateTime acceptTime) {
		this.acceptTime = acceptTime;
	}

}
