package com.std.aqs.common.config;

import com.std.aqs.common.interceptor.CurrentUserInterceptor;
import com.std.aqs.common.interceptor.CurrentUserMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 资源映射路径映射congfig
 *
 * @author Schaw
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${resourceLocations.uploadPath}")
    private String uploadPath;
    @Value("${resourceHandler.pathHandler}")
    private String pathHandler;


    @Bean
    public CurrentUserInterceptor currentUserInterceptor() {
        return new CurrentUserInterceptor();
    }

    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

    /**
     * 添加参数解析器
     *
     * @param argumentResolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(this.currentUserMethodArgumentResolver());
    }

    /**
     * 添加拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.currentUserInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login");
    }

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
                .addResourceLocations("file:///" + uploadPath);

        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


}

