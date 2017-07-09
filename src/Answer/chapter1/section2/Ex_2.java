package Answer.chapter1.section2;

import Answer.base.Answer1Integer;
import Answer.base.Answer2;
import Answer.base.convert.ArgsConvert;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdRandom;
import util.Checker;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_2 extends Answer1Integer {
    @Override
    public void answer() {
        int count = getArgs1();
        Checker.checkPlus(count);
        String[] interval1d = null;
        Interval1D[] intervals = new Interval1D[count];

        boolean isRandom = interval1d == null || interval1d.length != count * 2;
        for (int i = 0; i < intervals.length; i++) {
            int min = 0, max = 0;
            if (isRandom) {
                min = StdRandom.uniform(100);
                max = StdRandom.uniform(100);
                if (min > max) {
                    int temp = min;
                    min = max;
                    max = temp;
                }
            } else {
                min = Integer.parseInt(interval1d[i * 2]);
                max = Integer.parseInt(interval1d[i * 2 + 1]);
            }
            intervals[i] = new Interval1D(min, max);
        }

        println(Arrays.toString(intervals)); // 测试

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i].intersects(intervals[j])) {
                    println("interval_1 = " + intervals[i] + ",interval_2 = "
                            + intervals[j]);
                }
            }
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{5};
    }
}
