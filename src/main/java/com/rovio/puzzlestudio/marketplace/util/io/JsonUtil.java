package com.rovio.puzzlestudio.marketplace.util.io;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JsonUtil {

    private final ObjectMapper objectMapper;

    String createJson(Map<String, String> map) throws JsonProcessingException {
        return objectMapper.writeValueAsString(map);
    }

    public String createJsonFromObject(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public Object createObjectFromJson(String json, Class className) throws IOException {
        return objectMapper.readValue(json, className);
    }

}
