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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i += 1) {
            int num = StdRandom.uniform(1,100);
            int selector = StdRandom.uniform(0,4);
            if (selector == 0) {

                ads.addFirst(num);
                sad.addFirst(num);
                sb.append("addFirst(").append(num).append(")\n");

            } else if (selector == 1) {
                ads.addLast(num);
                sad.addLast(num);
                sb.append("addLast(").append(num).append(")\n");

            } else if (selector == 2) {

                if (!ads.isEmpty()) {
                    int expected = ads.removeLast();
                    int actual = sad.removeLast();
                    sb.append("removeLast()\n");
                    assertEquals(String.valueOf(sb), expected, actual);
                }

            }else{
                if (!ads.isEmpty()) {
                    int expected = ads.removeFirst();
                    int actual = sad.removeFirst();
                    sb.append("removeFirst()\n");
                    assertEquals(String.valueOf(sb), expected, actual);
                }

            }
        }


    }
}
