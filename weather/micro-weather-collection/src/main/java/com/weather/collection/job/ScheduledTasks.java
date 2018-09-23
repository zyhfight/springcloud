package com.weather.collection.job;

import com.weather.collection.service.CityClient;
import com.weather.collection.service.WeatherDataCollectionService;
import com.weather.collection.vo.City;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : zyh
 * @Description : com.weather.collection.job
 * @date : 2018-09-23 下午6:41
 */
@Component
@Configurable
@EnableScheduling
public class ScheduledTasks {

    private final static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private CityClient cityClient;

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;


  @Scheduled(cron = "*/30 * * * * ?") //30s执行一次
//    @Scheduled(cron = "0 */30 * * * ??") //30min执行一次
    public void reportCurrentByCron(){

        logger.info("Weather Data Sync Job. Start！");
        try{

            List<City> cityList = cityClient.listCity();
            for(City city : cityList){
                String cityId = city.getCityId();
                logger.info("weather data sync job, cityId : {}" , cityId);
                weatherDataCollectionService.syncWeatherDataByCityId(cityId);
            }

        }catch (Exception e){
            logger.error(" weather data sync job Exception：{}", ExceptionUtils.getFullStackTrace(e));
        }

        logger.info("Weather Data Sync Job. Start！");

    }
}
