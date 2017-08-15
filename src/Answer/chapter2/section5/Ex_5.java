package Answer.chapter2.section5;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Selection;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_5 extends Answer0 {
    @Override
    public void answer() {
        IndexNode[] ins = new IndexNode[5];
        for(int i = 0;i<ins.length;i++){
            IndexNode in = new IndexNode();
            in.index = i;
            in.content = i % 2;
            ins[i] = in;
        }
        for(int i = 0;i<ins.length;i++){
            println(ins[i]);
        }
        println();
        Selection.sort(ins);
        for(int i = 0;i<ins.length;i++){
            println(ins[i]);
        }
        println();
        println("选择排序的交换过程，可能导致两个相同key的位置互换");
    }

    public class IndexNode implements Comparable<IndexNode>{
        int index;
        int content;
        @Override
        public int compareTo(IndexNode o) {
            return content - o.content;
        }

        @Override
        public String toString() {
            StringBuilder sb = ChapterUtil.getStringBuilder();
            sb.append("index = ").append(index);
            sb.append("content = ").append(content);
            return sb.toString();
        }
    }
}