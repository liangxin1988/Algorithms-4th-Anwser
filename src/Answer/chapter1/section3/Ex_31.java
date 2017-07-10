package Answer.chapter1.section3;

import Answer.base.Answer0;
import linked.DoubleLinked;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_31 extends Answer0 {
    @Override
    public void answer() {
        DoubleLinked<Integer> doubleLinked = new DoubleLinked<>();
        String format = "%-9s:";
        for(int i = 0; i<3; i++){
            doubleLinked.insertFirst(i);
            printf(format,"在头部添加节点"+i);println(doubleLinked);
        }

        for(int i = 3;i<5;i++){
            doubleLinked.insertLast(i);
            printf(format,"在尾部添加节点"+i);println(doubleLinked);
        }

        for(int i = 0;i<3;i++){
            doubleLinked.deleteFirst();
            printf(format,"从头部删除节点");println(doubleLinked);
        }

        while(!doubleLinked.isEmpty()){
            doubleLinked.deleteLast();
            printf(format,"从尾部删除节点");println(doubleLinked);
        }

        for(int i = 0;i<5;i++){
            doubleLinked.insertLast(i);
        }
        printf(format,"重新构造单链表");println(doubleLinked);
        doubleLinked.insertItemForPre(doubleLinked.findNodeByIndex(0),10);
        printf(format,"在第一个元素前插入元素");println(doubleLinked);
        doubleLinked.insertItemForPre(doubleLinked.findNodeByIndex(2),15);
        printf(format,"在中间位置插入元素");println(doubleLinked);

        doubleLinked.insertItemForNext(doubleLinked.findNodeByIndex(4),20);
        printf(format,"在中间位置插入元素");println(doubleLinked);
        doubleLinked.insertItemForNext(doubleLinked.findNodeByIndex(7),25);
        printf(format,"在最后一个元素后插入元素");println(doubleLinked);

        while(!doubleLinked.isEmpty()){
            doubleLinked.deleteNode(doubleLinked.findNodeByIndex(0));
            printf(format,"删除第一个元素");println(doubleLinked);
        }
    }
}