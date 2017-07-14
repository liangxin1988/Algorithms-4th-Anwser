package Answer.chapter1.section4;

import Answer.base.Answer0;
import framework.Fixme;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_4 extends Answer0 {
    private static final String TABLE_FORMAT = "%-5s | %-10s | %-20s | %-10s\n";
    @Override
    public void answer() {
        printf(TABLE_FORMAT,"block","time","frequency","total time");
        printf(TABLE_FORMAT,"D","t0","x(depends on input)","t0 * x");
        printf(TABLE_FORMAT,"C","t1","N^2 / 2 - N / 2","t1 * (N^2 / 2 - N / 2)");
        printf(TABLE_FORMAT,"B","t2","N","t2 * N");
        printf(TABLE_FORMAT,"A","t3","1","t3");
        println("总时间：(t1 / 2)N^2 + (t2 - t1/2)N + t3 + t0*x");
        println("近似：~(t1 / 2)N^2 (假设X很小)");
        println("增长数量级：N^2");
    }

    public static class TowSum{
        public static int count(int[] a){       //用这种简略的方式标识语句块。
            int N = a.length;                   //A
            int cnt = 0;                        //A
            for(int i = 0; i< N; i++){          //B（i++部分开始）
                for(int j = i + 1;j < N;j++){   //C（j++部分开始）
                    if(a[i] + a[j] == 0){       //C
                        cnt++;                  //D
                    }
                }
            }
            return cnt;                         //A
        }
    }
}