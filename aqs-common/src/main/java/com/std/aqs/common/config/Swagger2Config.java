package com.std.aqs.common.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 主要用途：开启在线接口文档和添加相关配置
 *
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {
    /**
     * 添加摘要信息
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("接口文档")
                        .description("描述：具体包括XXX,XXX模块...")
                        .contact(new Contact("just we",null,null))
                        .version("版本号:1.0")
                        .build())
                .select()
                //.apis(RequestHandlerSelectors.basePackage("com.std.aqs.api"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }
}