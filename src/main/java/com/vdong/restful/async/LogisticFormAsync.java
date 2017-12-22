package com.vdong.restful.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.vdong.admin.model.LogisticForm;
import com.vdong.admin.service.LogisticFormService;

@Component
public class LogisticFormAsync {

	@Autowired
	LogisticFormService logisticFormService;

	/**
	 * 插入签收运单数据
	 * 
	 * @param logisticForm
	 */
	@Async
	public void saveLogisticForm(LogisticForm logisticForm) {
		logisticFormService.save(logisticForm);

	}
}
