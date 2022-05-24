package com.yahya.challenge4;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestConfiguration
public class test {
//    @Bean
//    public HttpClient
    @Test
    public void testSpy(){
        List<String> list = new ArrayList<>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("A");
        spyList.add("B");

        Mockito.verify(spyList).add("A");
        Mockito.verify(spyList).add("B");

        assertEquals(2,spyList.size());

    }
}
