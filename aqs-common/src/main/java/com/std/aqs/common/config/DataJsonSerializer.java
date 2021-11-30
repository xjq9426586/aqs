package com.std.aqs.common.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

@JsonComponent
public class DataJsonSerializer {
    private static String[] PATTERNS;

    @Value("${tcp.date.patterns}")
    public void setPatterns(String[] patterns) {
        PATTERNS = patterns;
    }

    /**
     * 请求json日期格式化
     */
    public static class DateDeSerializer extends JsonDeserializer<Date> {
        //private static String[] PATTERNS = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss.SSS"};

        @Override
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
            String text = jsonParser.getText();
            Date parseDate = null;
            try {
                if(StringUtils.isNotEmpty(text)){

                    if(PATTERNS.length > 0){
                        parseDate = DateUtils.parseDate(text, PATTERNS);
                    }else {
                        parseDate = DateUtils.parseDate(text);
                    }
                }
            }catch (ParseException e) {
                throw new IllegalArgumentException(e.getCause());
            }
           return parseDate;
        }
    }


    /**
     * 响应json日期格式化
     * 先用nacos  date-format 配置
     */
//    public static class DateSerializer extends JsonSerializer<Date> {
//        private static String PATTERN = "yyyy-MM-dd HH:mm:ss";
//
//        @Override
//        public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//            jsonGenerator.writeString(DateUtil.dateToString(date, PATTERN));
//        }
//    }
}
