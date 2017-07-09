package Answer.chapter1.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Transaction;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_13 extends Answer0 {
    @Override
    public void answer() {
        println(new Transaction("java",new Date(1,1,1988),100).toString());
    }
}
