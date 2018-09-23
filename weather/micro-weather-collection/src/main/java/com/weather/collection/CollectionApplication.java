package com.weather.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @Description  天气数据采集
 * @author : zyh
 * @date : 2018-09-22 下午5:24
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollectionApplication.class, args);
    }


}
