package com.fl;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String,Integer> hashMap = new HashMap<>();

        hashMap.put("1",1);
        hashMap.put("2",2);
        hashMap.put("3",3);
        hashMap.put("4",4);
        hashMap.put("5",5);

        System.out.println(hashMap.toString());
    }
}
