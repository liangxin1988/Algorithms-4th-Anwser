package st;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

import edu.princeton.cs.algs4.StdRandom;

public class OrderedSequentialSearchST<Key extends Comparable<Key>,Value> extends OrderST<Key,Value> {

	/**
	 * 首节点
	 * */
	private Node first;  //为了简化delete和put的逻辑，这里只保留first节点
	
	/**
	 * 节点个数
	 * */
	private int count = 0;
	
	@Override
	public Key min() {
		if(isEmpty())
			return null;
		return first.key;  //第一个节点必然最小
	}

	@Override
	public Key max() {  //由于没有last节点，所以最大值只能通过遍历整个链表获得最后一个节点
		if(isEmpty())
			return null;
		Node node = first;
		do{
			if(node.next == null){
				return node.key;
			}
		}while((node = node.next) != null);
		return null;
	}

	@Override
	public Key floor(Key key) {
		if(isEmpty() || first.key.compareTo(key) > 0){  //链表为空，或者第一个元素就比key大，只能返回null
			return null;
		}
		Node node = first;
		do{
			if(node.next == null){  //遍历到末尾了，则node为last节点。
				break;
			}
			if(node.next != null && node.next.key.compareTo(key) > 0){
				//没遍历到结尾，但是发现下一个元素比key大，则将当前元素返回
				return node.key;
			}
			node = node.next;
		}while(true);
		return node.key;
	}

	@Override
	public Key ceiling(Key key) {
		if(isEmpty()){
			return null;
		}
		Node node = first;
		if(first.key.compareTo(key) >= 0){  //先判断首节点
			return first.key;
		}
		do{
			//遍历后续节点
			if(node.next != null && node.next.key.compareTo(key) >= 0){
				return node.next.key;
			}
		}while((node = node.next) != null);
		return null;  //找不到更大的值
	}

	@Override
	public int rank(Key key) {
		if(isEmpty() || key == null){
			return 0;
		}
		Node node = first;
		int count = 0;
		do{
			if(node.key.compareTo(key) >= 0){
				break;
			}
			count++;
		}while((node = node.next) != null);
		return count;
	}

	@Override
	public Key select(int k) {
		if(k < 0 || k >= count){
			return null;
		}
		Node node = first;
		for(int i = 0;i<k;i++){
			node = node.next;
		}
		return node.key;
	}

	@Override
	public Iterable<Key> keys(Key start, Key end) {
		return new OrderedSequentialSearchSTIterable(start,end);
	}
	
	private class OrderedSequentialSearchSTIterable implements Iterable<Key>{

		private Key start;
		private Key end;
		
		@Override
		public Iterator<Key> iterator() {
			return new OrderedSequentialSearchSTIterator();
		}
		
		public OrderedSequentialSearchSTIterable(Key start,Key end){
			this.start = start;
			this.end = end;
		}
		
		private class OrderedSequentialSearchSTIterator implements Iterator<Key>{

			private Node node;
			
			public OrderedSequentialSearchSTIterator(){
				node = OrderedSequentialSearchST.this.first;
				do{
					if(node.key.equals(start)){  //找到key对应的Node
						return;
					}
				}while((node = node.next) != null);
			}
			
			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public Key next() {
				Key k = node.key;
				node = node.next;
				return k;
			}
		}
		
	}
	
	@Override
	public void delete(Key key) {
		if(isEmpty()){
			throw new RuntimeException("符号表为空，不能删除");
		}
		
		//如果首节点匹配，则删除首节点
		if(first.key.equals(key)){
			first = first.next;
			count--;
			return;
		}
		
		//遍历后续节点，发现匹配的则删除
		Node node = first;
		do{
			if(node.next != null && node.next.key.equals(key)){
				node.next = node.next.next;
				count--;
				return;
			}
		}while((node = node.next) != null);
	}

	@Override
	public void put(Key key, Value val) {
		//谁有更好的实现，修改一下吧。这个方法写完我基本就吐了
		if(val == null){
			delete(key);
			return;
		}
		
		//没有首节点或者首节点比key大，则将节点从头部插入
		if(first == null || first.key.compareTo(key) > 0){  
			Node node = new Node(key,val);
			node.next = first;
			first = node;
			count++;
			return;
		}
		
		//如果第一个匹配到，则更新first的value
		if(first.key.equals(key)){
			first.value = val;
			return;
		}
		
		//从第二个开始判断，如果遇到相等的则更新对应的value，如果发现node大于key则将key插入到Node前
		Node node = first.next;
		Node pre = first;  //为了将key插入到node前，要保留node的上一个节点
		do{
			node = pre.next;
			if(node == null){  //如果遍历到最后都没有找到大于等于key的节点，则应该在链表末尾追加节点
				break;
			}
			int cmp = node.key.compareTo(key);
			if(cmp == 0){  //如果node与key相等，则更新node的value
				node.value = val;
				return;
			}else if(cmp > 0){  //如果Node大于key，则将key插入到Node前。
				Node newNode = new Node(key,val);
				newNode.next = node;
				pre.next = newNode;
				count++;
				return;
			}
		}while((pre = pre.next) != null);
		
		//在链表结尾追加节点
		pre.next = new Node(key,val);
		count++;
	}

	@Override
	public Value get(Key key) {
		if(isEmpty() || key == null){
			return null;
		}
		Node node = first;
		do{
			if(node.key.equals(key)){
				return node.value;
			}
		}while((node = node.next) != null);
		return null;
	}
	
	/**
	 * 判断链表是否有序
	 * */
	public boolean isOrder(){
		if(isEmpty()){
			return true;
		}
		Node node = first;
		do{
			if(node.next != null && node.next.compareTo(node) < 0){
				return false;
			}
		}while((node = node.next) != null);
		return true;
	}

	@Override
	public int size() {
		return count;
	}
	
	/**
	 * 链表节点类。为了避免多次遍历链表，这里的节点包含了key和value两个数据
	 * */
	private class Node implements Comparable<Node>{
		
		private Key key;
		private Value value;
		
		private Node next;
		
		public Node(Key key,Value value){
			this.key = key;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node arg0) {
			return key.compareTo(arg0.key);
		}
		
	}
//	
//	public static void main(String[] args) {
//		OrderedSequentialSearchST<Double,Integer> st = new OrderedSequentialSearchST<>();
//		for(int i = 0;i<20;i++){
//			st.put((double)i, i);
//		}
//		for(int i = 0;i<st.size() + 1;i++){
//			System.out.println(st.rank((double)i));
//			System.out.println(st.rank(st.select(i)));
//		}
//	}
}
