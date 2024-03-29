package com.rjw.shortLink.admin.serializer;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @program: shortLink
 * @description:
 * @author: 饶嘉伟
 * @create: 2024-03-26 19:59
 **/
public class PhoneDesensitizationSerializer extends JsonSerializer<String> {


    @Override
    public void serialize(String o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String phone = DesensitizedUtil.mobilePhone (o);
        jsonGenerator.writeString (phone);
    }
}
