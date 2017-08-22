package Answer.chapter3.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.BST;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_3 extends Answer0 {
    @Override
    public void answer() {
        println(checkGoodTree("H C S A E R X"));
        println(checkGoodTree("H C S E A R X"));
        println(checkGoodTree("H C S A E X R"));
        println(checkGoodTree("H C S E A X R"));
        println(checkGoodTree("H S C A E R X"));
    }

    private boolean checkGoodTree(String str){
        String[] strs = str.split(" ");
        BST bst = new BST();
        for(String s : strs){
            bst.put(s,s);
        }
        int height = bst.height();
        return height == 2;
    }
}