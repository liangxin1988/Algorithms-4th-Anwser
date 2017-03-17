package st;
import java.util.Spliterator;
import java.util.function.Consumer;

import javax.swing.text.html.HTMLDocument.Iterator;

import util.ChapterUtil;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public abstract class ST<Key extends Comparable<Key> , Value> {

	public void delete(Key key){
		put(key,null);  
	}
	
	public abstract void put(Key key,Value val);
	
	public boolean contains(Key key){
		return get(key) != null;  
	}

	public abstract Value get(Key key);
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	public abstract int size();
	
	public abstract Iterable<Key> keys();
	
	
	@Override
	public String toString() {
		if(isEmpty()){
			return "";
		}
		StringBuilder sb = ChapterUtil.getStringBuilder("[");
		for(Key k : keys()){
			sb.append("(").append(k).append(",").append(get(k)).append(")");
			sb.append(",");
		}
		sb.replace(sb.length() - 1, sb.length(), "]");
		return sb.toString();
	}
	
}
