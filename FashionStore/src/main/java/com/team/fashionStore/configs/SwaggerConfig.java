/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.team.fashionStore.configs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 *
 * @author Asus
 */
@Configuration
public class SwaggerConfig {
    public static final String AUTHORIZATION_HEADER="Authorization";
    
    private ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }
    
    private List<SecurityContext> securityContexts(){
        return Arrays.asList(SecurityContext.builder().securityReferences(sf()).build());
    }
    
    private List<SecurityReference> sf(){
        AuthorizationScope scopes = new AuthorizationScope("global", "accessEverything");
        return Arrays.asList(new SecurityReference("JWT",new AuthorizationScope[]{scopes}));
    }
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getInfor())
                .securityContexts(securityContexts())
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
    
    private ApiInfo getInfor(){
        return new ApiInfo("Fashion Store API", "This is api for fashionstore", "1.0.0", "Terms of Service", new Contact("Big Assignment,Leader: Tran Tan Nhut", "https://laptrinhvui.com", "nhuttran@gmail.com"), "License of Api","Api License URL", Collections.EMPTY_LIST);
    }
}
