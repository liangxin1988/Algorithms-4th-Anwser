package Answer.chapter1.section4;

import Answer.base.Answer0;
import framework.Fixme;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_8 extends Answer0 {
    @Override
    public void answer() {
        int a[] = ChapterUtil.getRandomIntArray(100);
        ChapterUtil.printArray(a);
        println(count(a));
        println(countFast(a));
    }

    /**平方级别的统计方法*/
    public int count(int a[]){
        int N = a.length;
        int cnt = 0;
        for(int i = 0; i< N; i++){
            for(int j = i + 1;j<N;j++){
                if(a[i] == a[j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int countFast(int a[]){
        int N = a.length;
        int cnt = 0;
        Arrays.sort(a);

        //计算过程为线性
        int cacheIndex = 0;  //缓存坐标
        int cacheInt = a[0]; //缓存坐标对应的值
        for(int i = 1;i< N;i++){
            if(a[i] == cacheInt){  //元素与缓存的值相等
                cnt += i - cacheIndex;  //新元素与缓存元素与当前元素之间的每一个元素都能配对
            }else{
                cacheIndex = i;  //不相等则更新缓存
                cacheInt = a[i];
            }
        }
        return cnt;
    }
}