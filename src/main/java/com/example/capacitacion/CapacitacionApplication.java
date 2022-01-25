package com.example.capacitacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
//@EnableSwagger2
public class CapacitacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapacitacionApplication.class, args);
	}
	
    @Bean
    public RestTemplate getresttemplate() {
        return new RestTemplate();
    }
//	@Bean
//	public OpenAPI springShopOpenAPI() {
//		return new OpenAPI()
//		.info(new Info().title("Capacitacion API")
//		.description("Api de capacitacion")
//		.version("v0.0.1")
//		.license(new License().name("Apache 2.0").url("http://localhost:8080")))
//		.externalDocs(new ExternalDocumentation()
//		.description("SpringShop Wiki Documentation")
//		.url("https://springshop.wiki.github.org/docs"));
//	}
	
//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//		.apis(RequestHandlerSelectors.basePackage("com.example.capacitacion")).build();
//	}
}
