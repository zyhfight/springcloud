//package com.weather.report.HttpClientUtil;
//
//import feign.Feign;
//import okhttp3.ConnectionPool;
//import okhttp3.OkHttpClient;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author : zyh
// * @Description : com.weather.report.HttpClientUtil
// * @date : 2018-12-08 22:31
// */
//@Configuration
//@ConditionalOnClass(Feign.class)
//@AutoConfigureBefore(FeignAutoConfiguration.class)
//public class FeignOkHttpConfig {
//
//    @Bean
//    public OkHttpClient okHttpClient() {
//        return new OkHttpClient.Builder()
//                .readTimeout(60, TimeUnit.SECONDS)
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .writeTimeout(120,TimeUnit.SECONDS)
//                .connectionPool(new ConnectionPool())
//                .build();
//    }
//
//
//
//}
