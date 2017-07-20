package Answer.chapter1.section4;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_14 extends Answer0 {
    @Override
    public void answer() {
//        int[] a = {1, 2,-1,-2};
//        int[] a = {1, 2, -2, -1, 2, -1, 1, -2};
        int a = 10;
        for(int i = 0;i<10;i++){
            test(a);
            a *= 2;
        }
    }

    private void test(int size) {
        int[] a = ChapterUtil.getRandomIntArray(size);
        for(int i = 0;i<a.length;i++){
            if(StdRandom.bernoulli()){
                a[i] = -a[i];
            }
        }
        long time = System.currentTimeMillis();
        println(sum_4(a));
        long time1 = System.currentTimeMillis() - time;
        time = System.currentTimeMillis();
        println(sum_4_fast(a));
        long time2 = System.currentTimeMillis() - time;
        println("普通循环用时:"+time1+"，优化版用时："+time2);
    }

    /**
     * 使用最普通的算法，用来做对照
     * */
    private long sum_4(int a[]){
        long count = 0;
        for(int i = 0;i < a.length;i++){
            for(int j = i + 1;j < a.length;j++){
                for(int k = j + 1;k < a.length;k++){
                    for(int l = k + 1;l < a.length;l++){
                        if(a[i] + a[j] + a[k] + a[l] == 0){
//                            println(a[i]+","+a[j]+","+a[k]+","+a[l]);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /*
    * 写了好久，逻辑不算简单，但是运行时间反而更长，灰常崩溃，待我慢慢优化
    * 第一个优化思路，不使用对象Key，而是直接使用3个数组
    * 第二个优化思路，自己写快速排序，非系统默认
    * */
    private long sum_4_fast(int a[]){
        long count = 0;
        int n = a.length;
        Key[] keys = new Key[(n - 1) * n / 2];
        int num1 = 0,num2 = 1;
        //执行（n - 1）* n / 2次初始化，先计算两两和
        for(int i = 0;i<keys.length;i++){
            keys[i] = new Key(a[num1] + a[num2],num1,num2);
            num2++;
            if(num2 == n){
                num1++;
                num2 = num1 + 1;
            }
        }

        Arrays.sort(keys);
        for(int i = 0;i<keys.length;i++){
            Key keyIndex = keys[i];
            int rankLeft = rankLeft(-keyIndex.key,keys,i + 1,keys.length - 1);
            int rankRight = rankRight(-keyIndex.key,keys,i + 1,keys.length - 1);
//            println("keyIndex = "+keyIndex+",rankLeft = "+rankLeft+",rankRight = "+rankRight);
            int rank = rankLeft;
            while(rank <= rankRight && rank != -1){
                Key keyRank = keys[rank];
                if(!keyRank.intersect(keyIndex)){
                    count++;
//                    println("***"+a[keyRank.index1]+"("+keyRank.index1+","+keyRank.index2+")"+","+
//                            a[keyRank.index2]+"("+keyRank.index1+","+keyRank.index2+")"+","+
//                            a[keyIndex.index1]+"("+keyIndex.index1+","+keyIndex.index2+")"+","+
//                            a[keyIndex.index2]+"("+keyIndex.index1+","+keyIndex.index2+")");
                }
                rank++;
            }
        }
        return count / 3;  //由于这种算法，每种组合（4个数）都会计算3遍（C(4,3)）所以需要除以3
    }

    //1.4.10中使用的优化版的二分法查找，只找最左边的
    private int rankLeft(int key,Key[] a,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(a[mid].key < key){
            return rankLeft(key,a,mid + 1,end);
        }else if(a[mid].key > key){
            return rankLeft(key,a,start,mid - 1);
        }else if(mid > start && a[mid - 1].key == key){
            return rankLeft(key,a,start,mid - 1);
        }else {
            return mid;
        }
    }

    private int rankRight(int key,Key[] a,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(a[mid].key < key){
            return rankRight(key,a,mid + 1,end);
        }else if(a[mid].key > key){
            return rankRight(key,a,start,mid - 1);
        }else if(mid < end && a[mid + 1].key == key){
            return rankRight(key,a,mid + 1,end);
        }else{
            return mid;
        }
    }

    private class Key implements Comparable<Key>{
        int key;
        int index1;
        int index2;

        Key(int key,int index1,int index2){
            this.key = key;
            this.index1 = index1;
            this.index2 = index2;
        }

        /**两个key是否公用了同一个元素*/
        public boolean intersect(Key o){
            if(this.index1 == o.index1 || this.index2 == o.index1
                    || this.index1 == o.index2 || this.index2 == o.index2){
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Key o) {
            return key - o.key;
        }

        @Override
        public String toString() {
            return ""+key;
//            return "("+"key = "+key+",index1 = "+index1+",index2 = "+index2+")\n";
        }
    }
}