package com.example.sample.main.person.address.mnagement.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi
				.builder()
				.group("Person-Address-Management")
				.pathsToMatch("/person/**")
				.build();
	}

	@Bean
	public GroupedOpenApi adminApi() {
		return GroupedOpenApi
				.builder()
				.group("Person-Address-Management-admin")
				.pathsToMatch("/person/**")
				.build();
	}
}
