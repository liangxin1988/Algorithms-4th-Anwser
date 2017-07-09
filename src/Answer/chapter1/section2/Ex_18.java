package Answer.chapter1.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Accumulator;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_18 extends Answer0 {
    @Override
    public void answer() {
        double[] nums = ChapterUtil.getRandomDoubleArray(10);
        Accumulator accumulator = new Accumulator();
        for(double num : nums){
            accumulator.addDataValue(num);
        }
        println("var = "+accumulator.var());
        println("mean = "+accumulator.mean());
        println("stddev = "+accumulator.stddev());
        println("count = "+accumulator.count());

    }
}
