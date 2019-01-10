package com.std.aqs.common.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("unchecked")
public class QuartzUtil {
	//加入Qulifier注解，通过名称注入bean
	@Autowired 
	@Qualifier("Scheduler")
	private Scheduler scheduler;
	
	public void addJob(Class<?> jobClass, String jobName, String jobGroup, String cronExpression) throws SchedulerException {
		//构建job信息
		JobDetail jobDetail = JobBuilder.newJob((Class<? extends Job>) jobClass).withIdentity(jobName, jobGroup).build();
		
		//表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        //按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup)
            .withSchedule(scheduleBuilder).build();
        
        scheduler.scheduleJob(jobDetail, trigger);
	}
	
	public void removeJob() {
		
	}
}
