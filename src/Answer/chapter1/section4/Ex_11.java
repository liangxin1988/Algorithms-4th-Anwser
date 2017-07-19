package Answer.chapter1.section4;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_11 extends Answer0 {
    @Override
    public void answer() {
        int[] nums = ChapterUtil.getRandomIntArray(10);
        Arrays.sort(nums);
        ChapterUtil.printArray(nums);
        int key = StdRandom.uniform(10);
        StaticSETofInts staticSETofInts = new StaticSETofInts(nums);
        println("key = "+key+",count = "+staticSETofInts.howMany(key));
    }

    class StaticSETofInts{
        private int[] a;
        StaticSETofInts(int[] a){
            this.a = a;
            Arrays.sort(a);
        }

        boolean contains(int key){
            return rankLeft(key,0,a.length - 1) != -1;
        }

        int howMany(int key){
            int left = rankLeft(key,0,a.length - 1);
            if(left == -1){
                return 0;
            }
            int right = rankRight(key,0,a.length - 1);
            return right - left + 1;
        }

        //1.4.10中使用的优化版的二分法查找，只找最左边的
        private int rankLeft(int key,int start,int end){
            if(start > end){
                return -1;
            }
            int mid = (start + end) / 2;
            if(a[mid] < key){
                return rankLeft(key,mid + 1,end);
            }else if(a[mid] > key){
                return rankLeft(key,start,mid - 1);
            }else if(mid > 0 && a[mid - 1] == key){
                return rankLeft(key,start,mid - 1);
            }else {
                return mid;
            }
        }

        //只找最右边的，逻辑与rankLeft类似
        private int rankRight(int key,int start,int end){
            if(start > end){
                return -1;
            }
            int mid = (start + end) / 2;
            if(a[mid] < key){
                return rankRight(key,mid + 1,end);
            }else if(a[mid] > key){
                return rankRight(key,start,mid - 1);
            }else if(mid < a.length - 1 && a[mid + 1] == key){
                return rankRight(key,mid + 1,end);
            }else{
                return mid;
            }
        }
    }
}