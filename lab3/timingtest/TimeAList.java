package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    private static void createAListWithNElements(int n) {
        AList<Integer> aListForTiming = new AList<>();
        for (int i = 0; i < n; i++) {
            aListForTiming.addLast(i);
        }
    }

    private static void createAndTimeAList(int opNum, AList<Integer> numberOfOperations, AList<Double> times) {
        numberOfOperations.addLast(opNum);


        Stopwatch sw = new Stopwatch();
        createAListWithNElements(opNum);
        double timeInSeconds = sw.elapsedTime();
        times.addLast(timeInSeconds);

    }

    public static void timeAListConstruction() {
        AList<Integer> numberOfOperations = new AList<>();
        AList<Double> times = new AList<>();

        int i = 1000;
        while (i <= 1e6) {
            createAndTimeAList(i, numberOfOperations, times);
            i = i * 2;
        }
        printTimingTable(numberOfOperations, times, numberOfOperations);
    }
}
