package Answer.chapter3.section1;

import Answer.base.Answer0;
import data_structure.st.ArrayST;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_2 extends Answer0 {
    @Override
    public void answer() {
        ArrayST<String,Integer> st = new ArrayST<>();
        for(int i = 0;i<5;i++){
            st.put(i+"",i);
        }
        println(st);
        for(int i = 0;i<5;i+=2){
            st.delete(i+"");
        }
        println(st);
    }
}