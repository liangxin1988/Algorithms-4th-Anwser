package Answer.chapter1.section3;

import Answer.base.Answer0;
import Answer.base.Answer2;
import Answer.base.Answer2String;
import Answer.base.convert.ArgsConvert;
import Answer.base.convert.ArgsConvertFactory;
import queue.FixedLengthQueue;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_15 extends Answer2 {
    @Override
    public void answer() {
        int count = getArgs1();
        String[] array = new String[20];
        String args2 = getArgs2();
        if(args2 != null && args2.length() != 0){
            array = args2.split(",");
        }else{
            for(int i = 0;i<array.length;i++){
                array[i] = i + "";
            }
        }
        FixedLengthQueue<String> fixedLengthQueue = new FixedLengthQueue<String>(count);
        for(String s : array){
            fixedLengthQueue.enqueue(s);
			println(fixedLengthQueue);  //打印轨迹
        }
        println("倒数第"+count+"的元素为："+fixedLengthQueue.dequeue());
    }

    @Override
    public Integer getArgs1() {
        return Integer.parseInt(""+super.getArgs1());
    }

    @Override
    public String getArgs2() {
        return ""+super.getArgs2();
    }

    @Override
    protected ArgsConvert[] getConverts() {
        return new ArgsConvert[]{ArgsConvertFactory.createIntegerArgsConvert(),null};
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{5,""};
    }
}
