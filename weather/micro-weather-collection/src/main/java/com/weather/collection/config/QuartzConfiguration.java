//package com.weather.collection.config;
//
//import com.weather.collection.job.WeatherDataSyncJob;
//import org.quartz.*;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author : zyh
// * @Description : 定时任务调度器
// * @date : 2018-09-22 下午5:56
// */
//@Configuration
//public class QuartzConfiguration {
//
//    private static final int PERIOD_SECONDS = 1;
//
//    @Bean
//    public JobDetail weatherDataJobTrigger() {
//        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("weatherDataSyncJow")
//          .storeDurably().build();
//    }
//
//    @Bean
//    public Trigger weatherDataSyncTrigger() {
//        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(PERIOD_SECONDS).repeatForever();
//        return TriggerBuilder.newTrigger().forJob(weatherDataJobTrigger())
//                .withIdentity("weatherDataSyncTrigger").withSchedule(simpleScheduleBuilder).build();
//    }
//}
