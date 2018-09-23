package com.weather.city.service.impl;

import com.weather.city.service.CityDataService;
import com.weather.city.util.XmlBuilder;
import com.weather.city.vo.City;
import com.weather.city.vo.CityList;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : zyh
 * @Description : com.weather.city.service.impl
 * @date : 2018-09-23 下午4:09
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    private static final Logger logger = LoggerFactory.getLogger(CityDataServiceImpl.class);


    @Override
    public List<City> listCity() {
        Resource resource = new ClassPathResource("citylist.xml");

        try(
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"));
                ){

            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                buffer.append(line);
            }

            CityList cityList = (CityList) XmlBuilder.xmlStr2Object(CityList.class, buffer.toString());

            return cityList.getCityList();

        }catch (Exception e){
            logger.error("list City Exception : {}", ExceptionUtils.getFullStackTrace(e));
        }

        return new ArrayList<>();

    }
}
