package chapter1;

import Answer.BaseChapter;
import bag.Bag;
import bag.RandomBag;
import deque.Deque;
import deque.DoubleLinkedDeque;
import deque.ResizingArrayDeque;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdRandom;
import framework.Title;
import linked.LinkedSteque;
import queue.*;
import stack.LinkedStack;
import util.ChapterUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;
import static util.ChapterUtil.iterableToString;

/**
 * 1.3提高题
 */
public class Chapter1_3Creative extends BaseChapter {

    @Title("1.3.32")
    public static void question32(){
        LinkedSteque<Integer> steque = new LinkedSteque<>();
        println("入栈测试:");
        for(int i = 0;i<4;i++){
            steque.push(i);
        }
        println(steque);
        for(int i = 0;i<4;i++){
            print(steque.pop() + "  ");
        }
        println();
        println("入列测试：");
        for(int i = 0;i<4;i++){
            steque.enqueue(i);
        }
        println(steque);
        for(int i = 0;i<4;i++){
            print(steque.pop() + "  ");
        }
        println();
    }

    @Title("1.3.33")
    public static void question33(){
        println("双向链表实现的双向队列测试：");
        randomTestDeque(new DoubleLinkedDeque<Integer>());
        println("数组实现的双向队列测试：");
        randomTestDeque(new ResizingArrayDeque<Integer>());
    }

    /**1.3.33使用的，使用随机的方式对双向队列进行测试*/
    private static void randomTestDeque(Deque deque) {
        String str = "";
        String format = "%-10s:";
        for(int i = 0;i<20;i++){
            switch (StdRandom.uniform(100) % 4){
                case 0:
                    str = "pushLeft:"+i;
                    deque.pushLeft(i);
                    break;
                case 1:
                    str = "pushRight:"+i;
                    deque.pushRight(i);
                    break;
                case 2:
                    str = "popLeft";
                    if(!deque.isEmpty()){
                        deque.popLeft();
                    }
                    break;
                case 3:
                    str = "popRight";
                    if(!deque.isEmpty()){
                        deque.popRight();
                    }
                    break;
            }
            printf(format,str);println(deque);
        }
    }

    @Title("1.3.34")
    public static void question34(){
        Bag<Integer> bag = new RandomBag<>();
        for(int i = 0;i<10;i++){
            bag.add(i);
        }
        println("bag.size = "+bag.size());
        println(bag);
    }

    @Title("1.3.35")
    public static void question35(){
        RandomQueue<Card> randomQueue = new RandomQueue<>();
        //初始化52张牌
        for(Card.Type type : Card.Type.values()){
            for(int i = 1;i<=13;i++){  //1表示A，11表示J，12表示Q，13表示K。
                randomQueue.enqueue(new Card(type,i));    //将所有种类的牌加入随机队列
            }
        }
        int size = randomQueue.size();
        TreeSet<Card>[] cards = new TreeSet[4];  //使用4个TreeSet表示4个人手中的牌。
        for(int i = 0;i<cards.length;i++){
            cards[i] = new TreeSet<>();
        }
        for(int i = 0; i< size; i++){
            cards[i % 4].add(randomQueue.dequeue());  //4人轮番发牌
        }
        for(int i = 0;i<cards.length;i++){
            print("第"+i+"位用户："+ iterableToString(cards[i]) +"\n");
        }
    }

    @Title("1.3.36")
    public static void question36(){
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        for(int i = 0;i<10;i++){
            randomQueue.enqueue(i);
        }
        println(randomQueue);
    }

    @Title("1.3.37")
    public static void question37(String M,String N){
        int m = 2,n = 7;
        if(M != null && N != null){
            m = Integer.parseInt(M);
            n = Integer.parseInt(N);
        }

        JsephusQueue<Integer> jsephusQueue = new JsephusQueue<>(m);
        for(int i = 0;i < n;i++){  //将n个人入列（按顺序排好）
            jsephusQueue.enqueue(i);
        }
        while(!jsephusQueue.isEmpty()){  //将所有人出列，出列的顺序即为被杀死的人的顺序
            print(jsephusQueue.dequeue()+"  ");
        }
        println();
    }

    @Title("1.3.38")
    public static void question38(){
        testGeneralizedQueue(new ArrayGeneralizedQueue<>());
        println("----------------------------");
        testGeneralizedQueue(new LinkedGeneralizedQueue<>());
    }

    private static void testGeneralizedQueue(GeneralizedQueue<Integer> queue){
        for(int i = 0;i<10;i++){
            queue.insert(i);
        }
        println(queue);
        print("删除:"+queue.delete(3)+" : ");
        println(queue);
        print("删除:"+queue.delete(3)+" : ");
        println(queue);
        print("删除:"+queue.delete(5)+" : ");
        println(queue);
        print("删除:"+queue.delete(0)+" : ");
        println(queue);
        print("删除:"+queue.delete(5)+" : ");
        println(queue);
    }

