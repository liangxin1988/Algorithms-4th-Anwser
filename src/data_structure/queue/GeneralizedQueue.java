package data_structure.queue;

/**
 */
public interface GeneralizedQueue<Item> extends Iterable<Item>{
    boolean isEmpty();

    void insert(Item item);

    Item delete(int k);
}
