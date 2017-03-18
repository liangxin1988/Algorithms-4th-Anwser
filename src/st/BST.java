package st;
import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BST<Key extends Comparable<Key> , Value> extends OrderST<Key,Value> {

	private Node root;

	@Override
	public Key min() {
		if(isEmpty()){
			return null;
		}
		return getMinNode(root).key;
	}
	
	private Node getMinNode(Node root){
		if(root.left == null){ 
			return root;
		}
		return getMinNode(root.left); 
	}

	@Override
	public Key max() {
		if(isEmpty()){
			return null;
		}
		return getMaxNode(root).key;
	}
	
	private Node getMaxNode(Node root){
		if(root.right == null){
			return root;
		}
		return getMaxNode(root.right);
	}

	@Override
	public Key floor(Key key) {
		Node floorNode = floorNode(key,root);
		if(floorNode == null){
			return null;
		}
		return floorNode.key;
	}
	
	private Node floorNode(Key key,Node root){
		if(root == null){  
			return null;
		}
		int cmp = root.key.compareTo(key);
		if(cmp < 0){  
			Node node = floorNode(key,root.right); 
			if(node == null){ 
				return root;
			}
			return node; 
		}else if(cmp > 0){ 
			return floorNode(key,root.left);
		}
		return root; 
	}

	@Override
	public Key ceiling(Key key) {
		Node ceilingNode = ceilingNode(key,root);
		if(ceilingNode == null){
			return null;
		}
		return ceilingNode.key;
	}
	
	private Node ceilingNode(Key key,Node root){ 
		if(root == null){
			return null;
		}
		int cmp = root.key.compareTo(key);
		if(cmp > 0){ 
			Node node = ceilingNode(key,root.left); 
			if(node == null){ 
				return root;
			}
			return node; 
		}else if(cmp < 0){
			return ceilingNode(key,root.right);
		}
		return root;
	}

	@Override
	public int rank(Key key) {
		return rank(key,root);
	}
	
	private int rank(Key key,Node root){
		if(root == null){ 
			return 0;
		}
		int cmp = root.key.compareTo(key);
		if(cmp > 0){ 
			return rank(key,root.left);
		}else if(cmp < 0){  
			return size(root.left) + 1 + rank(key,root.right);
		}
		return size(root.left); 
	}

	@Override
	public Key select(int k) {
		if(k < 0 || k >= size()){
			return null;
		}
		Node selectNode = selectNode(k, root);
		if(selectNode != null){
			return selectNode.key;
		}
		return null;
	}
	
	private Node selectNode(int k,Node root){
		if(root == null){  
			return null;
		}
		int cmp = size(root.left) - k;
		if(cmp > 0){  
			return selectNode(k,root.left);
		}else if(cmp < 0){ 
			return selectNode(k - size(root.left) - 1,root.right);
		}else{  
			return root;
		}
		
	}
	
	@Override
	public void delete(Key key) {
		root = delete(key,root);
	}
	
	private Node delete(Key key,Node root){
		if(root == null){ 
			return null;
		}
		int cmp = root.key.compareTo(key);
		if(cmp < 0){  
			root.right = delete(key,root.right);
		}else if(cmp > 0){
			root.left = delete(key,root.left);
		}else{ 
			if(root.right == null){ 
				return root.left;
			}
			if(root.left == null){
				return root.right;
			}
			Node t = root;  
			root = getMinNode(t.right); 
			root.right = deleteMin(t.right);  
			root.left = t.left; 
		}
		root.count = size(root.left) + size(root.right) + 1; 
		root.height = 1 + max(height2(root.left),height2(root.right));
		return root;
	}
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	private Node deleteMin(Node root){
		if(root.left == null){ 
			return root.right; 
		}
		root.left = deleteMin(root.left); 
		root.count = size(root.left) + size(root.right) + 1; 
		root.height = 1 + max(height2(root.left),height2(root.right));
		return root;
	}
	
	public void deleteMax(){
		root = deleteMax(root);
	}
	
	private Node deleteMax(Node root){
		if(root.right == null){
			return root.left;
		}
		root.right = deleteMax(root.right);
		root.count = size(root.left) + size(root.right) + 1;
		root.height = 1 + max(height2(root.left),height2(root.right));
		return root;
	}

	@Override
	public Iterable<Key> keys(Key start, Key end) {
		Queue<Key> queue = new Queue<>();
		keys(root,queue,start,end);
		return queue;
	}
	
	private void keys(Node root,Queue<Key> queue,Key start,Key end){
		if(root == null){
			return;
		}
		int cmpStart = root.key.compareTo(start);
		int cmpEnd = root.key.compareTo(end);
		if(cmpStart > 0){  
			keys(root.left,queue,start,end);
		}
		if(cmpStart >= 0 && cmpEnd <= 0){ 
			queue.enqueue(root.key);
		}
		if(cmpEnd < 0){  
			keys(root.right,queue,start,end);
		}
	}

	@Override
	public void put(Key key, Value val) {
		root = put(key,val,root);
	}
	
	private Node put(Key key,Value value,Node root){
		if(root == null){
			return new Node(key,value);  
		}
		int cmp = root.key.compareTo(key);
		if(cmp < 0){  
			root.right = put(key,value,root.right);  
		}else if(cmp > 0){  
			root.left = put(key,value,root.left);
		}else{ 
			root.value = value;
		}
		root.count = 1 + size(root.left) + size(root.right);
		root.height = 1 + max(height2(root.left),height2(root.right));
		return root;
	}

	@Override
	public Value get(Key key) {
		return get(key,root);
	}
	
	private Value get(Key key,Node root){
		if(root == null){  
			return null;
		}
		int cmp = root.key.compareTo(key);
		if(cmp < 0){  
			return get(key,root.right);
		}else if(cmp > 0){  
			return get(key,root.left);
		}
		return root.value;  
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node node){
		if(node == null){
			return 0;
		}
		return node.count;
	}
	
	public int height(){
		return height2();
	}
	
	public int height1(){
		return height1(root);
	}
	
	private int height1(Node root){
		if(root == null){
			return 0;
		}
		return 1 + max(height1(root.left),height1(root.right));
	}
	
	private int max(int x,int y){
		return x>y?x:y;
	}
	
	public int height2(){
		return height2(root);
	}
	
	private int height2(Node node){
		if(node == null){
			return 0;
		}
		return node.height;
	}
	
	private class Node{
		private Key key;
		
		private Value value;
		
		private Node left;
		
		private Node right;
		
		private int count = 1;
		
		private int height = 1;
		
		public Node(Key key,Value value){
			this.key = key;
			this.value = value;
		}
	}
}
