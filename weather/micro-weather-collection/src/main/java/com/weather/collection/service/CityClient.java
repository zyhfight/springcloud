package com.weather.collection.service;

import com.weather.collection.vo.City;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author : zyh
 * @Description : 请求城市数据API微服务，获取城市数据
 * @date : 2018-09-22 下午6:13
 */
@FeignClient("micro-weather-city")
public interface CityClient {

    @GetMapping("/cities")
    List<City> listCity() throws Exception;
}
