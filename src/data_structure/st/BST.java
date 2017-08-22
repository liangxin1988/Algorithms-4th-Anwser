package data_structure.st;

import java.util.LinkedList;
import java.util.Queue;

import static edu.princeton.cs.algs4.StdOut.print;


/**
 * 以二叉查找树实现的有序符号表
 */
public class BST<Key extends Comparable<Key>,Value> extends AbsOrderST<Key,Value>{

    /**当前二叉查找树的根节点*/
    private Node root;

    public void setShowTrip(boolean showTrip) {
        this.showTrip = showTrip;
    }

    private boolean showTrip = false;

    @Override
    public void put(Key key, Value value) {
        root = put(key,value,root);
    }

    private Node put(Key key,Value value,Node node){
        if(node == null){
            return new Node(key,value,1,0);
        }
        int cmp = node.key.compareTo(key);
        if(cmp < 0){
            node.right = put(key,value,node.right);
        }else if(cmp > 0){
            node.left = put(key,value,node.left);
        }else {
            node.value = value;
        }
        node.size = size(node.left) + size(node.right) + 1;
        int leftHeight = height1(node.left);
        int rightHeight = height1(node.right);
        node.height = 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
        return node;
    }

    @Override
    public Value get(Key key) {
        return get(key,root);
    }

    /**通过递归的方式查找给定的键*/
    private Value get(Key key,Node node){
        if(node == null){
            return null;
        }
        if(showTrip){
            print(node.key+",");
        }
        int cmp = node.key.compareTo(key);
        if(cmp == 0){
            return node.value;
        }

        if(cmp > 0){
            return get(key,node.left);
        }else{
            return get(key,node.right);
        }
    }

    /**得到当前二叉查找树的元素个数*/
    public int size(){
        return size(root);
    }

    private int size(Node node){
        if(node == null){
            return 0;
        }
        return node.size;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node node){
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }


    @Override
    public Key max() {
        return max(root).key;
    }

    private Node max(Node node){
        if(node.right == null){
            return node;
        }
        return max(node.right);
    }

    @Override
    public Key floor(Key key) {
        Node floor = floor(key, root);
        if(floor == null){
            return null;
        }
        return floor.key;
    }

    private Node floor(Key key,Node node){
        if(node == null){
            return null;
        }
        int cmp = node.key.compareTo(key);
        if(cmp == 0){
            return node;
        }
        if(cmp > 0){
            return floor(key,node.left);
        }
        Node right = floor(key,node.right);
        if(right != null) return right;
        return node;
    }

    @Override
    public Key ceiling(Key key) {
        Node ceiling = ceiling(key, root);
        if(ceiling == null){
            return null;
        }
        return ceiling.key;
    }

    private Node ceiling(Key key,Node node){
        if(node == null){
            return null;
        }
        int cmp = node.key.compareTo(key);
        if(cmp == 0) return node;
        if(cmp < 0){
            return ceiling(key,node.right);
        }
        Node left = ceiling(key,node.left);
        if(left != null) return left;
        return node;
    }

    @Override
    public int rank(Key key) {
        return rank(key,root);
    }

    private int rank(Key key,Node node){
        if(node == null){
            return 0;
        }
        int cmp = node.key.compareTo(key);
        if(cmp == 0){
            return size(node.left);
        }else if(cmp > 0){
            return rank(key,node.left);
        }else{
            return rank(key,node.right) + size(node.left) + 1;
        }
    }

    @Override
    public Key select(int k) {
        return select(k,root).key;
    }

    private Node select(int k,Node node){
        if(node == null){
            return null;
        }
        int size = size(node.left);
        int cmp = size - k;
        if(cmp == 0){
            return node;
        }else if(cmp > 0){
            return select(k,node.left);
        }else{
            return select(k - size - 1,node.right);
        }

    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node){
        if(node == null){
            return null;
        }
        if(node.right == null){
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        int leftHeight = height1(node.left);
        int rightHeight = height1(node.right);
        node.height = 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
        return node;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        int leftHeight = height1(node.left);
        int rightHeight = height1(node.right);
        node.height = 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
        return node;
    }

    @Override
    public void delete(Key key) {
        root = delete(key,root);
    }

    private Node delete(Key key,Node node){
        if(node == null){
            return null;
        }
        int cmp = node.key.compareTo(key);
        if(cmp > 0){
            node.left = delete(key,node.left);
        }else if(cmp < 0){
            node.right = delete(key,node.right);
        }else{
            if(node.right == null){
                return node.left;
            }else if(node.left == null){
                return node.right;
            }
            Node t = node;
            node = min(node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        int leftHeight = height1(node.left);
        int rightHeight = height1(node.right);
        node.height = 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
        return node;
    }

    @Override
    public Iterable<Key> keys(Key start, Key end) {
        Queue<Key> queue = new LinkedList<Key>();
        keys(root,queue,start,end);
        return queue;
    }

    private void keys(Node node, Queue<Key> queue, Key start,Key end){
        if(node == null){
            return;
        }
        int startCmp = start.compareTo(node.key);
        int endCmp = end.compareTo(node.key);
        if(startCmp < 0){
            keys(node.left,queue,start,end);
        }
        if(startCmp <= 0 && endCmp >= 0){
            queue.add(node.key);
        }
        if(endCmp > 0){
            keys(node.right,queue,start,end);
        }
    }

    /**节点类，用来表示二叉查找树中的一个节点*/
    private class Node{
        /**节点中包含的key*/
        private Key key;
        /**节点中的值*/
        private Value value;
        /**左节点*/
        private Node left;
        /**右节点*/
        private Node right;
        /**以当前节点为跟节点的树的大小*/
        private int size;

        private int height;

        public Node(Key key, Value value, int size,int height) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    //通过递归的方式计算高度
    public int height1(){
        return height1(root);
    }

    private int height1(Node node){
        if(node == null){
            return -1;
        }
        int left = height1(node.left);
        int right = height1(node.right);
        return (left > right ? left : right) + 1;
    }

    public int height2(){
        return root.height;
    }

}
