package com.weather.report.controller;

import com.weather.report.service.DataClient;
import com.weather.report.service.WeatherReportService;
import com.weather.report.vo.City;
import com.weather.report.vo.Weather;
import com.weather.report.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * @author : zyh
 * @Description : com.weather.report.controller
 * @date : 2018-09-23 下午4:44
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    private static final Logger logger = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model){

        logger.info("start get {} resulst", cityId);

        List<City> cityList = dataClient.listCity();

        Weather weather = weatherReportService.getDataByCity(cityId);

        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weather);

        return new ModelAndView("weather/report", "reportModel", model);

    }

}
