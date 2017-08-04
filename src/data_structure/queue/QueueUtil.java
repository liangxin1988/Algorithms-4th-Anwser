package data_structure.queue;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class QueueUtil {

    public static <T extends Comparable> Queue<T> mergeQueue(Queue<T> queue1,Queue<T> queue2){
        Queue<T> queue = new CircularLinkedQueue<>();
        T x1 = null,x2 = null;

        x1 = queue1.isEmpty() ? null : queue1.dequeue();
        x2 = queue2.isEmpty() ? null : queue2.dequeue();

        while(x1 != null || x2 != null){
            if(x1 == null || (x2 != null && x1.compareTo(x2) > 0)){
                queue.enqueue(x2);
                x2 = queue2.isEmpty() ? null : queue2.dequeue();
            }

            if(x2 == null || (x1 != null && x1.compareTo(x2) <= 0)){
                if(x1 == null){
                    break;
                }
                queue.enqueue(x1);
                x1 = queue1.isEmpty() ? null : queue1.dequeue();
            }
        }
        return queue;
    }
}
