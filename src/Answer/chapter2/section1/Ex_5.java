package Answer.chapter2.section1;

import Answer.base.Answer0;
import Answer.base.Answer1Integer;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_5 extends Answer1Integer{
    @Override
    public void answer() {
        int N = getArgs1();
        int num[] = new int[N];
        for(int i = 0;i<num.length;i++){
            num[i] = i;
        }
        println(Arrays.toString(num));  //在插入排序的内循环中，如果数组已经有序，那么每次比较都为假，不执行交换
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{10};
    }
}
