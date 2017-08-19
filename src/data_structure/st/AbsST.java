package data_structure.st;

/**
 * 无序符号表的抽象类，实现了一些默认的方法
 */
abstract public class AbsST<Key,Value> implements ST<Key,Value>{
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
