package Answer.chapter3.section1;

import Answer.base.Answer0;
import data_structure.st.BinarySearchOrderST;
import data_structure.st.OrderST;

import static Answer.chapter3.section1.Ex_4.Event.*;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_4 extends Answer0{
    @Override
    public void answer() {
        String[] keys = new String[]{
                "09:00:00",
                "09:00:03",
                "09:00:13",
                "09:00:59",
                "09:01:10",
                "09:03:13",
                "09:10:11",
                "09:10:25",
                "09:14:25",
                "09:19:32",
                "09:19:46",
                "09:21:05",
                "09:22:43",
                "09:22:54",
                "09:25:52",
                "09:35:21",
                "09:36:14",
                "09:37:44",
        };
        Event[] values = new Event[]{
                Chicago,
                Phoenix,
                Houston,
                Chicago,
                Houston,
                Chicago,
                Seattle,
                Seattle,
                Phoenix,
                Chicago,
                Chicago,
                Chicago,
                Seattle,
                Seattle,
                Chicago,
                Chicago,
                Seattle,
                Phoenix,
        };

        OrderST<Time,Event> orderST = new BinarySearchOrderST<>();
        for(int i = 0;i<keys.length;i++){
            orderST.put(new Time(keys[i]),values[i]);
        }
        println("min = "+orderST.min());
        println("get(09:00:13) = "+orderST.get(new Time("09:00:13")));
        println("floor(09:05:00) = "+orderST.floor(new Time("09:05:00")));
        println("select(7) = "+orderST.select(7));
        println("keys(09:15:00,09:25:00) = ");
        for(Time t : orderST.keys(new Time("09:15:00"),new Time("09:25:00"))){
            println("---"+t);
        }
        println("ceiling(09:30:00) = "+orderST.ceiling(new Time("09:30:00")));
        println("max = "+orderST.max());
        println("size(09:15:00,09:25:00) = "+orderST.size(new Time("09:15:00"),new Time("09:25:00")));
        println("rank(09:10:25) = "+orderST.rank(new Time("09:10:25")));
    }

    public enum Event {
        Chicago,Phoenix,Houston,Seattle;
    }

    /**表示时间的数据类型*/
    public class Time implements Comparable<Time>{

        //表示时分秒
        private int hour,min,second;

        public Time(String str){
            String[] strs = str.split(":");
            hour = Integer.parseInt(strs[0]);
            min = Integer.parseInt(strs[1]);
            second = Integer.parseInt(strs[2]);
        }

        @Override
        public int compareTo(Time arg0) {
            if(hour != arg0.hour){
                return hour - arg0.hour;
            }
            if(min != arg0.min){
                return min - arg0.min;
            }
            return second - arg0.second;
        }

        @Override
        public String toString() {
            return String.format("%02d:%02d:%02d",hour,min,second);
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }
    }

}
