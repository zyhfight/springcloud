package com.weather.report.service;

import com.weather.report.vo.City;
import com.weather.report.vo.WeatherResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zyh
 * @Description : 降级逻辑
 * @date : 2018-09-23 下午4:39
 */
@Component
public class DataClientFallback implements DataClient{

    @Override
    public List<City> listCity() {
        return new ArrayList<>();
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return new WeatherResponse();
    }
}
