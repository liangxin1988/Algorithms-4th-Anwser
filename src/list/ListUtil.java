package list;

/**
 * 链表相关的工具类
 */
public class ListUtil {
    /**
     * 从以node为首节点的链表中尝试查找item。并返回链表中是否包含对应的数据
     * 1,3,21题目
     * */
    public static <Item> boolean find(Node<Item> node,Item item){
        if(node == null || item == null){  //空列表不可能包含item;
            return false;
        }
        for(Node index = node;index != null;index = index.next){
            if(item.equals(index.item)){
                return true;
            }
        }
        return false;
    }
}
