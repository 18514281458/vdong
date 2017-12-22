package com.vdong.runner;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vdong.admin.service.AreaService;

@Component
@Order(value = 1)
public class DictionaryTableRunner implements ApplicationRunner {
	Logger logger = Logger.getLogger(DictionaryTableRunner.class);

	@Autowired
	AreaService areaService;

	@Override
	public void run(ApplicationArguments arg0) throws Exception {

	}

}
