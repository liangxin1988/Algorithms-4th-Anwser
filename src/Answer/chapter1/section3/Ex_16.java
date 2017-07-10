package Answer.chapter1.section3;

import Answer.base.Answer1String;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_16 extends Answer1String {
    @Override
    public void answer() {
        String dataStr = getArgs1();
        String[] dataStrs = dataStr.split(",");
        Queue<Date> queue = new Queue<>();
        for(String s : dataStrs){
            queue.enqueue(new Date(s));
        }
        Date[] dates = new Date[queue.size()];
        for(int i = 0;i<dates.length;i++){
            dates[i] = queue.dequeue();
        }

        println(Arrays.toString(dates));
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"1/1/2016,1/2/2016,1/3/2016"};
    }
}
