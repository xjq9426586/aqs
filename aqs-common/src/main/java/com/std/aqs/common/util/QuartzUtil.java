package com.std.aqs.common.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
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
	
	/**
	 * 添加任务
	 * @param jobClass 任务class
	 * @param jobName 任务名
	 * @param jobGroup 任务组
	 * @param cronExpression cron表达式
	 * @throws SchedulerException
	 */
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
	
	/**
	 * 移除任务
	 * @param jobName 任务名
	 * @param jobGroup 任务组
	 * @throws SchedulerException
	 */
	public void removeJob(String jobName, String jobGroup) throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
		
		// 停止触发器 
        scheduler.pauseTrigger(triggerKey); 
        
        // 移除触发器  
        scheduler.unscheduleJob(triggerKey);
        
        // 删除任务
        scheduler.deleteJob(JobKey.jobKey(jobName, jobGroup));
	}
	
	/**
	 * 重设置任务
	 * @param jobName
	 * @param jobGroup
	 * @param cronExpression
	 * @throws SchedulerException 
	 */
	public void resetJob(String jobName, String jobGroup, String cronExpression) throws SchedulerException {
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
		
		// 表达式调度构建器
		CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

		// 按新的cronExpression表达式重新构建trigger
		trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

		// 按新的trigger重新设置job执行
		scheduler.rescheduleJob(triggerKey, trigger);
	}
}
