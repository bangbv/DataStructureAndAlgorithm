package com.algorithm.interview.world_quant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarParkingRoof {
    public static void main(String[] args) throws Exception {
        System.out.println("CarParkingRoof");
        ClassLoader classLoader = Question21.class.getClassLoader();
        String filename = java.net.URLDecoder.decode(classLoader.getResource("car_parking_roof_input.txt").getPath(), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Long> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long lot = Long.parseLong(bufferedReader.readLine());
            cars.add(lot);
        }
        int k = Integer.parseInt(bufferedReader.readLine());
        System.out.println(carParkingRoof(cars, k));
        bufferedReader.close();
    }

    public static long carParkingRoof(List<Long> cars, int k) {
        if (cars.size() == 0 || k < 0) {
            return 0;
        }
        Collections.sort(cars);
        long minDist = Long.MAX_VALUE;

        for (int i = 0; i <= cars.size() - k; i++) {
            long w = cars.get(i + k - 1);
            minDist = Math.min(minDist, w - cars.get(i));
        }
        return minDist + 1;
    }
}
