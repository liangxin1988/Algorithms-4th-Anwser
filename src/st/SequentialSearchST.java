package st;

/**
 * 通过链表实现无序的符号表
 * */
public class SequentialSearchST<Key extends Comparable<Key> , Value> extends ST<Key,Value>{
	
	private Node first;
	private int count;

	@Override
	public void put(Key key, Value val) {
		Node node = getNode(key);
		if(node != null){
			node.value = val;
			return;
		}
		Node oldFirst = first;
		first = new Node(key,val);
		first.next = oldFirst;
		count++;
	}

	@Override
	public Value get(Key key) {
		Node node = getNode(key);
		if(node != null){
			return node.value;
		}
		return null;
	}
	
	private Node getNode(Key key){
		if(first == null){
			return null;
		}
		Node node = first;
		do{
			if(node.isKeyEqual(key)){
				return node;
			}
			node = node.next;
		}while(node != null);
		return null;
	}

	@Override
	public int size() {
		return count;
	}
	
	@Override
	public void delete(Key key) {
		if(isEmpty()){
			throw new RuntimeException("符号表为空，不能删除");
		}
		
		if(first.key.equals(key)){
			first = first.next;
			count--;
			return;
		}
		
		Node node = first;
		while(node.next != null){
			if(node.next.isKeyEqual(key)){
				node.next = node.next.next;
				count--;
				return;
			}
			node = node.next;
		}
	}

	@Override
	public Iterable<Key> keys() {
		return new STIterable();
	}
	
	private class STIterable implements Iterable<Key>{

		@Override
		public java.util.Iterator iterator() {
			return new STIterator();
		}
		
	}
	
	private class STIterator implements java.util.Iterator<Key>{
		
		Node node = first;

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Key next() {
			Key key = node.key;
			node = node.next;
			return key;
		}
		
	}

	private class Node{
		private Key key;
		private Value value;
		
		private Node next;
		
		public Node(Key key,Value value){
			this.key = key;
			this.value = value;
		}
		
		public boolean isKeyEqual(Key key){
			if(key == null){
				return false;
			}
			return key.compareTo(this.key) == 0;
		}
	}
	
	public static void main(String[] args) {
		SequentialSearchST<Integer, Integer> st = new SequentialSearchST<>();
		System.out.println(st);
		for(int i = 0;i<20;i++){
			st.put(i, i);
		}
		for(int i = 0;i<20;i+=2){
			st.delete(i);
		}
		System.out.println(st);
		for(int i = 1;i<20;i+=2){
			st.delete(i);
		}
//		System.out.println(st);
	}
	
}