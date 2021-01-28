package com.lucasangelo.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // O Docket é uma classe adicionada no pom.xml e importada por aqui, para a aplicação
    @Bean
    public Docket produtoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lucasangelo.apirest")) // Pacote onde está as classes Java
                .paths(regex("/api.*")) // Qual caminho o swaggertype vai acessar
                .build()
                .apiInfo(metaInfo()); // Método abaixo criado
    }

    // Método contendo a info da API
    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST",
                "API REST de cadastro e consulta de produtos",
                "1.0",
                "Terms of Service",
                new Contact("Lucas Ângelo", "https://github.com/Lucas-Angelo", "lcs2001_@hotmail.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/license.html", new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }

}
