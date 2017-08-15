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

	}
	
	public static void question8(String str){

	}
	
	public static void question10(){
		Version v1 = new Version("115.1.1");
		Version v2 = new Version("115.10.1");
//		println(less(v1,v2));
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
	

	

	
	public static void sort(Comparable[] a,int start,int end){
		if(start >= end){
			return;
		}
//		int mid = partition(a,start,end);
//		println("mid = "+mid);
//		sort(a,start,mid - 1);
//		sort(a,mid + 1,end);
	}
	

	

	

    


	

}
