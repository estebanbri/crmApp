package com.crm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2 //turn on el soporte de swagger 
public class SwaggerConfig {
	
	//Docket is a builder class to configure the generation of Swagger documentation
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
						.apis(RequestHandlerSelectors.any()) //RequestHandlerSelectors.any()-> we want all controllers to be documented
						.paths(PathSelectors.any())          //PathSelectors.any()-> we want all mapped paths to be documented
						.build()
					.apiInfo(metadata());  
	}
	
	@Bean
	public ApiInfo metadata() {
	      return new ApiInfoBuilder()
	        .title("CRM API")
	        .description("Api for Customer Relationship Management")
	        .version("1.0")
	        .contact(new Contact("Ignacio Esteban Briceño","http://localhost:8080/crmWebApp/swagger-ui.html","estebanbriceno1989@gmail.com"))
	        .build();
	    }

}
