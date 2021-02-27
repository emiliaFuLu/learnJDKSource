package com.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author: fl
 * @data: 2020-06-27 12:02
 * @description:
 **/
public class test_2 {
    @Test
    public void test1(){
        ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();

        skipListMap.put(3,"3");
        skipListMap.put(6,"6");
        skipListMap.put(7,"7");
        skipListMap.put(9,"9");
        skipListMap.put(12,"12");
        skipListMap.put(17,"17");
        skipListMap.put(19,"19");
        skipListMap.put(21,"21");
        skipListMap.put(25,"25");
        skipListMap.put(26,"26");
        System.out.println("skipListMap = " + skipListMap);


    }

    @Test
    public void test2(){
        Map<String,String> map = new HashMap<>();
    }
}
