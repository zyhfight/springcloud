package com.weather.collection.vo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description : 城市数据model
 * @author : zyh
 * @date : 2018-09-22 下午5:40
 */
@Setter
@Getter
@ToString
public class City {

    private String cityId;

    private String cityName;

    private String cityCode;

    private String province;


}
