package chapter1;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Arrays;

import util.FileUtil;

import edu.princeton.cs.algs4.Counter;
import framework.Title;
import Answer.BaseChapter;

import static edu.princeton.cs.algs4.StdOut.println;


public class Chapter1_5Exercises extends BaseChapter {

	@Title("1.5.1")
	public static void question1(){
		executeUF(new QuickFindUF(10));
	}
	
	@Title("1.5.2")
	public static void question2(){
		executeUF(new QuickUnionUF(10));
	}
	
	@Title("1.5.3")
	public static void question3(){
		executeUF(new WeightQuickUnionUF(10));
	}
	
	private static void executeUF(UF uf){
		int[] a = {9,3,5,7,2,5,0,4};
		int[] b = {0,4,8,2,1,7,3,2};
		
		for(int i = 0;i<a.length;i++){
			uf.union(a[i], b[i]);
		}
	}
	
	private abstract static class UF{
		protected int[] id;
		protected int count;
		
		public UF(int N){
			id = new int[N];
			count = 0;
	        for (int i = 0; i < N; i++)
	            id[i] = i;
		}
		
		public int getCount(){
			return count;
		}
		
		public boolean connected(int p,int q){
			return find(p) == find(q);
		}
		
		public abstract int find(int p);
		public abstract void union(int p,int q);
	}
	
	private static class WeightQuickUnionUF extends UF{
		
		private int[] size;
		Counter counter = new Counter("WeightQuickUnionUF");

		public WeightQuickUnionUF(int N) {
			super(N);
			size = new int[N];
			for(int i = 0;i<N;i++){
				size[i] = 1;
			}
		}

		@Override
		public int find(int p) {
			counter.increment();
			while(p != id[p]){
				counter.increment();
				p = id[p];
			}
			return p;
		}

		@Override
		public void union(int p, int q) {
			int pId = find(p);
			int qId = find(q);
			
			if(pId == qId){
				return;
			}
			
			if(size[pId] < size[qId]){
				counter.increment();
				id[pId] = qId;
				counter.increment();
				counter.increment();
				size[qId] += size[pId];
			}else{
				counter.increment();
				id[qId] = pId;
				counter.increment();
				counter.increment();
				size[pId] += size[qId];
			}
			
			count--;
			
			println("counter = "+counter.tally());
			println("ids = "+Arrays.toString(id));
		}
		
	}
	
	private static class QuickUnionUF extends UF{
		public QuickUnionUF(int N) {
			super(N);
		}

		Counter counter = new Counter("QuickUnionUF");

		@Override
		public int find(int p) {
			counter.increment();
			while(p != id[p]){
				counter.increment();
				p = id[p];
			}
			return p;
		}

		@Override
		public void union(int p, int q) {
			int pId = find(p);
			int qId = find(q);
			
			if(pId == qId){
				return;
			}
			
			counter.increment();
			id[pId] = qId;
			
			count--;
			
			println("counter = "+counter.tally());
			println("ids = "+Arrays.toString(id));
		}
	}
	
	private static class QuickFindUF extends UF{
		
		Counter counter = new Counter("QuickFindUF");

		public QuickFindUF(int N) {
			super(N);
		}

		@Override
		public int find(int p) {
			counter.increment();
			return id[p];
		}

		@Override
		public void union(int p, int q) {
			int pId = find(p);
			int qId = find(q);
			
			if(pId == qId){
				return;
			}
			
			for(int i = 0;i<id.length;i++){
				counter.increment();
				if(id[i] == pId){
					counter.increment();
					id[i] = qId;
				}
			}
			
			count--;
			
			println("counter = "+counter.tally());
			println("ids = "+Arrays.toString(id));
		}
		
	}
}
