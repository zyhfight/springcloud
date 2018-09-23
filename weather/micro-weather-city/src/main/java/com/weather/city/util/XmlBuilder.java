package com.weather.city.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author : zyh
 * @Description : com.weather.city.util
 * @date : 2018-09-23 下午3:44
 */
public class XmlBuilder {

    private static final Logger logger = LoggerFactory.getLogger(XmlBuilder.class);

    /**
     *  将XML转为指定的Object
     * @param clazz
     * @param xmlStr
     * @return
     */
    public static Object xmlStr2Object(Class<?> clazz, String xmlStr) {
        Object xmlObject = null;
        Reader reader = null;

        try{

            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            reader = new StringReader(xmlStr);
            xmlObject = unmarshaller.unmarshal(reader);

        }catch (Exception e){
            logger.error("xml to object Exception : {}", ExceptionUtils.getFullStackTrace(e));
        }finally {
            try{
                if(null != reader){
                    reader.close();
                }
            }catch (Exception e){
                logger.error("reader close Exception: {]", ExceptionUtils.getFullStackTrace(e));
            }

        }

        return xmlObject;

    }
}
