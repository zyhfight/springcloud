package com.weather.report.service;

import com.weather.report.controller.WeatherReportController;
import com.weather.report.vo.City;
import com.weather.report.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);


    @Override
    public List<City> listCity() {
        logger.info("fall back list city");
        return new ArrayList<>();
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return new WeatherResponse();
    }
}
