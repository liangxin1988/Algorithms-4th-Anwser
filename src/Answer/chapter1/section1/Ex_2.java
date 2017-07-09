package Answer.chapter1.section1;

import Answer.base.Answer0;
import Answer.base.BaseAnswer;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 *
 */
public class Ex_2 extends Answer0 {
    @Override
    public void answer() {
        print((1 + 2.236) / 2);println("  说明：因为表达式中存在浮点数2.236，所以经过计算后，整个表达式中的所有数据都会自动提升为浮点数，结果也就是浮点数");
        println(1 + 2 + 3 + 4.0);
        print(4.1 >= 4);println("  说明：两个不同类型无法直接比较，不过编译器会自动将4提升为double，然后进行比较");
        print(1 + 2 + "3");  print("  +运算符的运算顺序为从左到右，进行1 + 2时，得到结果3。将3 与 “3”相加时，会自动调用字符串连接方法，将两者拼接为字符串“33”");
    }
}
