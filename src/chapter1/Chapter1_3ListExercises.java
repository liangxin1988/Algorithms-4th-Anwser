package chapter1;

import java.util.Iterator;

import list.ListUtil;
import list.SimpleList;
import util.ChapterUtil;
import static edu.princeton.cs.algs4.StdOut.*;
import framework.Title;
import Answer.BaseChapter;

public class Chapter1_3ListExercises extends BaseChapter {

	@Title("1.3.18")
	public static void question18(){
		ChapterUtil.questionLue();
	}
	
	@Title("1.3.19")
	public static void question19(){
		SimpleList<Integer> simpleList = new SimpleList<>();
		for(int i = 0;i<3;i++){
			simpleList.addFirst(i);
		}
		println(simpleList);
		for(int i = 0;i<3;i++){
			simpleList.deleteLast();
			println(simpleList);
		}
	}

	@Title("1.3.20")
	public static void question20(){
		SimpleList<Integer> simpleList = new SimpleList<>();
		for(int i = 0;i<5;i++){
			simpleList.addFirst(i);
		}
		println(simpleList);
		simpleList.deleteForIndex(4);
		println(simpleList);
		simpleList.deleteForIndex(0);
		println(simpleList);
		simpleList.deleteForIndex(1);
		println(simpleList);
		simpleList.deleteForIndex(1);
		println(simpleList);
		simpleList.deleteForIndex(0);
		println(simpleList);
	}

	/*
	* 注意：
	* 从此题开始，题目中要求方法直接操作Node对象。
	* 不过将Node直接暴露出来，可能导致链表被不受控制的修改，所以此处将Node对象打包为NodeBox
	* 链表外部无法通过NodeBox操作链表，增强安全性。阅读代码的时候请注意。
	* */
	@Title("1.3.21")
	public static void question21(){
	    SimpleList<Integer> simpleList = new SimpleList<>();
	    for(int i = 0;i<5;i++){
	        simpleList.addFirst(i);
        }
		println(simpleList);
        int curr = 4;
        println("链表中"+(simpleList.find(simpleList.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 6;
        println("链表中"+(simpleList.find(simpleList.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 0;
        println("链表中"+(simpleList.find(simpleList.getFirst(),curr)?"存在":"不存在")+curr);
    }

    @Title("1.3.22")
    public static void question22(){
		ChapterUtil.questionLue();
	}

	@Title("1.3.23")
	public static void question23(){
		ChapterUtil.questionLue();
	}

	@Title("1.3.24")
	public static void question24(){
		SimpleList<Integer> simpleList = new SimpleList<>();
		for(int i = 0;i<5;i++){
			simpleList.addFirst(i);
		}
		println(simpleList);
		simpleList.removeAfter(simpleList.getItemForIndex(2));  //会把2以后的元素都删除
		println(simpleList);
		simpleList.removeAfter(simpleList.getFirst());  //把除first的元素都删除
		println(simpleList);
	}
}
