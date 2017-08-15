package Answer.chapter2.section5;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_6 extends Answer0 {
    @Override
    public void answer() {
        Integer[] is = new Integer[10];
        for(int i = 0;i < is.length;i++){
            is[i] = i;
        }
        StdRandom.shuffle(is);
        for(int i = 0;i<is.length;i++){
            println(select(is, 0, is.length - 1, i));
        }
    }

    public Comparable select(Comparable[] a,int start,int end,int k){
        int mid = partition(a, start, end);
        if(mid == k){
            return a[mid];
        }
        if(mid > k){
            return select(a,start,mid - 1,k);
        }else if(mid < k){
            return select(a,mid + 1,end,k);
        }
        return null;
    }

    public static int partition(Comparable[] a,int start,int end){
        int i = start;
        int j = end + 1;
        Comparable min = a[start];
        while(true){
            while(i < end){
                if(less(min,a[++i])){
                    break;
                }
            }
            while(j > start){
                if(less(a[--j],min)){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exch(a, i, j);
        }
        exch(a,start,j);
        return j;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}