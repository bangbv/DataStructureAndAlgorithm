package com.algorithm.hmm;

import java.text.*;


public class HMM {
    /**
     * number of states
     */
    public int numStates;
    /**
     * size of output vocabulary
     */
    public int sigmaSize;
    /**
     * initial state probabilities
     */
    public double pi[];
    /**
     * transition probabilities
     */
    public double a[][];

    /**
     * emission probabilities
     */
    public double b[][];

    DecimalFormat fmt = new DecimalFormat();

    /**
     * initializes an HMM.
     *
     * @param numStates number of states
     * @param sigmaSize size of output vocabulary
     */
    public HMM(int numStates, int sigmaSize) {
        this.numStates = numStates;
        this.sigmaSize = sigmaSize;

        pi = new double[numStates];
        a = new double[numStates][numStates];
        b = new double[numStates][sigmaSize];

        fmt.setMinimumFractionDigits(4);
        fmt.setMaximumFractionDigits(4);
    }


    /**
     * implementation of the Baum-Welch Algorithm for HMMs.
     *
     * @param o     the training set
     * @param steps the number of steps
     */
    public void train(int[] o, int steps) {
        int T = o.length;
        double[][] fwd;
        double[][] bwd;

        double pi1[] = new double[numStates];
        double a1[][] = new double[numStates][numStates];
        double b1[][] = new double[numStates][sigmaSize];

        for (int s = 0; s < steps; s++) {
            /*
             * calculation of Forward- und Backward Variables from the current model
             */
            fwd = forwardProc(o);
            printFB(fwd);
            bwd = backwardProc(o);
            printFB(bwd);
            /* re-estimation of initial state probabilities */
            for (int i = 0; i < numStates; i++)
                pi1[i] = gamma(i, 0, o, fwd, bwd);
            /* re-estimation of transition probabilities */
            System.out.println("re-estimation of transition probabilities");
            for (int i = 0; i < numStates; i++) {
                for (int j = 0; j < numStates; j++) {
                    double num = 0, denom = 0;
                    for (int t = 0; t <= T - 1; t++) {
                        num += p(t, i, j, o, fwd, bwd);
                        denom += gamma(i, t, o, fwd, bwd);
                    }
                    a1[i][j] = num / denom;
                    System.out.println("a1(" + i + "," + j + ") = " + fmt.format(num) + "/" + fmt.format(denom) + "=" + fmt.format(a1[i][j]) + "  ");
                }
            }
            /* re-estimation of emission probabilities */
            System.out.println("re-estimation of emission probabilities");
            for (int i = 0; i < numStates; i++) {
                for (int k = 0; k < sigmaSize; k++) {
                    double num = 0, denom = 0;
                    for (int t = 0; t <= T - 1; t++) {
                        double g = gamma(i, t, o, fwd, bwd);
                        num += g * (k == o[t] ? 1 : 0);
                        denom += g;
                    }
                    b1[i][k] = num / denom;
                }
            }
            pi = pi1;
            a = a1;
            b = b1;
        }
    }

    /**
     * calculation of Forward-Variables f(i,t) for state i at time t for output
     * sequence O with the current HMM parameters
     * @param o the output sequence O
     * @return an array f(i,t) over states and times, containing the
     */
    public double[][] forwardProc(int[] o) {
        int T = o.length;
        double[][] fwd = new double[numStates][T];
        /* initialization (time 0) */
        for (int i = 0; i < numStates; i++) {
            System.out.print(pi[i] + "x" + b[i][o[0]] + ":");
            fwd[i][0] = pi[i] * b[i][o[0]];
            System.out.print(fmt.format(fwd[i][0]));
        }
        /* induction */
        for (int t = 0; t <= T - 2; t++) {
            for (int j = 0; j < numStates; j++) {
                System.out.print("fwd(" + j + "," + (t + 1) + ") = ");
                fwd[j][t + 1] = 0;
                for (int i = 0; i < numStates; i++) {
                    fwd[j][t + 1] += (fwd[i][t] * a[i][j] * b[j][o[t + 1]]);
                }
                System.out.print(fmt.format(fwd[j][t + 1]) + "|");
            }
            System.out.println();
        }
        return fwd;
    }

