package com.algorithm.interview;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class L_1 {

	public static void main(String[] args) {
		String s = "00:01:07,400-234-090\n" + "00:05:01,701-080-080\n" + "00:05:00,400-234-090";
		try {
			BufferedReader reader = new BufferedReader(new StringReader(s));
			String line;
			int number;
			int lDuration = 0;
			int lNumber = 0;
			int amount = 0;

			Map<Integer, Integer> map = new HashMap<>();
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				String[] aLine = line.split(",");
				int duration = convertTimeDuration(aLine[0]);
				number = (Integer.valueOf(aLine[1].split("-")[0]) * 1000000)
						+ (Integer.valueOf(aLine[1].split("-")[0]) * 1000) + Integer.valueOf(aLine[1].split("-")[0]);
				
				if (map.containsKey(number)) {
					duration += map.get(number) ;
					map.put(number, duration);
				} else {
					map.put(number, duration);
				}
				
				if (duration > lDuration) {
					lDuration = duration;
				} else if (duration == lDuration) {
					if (number < lNumber) {
						lDuration = duration;
					}
				}
			}

			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				number = entry.getKey();
				int duration = entry.getValue();
				if(duration != lDuration) {
					String str_duration = convertDurationTime(duration);
					String[] aTime = str_duration.split(":");
					int hour = Integer.valueOf(aTime[0]);
					int minute = Integer.valueOf(aTime[1]);
					int second = Integer.valueOf(aTime[2]);
					if (hour == 0 && minute < 5) { // case 1
						amount += (((minute * 60) + second) * 3);
					} else if (hour == 0 && minute >= 5 && second == 0) {
						amount += (minute * 150);
					} else if (hour == 0 && minute >= 5 && second > 0) {
						amount += ((minute + 1) * 150);
					}	
				}
			}
			
			System.out.println("result:" + amount);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int convertTimeDuration(String string) {
		int duration = 0;
		String[] aTime = string.split(":");
		int hour = Integer.valueOf(aTime[0]);
		int minute = Integer.valueOf(aTime[1]);
		int second = Integer.valueOf(aTime[2]);
		duration += ((hour * 3600) + (minute * 60) + second);
		return duration;
	}
	
	private static String convertDurationTime(int duration) {
		   int hours = duration / 3600;
		    int secondsLeft = duration - hours * 3600;
		    int minutes = secondsLeft / 60;
		    int seconds = secondsLeft - minutes * 60;

		    String formattedTime = "";
		    if (hours < 10)
		        formattedTime += "0";
		    formattedTime += hours + ":";

		    if (minutes < 10)
		        formattedTime += "0";
		    formattedTime += minutes + ":";

		    if (seconds < 10)
		        formattedTime += "0";
		    formattedTime += seconds ;
		    return formattedTime;
	}
}
