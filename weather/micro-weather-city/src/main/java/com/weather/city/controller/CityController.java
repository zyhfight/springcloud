package com.weather.city.controller;

import com.weather.city.service.CityDataService;
import com.weather.city.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : zyh
 * @Description : com.weather.city.controller
 * @date : 2018-09-23 下午4:20
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() {
        return cityDataService.listCity();
    }
}
