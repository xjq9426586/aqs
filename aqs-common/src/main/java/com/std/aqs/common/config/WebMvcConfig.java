package com.std.aqs.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * 资源映射路径映射congfig
 * @author Schaw
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Value("${resourceLocations.uploadPath}")
	private String uploadPath;
	@Value("${resourceHandler.pathHandler}")
	private String pathHandler;
	
    @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	/*
    	 * swagger资源映射路径映射
    	 */
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        /*
         * 文件资源路径映射
         */
        registry.addResourceHandler(pathHandler + "**")
        		.addResourceLocations("file:///"+uploadPath);
    }


}

