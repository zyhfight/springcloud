package com.weather.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.demo.service.WeatherDataService;
import com.weather.demo.vo.WeatherResponse;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author : zyh
 * @Description : 天气数据获取实现类
 * @date : 2018-09-23 下午3:15
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Autowired
    private StringRedisTemplate redisTemplate;


    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return getWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return getWeatherData(uri);
    }

    private WeatherResponse getWeatherData(String uri){
        String key = uri;
        String responseBody = null;
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        if (redisTemplate.hasKey(key)) {
            logger.info("Redis has Data : {}", key);
            responseBody = operations.get(key);
        }else {
            logger.info("Redis don't has data : {}", key);
            throw new RuntimeException("Don't has data");
        }

        WeatherResponse response = null;
        try{
            response = mapper.readValue(responseBody, WeatherResponse.class);
        }catch (IOException e){
            logger.error("获取weather data Exception：{}" , ExceptionUtils.getFullStackTrace(e));
        }

        return response;

    }
}
