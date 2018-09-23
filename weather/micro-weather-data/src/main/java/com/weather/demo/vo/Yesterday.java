package com.weather.demo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author : zyh
 * @Description : com.weather.report.vo
 * @date : 2018-09-23 下午2:48
 */
@Setter
@Getter
@ToString
public class Yesterday implements Serializable {

    private static final long serialVersionUID = 1L;
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
