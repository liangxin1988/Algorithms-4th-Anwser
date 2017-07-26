package Answer.chapter1.section5;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdStats;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_21 extends Answer0 {
    @Override
    public void answer() {
        String format = "%7s%10s%13s\n";
        printf(format,"n","mean","1/2 n ln n");
        println("------------------------------");
        int repeatCount = 1000;        //单次测试循环次数
        for(int i = 100;i<=409600;i *= 2){
            int N = i;
            Accumulator accumulator = new Accumulator();
            for(int j = 0; j < repeatCount; j++){
                accumulator.addDataValue(Ex_17.count(N));
            }
            printf(format,""+N,String.format("%.0f",accumulator.mean()),String.format("%.0f",(N / 2.0) * Math.log(N)));
        }
    }
}