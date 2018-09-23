package com.weather.collection.service;

/**
 * @author : zyh
 * @Description : 天气数据收集借口
 * @date : 2018-09-22 下午6:07
 */
public interface WeatherDataCollectionService {

    /**
     * 根据城市ID同步天气数据
     * @param cityId
     */
    void syncWeatherDataByCityId(String cityId);
}
