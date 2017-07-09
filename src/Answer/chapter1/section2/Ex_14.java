package Answer.chapter1.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Date;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_14 extends Answer0 {
    @Override
    public void answer() {
        Transaction t1 = new Transaction("java",new Date(1,1,1988),100);
        Transaction t2 = new Transaction("java",new Date(1,1,1988),100);
        Transaction t3 = new Transaction("kotlin",new Date(1,1,1988),100);

        println("t1 == t2?"+t1.equals(t2));
        println("t1 == t3?"+t1.equals(t3));

    }

    class Transaction{
        private String who;
        private Date when;
        private double amount;
        Transaction(String who,Date when,double amount){
            this.who = who;
            this.when = when;
            this.amount = amount;
        }

        public String who(){
            return who;
        }

        public Date when(){
            return when;
        }

        public double amount(){
            return amount;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "who='" + who + '\'' +
                    ", when=" + when +
                    ", amount=" + amount +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null) return false;
            if(this.getClass() != o.getClass()) return false;
            Transaction that = (Transaction) o;
            if(that.amount != this.amount) return false;
            if(!that.when.equals(this.when)) return false;
            if(!that.who.equals(this.who)) return false;
            return true;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = who != null ? who.hashCode() : 0;
            result = 31 * result + (when != null ? when.hashCode() : 0);
            temp = Double.doubleToLongBits(amount);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }

        int compareTo(Transaction that){
            return (int)(this.amount - that.amount);
        }
    }
}
