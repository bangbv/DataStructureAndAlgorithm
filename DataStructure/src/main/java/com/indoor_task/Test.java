package com.indoor_task;

public class Test {
    public static void main(String[] args) {

//        DwVector[] input = new DwVector[] {
//                new DwVector(-70,-45,-60),
//                new DwVector(-75, -40, -60),
//                new DwVector(-80, -51, -65)
//        };

//        DwVector[] input = new DwVector[] {
//                new DwVector(-70,-75,-80),
//                new DwVector(-45, -40, -51),
//                new DwVector(-60, -60, -65)
//        };

        DwVector[] input = new DwVector[] {
                new DwVector(58,91),
                new DwVector(58,92),
                new DwVector(58,90),
                new DwVector(57,89),
                new DwVector(58,92),
                new DwVector(57,88),
                new DwVector(28,63),
                new DwVector(28,63),
                new DwVector(28,63),
                new DwVector(27,62),
                new DwVector(27,63)
        };
//        58.21361,91.88189
//        58.19605,92.21499
//        58.71823,90.31053
//        57.27837,89.90761
//        58.08202,92.00815
//        57.48945,88.08529
//        28.08874,63.51079
//        28.08547,63.5902
//        28.08727,63.12328
//        27.57803,62.82104
//        27.77992,63.51815

        PCA pca = new PCA(input);
        pca.compute();
    }
}
