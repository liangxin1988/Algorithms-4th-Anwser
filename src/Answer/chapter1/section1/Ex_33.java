package Answer.chapter1.section1;

import Answer.base.Answer0;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_33 extends Answer0{
    @Override
    public void answer() {
        part1();
        println("------------------------------------------------");
        part2();
        println("---------------------------------------------------");
        part3();
        println("---------------------------------------------------");
        part4();
        println("---------------------------------------------------");
        part5();
    }

    private void part5() {
        println("测试向量乘以矩阵");
        double[] a = {0.15, 0.10, 0.15, 0.05};
        double[][] b = {{0, 0, 0.2, 0.3, 0.5},
                {0.1, 0.4, 0.4, 0.1, 0},
                {0, 0, 0, 0.5, 0.5},
                {0.4, 0.3, 0.3, 0, 0}};
        double[] result = new Matrix().mult(a, b);
        println("向量");
        ChapterUtil.printArray(a);
        println("矩阵：");
        ChapterUtil.printArray(b);
        println("向量与矩阵的乘积");
        ChapterUtil.printArray(result);
    }

    private void part4() {
        println("测试矩阵乘以向量");
        double[][] a = {{0, 0, 0.2, 0.3, 0.5},
                {0.1, 0.4, 0.4, 0.1, 0},
                {0, 0, 0, 0.5, 0.5},
                {0.4, 0.3, 0.3, 0, 0}};
        double[] b = {0.15, 0.1, 0.15, 0.05, 0.1};
        double[] result = new Matrix().mult(a, b);
        println("矩阵:");
        ChapterUtil.printArray(a);
        println("向量：");
        ChapterUtil.printArray(b);
        println("矩阵与向量的乘积：");
        ChapterUtil.printArray(result);
    }

    private void part3() {
        println("测试矩阵转置");
        double[][] a = {{1, 2, 3}, {4, 5, 6}};
        println("转置前");
        ChapterUtil.printArray(a);
        println("转置后");
        ChapterUtil.printArray(new Matrix().transpose(a));
    }

    private void part2() {
        println("测试矩阵积");
        double[][] a = {{1, 2, 3}, {4, 5, 6}};
        double[][] b = {{1, 4}, {2, 5}, {3, 6}};

        double[][] result = new Matrix().mult(a, b);

        println("矩阵1：");
        ChapterUtil.printArray(a);
        println("矩阵2：");
        ChapterUtil.printArray(b);

        println("乘积：");
        ChapterUtil.printArray(result);
    }

    private void part1() {
        println("测试向量点乘");
        double[] a = {1, 2, 3, 4, 5};
        double[] b = {6, 7, 8, 9, 0};

        println("a = " + Arrays.toString(a));
        println("b = " + Arrays.toString(b));

        println("a 与 b点乘：" + new Matrix().dot(a, b));
    }

    /**矩阵工具类*/
    class Matrix{
        /**向量点乘*/
        double dot(double[] x,double[] y){
            if(x == null || y == null ||x.length != y.length){
                throw new RuntimeException("参数不合法");
            }
            int count = 0;
            for(int i = 0;i<x.length;i++){
                count += x[i] * y[i];
            }
            return count;
        }

        /**矩阵乘法*/
        double[][] mult(double[][] a,double[][] b){
            if(a == null || b == null ||b[0] == null || a[0] == null || a[0].length != b.length){
                throw new RuntimeException("参数不合法");
            }
            double[][] result = new double[a.length][b[0].length];
            for(int i = 0;i<result.length;i++){
                for(int j = 0;j<result[0].length;j++){
                    result[i][j] = 0;
                    for(int k = 0;k < b.length;k++){
                        result[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return result;
        }

        /**矩阵转置*/
        double[][] transpose(double[][] a){
            if(a == null){
                throw new RuntimeException("参数不合法");
            }
            double[][] result = new double[a[0].length][a.length];
            for(int i = 0;i<result.length;i++){
                for(int j = 0;j<result[0].length;j++){
                    result[i][j] = a[j][i];
                }
            }
            return result;
        }

        /**矩阵乘以向量*/
        double[] mult(double[][] a,double[] x){
            if(a == null || x == null || a[0].length != x.length){
                throw new RuntimeException("参数不合法");
            }
            double[] result = new double[a.length];
            for(int i = 0;i<result.length;i++){
                for(int j = 0;j<x.length;j++){
                    result[i] += a[i][j] * x[j];
                }
            }
            return result;
        }

        /**向量乘以矩阵*/
        double[] mult(double[] y,double[][] a){
            if(a == null || y == null || a.length != y.length){
                throw new RuntimeException("参数不合法");
            }
            double[] result = new double[a[0].length];
            for(int i = 0;i<result.length;i++){
                for(int j = 0;j<a.length;j++){
                    result[i] += a[j][i] * y[j];
                }
            }
            return result;
        }
    }

}
