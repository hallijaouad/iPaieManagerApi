package com.jhl.ipaiemanager.configs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)//
        .select()//
        .apis(RequestHandlerSelectors.basePackage("com.jhl.ipaiemanager.controllers"))//
        .paths(paths("/api/users.*"))

        .build()//
        .apiInfo(metadata())//
        .useDefaultResponseMessages(false)//
        .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))//
        .tags(new Tag("paie", "Dématérialisation des Bulletins de paie, Consultation, Edition, Envoi par email et téléchargement des documents par les collaborateurs (Attestation de salaire, Attestion de travail ...)"))//
        .tags(new Tag("ping", "Just a ping"))//
        .genericModelSubstitutes(Optional.class);

  }

  private ApiInfo metadata() {
    return new ApiInfoBuilder()//
        .title("iPaieManager API")//
        .description(
            "Dématérialisation des Bulletins de paie, Consultation, Edition, Envoi par email et téléchargement des documents par les collaborateurs (bulletin de paie, Attestation de salaire, Attestion de travail ...)")//
        .version("1.0.0")//
        .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
        .contact(new Contact("Jaouad Halli", null, "hallijaouad@gmail.com"))//
        .build();
  }
  
//Only select apis that matches the given Predicates.
private Predicate<String> paths(String path) {
//Match all paths except /error
   return Predicates.and(
		   PathSelectors.regex(path),		  
		   Predicates.not(PathSelectors.regex("/error")));
   }


}
