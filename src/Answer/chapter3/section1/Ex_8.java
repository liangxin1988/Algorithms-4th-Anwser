package Answer.chapter3.section1;

import Answer.base.Answer0;
import data_structure.st.ArrayST;
import data_structure.st.ST;
import util.algorithms.FrequencyCounter;

import java.io.FileNotFoundException;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_8 extends Answer0 {
    @Override
    public void answer() {
        //书中的数据与代码实测不符，所以改造了FrequencyCounter，通过java中的hashmap生成对比数据，来验证结论。
        try {
            new FrequencyCounter(){
                @Override
                public ST getST() {
                    return new ArrayST();
                }
            }.execute(10,"tale.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            println("产生了异常");
        }
    }
}