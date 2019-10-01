package br.com.faculdadedelta.bibliotecaapi.configuration;

import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.faculdadedelta.bibliotecaapi.resource"))
                .paths(PathSelectors.any())
                .build()
//                .securitySchemes (Arrays.asList (new ApiKey ("", HttpHeaders.AUTHORIZATION, In.HEADER.name())))
//                .securityContexts (Arrays.asList (securityContext()));
                .apiInfo(apiInfo());
    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder ()
//                .securityReferences (defaultAuth ())
//                .forPaths (PathSelectors.any ())
//                .build ();
//    }
//
//    List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope
//                = new AuthorizationScope ("ADMIN", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList (
//                new SecurityReference ("Token Access", authorizationScopes));
//    }


    private ApiInfo apiInfo() {

        return new ApiInfoBuilder ()
                .title("API - Exemplo")
                .description("Utilizando Spring Boot com JPA.")
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact ("Frederico Hernany"
                        , "https://github.com/Fredericoh "
                        , "fredericoh@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
                .version("0.0.1")
                .build();
    }

}

