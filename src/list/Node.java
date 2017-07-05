package list;
/**
 * 链表中的节点
 * 为了满足将Node作为参数的要求，将Node抽离为单独的类
 * */
public class Node<Item>{
    public Item item;
    public Node<Item> next;

    //构造函数为了简化对链表的操作。
    Node(Item item){
        this.item = item;
    }
    Node(Item item,Node next){
        this(item);
        this.next = next;
    }
}