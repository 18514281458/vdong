package com.vdong.restful.response;

public class ExceptionMessage {
	private String type;
	private String exceptionData;
	private String value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExceptionData() {
		return exceptionData;
	}

	public void setExceptionData(String exceptionData) {
		this.exceptionData = exceptionData;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static ExceptionMessage putMessage(String type, String exceptionData) {

		ExceptionMessage exception = new ExceptionMessage();
		exception.setType(type);
		exception.setExceptionData(exceptionData);

		return exception;
	}
}
