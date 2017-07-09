package chapter3;
import static edu.princeton.cs.algs4.StdOut.println;
import st.ArrayST;
import st.BinarySearchST;
import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdRandom;

public class Chapter3_1Exercises {

	public static void question1(String str){
		if(str == null){
			str = "a,1,a,2,a,4,b,3,b,3,d,1";
		}
		String[] strs = str.split(",");
		ArrayST<String, Accumulator> st = new ArrayST<>(10);
		for(int i = 0;i<strs.length;i+=2){
			Accumulator accumulator = null;
			if(st.contains(strs[i])){
				accumulator = st.get(strs[i]);
			}else{
				accumulator = new Accumulator();
			}
			accumulator.addDataValue(Integer.parseInt(strs[i + 1]));
			st.put(strs[i],accumulator);
		}
		
		for(String s : st.keys()){
			println("char : "+s+",score : "+st.get(s).mean());
		}
	}
	
	public static void question2(){
		println("参考ArrayST代码");
	}
	
	public static void question3(){
		println("参考OrderedSequentialSearchST代码");
	}
	
	public static void question4(){
		println("参考Time和Event的代码");
	}
	
	public static void question5(){
		println("参考SequentialSearchST代码");
	}
	
	public static void question6(){
		println("这里忽略minlen,认为其等于1");
		println("put:由于对每一个单词，都必然执行一次put操作，所以put次数为总单词数W。另外后面的max进行了一次put");
		println("get:首先，对每个单词都会进行contains(其内部通过get方法实现)，而对每个重复的单词，都会使用get获取count，调用了W - D次get。");
		println("后面比较max时，对每一个单词都调用两次get进行比较，打印的时候有一次get。");
	}
	
	public static void question12(){
		println("参考BinarySearchST代码");
	}
	
	public static void question16(){
		println("参考BinarySearchST代码");
	}
	
	public static void question17(){
		println("参考BinarySearchST代码");
	}
	
	public static void question18(){
		BinarySearchST<Integer, Integer> st = new BinarySearchST<>(20);
		for(int i = 0;i<1000;i++){
			int x = StdRandom.uniform(100000);
			st.put(x, x);
		}
		for(int i = 0;i<st.size();i++){
			if(i != st.rank(st.select(i))){
				println("wrong");
				return;
			}
		}
		println("right");
	}
	
	public static void question19(){
		println("参考FrequencyCounter代码");
	}
}
