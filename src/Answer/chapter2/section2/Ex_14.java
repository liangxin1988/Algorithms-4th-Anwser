package Answer.chapter2.section2;

import Answer.base.Answer0;
import data_structure.queue.CircularLinkedQueue;
import data_structure.queue.Queue;
import data_structure.queue.QueueUtil;
import edu.princeton.cs.algs4.StdRandom;
import framework.Fixme;
import util.ChapterUtil;

import javax.print.attribute.standard.PrintQuality;

import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_14 extends Answer0 {
    @Override
    public void answer() {
        Queue<Integer> queue1 = new CircularLinkedQueue<>();
        Queue<Integer> queue2 = new CircularLinkedQueue<>();

        //添加有序元素
        initQueue(queue1);
        initQueue(queue2);

        Queue<Integer> x = QueueUtil.mergeQueue(queue1, queue2);
        println(x);
        println("size = "+x.size());
        println("isSort = "+isSort(x));
    }

    private boolean isSort(Queue<Integer> queue){
        if(queue.isEmpty()){
            return true;
        }
        int old = queue.dequeue();
        while(!queue.isEmpty()){
            int newInt = queue.dequeue();
            if(newInt < old){
                return false;
            }
            old = newInt;
        }
        return true;
    }

    private void initQueue(Queue<Integer> queue){
        int curr = 0;
        for(int i = 0;i<10;i++){
            curr += StdRandom.uniform(10);
            queue.enqueue(curr);
        }
    }
}