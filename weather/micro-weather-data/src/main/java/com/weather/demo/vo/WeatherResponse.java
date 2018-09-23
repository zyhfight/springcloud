package com.weather.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author : zyh
 * @Description : 天气响应类
 * @date : 2018-09-23 下午2:51
 */
@Getter
@Setter
@ToString
public class WeatherResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private Weather data;
    private Integer status;
    private String desc;
}
