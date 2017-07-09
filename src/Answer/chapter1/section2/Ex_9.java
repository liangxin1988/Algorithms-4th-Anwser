package Answer.chapter1.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Counter;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_9 extends Answer0 {
    @Override
    public void answer() {
        Counter counter = new Counter("次");
        int[] x = new int[10000];
        ChapterUtil.initRandomArray(x, 10000);
        Arrays.sort(x);
        rank(5, x, counter); // 将counter传递给方法，相当于给方法传递地址。方法中通过地址修改的值，对所有对象的引用都起作用
        println(counter.tally());
    }

    private static int rank(int key, int[] a, Counter counter) {
        return rank(key, a, 0, a.length - 1, counter);
    }

    private static int rank(int key, int[] a, int lo, int hi, Counter counter) {
        if (lo > hi)
            return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) {
            counter.increment(); // 题意不明确，暂时按照使用key进行比较的次数理解。原题考察对象传递是可以在方法内直接修改值的，这种理解不影响题目
            return rank(key, a, lo, mid - 1, counter);
        } else if (key > a[mid]) {
            counter.increment();
            return rank(key, a, mid + 1, hi, counter);
        } else
            return mid;
    }
}
