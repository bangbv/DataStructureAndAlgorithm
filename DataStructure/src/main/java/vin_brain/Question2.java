package vin_brain;

import com.algorithm.sort.QuickSort;

import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public static void main(String[] args) {
        System.out.println("Question2");
        List<Integer> avg = new ArrayList<>();
        avg.add(0);
        avg.add(1);
        avg.add(0);
        avg.add(1);
        System.out.println(minMoves(avg));

    }

    public static int minMoves(List<Integer> avg) {
        QuickSort qs = new QuickSort();
        int[] input = new int[avg.size()];
        for(int i =0;i<avg.size();i++){
            input[i] = avg.get(i);
        }
        qs.quicksort(input,0,input.length-1);
        print(input);
        return 0;
    }

    static void print(int[] a) {
        for(int i = 0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
