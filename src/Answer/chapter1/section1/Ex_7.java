package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_7 extends Answer0 {

    private void part1(){
        println("a:");
        double t = 9.0;
        while(Math.abs(t - 9.0/t) > .001) //牛顿迭代法求平方根
            t = (9.0/t + t)/2.0;
        printf("%.5f\n",t);
    }

    private void part2(){
        println("b:");
        int sum = 0;
        for(int i = 1;i<1000;i++){  //外层循环执行999次
            for(int j = 0;j<i;j++){  //内层循环执行次数与i一致
                sum++;
            }
        }
        println(sum);  //执行次数为1，2，3...999的等差数列，使用等差数列求和公式可得答案
    }

    private void part3(){
        println("c:");
        int sum = 0;
        for(int i = 1;i<1000;i*=2){  //外层循环执行10次（2的10次方为1024，从i=1(2^0)一直执行到i=512(2^9)，一共10次）
            for(int j = 0;j<1000;j++){  //内层循环每次固定执行1000次。
                sum++;
            }
        }
        println(sum);  //内外层循环相乘，等于10000
    }
    @Override
    public void answer() {
        part1();
        part2();
        part3();
    }
}
