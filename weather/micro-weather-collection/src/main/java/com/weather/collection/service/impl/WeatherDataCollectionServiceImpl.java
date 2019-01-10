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
//
//        // 调用天气服务接口，获取天气数据
//        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
//        if (responseEntity.getStatusCodeValue() == HttpStatus.OK.value()){
//            responseBody = responseEntity.getBody();
//        }

        responseBody = "{\"data\":{\"yesterday\":{\"date\":\"24日星期一\",\"high\":\"高温 28℃\",\"fx\":\"东北风\",\"low\":\"低温 19℃\",\"fl\":\"<![CDATA[3-4级]]>\",\"type\":\"多云\"},\"city\":\"杭州\",\"aqi\":\"58\",\"forecast\":[{\"date\":\"25日星期二\",\"high\":\"高温 27℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 20℃\",\"fengxiang\":\"东北风\",\"type\":\"多云\"},{\"date\":\"26日星期三\",\"high\":\"高温 27℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 20℃\",\"fengxiang\":\"东北风\",\"type\":\"多云\"},{\"date\":\"27日星期四\",\"high\":\"高温 27℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 19℃\",\"fengxiang\":\"东北风\",\"type\":\"阵雨\"},{\"date\":\"28日星期五\",\"high\":\"高温 26℃\",\"fengli\":\"<![CDATA[3-4级]]>\",\"low\":\"低温 20℃\",\"fengxiang\":\"北风\",\"type\":\"阴\"},{\"date\":\"29日星期六\",\"high\":\"高温 26℃\",\"fengli\":\"<![CDATA[4-5级]]>\",\"low\":\"低温 20℃\",\"fengxiang\":\"北风\",\"type\":\"阵雨\"}],\"ganmao\":\"天气转凉，空气湿度较大，较易发生感冒，体质较弱的朋友请注意适当防护。\",\"wendu\":\"25\"},\"status\":1000,\"desc\":\"OK\"}";

        //天气数据缓存redis
        operations.set(key, responseBody, TIME_OUT, TimeUnit.SECONDS);
    }
}
