package com.weather.report.service;

import com.weather.report.vo.City;
import com.weather.report.vo.WeatherResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author : zyh
 * @Description : feign调用接口获取城市数据/天气数据
 * @date : 2018-09-23 下午2:57
 */
@FeignClient(name = "micro-weather-zuul", fallback = DataClientFallback.class)
public interface DataClient {

    /**
     *  获取城市list
     * @return
     */
    @GetMapping("/city/cities")
    List<City> listCity();

    /**
     * 根据城市ID获取天气数据
     * @param cityId
     * @return
     */
    @GetMapping("/data/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);


}
