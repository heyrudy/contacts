package com.example.contacts.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@ConfigurationProperties(prefix = "swagger.api.info")
@EnableSwagger2
@Getter
@Setter
public class SwaggerConfiguration {
    private String title;
    private String description;
    private String version;
    private String contactName;
    private String contactEmail;
    private String hostName;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.contacts.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .host(hostName)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                title,
                description,
                version,
                "TERMS OF SERVICE URL",
                new Contact(contactName, "", contactEmail),
                "MIT License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}