package data_structure.st;

/**
 * 有序符号表的抽象类
 */
abstract public class AbsOrderST<Key extends Comparable<Key>,Value> implements OrderST<Key,Value> {
    @Override
    public void deleteMin() {
        delete(min());
    }

    @Override
    public void deleteMax() {
        delete(max());
    }

    @Override
    public int size(Key start, Key end) {
        if(end.compareTo(start) < 0){
            return 0;
        }else if(contains(end)){
            return rank(end) - rank(start) + 1;
        }else{
            return rank(end) - rank(start);
        }
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(),max());
    }

    @Override
    public void delete(Key key) {
        put(key,null);  //默认的delete通过put实现。
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;  //通过get获取到的value非null，表示存在key
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Key k : keys()){
            sb.append("(").append(k).append(",").append(get(k)).append(")").append(",");
        }
        sb.delete(sb.length() - 1,sb.length());
        sb.append("]");
        return sb.toString();
    }
}
