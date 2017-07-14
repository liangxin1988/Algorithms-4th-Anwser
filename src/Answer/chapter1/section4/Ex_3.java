package Answer.chapter1.section4;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import framework.Fixme;
import framework.bean.Question;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;
@Fixme(info = "等Canvas框架完成后再进行绘图")
public class Ex_3 extends Answer0 {
    @Override
    public void answer() {
        for(int N = 250;true;N += N){
            double time = DoubleingTest.timeTrial(N);
            StdOut.printf("%7d %5.1f\n",N,time);
            if(N >= 8000){
                return;
            }
        }
    }

    public static class DoubleingTest{
        public static double timeTrial(int N){
            int MAX = 1000000;
            int[] a = new int[N];
            for(int i = 0;i<N;i++){
                a[i] = StdRandom.uniform(-MAX,MAX);
            }
            Stopwatch timer = new Stopwatch();
            int cnt = Ex_2.ThreeSum.count(a);
            return timer.elapsedTime();
        }
    }
}