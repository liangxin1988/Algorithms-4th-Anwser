package Answer.chapter1.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Date;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_19 extends Answer0{
    @Override
    public void answer() {
        println(new Transaction("Turing 5/22/1939 11.99").toString());

    }

    static class Transaction{
        private String who;
        private Date when;
        private double amount;
        Transaction(String str){
            String[] contents = str.split(" ");
            this.who = contents[0];
            this.amount = Double.parseDouble(contents[2]);
            this.when = new Date(contents[1]);
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "who='" + who + '\'' +
                    ", when=" + when +
                    ", amount=" + amount +
                    '}';
        }
    }

}
