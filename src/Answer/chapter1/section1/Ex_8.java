package Answer.chapter1.section1;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_8 extends Answer0 {
    @Override
    public void answer() {
        println('b');
        println('b'+'c');  //字符型变量，在java编译器中也是按照int类型来看待的，所以两个char相加，等价于两个char的ascii码相加，即98(b)+99(c)=197
        print((char)('a'+ 4));  //同上，char也可以直接与int相加，得到的结果再转为char，则表示了该结果通过ascii反查到的char
    }
}
