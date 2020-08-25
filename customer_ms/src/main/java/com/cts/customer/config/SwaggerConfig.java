package com.cts.customer.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2).enable(true) 
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.cts.customer"))     
          .paths(PathSelectors.any())                          
          .build()
          .tags(new Tag("Customer API","Customer Controller"))
          .apiInfo(getApiInfo());                                           
    }
	
	private ApiInfo getApiInfo() {
		return new ApiInfo("customer request API",
				            "A Service enable client to Add a new customer,Retrieve all customers,Retrieve one customer by it's identifier,Search customers by first name and/or last name,Update the living address",
				            "1.0","urn:tos",new Contact("customer","www.google.co",""),"Apache2.0","http://www.apache.org/licenses/LICENSE-2.0",Collections.emptyList());
	}
	
	@Bean
	public UiConfiguration uiConfig() {
		return  UiConfigurationBuilder.builder().defaultModelRendering(ModelRendering.MODEL).defaultModelExpandDepth(-1).build();
	}
	

}
