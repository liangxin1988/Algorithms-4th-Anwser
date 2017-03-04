package chapter2;

import Answer.BaseChapter;
import Answer.ChapterUtil;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Selection;
import framework.Title;
import static edu.princeton.cs.algs4.StdOut.*;

import java.util.Arrays;
import java.util.Comparator;

public class Chapter2_5Exercises extends BaseChapter {

	@Title("2.5.3")
	public static void question3(){
		Balance a = new Balance();
		Balance b = new Balance();
		Balance c = new Balance();
		a.amount = 0;
		b.amount = a.amount + 0.005;
		c.amount = b.amount + 0.005;
		println("b比a："+b.compareTo(a));
		println("c比b："+c.compareTo(b));
		println("c比a："+c.compareTo(a));
		println("不满足传递性，a与b相等，b与c相等，但是a与c不相等");
		println("修改方法：去掉加减0.005的代码");
	}
	
	@Title("2.5.5")
	public static void question5(){
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
	}
	
	public static class IndexNode implements Comparable<IndexNode>{
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

	
	public static class Balance implements Comparable<Balance>{

		private double amount;
		@Override
		public int compareTo(Balance that) {
			if(this.amount < that.amount - 0.005){
				return -1;
			}
			if(this.amount > that.amount + 0.005){
				return 1;
			}
			return 0;
		}
		
	}
}
