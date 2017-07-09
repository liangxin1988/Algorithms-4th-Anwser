package Answer.chapter1.section1;

import Answer.base.Answer1Integer;
import util.ChapterUtil;
import util.Checker;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_15 extends Answer1Integer{
    @Override
    public void answer() {
        int num = getArgs1();
        Checker.checkPlus(num);
        int[] nums = new int[num * num];  //num * num没啥具体含义，就是想让元素个数多一些
        ChapterUtil.initRandomArray(nums, num);
        println("打印原始数组：");
        println(Arrays.toString(nums));
        println("打印统计数组");
        println(Arrays.toString(histogram(nums,num)));
    }

    private static int[] histogram(int[] a,int m){
        int[] count = new int[m];
        for(int i : a){
            count[i]++;
        }
        return count;
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{5};
    }
}
