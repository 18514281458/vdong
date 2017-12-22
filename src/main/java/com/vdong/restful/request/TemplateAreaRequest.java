package com.vdong.restful.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * The persistent class for the template_area database table.
 * 
 */

public class TemplateAreaRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "proincesCode 不能为空")
	private String proincesName;
	@NotNull(message = "citiesId 不能为空")
	private String citiesName;

	public TemplateAreaRequest() {
	}

	public String getProincesName() {
		return proincesName;
	}

	public void setProincesName(String proincesName) {
		this.proincesName = proincesName;
	}

	public String getCitiesName() {
		return citiesName;
	}

	public void setCitiesName(String citiesName) {
		this.citiesName = citiesName;
	}

}