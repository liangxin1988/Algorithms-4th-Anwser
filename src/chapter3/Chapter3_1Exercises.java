package chapter3;
import static edu.princeton.cs.algs4.StdOut.println;
import st.ArrayST;
import edu.princeton.cs.algs4.Accumulator;
import framework.Title;
import Answer.BaseChapter;

public class Chapter3_1Exercises extends BaseChapter {

	@Title("3.1.1")
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
	
	@Title("3.1.2")
	public static void question2(){
		println("参考ArrayST代码");
	}
	
	@Title("3.1.3")
	public static void question3(){
		println("参考OrderedSequentialSearchST代码");
	}
}
