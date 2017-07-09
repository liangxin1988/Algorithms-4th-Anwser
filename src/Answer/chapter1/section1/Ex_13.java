package Answer.chapter1.section1;

import Answer.base.Answer0;
import Answer.base.Answer2Integer;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_13 extends Answer2Integer{
    private String format = "%2d";
    @Override
    public void answer() {
        int line = getArgs1(),
                column = getArgs2();
        if(line <= 0 || column <= 0){
            throw new RuntimeException("参数不合法");
        }
        format = "%"+(((line > column ? line : column) + "").length() + 1)+"s";

        int[][] x = new int[line][column];
        for(int i = 0;i<line;i++){
            for(int j = 0;j<column;j++){
                x[i][j] = StdRandom.uniform(10);
            }
        }
        println("原数组");
        for(int i = 0;i<line;i++){
            for(int j = 0;j<column;j++){
                printf(format,x[i][j]);
            }
            println();
        }
        println("转置后的数组");
        for(int i = 0;i<column;i++){
            for(int j = 0;j<line;j++){
                printf(format,x[j][i]);
            }
            println();
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{3,5};
    }
}
