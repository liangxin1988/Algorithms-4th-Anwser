package algorithms.sort;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * 比较算法，由第1和2个参数设定待比较的算法，第三个参数设置数据量，而第四个参数指定重复次数（用来消除误差）
 * */
public class SortCompare {
	public static double time(String alg, Comparable[] a) {
		BaseSort baseSort = null;
		if (alg.equals("LocalCacheMergeSort")){
			baseSort = new LocalCacheMergeSort(a);
		}else if(alg.equals("SentryInsertSort")){
			baseSort = new SentryInsertSort(a);
		}else if(alg.equals("InsertionSort")){
			baseSort = new InsertionSort(a);
		}else if(alg.equals("WithoutExchangeInsertiongSort")){
			baseSort = new WithoutExchangeInsertiongSort(a);
		}
		Stopwatch timer = new Stopwatch();
		baseSort.sort();
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t++) {
			for (int i = 0; i < N; i++)
				a[i] = StdRandom.uniform();
			total += time(alg, a);
		}
		return total;
	}

	public static void test(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double t1 = timeRandomInput(alg1, N, T); 
		double t2 = timeRandomInput(alg2, N, T); 
		StdOut.printf("For %d random Doubles\n %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
		StdOut.println("t1 = "+t1);
		StdOut.println("t2 = "+t2);
	}
}