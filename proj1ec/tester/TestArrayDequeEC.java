package tester;
import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.algs4.StdRandom;
public class TestArrayDequeEC {
    @Test
    public void randomizeTest() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        String message = "\n";
        int n = 5000;

        for (int i = 0; i < n; i++) {

            int selector = StdRandom.uniform(0,4);
            if (selector == 0) {
                int num = StdRandom.uniform(0, 100);
                ads.addFirst(num);
                sad.addFirst(num);
                message += "addFirst(" + num + ")\n";

            } else if (selector == 1) {
                int num = StdRandom.uniform(0, 100);
                ads.addLast(num);
                sad.addLast(num);
                message += "addLast(" + num + ")\n";

            }
            if (sad.isEmpty()){
                continue;
            };

            if (selector == 2) {
                int expected = ads.removeFirst();
                int actual = sad.removeFirst();
                message += "removeFirst()\n";
                assertEquals(message, expected, actual);

            } else if (selector == 3) {
                int expected = ads.removeLast();
                int actual = sad.removeLast();
                message += "removeLast()\n";
                assertEquals(message, expected, actual);


            }
        }


    }
}
