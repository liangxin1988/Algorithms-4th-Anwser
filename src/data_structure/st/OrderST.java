package data_structure.st;
public abstract class OrderST<Key extends Comparable<Key> , Value> extends ST<Key,Value>{

	public abstract Key min();
	
	public abstract Key max();
	
	public abstract Key floor(Key key);
	
	public abstract Key ceiling(Key key);
	
	public abstract int rank(Key key);
	
	public abstract Key select(int k);
	
	public void deleteMin(){
		delete(min());
	}

	public void deleteMax(){
		delete(max());
	}

	public int size(Key start,Key end){
		if(end.compareTo(start) < 0){
			return 0;
		}else if(contains(end)){
			return rank(end) - rank(start) + 1;
		}else{
			return rank(end) - rank(start);
		}
	}
	
	public abstract Iterable<Key> keys(Key start,Key end);
	
	public Iterable<Key> keys(){
		return keys(min(),max());
	}
}
