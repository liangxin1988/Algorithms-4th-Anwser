package Answer.chapter1.section1;

import Answer.base.Answer0;
import framework.Fixme;

import java.util.ArrayList;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
@Fixme
public class Ex_34 extends Answer0 {
    @Override
    public void answer() {
        //        double a[] = {0.2,0.7,0.8,0.5,0.9,0.6,0.3,0.2,0.7,0.4,0.8,0.6,0.1,0.4,0.5,0.2,0.3,0.6};
        println("打印出最大和最小值。  //需要两个变量，参考MaxAndMinFilter");
        println("打印出所有数的中位数。  //需要保存所有元素，参考MiddleNumFilter");
        println("打印出第k小的数，k小于100    //保存前k个最小值，参考KSmallNumFilter");
        println("打印出所有数的平方和    //需要一个变量，用来保存累计的平方和");
        println("打印所有数的平均数  //需要两个变量，保存计数器和累计的数据和");
        println("剩余3个都想不到不保存完整数据的实现方案");
//        double a[] = ChapterUtil.getRandomDoubleArray(20);
//        Filter filter = new AverageFilter();
//        for(Double x : a){
//            filter.set(x);
//        }
//        filter.printResult();

    }

    /**实现过滤器的接口*/
    interface Filter{
        /**通过多次调用，将数据流传递给Filter*/
        void set(double num);

        /**将数据流的计算结果打印出来*/
        void printResult();
    }

    /**计算中位数的过滤器*/
    class MiddleNumFilter implements Filter{

        private ArrayList<Double> nums = new ArrayList<>();

        @Override
        public void set(double num) {
            nums.add(num);
        }

        @Override
        public void printResult() {
            nums.sort(Double::compareTo);
            println(nums);
            if(nums.size() % 2 == 0){
                //偶数个数据的中位数是中间两个数的平均数
                println("中位数为："+((nums.get(nums.size() / 2) + nums.get(nums.size() / 2 - 1)) / 2));
            }else{
                //奇数个数据的中位数是中间的一个数
                println("中位数为："+nums.get(nums.size() / 2));
            }
        }
    }
    /**计算最大最小值*/
    class MaxAndMinFilter implements Filter{

        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        @Override
        public void set(double num) {
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
        }

        @Override
        public void printResult() {
            println("max = "+max+",min = "+min);
        }
    }

    class KSmallNumFilte implements Filter{

        private double[] small;
        private int count = 0;

        public KSmallNumFilte(int k){
            small = new double[k];
            for(int i = 0;i<small.length;i++){
                small[i] = Double.MAX_VALUE;
            }
        }

        @Override
        public void set(double num) {
            int index = rank(num,small,0,count - 1);
            if(index < 0)  index = ~index;
            insert(index,num);
        }

        /**将字符插入到数组中*/
        private void insert(int index,double key){
            if(index >= small.length){
                return;
            }
            for(int i = small.length - 1;i > index;i--){
                small[i] = small[i - 1];
            }
            small[index] = key;
            if(count < small.length)
                count++;
        }

        @Override
        public void printResult() {
            println(small[small.length - 1]);
        }

        private int rank(double key,double[] a,int lo,int hi){
            if(lo > hi) return ~lo;  //不返回-1，而是返回lo，这时lo指向的即是假设key存在时的索引。取反的目的，是为了标识是否找到了该元素
            int mid = lo + (hi - lo) / 2;
            if(key < a[mid]) return rank(key,a,lo,mid - 1);
            else if(key > a[mid]) return rank(key,a,mid + 1,hi);
                //这个分支表示，如果找到了key，但是左边的元素仍然等于key，那么找到的这个元素不是目标元素，需要继续查找
            else if(mid - 1 >= 0 && a[mid - 1] == key){
                return rank(key,a,lo,mid - 1);
            }else{
                return mid;
            }
        }
    }
    /**打印所有数的平方和*/
    class QuadraticSumFilter implements Filter {

        double sum = 0;

        @Override
        public void set(double num) {
            sum += num * num;
        }

        @Override
        public void printResult() {
            println("所有数的平方和为："+sum);
        }
    }

    class AverageFilter implements Filter{

        private int count = 0;
        private double sum = 0;
        @Override
        public void set(double num) {
            sum += num;
            count++;
        }

        @Override
        public void printResult() {
            println("平均值为："+(sum / count));
        }

    }}
