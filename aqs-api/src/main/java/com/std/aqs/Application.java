package com.std.aqs;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.std.aqs.common.job.startJob;
import com.std.aqs.common.util.QuartzUtil;

/**
 * 注：为了避免扫描路径不一致，启动类放在Root Package 即 com.std.aqs 打包成war包,需要继承
 * org.springframework.boot.context.web.SpringBootServletInitializer类,
 * 覆盖其configure(SpringApplicationBuilder)方法
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	@Autowired
	private QuartzUtil quartzUtil;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	@Bean
	public CommandLineRunner commandLineRunner() throws SchedulerException {
		return args -> {
			quartzUtil.addJob(startJob.class, "startJob", "startJob", "0 0/1 * * * ? ");
		};

	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
