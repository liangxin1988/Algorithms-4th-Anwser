package Answer.chapter1.section1;

import Answer.base.Answer0;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_22 extends Answer0 {
    @Override
    public void answer() {
        int a[] = {85,54,6,5,8,52,6,8,6,65,6,85,3};
        Arrays.sort(a);  //使用二分法查找前必须保证数组有序
        rankByLevel(52, a, 0, a.length - 1, 0);
    }

    private int rankByLevel(int key,int[] a,int lo,int hi,int level){
        println(ChapterUtil.getEmptyChar(level)+"lo = "+lo+",hi = "+hi);
        if(lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid]) return rankByLevel(key,a,lo,mid - 1,level + 1);
        else if(key > a[mid]) return rankByLevel(key,a,mid + 1,hi,level + 1);
        else return mid;
    }
}
