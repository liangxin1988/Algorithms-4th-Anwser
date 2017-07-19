package Answer.chapter1.section4;

import Answer.base.Answer0;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_12 extends Answer0 {
    @Override
    public void answer() {
        int[] a = ChapterUtil.getRandomIntArray(10);
        int[] b = ChapterUtil.getRandomIntArray(15);
        Arrays.sort(a);
        Arrays.sort(b);
        printSortArray(a,b);
    }

    /**
     * 将两个有序数组按有序的方式输出
     * 参考归并排序算法
     * */
    private void printSortArray(int[] a1,int[] a2){
        int index1 = 0;
        int index2 = 0;

        //遍历两个数组
        for(int i = 0;i<a1.length + a2.length;i++){
            if(index1 == a1.length){  //a1集合打印完毕
                printf("%d ",a2[index2++]);
            }else if(index2 == a2.length){  //a2集合打印完毕
                printf("%d ",a1[index1++]);
            }else{
                printf("%d ",a1[index1] < a2[index2] ? a1[index1++] : a2[index2++]);
            }
        }
    }
}