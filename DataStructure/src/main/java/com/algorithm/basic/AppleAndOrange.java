package com.algorithm.basic;

import java.util.Scanner;

public class AppleAndOrange {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        in.close();
        int s_a = 0;
        int s_o = 0;
        for(int i=0;i<m;i++){
            int temp = apple[i]+a;
            if((temp >= s) && (temp <= t)){
                s_a++;
            }
        }

        for(int y=0;y<n;y++){
            int temp = orange[y]+b;
            if((temp >= s) && (temp <= t)){
                s_o++;
            }
        }
        System.out.println(s_a);
        System.out.println(s_o);
    }

}
