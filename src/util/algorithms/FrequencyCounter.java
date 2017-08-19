package util.algorithms;

import data_structure.st.ST;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import util.FileUtil;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static edu.princeton.cs.algs4.StdOut.println;

abstract public class FrequencyCounter {

    public abstract ST getST();

    /**
     * 计算文本中出现概率最高的单词及单词总数
     * */
    public void execute(int minlen,String fileName) throws FileNotFoundException {

        int distinct = 0, words = 0;
        ST<String, Integer> st = getST();
        //对比测试
        Map<String,Integer> map = new HashMap<>();

        //稍微进行了改造，通过读取文件获得测试用例
        Scanner scanner = FileUtil.getScanner(fileName);
        while (scanner.hasNext()) {
            String key = scanner.next();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
            //对比测试
            if(map.containsKey(key)){
                map.put(key,map.get(key) + 1);
            }else{
                map.put(key,1);
            }
        }
        
        Queue<String> queue = null;

        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)){
            	max = word;
            	queue = new Queue<>();
            	queue.enqueue(word);
            }else if(st.get(word).equals(st.get(max))){
            	queue.enqueue(word);
            }
                
        }

        int mapmax = -1;
        String mapMaxStr = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > mapmax){
                mapmax = entry.getValue();
                mapMaxStr = entry.getKey();
            }
        }

        println(max + " " + st.get(max));
        println("max words = "+queue);
        println("distinct = " + distinct);
        println("words    = " + words);

        println("对比数据");
        println("map max = "+mapmax);
        println("map max String = "+mapMaxStr);
    }
}
