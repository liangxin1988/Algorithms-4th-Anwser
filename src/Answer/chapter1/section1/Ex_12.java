package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_12 extends Answer0 {
    @Override
    public void answer() {
        int[] a = new int[10];
        for(int i = 0;i<10;i++)
            a[i] = 9 - i;
        for(int i = 0;i<10;i++)
            a[i] = a[a[i]];
        for(int i = 0;i<10;i++){
            print(a[i]+"  ");   //原题为i，不合理，这里应该是a[i]
        }
    }
}
