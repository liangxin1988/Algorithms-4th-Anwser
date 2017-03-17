package chapter3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {

    private FrequencyCounter() { }

    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        ST<String, Integer> st = new ST<String, Integer>();

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }
        
        Queue<String> queue = null;

        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max)){
            	max = word;
            	queue = new Queue<String>();
            	queue.enqueue(word);
            }else if(st.get(word) == st.get(max)){
            	queue.enqueue(word);
            }
                
        }

        StdOut.println(max + " " + st.get(max));
        StdOut.println("max words = "+queue);
        StdOut.println("distinct = " + distinct);
        StdOut.println("words    = " + words);
    }
}
