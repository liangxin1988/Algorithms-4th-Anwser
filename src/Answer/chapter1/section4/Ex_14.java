package Answer.chapter1.section4;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_14 extends Answer0 {
    @Override
    public void answer() {

        int a = 10;
        for(int i = 0;i<10;i++){
            test(a);
            a *= 2;
        }
    }

    private void test(int size) {
//        int[] a = {1, 2,-1,-2};
//        int[] a = {1, 2, -2, -1, 2, -1, 1, -2};

        int[] a = ChapterUtil.getRandomIntArray(size);
        for(int i = 0;i<a.length;i++){
            if(StdRandom.bernoulli()){
                a[i] = -a[i];  //随机变化符号，不然都是正数相加不可能为0
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
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 逻辑太复杂了，而且提升了内存使用，希望有其他人提供更好的思路
     * */
    private long sum_4_fast(int a[]){
        long count = 0;
        final int n = a.length;
        final int arrayLength = (n - 1) * n / 2;
        int[] value = new int[arrayLength];
        int[] index1 = new int[arrayLength];
        int[] index2 = new int[arrayLength];
        int num1 = 0,num2 = 1;
        //执行（n - 1）* n / 2次初始化，先计算两两和，并保存两个数的索引，方便后续判断数字有效性
        for(int i = 0;i<arrayLength;i++){
            value[i] = a[num1] + a[num2];
            index1[i] = num1;
            index2[i] = num2;
            num2++;
            if(num2 == n){
                num1++;
                num2 = num1 + 1;
            }
        }
        //下面要进行二分法查找，所以这里需要对其进行排序（注意索引数组也要一起参与排序）
        sort(value,index1,index2,0,value.length - 1);

        for(int i = 0;i<arrayLength;i++){
            int keyIndex = value[i];
            //参考1.4.11题，用来获取当前key的最小索引和最大索引
            int rankLeft = rankLeft(-keyIndex,value,i + 1,arrayLength - 1);
            int rankRight = rankRight(-keyIndex,value,i + 1,arrayLength- 1);
            int rank = rankLeft;
            while(rank <= rankRight && rank != -1){
                //算法上无法规避，需要单独处理。四个元素中有重合的现象
                if(!intersect(index1,index2,i,rank)){
                    count++;
                }
                rank++;
            }
        }
        return count / 3;  //由于这种算法，每种组合（4个数）都会计算3遍（C(4,3)）所以需要除以3
    }

    /**
     * 自己写的快速排序
     * */
    private void sort(int[] a,int[] index1,int[] index2,int start,int end){
        if(end <= start){
            return;
        }
        int mid = partetion(a,index1,index2, start, end);
        sort(a,index1,index2,start,mid - 1);
        sort(a,index1,index2,mid + 1,end);
    }

    private int partetion(int[] a,int[] index1,int[] index2,int start,int end){
        int i = start,j = end + 1;
        while(true){
            while(a[++i]<a[start]){
                if(i == end){
                    break;
                }
            }
            while(a[start]<a[--j]){
                if(j == start){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exch(a,index1,index2, i, j);
        }
        exch(a,index1,index2, start, j);
        return j;
    }

    /**同时交换3个数组的元素*/
    private void exch(int[] a,int[] index1,int[] index2,int x,int y){
        exch(a,x,y);
        exch(index1,x,y);
        exch(index2,x,y);
    }

    /**交换单个数组的元素*/
    private void exch(int[] a,int x,int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    /**判断点是否重复使用了元素*/
    private boolean intersect(int[]a,int[]b,int x,int y){
        if(a[x] == b[x] || a[y] == b[y] ||
                a[x] == b[y] || a[y] == b[x] ||
                a[x] == a[y] || b[x] == b[y]){
            return true;
        }
        return false;
    }

    //1.4.10中使用的优化版的二分法查找，只找最左边的
    private int rankLeft(int key,int[] a,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(a[mid] < key){
            return rankLeft(key,a,mid + 1,end);
        }else if(a[mid] > key){
            return rankLeft(key,a,start,mid - 1);
        }else if(mid > start && a[mid - 1] == key){
            return rankLeft(key,a,start,mid - 1);
        }else {
            return mid;
        }
    }

    private int rankRight(int key,int[] a,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(a[mid] < key){
            return rankRight(key,a,mid + 1,end);
        }else if(a[mid] > key){
            return rankRight(key,a,start,mid - 1);
        }else if(mid < end && a[mid + 1] == key){
            return rankRight(key,a,mid + 1,end);
        }else{
            return mid;
        }
    }
}