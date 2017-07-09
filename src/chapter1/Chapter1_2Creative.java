package chapter1;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.Date;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 * Created by liangxin on 2017/7/3.
 */
public class Chapter1_2Creative {

    public static void question15(){
        ChapterUtil.questionLue();
    }

    public static void question16(){
        print("测试加法：");println("4 / 9 + 2 / 8 = " + new Rational(4,9).plus(new Rational(2,8)));
        print("测试减法：");println("2 / 8 - 4 / 9 = " + new Rational(2,8).minus(new Rational(4,9)));
        print("测试乘法：");println("(2 / 5) * (1 / 4) = " + new Rational(2,5).times(new Rational(1,4)));
        print("测试除法：");println("(2 / 5) / (1 / 4) = " + new Rational(2,5).divides(new Rational(1,4)));
    }

    public static void question17(){
        ChapterUtil.questionNo();
    }

    public static void question18(){
        double[] nums = ChapterUtil.getRandomDoubleArray(10);
        Accumulator accumulator = new Accumulator();
        for(double num : nums){
            accumulator.addDataValue(num);
        }
        println("var = "+accumulator.var());
        println("mean = "+accumulator.mean());
        println("stddev = "+accumulator.stddev());
        println("count = "+accumulator.count());
    }

    public static void question19(){
        println(new Transaction("Turing 5/22/1939 11.99").toString());
    }

    /**1.2.19要求的类，只演示构造方法*/
    static class Transaction{
        private String who;
        private Date when;
        private double amount;
        Transaction(String str){
            String[] contents = str.split(" ");
            this.who = contents[0];
            this.amount = Double.parseDouble(contents[2]);
            this.when = new Date(contents[1]);
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "who='" + who + '\'' +
                    ", when=" + when +
                    ", amount=" + amount +
                    '}';
        }
    }

}

class Rational{
    //分子
    private final long numerator;
    //分母
    private final long denominator;

    Rational(long numerator,long denominator){
        if(denominator == 0){
            throw new RuntimeException("分母不能为0");
        }
        long gcd = gcd(numerator,denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private static long gcd(long p,long q){
        if(q == 0){
            return p;
        }
        return gcd(q,p % q);
    }

    public Rational plus(Rational b){
        return new Rational(this.numerator * b.denominator + b.numerator * this.denominator,this.denominator * b.denominator);
    }

    public Rational minus(Rational b){
        return new Rational(this.numerator * b.denominator - b.numerator * this.denominator,this.denominator * b.denominator);
    }

    public Rational times(Rational b){
        return new Rational(this.numerator * b.numerator,this.denominator * b.denominator);
    }

    public Rational divides(Rational b){
        return new Rational(this.numerator * b.denominator,this.denominator * b.numerator);
    }

    @Override
    public String toString() {
        if(!getSign())
            return numerator +" / "+denominator;
        return "-( "+absolute(numerator) +" / "+absolute(denominator)+" )";
    }
    private long absolute(long num){
        return num > 0?num : -num;
    }
    /**判断符号，返回false为正数，否则返回负数*/
    private boolean getSign(){
        return (numerator > 0) ^ (denominator > 0);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        Rational r = (Rational) obj;
        if(r.numerator != this.numerator) return false;
        if(r.denominator != this.denominator) return false;
        return true;
    }
}

