package Answer.chapter1.section1;

import Answer.base.Answer0;
import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 *
 */
public class Ex_1 extends Answer0{

    @Override
    public void answer() {
        print((0 + 15) / 2);  println("  说明：整数运算，得到的结果依然为整数。小数部分被舍弃（不是四舍五入）");
        print(2.0e-6 * 100000000.1); println("  说明：2.0e-6，表示2乘以10的-6次方，也就是2 * 0.000001。而默认的浮点型为double，足以处理最后的.1。如果使用f修饰两个浮点数，则结果为200");
        print(true && false || true && false);  print("  说明：&&的优先级高于||");
    }
}
