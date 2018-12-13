package com.std.aqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *  注：为了避免扫描路径不一致，启动类放在Root Package 即 com.std.aqs
 *  打包成war包,需要继承 org.springframework.boot.context.web.SpringBootServletInitializer类,
 *  覆盖其configure(SpringApplicationBuilder)方法
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
