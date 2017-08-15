package Answer.chapter2.section5;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_3 extends Answer0 {
    @Override
    public void answer() {
        Balance a = new Balance();
        Balance b = new Balance();
        Balance c = new Balance();
        a.amount = 0;
        b.amount = a.amount + 0.005;
        c.amount = b.amount + 0.005;
        println("b比a："+b.compareTo(a));
        println("c比b："+c.compareTo(b));
        println("c比a："+c.compareTo(a));
        println("不满足传递性，a与b相等，b与c相等，但是a与c不相等");
        println("修改方法：去掉加减0.005的代码");
    }

    public static class Balance implements Comparable<Balance>{

        private double amount;
        @Override
        public int compareTo(Balance that) {
            if(this.amount < that.amount - 0.005){
                return -1;
            }
            if(this.amount > that.amount + 0.005){
                return 1;
            }
            return 0;
        }

    }
}