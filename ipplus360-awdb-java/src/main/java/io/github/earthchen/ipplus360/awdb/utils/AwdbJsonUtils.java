package io.github.earthchen.ipplus360.awdb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author earthchen
 * @date 2021/1/22
 **/
public class AwdbJsonUtils {

    private static final Logger log = LoggerFactory.getLogger(AwdbJsonUtils.class);

    public static final ObjectMapper OBJECT_MAPPER = getObjectMapper();

    public static <T> T nodeToBean(JsonNode node, Class<T> clazz) {
        if (node == null) {
            return null;
        } else {
            return OBJECT_MAPPER.convertValue(node, clazz);
        }
    }

    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(str, clazz);
            } catch (IOException var4) {
                log.error("反序列化失败", var4);
                return null;
            }
        }
    }


    public static <T> T stringToBean(String str, JavaType javaType) {
        if (str == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(str, javaType);
            } catch (IOException var4) {
                log.error("反序列化失败", var4);
                return null;
            }
        }
    }

    public static <T> String beanToString(T value) {
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException var3) {
            log.error("序列化失败", var3);
            return null;
        }
    }

    public static <T> T stringToBean(String str, TypeReference<T> clazz) {
        if (str == null) {
            return null;
        } else {
            try {
                return OBJECT_MAPPER.readValue(str, clazz);
            } catch (IOException var4) {
                log.error("反序列化失败", var4);
                return null;
            }
        }
    }


    private static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        return objectMapper;
    }

}
