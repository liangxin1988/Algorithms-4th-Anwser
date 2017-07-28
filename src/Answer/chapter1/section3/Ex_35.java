package Answer.chapter1.section3;

import Answer.base.Answer0;
import bean.Card;
import data_structure.queue.RandomQueue;

import java.util.TreeSet;

import static edu.princeton.cs.algs4.StdOut.print;
import static util.ChapterUtil.iterableToString;

public class Ex_35 extends Answer0 {
    @Override
    public void answer() {
        RandomQueue<Card> randomQueue = new RandomQueue<>();
        //初始化52张牌
        for(Card.Type type : bean.Card.Type.values()){
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


}