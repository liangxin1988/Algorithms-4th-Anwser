package Answer.chapter1.section1;

import Answer.base.Answer2Integer;
import framework.Fixme;
import util.ChapterUtil;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
@Fixme
public class Ex_27 extends Answer2Integer {
    @Override
    public void answer() {
        int N = getArgs1(),k = getArgs2();
        Checker.checkPlus(N,k);
        double p = 0.25;
//		println(binomial(N,k,p));  //未优化版本时间执行时间灰常的长，所以这里只能将其注释
        println(binomialFaster(N,k,p));
        print("估计调用次数：");
        ChapterUtil.questionNo();

    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{100,50};
    }

    /**不带有缓存的实现*/
    private static double binomial(int N,int k,double p){
        if(N == 0 && k == 0) return 1.0;
        if(N < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(N - 1,k,p) + p * binomial(N - 1,k - 1,p);
    }

    /**在binomialFaster方法中使用的缓存数据*/
    private static double[][] binomialFasterCache = new double[150][150];
    static{
        for(int i = 0;i<150;i++){
            for(int j = 0;j<150;j++){
                binomialFasterCache[i][j] = Double.MIN_VALUE;
            }
        }
    }

    /**带有缓存的实现*/
    private static double binomialFaster(int N,int k,double p){
        if(N == 0 && k == 0) return 1.0;
        if(N < 0 || k < 0) return 0.0;
        if(binomialFasterCache[N][k] == Double.MIN_VALUE){
            binomialFasterCache[N][k] =  (1.0 - p) * binomialFaster(N - 1,k,p) + p * binomialFaster(N - 1,k - 1,p);
        }
        return binomialFasterCache[N][k];
    }


}
