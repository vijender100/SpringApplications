package com.sathyatech.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			   .select()
			   .apis(RequestHandlerSelectors.basePackage("com.sathyatech.app.rest"))
			   .paths(PathSelectors.regex("/rest.*"))
			   .build()
			   .apiInfo(metaData());			   
	}
	
	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo(
				"DataWarehouse Rest Application", 
				"Data Warehouse [Storage] Application For Inbound-Outbound Operations", 
				"1.0", 
				"Terms Of Service", 
				new Contact("RamsSoft Tech","http://www.ramsoft.com/","ramsoftech@gmail.com"), 
				"Apache Licence Version 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0"
				);
	   return apiInfo;
	}
}
