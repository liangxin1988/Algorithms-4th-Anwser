package Answer.chapter2.section1;

import Answer.base.Answer0;
import Answer.base.Answer1Integer;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_3 extends Answer1Integer {
    @Override
    public void answer() {
        int N = getArgs1();
        int num[] = new int[N];
        for(int i = 0;i<num.length;i++){
            num[i] = num.length - i;
        }
        println(Arrays.toString(num));  //给定一个倒序数组，每次内循环从前往后遍历都能找到更小的元素。
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{10};
    }
}