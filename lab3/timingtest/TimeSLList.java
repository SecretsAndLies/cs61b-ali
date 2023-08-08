package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static SLList<Integer> createSListWithNElements(int itemCount) {
        SLList<Integer> slist = new SLList<>();
        for (int i = 0; i < itemCount; i++) {
            slist.addLast(i);
        }
        return slist;
    }

    public static void getNElementsFromList(SLList<Integer> list, int n) {
        for (int i = 0; i < n; i++) {
            list.getLast();
        }
    }

    public static void timeGetLast() {
        AList<Integer> Ns = new AList<>();
        AList<Integer> numberOfOperations = new AList<>();
        AList<Double> times = new AList<>();

        int N = 1000;
        while (N <= 128000) {
            SLList<Integer> list = createSListWithNElements(N);

            int M = 10000;
            Stopwatch sw = new Stopwatch();
            getNElementsFromList(list, 10000);
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            Ns.addLast(N);
            numberOfOperations.addLast(M);

            N = N * 2;
        }


        printTimingTable(Ns, times, numberOfOperations);

    }

}
