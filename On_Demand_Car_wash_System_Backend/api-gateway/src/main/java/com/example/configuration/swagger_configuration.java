package com.example.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class swagger_configuration {
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.any())
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Address book API for Contact-Service", 
				"<h1>This is sample documentation for the Contact-service App<h1>", 
				"1.0", 
				"Free to use",
				new springfox.documentation.service.Contact("Ayush Ghai", "http://codeShark.com","AyushGhai9@gmail.com"),
				"API License", 
				"http://codeShark.com", 
				Collections.emptyList());

	}

}
