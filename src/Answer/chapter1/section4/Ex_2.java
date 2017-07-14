package Answer.chapter1.section4;

import Answer.base.Answer0;
import framework.Fixme;

import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_2 extends Answer0 {

    @Override
    public void answer() {
        println("参考Ex_2中ThreeSum类的代码，将3个数字相加的公式提升为long类型，避免溢出");
    }

    public static class ThreeSum{
        public static int count(int[] a){
            int N = a.length;
            int cnt = 0;
            for(int i = 0;i < N;i++){
                for(int j = i + 1;j < N;j++){
                    for(int k = j + 1;k < N;k++){
                        if((long)a[i] + a[j] + a[k] == 0){  //将以long类型进行计算，避免产生溢出
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }
}