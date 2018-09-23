//package com.weather.collection.job;
//
//import com.weather.collection.service.CityClient;
//import com.weather.collection.service.WeatherDataCollectionService;
//import com.weather.collection.vo.City;
//import org.apache.commons.lang.exception.ExceptionUtils;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//
//
//import java.util.List;
//
///**
// * @author : zyh
// * @Description :   天气数据定时收集job
// * @date : 2018-09-22 下午6:00
// */
//public class WeatherDataSyncJob extends QuartzJobBean {
//
//    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);
//
//    @Autowired
//    private CityClient cityClient;
//
//    @Autowired
//    private WeatherDataCollectionService weatherDataCollectionService;
//
//    @Override
//    protected void executeInternal(JobExecutionContext context) {
//
//        logger.info("Weather Data Sync Job. Start！");
//        try{
//
//            List<City> cityList = cityClient.listCity();
//            for(City city : cityList){
//                String cityId = city.getCityId();
//                logger.info("weather data sync job, cityId : {}" , cityId);
//                weatherDataCollectionService.syncWeatherDataByCityId(cityId);
//            }
//
//        }catch (Exception e){
//            logger.error(" weather data sync job Exception：{}", ExceptionUtils.getFullStackTrace(e));
//        }
//
//        logger.info("Weather Data Sync Job. Start！");
//    }
//}
