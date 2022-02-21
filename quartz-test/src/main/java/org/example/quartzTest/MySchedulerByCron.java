package org.example.quartzTest;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @program: quartz-test
 * @description: 基于CronTrigger的定时器
 * @author: soufal
 * @create: 2022-02-21 20:09
 **/

public class MySchedulerByCron {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Schedule
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 2、创建JobDetail实例，并于PrinWordsJob类绑定（Job执行的内容）
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .usingJobData("jobDetail", "用于cronTrigger测试的Job")
                .withIdentity("jobName1", "group1").build();

        // 3、 构建trigger实例，根据cron表达式的周期时间执行
        //* * * * * ? *  每秒执行一次
        // 设置执行1分钟后结束
        Date startTime = new Date();
        startTime.setTime(startTime.getTime() + 5000);

        Date endTime = new Date();
        endTime.setTime(startTime.getTime() + 10000);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .usingJobData("triggerName","这是一个crontrigger定时任务测试")
                .startNow()
                .startAt(startTime)
                .endAt(endTime)
                .withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
                .build();

        // 4、执行
        scheduler.scheduleJob(jobDetail, cronTrigger);
        System.out.println("--------------start!-----------------");
        scheduler.start();
        System.out.println("---------------shutdown!-------------");

    }
}
