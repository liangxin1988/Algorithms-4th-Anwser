package Answer.chapter1.section1;

import Answer.base.Answer1Integer;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_20 extends Answer1Integer {
    @Override
    public void answer() {
        int x = getArgs1();
        Checker.checkPlus(x);
        println(Math.log(factorial(x)));
        print(lnFactorial(x));
    }

    private static long factorial(int x){
        if(x == 1) return 1;
        return factorial(x - 1) * x;  //阶乘等于当前数乘以上一个数的阶乘
    }

    private static double lnFactorial(int x){
        if(x == 1) return Math.log(1);
        return lnFactorial(x - 1) + Math.log(x);  //由于乘积的对数等于对数的和（log(a * b) == log(a) + log(b)），所以原题可以简化为递归计算对数和
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{10};
    }
}
