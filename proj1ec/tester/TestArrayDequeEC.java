package tester;
import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.algs4.StdRandom;
public class TestArrayDequeEC {
    @Test
    public void testBetweenOneAndAHundred() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        for (int i = 0; i < 100; i += 1) {
            int num = StdRandom.uniform(1,100);
            if (num < 50) {
                ads.addFirst(num);
                sad.addFirst(num);
            } else {
                ads.addLast(num);
                sad.addLast(num);
            }
        }

        int actual;
        int expected;
        for (int i = 0; i < 50; i += 1) {
            actual = sad.removeFirst();
            expected = ads.removeFirst();
            assertEquals(expected, actual);
        }
        for (int i = 0; i < 50; i += 1) {
            actual = sad.removeLast();
            expected = ads.removeLast();
            assertEquals(expected, actual);
        }
    }
}
