package com.vdong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableDiscoveryClient // 激活eureka中的DiscoveryClient实现
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@EnableCaching
@EnableFeignClients("com.vdong.supplier") // 扫描feiclient
public class SupportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupportServiceApplication.class, args);

	}

}
