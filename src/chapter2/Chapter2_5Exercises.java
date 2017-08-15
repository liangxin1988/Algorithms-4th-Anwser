package chapter2;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.*;

import java.util.ArrayList;
import java.util.Arrays;

import util.ChapterUtil;



public class Chapter2_5Exercises {

	public static void question3(){

	}
	
	public static void question5(){

	}
	
	public static void question6(){
		Integer[] is = new Integer[10];
		for(int i = 0;i < is.length;i++){
			is[i] = i;
		}
		StdRandom.shuffle(is);
		for(int i = 0;i<is.length;i++){
			println(select(is, 0, is.length - 1, i));
		}
	}
	
	public static void question8(String str){
		if(str == null){
			str = "a,b,c,d,d,d,e,e,d,a,d";
		}
		String[] strs = str.split(",");
		
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
	
	public static void question10(){
		Version v1 = new Version("115.1.1");
		Version v2 = new Version("115.10.1");
		println(less(v1,v2));
	}
	
	public static class Version implements Comparable<Version>{
		int first;
		int secend;
		int third;
		
		public Version(String version){
			String[] str = version.split("\\.");
			first = Integer.parseInt(str[0]);
			secend = Integer.parseInt(str[1]);
			third = Integer.parseInt(str[2]);
		}

		@Override
		public int compareTo(Version o) {
			if(this.first != o.first){
				return this.first - o.first;
			}
			if(this.secend != o.secend){
				return this.secend - o.secend;
			}
			
			return this.third - o.third;
		}
		
		
	}
	
	public static class StringCounter implements Comparable<StringCounter>{
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
    


	

}
