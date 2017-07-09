package Answer.chapter1.section1;

import Answer.base.Answer0;
import Answer.base.Answer1;
import Answer.base.convert.ArgsConvert;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_23 extends Answer1 {
    @Override
    public void answer() {
        int a[] = {85,54,6,5,8,52,6,8,6,65,6,85,3};  //白名单
        int list[] = {85,54,6,35,8,52,26,8,6,365,6,85,3,56,654,6,46,5};  //测试数据
        String f = getArgs1();
        Arrays.sort(a);  //二分法查找前要保证数组有序
        for(int integer : list){
            int index = rank(integer,a);
            switch (f){
                case "+":
                    if(index == -1){
                        print(integer + " ");
                    }
                    break;
                case "-":
                    if(index != -1){
                        print(integer + " ");
                    }
                    break;
                default:
                    print("参数不合法");
            }
        }
        println();
    }

    @Override
    protected ArgsConvert[] getConverts() {
        return new ArgsConvert[]{null};
    }

    @Override
    public String getArgs1() {
        return ""+super.getArgs1();
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"+"};
    }

    private static int rank(int key,int[] a){
        return rank(key,a,0,a.length - 1);
    }

    private static int rank(int key,int[] a,int lo,int hi){
        if(lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if(key < a[mid]) return rank(key,a,lo,mid - 1);
        else if(key > a[mid]) return rank(key,a,mid + 1,hi);
        else return mid;
    }
}
