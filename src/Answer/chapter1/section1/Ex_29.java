package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_29 extends Answer0 {
    @Override
    public void answer() {
        int num[] = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 5, 6, 7, 7, 7, 7, 8, 8, 8};
        int key = 9;
        int rank = rank(key, num);
        print("小于" + key + "的元素个数：");
        println(rank < 0 ? ~rank : rank);  //如果查不到，则rank为负数，需要取反
        print("等于" + key + "的元素个数：");
        print(count(key, num));

    }

    private int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1);
    }


    /**
     * 改进版的二分法查找
     * 题目中要求找到小于key的所有元素，也可理解成找到第一个等于key的元素索引，
     * 或如果找不到，返回key应该存在的位置的索引
     */
    private int rank(int key, int[] a, int lo, int hi) {
        if (lo > hi) return ~lo;  //不返回-1，而是返回lo，这时lo指向的即是假设key存在时的索引。取反的目的，是为了标识是否找到了该元素
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
            //这个分支表示，如果找到了key，但是左边的元素仍然等于key，那么找到的这个元素不是目标元素，需要继续查找
        else if (mid - 1 >= 0 && a[mid - 1] == key) {
            return rank(key, a, lo, mid - 1);
        } else {
            return mid;
        }
    }

    private int count(int key, int[] nums) {
        //目前想到两种方案。
        // 1.通过rank方法找到最左边的key，然后往后遍历计数
        // 2.增加另一個rank方法，使其能找到最右边的key，然后两者运算。
        // 选择哪种方案，得看key的具体个数的多少，本例采用方案1。
        int count = 0;
        int rank = rank(key, nums);
        if (rank >= 0) {
            for (int i = rank; i < nums.length; i++) {
                if (nums[i] != key) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

}
