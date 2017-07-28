package Answer.chapter2.section1;

import Answer.base.Answer0;
import algorithms.sort.ShellSort;
import edu.princeton.cs.algs4.Shell;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_11 extends Answer0 {
    @Override
    public void answer() {
        Comparable<Double>[] array = ChapterUtil.getRandomSortArray(10);
        ShellSort shellSort = new ShellSort(array);
        shellSort.sort();
        println(shellSort.isSorted());
    }
}