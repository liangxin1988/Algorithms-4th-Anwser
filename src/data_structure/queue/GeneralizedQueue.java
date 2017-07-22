package data_structure.queue;

/**
 * Created by liangxin on 2017/7/9.
 */
public interface GeneralizedQueue<Item> extends Iterable<Item>{
    boolean isEmpty();

    void insert(Item item);

    Item delete(int k);
}
