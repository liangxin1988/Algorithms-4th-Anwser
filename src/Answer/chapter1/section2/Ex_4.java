package Answer.chapter1.section2;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_4 extends Answer0{
    @Override
    public void answer() {
        String str1 = "hello";
        String str2 = str1;
        str1 = "world";
        println(str1);
        print(str2);
    }
}
