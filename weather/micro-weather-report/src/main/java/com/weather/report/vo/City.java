package com.weather.report.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : zyh
 * @Description : com.weather.report.vo
 * @date : 2018-09-23 下午2:45
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
