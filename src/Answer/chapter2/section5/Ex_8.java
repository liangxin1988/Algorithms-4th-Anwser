package Answer.chapter2.section5;

import Answer.base.Answer1String;
import edu.princeton.cs.algs4.Quick;
import util.ChapterUtil;

import java.util.ArrayList;
import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_8 extends Answer1String {
    @Override
    public void answer() {
        String[] strs = getArgs1().split(",");

        ArrayList<StringCounter> al = new ArrayList<>();
        outer:
        for(String s : strs){
            for(StringCounter sc : al){
                if(sc.str.equals(s)){
                    sc.count++;
                    continue outer;
                }
            }
            al.add(new StringCounter(s));
        }
        StringCounter[] scs = new StringCounter[al.size()];
        al.toArray(scs);
        Quick.sort(scs);
        println(Arrays.toString(scs));
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"a,b,c,d,d,d,e,e,d,a,d"};
    }

    public class StringCounter implements Comparable<StringCounter>{
        String str;
        int count;

        public StringCounter(String str){
            this.str = str;
            count = 1;
        }

        @Override
        public int compareTo(StringCounter o) {
            return o.count - this.count;
        }

        @Override
        public String toString() {
            StringBuilder sb = ChapterUtil.getStringBuilder();
            sb.append("str = ").append(str);
            sb.append(",count = ").append(count);
            sb.append("\n");
            return sb.toString();
        }
    }
}