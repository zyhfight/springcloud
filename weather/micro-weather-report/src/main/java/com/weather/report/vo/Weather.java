package com.weather.report.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author : zyh
 * @Description : com.weather.report.vo
 * @date : 2018-09-23 下午2:48
 */
@Setter
@Getter
@ToString
public class Weather implements Serializable {

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
