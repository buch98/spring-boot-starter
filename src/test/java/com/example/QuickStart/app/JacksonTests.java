package com.example.QuickStart.app;


import com.example.QuickStart.app.Entity.BookEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTests {

    @Test
    public void testThatObjectMapperCanCreateJsonFromJavaObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        BookEntity book = BookEntity.builder().isbn("978").title("title1").build();
        String s = objectMapper.writeValueAsString(book);
        assertThat(s).isEqualTo("{\"isbn\":\"978\",\"title\":\"title1\",\"author\":null}");

    }
}
