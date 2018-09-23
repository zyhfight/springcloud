package com.weather.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author : zyh
 * @Description : 未来天气
 * @date : 2018-09-23 下午2:46
 */
@Setter
@Getter
@ToString
public class Forecast implements Serializable {

    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;


}
