package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_4 extends Answer0 {
    @Override
    public void answer() {
        println("if(a > b) then c = 0;   //java中没有then关键字。应改为：if(a > b) c = 0;");
        println("if a > b {c = 0;}  //if后面的判断条件，需要括号。应改为：if(a > b){c = 0;}");
        println("if (a > b) c = 0;  //木有问题，if后面的代码块如果只有一句代码，则大括号可以省略");
        println("if (a > b) c = 0 else b = 0;  //if后面的代码块中，c = 0是一条语句。java中的所有语句必须以“;”结尾。应改为：if (a > b) c = 0; else b = 0;");
    }
}
