package algorithms.sort;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 对排序进行有效性测试的测试类
 * */
public class Main {

	public static void main(String[] args) {
		test(args);
	}
	
	
	/**
	 * 将测试方法定义在父类，子类通过main调用这个方法进行测试
	 * */
	private static void test(String[] args){
		BaseSort bs = getBaseSort(getData(args));
		StdOut.println("排序前：");
		bs.show();
		bs.sort();
		StdOut.println("排序后：");
		bs.show();
		StdOut.println(bs.getClass().getSimpleName()+"排序"+(bs.isSorted()?"成功":"失败"));
	}
	
	
	/**
	 * 定义排序数组来源，可以通过控制台或者随机生成
	 * */
	private static Comparable[] getData(String[] args){
		Integer[] a = null;
		if(args != null && args.length != 0){
			String[] s = args[0].split(",");
			a = new Integer[s.length];
			for(int i = 0;i<a.length;i++){
				a[i] = new Integer(Integer.parseInt(s[i]));
			}
		}else{
			a = new Integer[20];
			for(int i = 0;i<a.length;i++){
				a[i] = new Integer(StdRandom.uniform(100));
			}
		}
		return a;
	}
	

	private static BaseSort getBaseSort(Comparable[] a) {
		return new MergeSortNewCache(a);
	}
}
