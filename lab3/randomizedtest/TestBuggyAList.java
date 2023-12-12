package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        correct.addLast(1);
        buggy.addLast(1);
        correct.addLast(2);
        buggy.addLast(2);
        correct.addLast(5);
        buggy.addLast(5);
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
        assertEquals(correct.removeLast(), buggy.removeLast());
    }
    @Test
    public void randomTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> B = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
                assertEquals(L.size(),B.size());
            } else if (operationNumber == 1) {
                // size
                if (L.size() == 0) {
                    continue;
                }
                int removeLastL = L.removeLast();
                int removeLastB = B.removeLast();
                //System.out.println("removeLast(" + removeLast + ")" );
                assertEquals(removeLastL, removeLastB);
            } else {
                // getLast
                if (L.size() == 0) {
                    continue;
                }
                int getLastL = L.getLast();
                int getLastB = B.getLast();
                //System.out.println("getLast(" + getLast + ")");
                assertEquals(getLastL, getLastB);
            }
        }
    }

}
