package Answer.chapter2.section4;

import Answer.base.Answer0;
import Answer.base.Answer1String;
import data_structure.max_pq.HeapMaxPQ;
import edu.princeton.cs.algs4.Heap;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_5 extends Answer1String{
    @Override
    public void answer() {
        String[] str = getArgs1().split(" ");
        HeapMaxPQ heapMaxPQ = new HeapMaxPQ();
        for(String s : str){
            heapMaxPQ.insert(s);
        }
        println(Arrays.toString(heapMaxPQ.getContents()));
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"E A S Y Q U E S T I O N"};
    }
}
