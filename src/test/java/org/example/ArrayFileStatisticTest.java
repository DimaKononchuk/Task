package org.example;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFileStatisticTest {

    private ArrayFileStatistic arrayFileStatistic=new ArrayFileStatistic(new BufferedReader(new InputStreamReader(new FileInputStream("10m.txt"))));

    ArrayFileStatisticTest() throws FileNotFoundException {
    }


    @Test
    void testMax(){
        assertEquals(49999978,arrayFileStatistic.getMaxNumber());
    }


    @Test
    void testMin(){
        assertEquals(-49999996,arrayFileStatistic.getMinNumber());
    }

    @Test
    void testAverage(){
        assertEquals(7364.0,arrayFileStatistic.getAverage());
    }


    @Test
    void testMediana(){
        assertEquals(25216.0,arrayFileStatistic.getMediana());
    }


}