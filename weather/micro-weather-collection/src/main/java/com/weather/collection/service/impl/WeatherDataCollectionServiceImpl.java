package com.weather.collection.service.impl;

import com.weather.collection.service.WeatherDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author : zyh
 * @Description : 天气数据收集实现类
 * @date : 2018-09-22 下午6:17
 */
@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    private static final long TIME_OUT = 1800L; // 1800s

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void syncWeatherDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        saveWeatherData(uri);

    }

    /**
     * 请求天气数据，并缓存到redis
     * @param uri
     */
    private void saveWeatherData(String uri){
        String key = uri;
        String responseBody = null;
        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        // 调用天气服务接口，获取天气数据
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()){
            responseBody = responseEntity.getBody();
        }

        //天气数据缓存redis
        operations.set(key, responseBody, TIME_OUT, TimeUnit.SECONDS);
    }
}
