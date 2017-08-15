package Answer.chapter2.section5;

import Answer.base.Answer0;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_9 extends Answer0 {
    @Override
    public void answer() {
        Version v1 = new Version("115.1.1");
        Version v2 = new Version("115.10.1");
		println(less(v1,v2));
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private class Version implements Comparable<Version>{
        int first;
        int secend;
        int third;

        public Version(String version){
            String[] str = version.split("\\.");
            first = Integer.parseInt(str[0]);
            secend = Integer.parseInt(str[1]);
            third = Integer.parseInt(str[2]);
        }

        @Override
        public int compareTo(Version o) {
            if(this.first != o.first){
                return this.first - o.first;
            }
            if(this.secend != o.secend){
                return this.secend - o.secend;
            }

            return this.third - o.third;
        }


    }
}