    @Title("1.3.42")
    public static void question42(){
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        for(int i = 0;i<20;i++){
            boolean bernoulli = StdRandom.bernoulli();
            if(bernoulli){
                linkedStack.push(i);
            }else{
                if(!linkedStack.isEmpty()){
                    linkedStack.pop();
                }
            }
//            print(bernoulli?("push:"+i):("pop   "));println(linkedStack);  //打印轨迹
        }
        println("原始栈："+linkedStack);
        println("复制的栈："+new LinkedStack<Integer>(linkedStack));
    }

    @Title("1.3.43")
    public static void question43(String fileName){
        if(fileName == null){
            fileName = "d:\\";
        }
        File file = new File(fileName);
        if(file.isFile() || !file.exists()){
            println("给定文件不合法");
        }else{
            Queue<String> queue = new CircularLinkedQueue<>();
            parserFileList(file,queue,0);
            while(!queue.isEmpty()){
                print(queue.dequeue());
            }
        }
    }

    private static void parserFileList(File file,Queue<String> queue,int level){
        StringBuilder sb = new StringBuilder(ChapterUtil.getEmptyChar(2 * level));
        sb.append(file.getName());
        sb.append("\n");
        queue.enqueue(sb.toString());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files == null){
                return;
            }
            for(File f : files){
                parserFileList(f,queue,level + 1);
            }
        }
    }

    @Title("1.3.44")
    public static void question44(){
        Buffer buffer = new Buffer();
        buffer.insert("My name is java");
        println(buffer);
            print("删除以下字符:");
        for(int i = 0;i<4;i++){
            print(buffer.delete());
        }
        println();
        buffer.insert("kotlin");
        println(buffer);
        buffer.left(14);
        buffer.insert("program ");
        println(buffer);
        buffer.right(4);
        buffer.insert("eeeeeeee");
        println(buffer);
    }
}

/**
 * 桥牌对象
 * 1.3.35
 * */
class Card implements Comparable<Card>{

    /**扑克牌的花色*/
    private final Type type;
    /**扑克牌上的数字*/
    private final int count;

    public Card(Type type,int count){
        this.type = type;
        this.count = count;
    }

    private String getCount(){
        switch (count){
            case 1:
                return "A";
            case 11:
                return "J";
            case 12:
                return "Q";
            case 13:
                return "K";
            default:
                return ""+count;
        }
    }

    @Override
    public String toString() {
        return ""+type+getCount();
    }

    @Override
    public int compareTo(Card o) {
        if(o.type != this.type){
            return this.type.ordinal() - o.type.ordinal();  //以枚举中的定义顺序作为花色的大小
        }
        return this.count - o.count;  //花色相同，以数字比较大小（不严格按桥牌规则，单纯的使用数字的大小）
    }

    enum Type{
        H("红桃"),
        S("黑桃"), //
        D("方块"), //
        C("梅花");  //
        private String name;
        Type(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}

/**
 * 文件缓冲区
 * 1.3.44
 * */
class Buffer{
    private LinkedStack<Character> left = new LinkedStack<>();
    private LinkedStack<Character> right = new LinkedStack<>();
    /**
     * 在光标位置插入字符
     * */
    void insert(char c){
        left.push(c);
    }

    void insert(String str){
        for(char c : str.toCharArray()){
            insert(c);
        }
    }

    /**刪除光标位置的字符*/
    char delete(){
        if(!left.isEmpty())
            return left.pop();
        throw new RuntimeException("已经没有字符可删除");
    }

    /**将光标左移k位*/
    void left(int k){
        for(int i = 0;i<k;i++){
            if(left.size() != 0)
                right.push(left.pop());
        }
    }

    /**将光标右移k位*/
    void right(int k){
        for(int i = 0;i<k;i++){
            if(right.size() != 0){
                left.push(right.pop());
            }
        }
    }

    /**缓冲区中字符数量*/
    int size(){
        return left.size() + right.size();
    }

    @Override
    public String toString() {
        LinkedStack<Character> cacheRightStack = new LinkedStack<>(right);
        LinkedStack<Character> cacheLeftStack = new LinkedStack<>(left);
        while(!cacheLeftStack.isEmpty()){
            cacheRightStack.push(cacheLeftStack.pop());
        }
        StringBuilder stringBuilder = ChapterUtil.getStringBuilder();
        while(!cacheRightStack.isEmpty()){
            stringBuilder.append(cacheRightStack.pop());
        }
        return stringBuilder.toString();
    }
}
