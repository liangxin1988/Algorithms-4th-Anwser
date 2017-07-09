package Answer.chapter1.section1;

import Answer.base.Answer1Integer;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_14 extends Answer1Integer {
    @Override
    public void answer() {
        int a = getArgs1();
//		a = StdRandom.uniform(100);  //打开后可通过多次调用验证
//		println(Math.log(a) / Math.log(2));  //以2为底的对数，打开注释可作为对照
        int count = 0;
        for(int i = 1;i<=a;i*=2){
            count++;
        }
        print(count-1);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{9};
    }
}
