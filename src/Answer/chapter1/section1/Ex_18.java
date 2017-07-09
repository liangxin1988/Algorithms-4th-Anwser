package Answer.chapter1.section1;

import Answer.base.Answer0;
import Answer.base.Answer2Integer;
import Answer.base.Answer3Integer;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 *
 * 注意需要使用第二个参数来区分调用那个mystery方法
 */
public class Ex_18 extends Answer3Integer {
    @Override
    public void answer() {
        int caseInt = getArgs3();
        int a = getArgs1();
        int b = getArgs2();
        switch (caseInt){
            case 1:
                print(mystery1(a,b));  //计算乘法
                break;
            case 2:
                print(mystery2(a,b));  //计算次方
                break;
            default:
                print("参数错误");
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{2,25,1};
    }

    private static int mystery1(int a,int b){  //递归计算乘法
        if(b == 0){
            return 0;
        }
        if(b % 2 == 0){
            return mystery1(a+a, b / 2);  //将乘法转换为加法，将b的每一位取出，如果为0，不管。如果不为0，则计算当前位与a的乘积
        }
        return mystery1(a+a, b / 2) + a;  //每次返回的值中增加了a，a是此次递归时b的当前位与a的乘积，最后的结果就是所有不为0位的和。
    }

    /**题目中提出的另一个方法*/
    private static int mystery2(int a,int b){
        if(b == 0){
            return 1;
        }
        if(b % 2 == 0){
            return mystery2(a*a, b / 2);  //与mystery1思想类似，将加法变为乘法，得到的结果是将b个a相乘，及a的b次方。
        }
        return mystery2(a*a, b / 2) * a;
    }
}
