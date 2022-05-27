package com.yahya.challenge4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class testSpy {
    @Test
    void testSpy(){
        List<String> list = new ArrayList<>();
        List<String> spyList = Mockito.spy(list);

        spyList.add("A");
        spyList.add("B");

        Mockito.verify(spyList).add("A");
        Mockito.verify(spyList).add("B");

        assertEquals(2,spyList.size());

    }
}
