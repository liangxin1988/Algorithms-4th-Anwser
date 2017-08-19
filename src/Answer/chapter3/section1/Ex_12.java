package Answer.chapter3.section1;

import Answer.base.Answer0;
import data_structure.st.ItemBinarySearchST;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_12 extends Answer0 {
    @Override
    public void answer() {
        ItemBinarySearchST.Item[] item = new ItemBinarySearchST.Item[20];
        for(int i = 0;i<item.length;i++){
            int x = StdRandom.uniform(10);
            item[i] = new ItemBinarySearchST.Item(x,x);
        }
        ItemBinarySearchST st = new ItemBinarySearchST(item);
        println(Arrays.toString(item));
    }
}