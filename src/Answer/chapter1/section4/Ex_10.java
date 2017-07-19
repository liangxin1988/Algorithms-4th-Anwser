package Answer.chapter1.section4;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_10 extends Answer0 {
    @Override
    public void answer() {
        //以下为测试代码
        for(int i = 0;i<100000;i++){
            int[] array = ChapterUtil.getRandomIntArray(20);
            Arrays.sort(array);  //别忘了排序
            int key = StdRandom.uniform(10);
            int position = rank(array,key,0,array.length - 1);
            //如果找到了元素，测试找到的元素是否为key
            if(position != -1 && array[position] != key){
                println("数据异常：找到了错误的position");
                println("异常数组为："+Arrays.toString(array));
                println("key = "+key+",position = "+position);
                continue;
            }
            //如果没有找到元素，测试数组中是否确实不包含元素
            if(position == -1){
                for(Integer num : array){
                    if(num == key){
                        println("数据异常：没找到元素");
                        println("异常数组为："+Arrays.toString(array));
                        println("key = "+key+",position = "+position);
                        break;
                    }
                }
                continue;
            }
            //如果找到了元素，但是找到的元素不是最左边的元素
            if(position > 0 && array[position - 1] == key){
                println("数据异常：找到的不是最左边的元素");
                println("异常数组为："+Arrays.toString(array));
                println("key = "+key+",position = "+position);
                continue;
            }
        }
        println("执行完毕");
    }

    private int rank(int[] x,int key,int start,int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(x[mid] < key){
            return rank(x,key,mid + 1,end);
        }else if(x[mid] > key){
            return rank(x,key,start,mid - 1);
        }else if((mid - 1 >= 0) && (x[mid - 1] == key)){  //普通的二分法查找没有这条分支
            //如果当前元素左侧还有元素，且左侧的元素与key相等，证明当前的key不是目标key
            return rank(x,key,start,mid - 1);  //继续往左找
        }else{
            return mid;
        }
    }
}