package com.weather.report.service.impl;

import com.weather.report.service.DataClient;
import com.weather.report.service.WeatherReportService;
import com.weather.report.vo.Weather;
import com.weather.report.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : zyh
 * @Description : com.weather.report.service.impl
 * @date : 2018-09-23 下午4:50
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCity(String cityId) {

        WeatherResponse weatherResponse = dataClient.getDataByCityId(cityId);
       return  weatherResponse.getData();

    }
}
