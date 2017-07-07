package chapter1;

import Answer.BaseChapter;
import bag.Bag;
import bag.RandomBag;
import deque.Deque;
import deque.DoubleLinkedDeque;
import deque.ResizingArrayDeque;
import edu.princeton.cs.algs4.StdRandom;
import framework.Title;
import linked.LinkedSteque;
import queue.JsephusQueue;
import queue.RandomQueue;
import util.ChapterUtil;

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
