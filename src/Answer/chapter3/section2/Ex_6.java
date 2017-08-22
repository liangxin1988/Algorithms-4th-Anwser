package Answer.chapter3.section2;

import Answer.base.Answer0;
import data_structure.st.BST;
import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_6 extends Answer0 {
    @Override
    public void answer() {
        for(int i = 0;i<1000;i++){
            check();
        }
        println("测试成功");
    }

    private void check(){
        BST bst = new BST();
        edu.princeton.cs.algs4.BST bst2 = new edu.princeton.cs.algs4.BST(); //对比测试
        for(Integer i : ChapterUtil.getRandomIntArray(1000)){
            bst.put(i,i);
            bst2.put(i,i);
        }
        int h1 = bst.height1();
        int h2 = bst.height2();
        int h3 = bst2.height();

        if(h1 != h2 || h2 != h3){
            throw new RuntimeException("测试失败");
        }
    }
}