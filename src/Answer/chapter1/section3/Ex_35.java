package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.queue.RandomQueue;

import java.util.TreeSet;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;
import static util.ChapterUtil.iterableToString;

public class Ex_35 extends Answer0 {
    @Override
    public void answer() {
        RandomQueue<Card> randomQueue = new RandomQueue<>();
        //初始化52张牌
        for(Type type : Type.values()){
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

    /**
     * 桥牌对象
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