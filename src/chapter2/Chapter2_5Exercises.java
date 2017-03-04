package chapter2;

import Answer.BaseChapter;
import Answer.ChapterUtil;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;
import framework.Title;
import static edu.princeton.cs.algs4.StdOut.*;

import java.util.Arrays;
import java.util.Comparator;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

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
	
	@Title("2.5.6")
	public static void question6(){
		Integer[] is = new Integer[10];
		for(int i = 0;i < is.length;i++){
			is[i] = i;
		}

		for(int i = 0;i<is.length;i++){
			println(select(is, 0, is.length - 1, i));
		}
	}
	
	public static Comparable select(Comparable[] a,int start,int end,int k){
		int mid = partition(a, start, end);
		if(mid == k){
			return a[mid];
		}
		if(mid > k){
			return select(a,start,mid - 1,k);
		}else if(mid < k){
			return select(a,mid + 1,end,k);
		}
		return null;
	}
	
	public static void sort(Comparable[] a,int start,int end){
		if(start >= end){
			return;
		}
		int mid = partition(a,start,end);
		println("mid = "+mid);
		sort(a,start,mid - 1);
		sort(a,mid + 1,end);
	}
	
	public static int partition(Comparable[] a,int start,int end){
		int i = start;
		int j = end + 1;
		Comparable min = a[start];
		while(true){
			while(i < end){
				if(less(min,a[++i])){
					break;
				}
			}
			while(j > start){
				if(less(a[--j],min)){
					break;
				}
			}
			if(i >= j){
				break;
			}
			exch(a, i, j);
		}
		exch(a,start,j);
		return j;
	}
	
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
	
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
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
