package Answer.chapter2.section4;

import Answer.base.Answer1String;
import data_structure.max_pq.HeapMaxPQ;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_6 extends Answer1String {
    @Override
    public void answer() {
        String[] strs = getArgs1().split(" ");
        HeapMaxPQ heapMaxPQ = new HeapMaxPQ();
        for(String s : strs){
            if(s.equals("*")){
                heapMaxPQ.delMax();
            }else{
                heapMaxPQ.insert(s);
            }
            println(Arrays.toString(heapMaxPQ.getContents()));
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"P R I O * R * * I * T * Y * * * Q U E * * * U * E"};
    }
}
