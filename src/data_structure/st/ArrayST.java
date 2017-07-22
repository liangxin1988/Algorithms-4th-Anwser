package data_structure.st;

import java.util.Iterator;

public class ArrayST<Key extends Comparable<Key>,Value> extends ST<Key,Value> {
	
	private Key[] keys;
	private Value[] values;
	
	private int count = 0;
	
	@Override
	public void delete(Key key) {
		if(isEmpty()){
			throw new RuntimeException("符号表为空，无法删除");
		}
		for(int i = 0;i<count;i++){  //遍历keys，找key是否存在
			if(keys[i].equals(key)){  //找到了，就删掉这个节点
				count--;  //将count指向最后一个元素
				keys[i] = keys[count];
				values[i] = values[count];
				keys[count] = null;  //避免内存泄漏
				values[count] = null;
				
				if(count <= keys.length / 4){
					changeSize(keys.length / 2);
				}
			}
		}
	}

	@Override
	public void put(Key key, Value val) {
		if(val == null){
			delete(key);
			return;
		}
		for(int i = 0;i<count;i++){  
			if(keys[i].equals(key)){  //遍历数组，如果找到了Key,则直接更新对应的value
				values[i] = val;
				return;
			}
		}
		if(isFull()){
			changeSize(2 * keys.length);
		}
		keys[count] = key;
		values[count] = val;
		count++;
	}
	
	private boolean isFull(){
		return count >= keys.length - 1;
	}
	
	private void changeSize(int newSize){
		Key[] newKeys = (Key[])new Comparable[newSize];
		for(int i = 0;i<count;i++){
			newKeys[i] = keys[i];
		}
		keys = newKeys;
		
		Value[] newValue = (Value[])new Object[newSize];
		for(int i = 0;i<count;i++){
			newValue[i] = values[i];
		}
		values = newValue;
	}

	@Override
	public Value get(Key key) {
		if(isEmpty()){
			return null;
		}
		for(int i = 0;i<count;i++){
			if(keys[i].equals(key)){
				return values[i];
			}
		}
		return null;
	}
	public ArrayST(int size){
		keys = (Key[])new Comparable[size];
		values = (Value[])new Object[size];
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public Iterable<Key> keys() {
		return new ArraySTIterable();
	}

	private class ArraySTIterable implements Iterable<Key>{

		@Override
		public Iterator<Key> iterator() {
			return new ArraySTIterator();
		}
		
		private class ArraySTIterator implements Iterator<Key>{
			
			private int index = 0;

			@Override
			public boolean hasNext() {
				return index < count;
			}

			@Override
			public Key next() {
				return keys[index++];
			}

		}

	}
	
//	public static void main(String[] args) {
//		ArrayST<Integer, Integer> data_structure.st = new ArrayST<>(10);
//		for(int i = 0;i<20;i++){
//			data_structure.st.put(i, i);
//		}
//		System.out.println(data_structure.st);
//		for(int i = 0;i<20;i+=2){
//			data_structure.st.delete(i);
//		}
//		System.out.println(data_structure.st);
//	}
}
