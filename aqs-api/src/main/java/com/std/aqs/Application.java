package com.std.aqs;

import com.std.aqs.api.startJob;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;


import com.std.aqs.common.util.QuartzUtil;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * 注：为了避免扫描路径不一致，启动类放在Root Package 即 com.std.aqs
 * 打包成war包,需要继承org.springframework.boot.context.web.SpringBootServletInitializer类,
 * 覆盖其configure(SpringApplicationBuilder)方法
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Autowired
    private QuartzUtil quartzUtil;

    @Autowired
    ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);

    }

    @Bean
    public CommandLineRunner commandLineRunner() throws SchedulerException {
        return args -> {
            threadPoolTaskExecutor.execute(() -> {
                System.out.println("-------------------------------------");
            });
            Map<String, Object> params = new HashMap<>();
            params.put("a", "111111");
            quartzUtil.addJob(startJob.class, params,"startJob", "startJob", "0/5 * * * * ?");
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
