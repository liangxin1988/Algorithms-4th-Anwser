package data_structure.st;
import java.util.Iterator;

import algorithms.sort.MergeSortFaster;

/**
 * 将BinarySearchSt修改为通过item实现，并没有做过什么测试
 * */
public class BinarySearchST<Key extends Comparable<Key> , Value> extends OrderST<Key, Value>{
	
	private Item<Key,Value>[] items;
	private int count = 0;
	
	public BinarySearchST(int size){
		items = new Item[size];
	}
	
	public BinarySearchST(Item[] items){
		new MergeSortFaster(items).sort();
		this.items = items;
	}

	@Override
	public Key min() {
		if(!isEmpty())
			return items[0].key;
		return null;
	}

	@Override
	public Key max() {
		if(!isEmpty())
			return items[count - 1].key;
		return null;
	}

	@Override
	public Key floor(Key key) {
		int rank = rank(key);
		if(rank < count && items[rank].key.equals(key)){  
			return items[rank].key;
		}
		if (rank == 0) return null; 
		return items[rank - 1].key;  
	}

	@Override
	public Key ceiling(Key key) {
		return items[rank(key)].key; 
	}

	@Override
	public int rank(Key key) {
		int start = 0,end = count - 1;
		while(start <= end){
			int mid = start + (end - start) / 2;
			int com = key.compareTo(items[mid].key);
			if(com < 0){
				end = mid - 1;
			}else if(com > 0){
				start = mid + 1;
			}else{
				return mid;
			}
		}
		return start;
	}

	@Override
	public Key select(int k) {
		return items[k].key;
	}

	@Override
	public Iterable<Key> keys(Key start, Key end) {
		return new BinarySearchSTIterable(start, end);
	}
	
	@Override
	public void delete(Key key) {
		if(isEmpty()){
			return;
		}
		int rank = rank(key);
		if(rank < count && items[rank].key.equals(key)){
			for(int i = rank;i<count;i++){  //假设不会越界
				items[i] = items[i + 1];
			}
			count--;
		}
	}

	@Override
	public void put(Key key, Value val) {
		int rank = rank(key);
		if(rank < count && items[rank].key.compareTo(key) == 0){ 
			items[rank].value = val;
			return;
		}
		for(int i = count;i > rank ;i--){
			items[i] = items[i-1];
		}
		Item item = new Item();
		item.key = key;
		item.value = val;
		items[rank] = item;
		count++;
		
		if(count == items.length){
			changeSize(2 * items.length);
		}
	}
	
	private void changeSize(int size){
		Item[] newItems = new Item[size];
		for(int i = 0;i<count;i++){
			newItems[i] = items[i];
		}
		items = newItems;
	}

	@Override
	public Value get(Key key) {
		if(isEmpty()){
			return null;
		}
		int rank = rank(key);
		if(rank < count && items[rank].key.equals(key)){
			return items[rank].value;
		}
		return null;
	}

	@Override
	public int size() {
		return count;
	}
	
	private class BinarySearchSTIterable implements Iterable<Key>{

		private Key start;
		private Key end;
		
		public BinarySearchSTIterable(Key start,Key end){
			this.start = start;
			this.end = end;
		}

		@Override
		public Iterator iterator() {
			return new BinarySearchSTIterator();
		}
		
		private class BinarySearchSTIterator implements Iterator<Key>{

			private Key start = BinarySearchSTIterable.this.start;
			private Key end = BinarySearchSTIterable.this.end;
			
			private int index = rank(start);
			@Override
			public boolean hasNext() {
				return index < count && items[index].key.compareTo(end) <= 0;
			}

			@Override
			public Key next() {
				return items[index++].key;
			}
			
		}
		
	}

}

class Item<Key extends Comparable<Key> , Value> implements Comparable<Item>{
	Key key;
	Value value;
	@Override
	public int compareTo(Item arg0) {
		return key.compareTo((Key) arg0.key);
	}
}
