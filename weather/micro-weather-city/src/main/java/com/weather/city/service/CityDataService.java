package com.weather.city.service;

import com.weather.city.vo.City;

import java.util.List;

/**
 * @author : zyh
 * @Description : com.weather.city.service
 * @date : 2018-09-23 下午3:56
 */
public interface CityDataService {

    /**
     * 获取City list
     * @return
     */
    List<City> listCity();
}
