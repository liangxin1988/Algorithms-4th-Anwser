package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_6 extends Answer0{
    @Override
    public void answer() {
        int f = 0;
        int g = 1;
        for(int i = 0;i<=15;i++){
            print(f + "  ");  //斐波那契数列的前16(16为循环次数)个数
            f = f + g;  //每次循环，得到的是当前数的下一个数
            g = f - g;  //每次循环，得到的是上一次循环的f，也就是当前的数。
        }
    }
}
