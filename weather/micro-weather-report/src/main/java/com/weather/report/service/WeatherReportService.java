package com.weather.report.service;

import com.weather.report.vo.Weather;

/**
 * @author : zyh
 * @Description : com.weather.report.service
 * @date : 2018-09-23 下午4:49
 */
public interface WeatherReportService {

    /**
     * 根据城市ID获取天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCity(String cityId);
}
