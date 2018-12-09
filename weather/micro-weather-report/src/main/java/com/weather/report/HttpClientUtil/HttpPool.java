//package com.weather.report.HttpClientUtil;
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author : zyh
// * @Description : com.weather.report.HttpClientUtil
// * @date : 2018-12-08 15:36
// */
//@Configuration
//public class HttpPool {
//
//    private Logger logger = LoggerFactory.getLogger(HttpPool.class);
//
//    @Bean
//    public HttpClient httpClient() {
//        logger.info("init feign httpclient configuration");
//        //生成默认请求配置
//        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
//        //超时时间
//        requestConfigBuilder.setSocketTimeout(5 * 1000);
//        //连接时间
//        requestConfigBuilder.setConnectTimeout(5 * 1000);
//        RequestConfig defaultRequestConfig = requestConfigBuilder.build();
//
//        //连接池配置
//        //长连接保持30s
//        final PoolingHttpClientConnectionManager poolingConnectionManager = new PoolingHttpClientConnectionManager(30, TimeUnit.SECONDS);
//        //总连接数
//        poolingConnectionManager.setMaxTotal(5000);
//        //一个路由的并发数
//        poolingConnectionManager.setDefaultMaxPerRoute(100);
//
//        //httpclient 配置
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//        //保持长连接配置，需要在头添加Keep-Alive
//        httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
//        httpClientBuilder.setConnectionManager(poolingConnectionManager);
//        httpClientBuilder.setDefaultRequestConfig(defaultRequestConfig);
//
//        HttpClient httpClient = httpClientBuilder.build();
//
//
//        //启动定时器，定时回收过期、空闲的连接
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                poolingConnectionManager.closeExpiredConnections();
//                poolingConnectionManager.closeIdleConnections(5,TimeUnit.SECONDS);
//            }
//        }, 10 * 1000, 5 * 1000);
//
//        logger.info("===== Apache httpClient 初始化连接池 =====");
//
//        return httpClient;
//
//    }
//
//
//}
