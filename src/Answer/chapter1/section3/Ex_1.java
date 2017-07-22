package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.stack.FixedCapacityStackOfStrings;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_1 extends Answer0 {
    @Override
    public void answer() {
        FixedCapacityStackOfStrings fixedCapacityStackOfStrings = new FixedCapacityStackOfStrings(5);  //最多存储5个
        while(!fixedCapacityStackOfStrings.isFull()){  //通过isFull标记，将数据存满
            fixedCapacityStackOfStrings.push("test");
        }
        println("size = "+fixedCapacityStackOfStrings.size());  //打印size，看是否与设置的5一致。

    }
}
