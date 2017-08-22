package Answer.chapter3.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.BST;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_2 extends Answer0{
    @Override
    public void answer() {
        println(checkBadTree("A C E H R S X"));
        println(checkBadTree("X S R H E C A"));
        println(checkBadTree("A X C S E H R"));
        println(checkBadTree("A C E X S R H"));
        println(checkBadTree("X S R H A C E"));
    }

    private boolean checkBadTree(String str){
        String[] strs = str.split(" ");
        BST bst = new BST();
        for(String s : strs){
            bst.put(s,s);
        }
        int height = bst.height();
        return height == strs.length - 1;
    }
}
