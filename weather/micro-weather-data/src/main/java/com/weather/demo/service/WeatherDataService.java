package com.weather.demo.service;

import com.weather.demo.vo.WeatherResponse;

/**
 * @author : zyh
 * @Description : 天气数据获取接口
 * @date : 2018-09-23 下午3:13
 */
public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
