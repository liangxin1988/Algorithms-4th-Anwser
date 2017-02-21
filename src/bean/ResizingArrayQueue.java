package bean;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 使用动态调整数组的方法
 * */
public class ResizingArrayQueue<Item> implements Iterable<Item>{

	private Item[] a;
	private int start = 0,end = 0; //分别记录队列的起始位置(队列中第一个元素的位置)和结束位置（队列中第一个空位）
	int count = 0;
	
	public ResizingArrayQueue(int size){
		a = (Item[]) new Object[size];
	}
	
	/**
	 * 入列
	 * */
	public void enqueue(Item item){
		count++;
		a[end++] = item;
		if(end == a.length){  //数组用完了，但这个时候不应该直接扩容，因为数组前半部分可能还有空间（元素出栈后留下的空位）
			end = 0;
		}
		if(end == start){  //已经满了，需要扩容
			resize(a.length * 2); 
		}
		
	}
	
	/**
	 * 扩容
	 * */
	private void resize(int max){
		Item[] items = (Item[]) new Object[max];
		int end = 0;
		for(Item item : this){
			items[end++] = item;
		}
		a = items;
		start = 0;
		this.end = end;  //除了复制数组内容，顺便将元素按队列顺序整理，避免出现end < start的情况
	}
	
	/**
	 * 出列
	 * */
	public Item dequeue(){
		count--;
		if(isEmpty()){
			throw new RuntimeException("队列以空");
		}
		Item item = a[start++];  //为了避免内存泄漏，这里可以将其设置为null。
		if(size() > 0 && size() <= a.length / 4){  //使用的空间太小，缩小数组
			resize(a.length / 2);
		}
		return item;
	}
	
	public boolean isEmpty(){
		return count == 0; 
	}
	
	/**
	 * 获得队列的长度
	 * */
	public int size(){
		return count;
	}
	
	@Override
	public String toString() {
		String str = "";
		for(Item item : this){
			str+=item;
			str+=" ";
		}
		str+=";start = "+start+",end = "+end;
		return str;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ResizingArrayQueueIterator();
	}
	
	private class ResizingArrayQueueIterator implements Iterator<Item>{
		
		int index = start;
		int innerCount = 0;

		@Override
		public boolean hasNext() {
			return innerCount != count;
		}

		@Override
		public Item next() {
			Item item = a[index++];
			if(index == a.length){  //如果超过数组长度，应该将其置为0，从数组头部继续遍历
				index = 0;
			}
			innerCount++;
			return item;
		}

	}
	public static void main(String[] args) {
		TestHelper testHelper = new TestHelper();
		StdOut.println("start");
		String str = "";
		while(!(str = StdIn.readLine()).equals("exit")){
			testHelper.execute(str);
		}
		StdOut.println("end");
	}
	
	public static class TestHelper{
		ResizingArrayQueue<String> resizingArrayQueue = new ResizingArrayQueue<>(5);
		public void execute(String str){
			if(str.startsWith("e")){
				resizingArrayQueue.enqueue(str.split(" ")[1]);
			}else if(str.startsWith("d")){
				resizingArrayQueue.dequeue();
			}else{
				StdOut.println("未定义的操作");
			}
			
			StdOut.println(resizingArrayQueue);
		}
	}

}
