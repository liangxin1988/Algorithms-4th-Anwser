package data_structure.max_pq;

import static edu.princeton.cs.algs4.StdOut.print;

/**
 * 辅助对maxPQ进行测试
 */
public class MaxPQHelper {

    /**
     * 执行一串命令，其中普通字符表示加入队列，*号表示删除最大，并打印删除的元素。需要使用空格分割所有字符。
     * */
    public static void execute(String command){
        String[] strs = command.split(" ");
        MaxPQ<String> pq = new HeapMaxPQ<>();
        for(String s : strs){
            if("*".equals(s) && !pq.isEmpty()){
                print(pq.delMax()+" ");
            }else{
                pq.insert(s);
            }
        }
    }
}
