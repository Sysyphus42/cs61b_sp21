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

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> N = new AList<>();
        AList<Double> time = new AList<>();
        AList<Integer> ops = new AList<>();
        int M = 10000;
        int length = 1000;
        while (length <= 128000) {
            SLList<Integer> SL = new SLList<>();
            for (int i = 0; i < length; i++) {
                SL.addLast(i);
            }
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < M; i++) {
                SL.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            N.addLast(length);
            time.addLast(timeInSeconds);
            ops.addLast(M);
            length = length * 2;
        }
        printTimingTable(N, time, ops);
    }

}
