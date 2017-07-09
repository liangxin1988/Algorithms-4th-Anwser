package Answer.chapter1.section1;

import Answer.base.Answer1Integer;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_19 extends Answer1Integer {
    @Override
    public void answer() {
        int x = getArgs1();
        if(x >= 40){
            println("所需时间较长，请耐心等待");
        }
        //粗略估算运行时间
        long time = System.currentTimeMillis();
        println(new Fibonacci().F(x));
        println("使用时间："+(System.currentTimeMillis() - time));
        time = System.currentTimeMillis();
        println(new FibonacciFaster().F(x));
        println("使用时间："+(System.currentTimeMillis() - time));
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{50};
    }


    /**1.1.19原题中的斐波那契计算类*/
    class Fibonacci{
        long F(int N){
            if(N == 0) return 0;
            if(N == 1) return 1;
            return F(N - 1) + F(N - 2);
        }
    }
    /**1.1.19中斐波那契计算类的优化版本通过数组缓存计算的中间结果*/
    class FibonacciFaster{
        /**最为缓存使用的数组。为了简化操作，长度定为100*/
        long cache[] = new long[100];
        long F(int N){
            if(N >= 100){
                throw new RuntimeException("请输入0 ~ 99的整数");
            }
            if(N == 0) return 0;
            if(N == 1) return 1;
            if(cache[N] == 0){
                cache[N] =  F(N - 1) + F(N - 2);
            }
            return cache[N];
        }
    }
}
