package Answer.chapter3.section1;

import Answer.base.Answer0;
import Answer.base.Answer1String;
import data_structure.st.ST;
import data_structure.st.SequentialSearchST;

import static edu.princeton.cs.algs4.StdOut.printf;

/**
 */
public class Ex_1 extends Answer1String {
    @Override
    public void answer() {
        //初始化数据
        ST<String,Float> st = new SequentialSearchST<>();
        String[] ns = new String[]{
                "A+","A","A-",
                "B+","B","B-",
                "C+","C","C-",
                "D","F"
        };
        float[] ss = new float[]{
                4.33f,4.00f,3.67f,
                3.33f,3.00f,2.67f,
                2.33f,2.00f,1.67f,
                1.00f,0.00f
        };
        for(int i = 0;i<ns.length;i++){
            st.put(ns[i],ss[i]);
        }

        //计算平均值
        String str = getArgs1();
        String[] strs = str.split(",");
        float sum = 0;
        int count = 0;
        for(String s : strs){
            count++;
            sum += st.get(s);
        }
        printf("GPA = %.2f",sum / count);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"A+,A+,A,A,A"};
    }
}
