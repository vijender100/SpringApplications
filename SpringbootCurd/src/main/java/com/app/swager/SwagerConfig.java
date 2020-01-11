package com.app.swager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwagerConfig extends WebMvcConfigurationSupport {
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
			   .select()
			   .apis(RequestHandlerSelectors.basePackage("com.app.restcontroller"))
			   .paths(PathSelectors.regex("/services.*"))
			   .build()
			   .apiInfo(metaData());			   
	}
  
	private ApiInfo metaData() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo(
				"Verizon Enterprise Application", 
				"Data Warehouse [Storage] Application For Inbound-Outbound Operations", 
				"1.0", 
				"Terms Of Service", 
				"Apache Licence Version 2.0", 
				"https://www.apache.org/licenses/LICENSE-2.0","vijender"
				);
	   return apiInfo;
	}
}