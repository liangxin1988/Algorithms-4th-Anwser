package chapter2;

import sort.SortCompare;
import framework.Title;
import Answer.BaseChapter;

public class Chapter2_2Experiments extends BaseChapter{

	@Title("2.2.26")
	public static void question26(){
		SortCompare.test(new String[]{"mergeSortNewCache","mergeSort","100000000","100"});
	}
}