    /**
     * calculation of Backward-Variables b(i,t) for state i at time t for output
     * sequence O with the current HMM parameters
     * @param o the output sequence O
     * @return an array b(i,t) over states and times, containing the
     * Backward-Variables.
     */
    public double[][] backwardProc(int[] o) {
        int T = o.length;
        double[][] bwd = new double[numStates][T];
        /* initialization (time 0) */
        for (int i = 0; i < numStates; i++)
            bwd[i][T - 1] = 1;
        /* induction */
        for (int t = T - 2; t >= 0; t--) {
            for (int i = 0; i < numStates; i++) {
                bwd[i][t] = 0;
                for (int j = 0; j < numStates; j++)
                    bwd[i][t] += (bwd[j][t + 1] * a[i][j] * b[j][o[t + 1]]);
            }
        }
        return bwd;
    }

    /**
     * calculation of probability P(X_t = s_i, X_t+1 = s_j | O, m).
     * @param t   time t
     * @param i   the number of state s_i
     * @param j   the number of state s_j
     * @param o   an output sequence o
     * @param fwd the Forward-Variables for o
     * @param bwd the Backward-Variables for o
     */
    public double p(int t, int i, int j, int[] o, double[][] fwd, double[][] bwd) {
        double num;
        if (t == o.length - 1)
            num = fwd[i][t] * a[i][j];
        else
            num = fwd[i][t] * a[i][j] * b[j][o[t + 1]] * bwd[j][t + 1];
        if (t < 2) {
            System.out.println("p:num = fwd(" + i + "," + t + ") * " + "bwd(" + j + "," + (t + 1) + ")=" + fmt.format(num));
        }
        double denom = 0;
        for (int k = 0; k < numStates; k++) {
            denom += (fwd[k][t] * bwd[k][t]);
            if (t < 2) {
                System.out.print("p: denom += fwd(" + k + "," + t + ") * " + "bwd(" + k + "," + t + ")=" + fmt.format(denom) + "   ");
            }
        }
        if (t < 2) {
            System.out.println();
        }
        return num / denom;
    }

    /**
     * computes gamma(i, t)
     */
    public double gamma(int i, int t, int[] o, double[][] fwd, double[][] bwd) {
        double num = fwd[i][t] * bwd[i][t];
        if (t < 2) {
            System.out.println("gamma:num = fwd(" + i + "," + t + ") * " + "bwd(" + i + "," + t + ")=" + fmt.format(num));
        }
        double denom = 0;
        for (int j = 0; j < numStates; j++) {
            denom += fwd[j][t] * bwd[j][t];
            if (t < 2) {
                System.out.print("gamma: denom += fwd(" + j + "," + t + ") * " + "bwd(" + j + "," + t + ")=" + fmt.format(denom) + "   ");
            }

        }
        if (t < 2) {
            System.out.println();
        }
        return num / denom;
    }

    /**
     * prints all the parameters of an HMM
     */
    public void print() {

        for (int i = 0; i < numStates; i++)
            System.out.println("pi(" + i + ") = " + fmt.format(pi[i]));
        System.out.println();

        for (int i = 0; i < numStates; i++) {
            for (int j = 0; j < numStates; j++)
                System.out.print("a(" + i + "," + j + ") = " + fmt.format(a[i][j]) + "  ");
            System.out.println();
        }

        System.out.println();
        for (int i = 0; i < numStates; i++) {
            for (int k = 0; k < sigmaSize; k++)
                System.out.print("b(" + i + "," + k + ") = " + fmt.format(b[i][k]) + "  ");
            System.out.println();
        }
    }

    private void printFB(double[][] fb) {
        for (int i = 0; i < fb.length; i++) {
            for (int j = 0; j < fb[i].length; j++)
                System.out.print("bwd(" + i + "," + j + ") = " + fmt.format(fb[i][j]) + "  ");
            System.out.println();
        }
    }
}
