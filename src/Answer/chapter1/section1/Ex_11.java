package Answer.chapter1.section1;

import Answer.base.Answer2Integer;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_11 extends Answer2Integer {
    private static String FORMAT = "%2s";
    @Override
    public void answer() {
        int line = getArgs1();
        int column = getArgs2();
        if(line <= 0 || column <= 0){
            throw new RuntimeException("参数不合法");
        }
        FORMAT = "%"+(((line > column ? line : column) + "").length() + 1)+"s";
        //初始化boolean数组
        boolean[][] a = new boolean[line][column];
        for(int i = 0;i<line;i++){
            for(int j = 0;j<column;j++){
                a[i][j] = StdRandom.bernoulli();
            }
        }
        for(int i = -1;i<line;i++){
            for(int j = -1;j<column;j++){
                if(i == -1){  //打印列号
                    printf(FORMAT,j == -1?" ":""+j);
                }else if(j == -1){  //打印行号
                    printf(FORMAT,""+i);
                }else{  //打印数组内容
                    printf(FORMAT,a[i][j]?"*":" ");
                }
            }
            println();  //每一行结束要换行
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{10,10};
    }
}
