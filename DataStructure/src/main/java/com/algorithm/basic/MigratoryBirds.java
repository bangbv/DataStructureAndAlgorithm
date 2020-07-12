package com.algorithm.basic;

import java.util.*;

public class MigratoryBirds {
    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(2);
        arr.add(3);
        System.out.println(migratoryBirds(arr));
    }

    static int migratoryBirds(List<Integer> arr) {
        int length = arr.size();
        int result = 0;
        int largestBird = 0;
        Map m = new HashMap<Integer,Integer>();
        for(int i = 0;i< length;i++){
            int birdType = arr.get(i);
            if(m.containsKey(birdType)) {
                int number = (int)m.get(birdType) + 1;
                m.put(birdType, number);
            } else {
                m.put(birdType, 1);
            }
        }
        Set<Integer> keys = m.keySet();
        for (Integer key :keys) {
            int number = (int)m.get(key);
            if(number > largestBird){
                largestBird = number;
                result = key;
            }
        }
        return result;
    }

}
