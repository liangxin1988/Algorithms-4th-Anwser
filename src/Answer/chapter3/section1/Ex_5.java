package Answer.chapter3.section1;

import Answer.base.Answer0;
import data_structure.st.SequentialSearchST;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_5 extends Answer0{
    @Override
    public void answer() {
        SequentialSearchST<String,Integer> st = new SequentialSearchST<>();
        for(int i = 0;i<10;i++){
            st.put(i+"",i);
        }
        println("size() = "+st.size());
        for(int i = 0;i<10;i+=2){
            st.delete(i+"");
        }
        println(st);
    }
}
