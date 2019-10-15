package com.algorithm.hmm;

import java.io.*;

public class Test {
    public static void main(String argv[]) {
        HMM hmm = new HMM(2, 2);

        /** initial state probabilities */
        hmm.pi[0] = 0.2;
        hmm.pi[1] = 0.8;

        /** transition probabilities */
        hmm.a[0][0] = 0.5;
        hmm.a[0][1] = 0.5;
        hmm.a[1][0] = 0.3;
        hmm.a[1][1] = 0.7;

        /** emission probabilities */
        hmm.b[0][0] = 0.3;
        hmm.b[0][1] = 0.7;
        hmm.b[1][0] = 0.8;
        hmm.b[1][1] = 0.2;

        try {
            ClassLoader classLoader = Bw.class.getClassLoader();
            String filename = java.net.URLDecoder.decode(classLoader.getResource("input.txt").getPath(), "UTF-8");
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int olen = Integer.parseInt(br.readLine());
            int[] o = new int[olen];
            String os = br.readLine();

            for (int i = 0; i < olen; i++)
                o[i] = Integer.parseInt(os.substring(i, i + 1));

            System.out.println("Initial Parameters:");
            hmm.print();

            hmm.train(o, Integer.parseInt(argv[0]));

            System.out.println();

            System.out.println("Trained Model:");
            hmm.print();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("crazysoda.seq file not found. Create using 'java soda'");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Problem reading crazysoda.seq");
            System.exit(0);
        }
    }
}
