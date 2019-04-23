/**
 * Copyright (c) HCL PCF TEAM ,2019
 */
package com.hcl.cloud.user.SwaggerConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * com.hcl.cloud.user.SwaggerConfig abhishek_sin
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	/**
	 * ApiInfo
	 */
	@SuppressWarnings("deprecation")
	public static final ApiInfo DEFAULT_CUSTOM_INFO = new ApiInfo("User Microservice API Documents",
			"User Microservice API Documents", "1.0.0", "urn:tos", "abhishek_sin@hcl.com", "Cloud Foundry",
			"http://www.pivotal.org/licenses/LICENSE-2.0");

	/**
	 * ApiInfo
	 *
	 * @return tag for postsapi
	 */
	@Bean
	public Docket postsApi() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_CUSTOM_INFO);

	}

}
