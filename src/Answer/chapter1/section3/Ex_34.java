package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.bag.Bag;
import data_structure.bag.RandomBag;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_34 extends Answer0 {
    @Override
    public void answer() {
        Bag<Integer> bag = new RandomBag<>();
        for(int i = 0;i<10;i++){
            bag.add(i);
        }
        println("data_structure.bag.size = "+bag.size());
        println(bag);
    }
}