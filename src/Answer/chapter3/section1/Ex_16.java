package Answer.chapter3.section1;

import Answer.base.Answer0;
import data_structure.st.BinarySearchOrderST;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_16 extends Answer0 {
    @Override
    public void answer() {
        BinarySearchOrderST st = new BinarySearchOrderST();
        for(int i = 0;i<10;i++){
            st.put(i,i);
        }
        for(int i = 0;i<10;i+=2){
            st.delete(i);
        }
        println(st);
    }
}
