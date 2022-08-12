package com.allstate.reactclaimsprojectserver.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(generateApiInfo())
                .groupName("public-api")
                .select()
                .paths( url -> url.startsWith("/api") )
                .build();
    }

    public ApiInfo generateApiInfo() {
        return new ApiInfoBuilder()
                .title("Claims API")
                .description("API for Claims Transactions")
                .build();
    }
}
