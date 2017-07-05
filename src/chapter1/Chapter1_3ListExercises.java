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

	@Title("1.3.21")
	public static void question21(){
	    SimpleList<Integer> simpleList = new SimpleList<>();
	    for(int i = 0;i<5;i++){
	        simpleList.addFirst(i);
        }
        println(simpleList);
        int curr = 4;
        println("链表中"+(ListUtil.find(simpleList.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 6;
        println("链表中"+(ListUtil.find(simpleList.getFirst(),curr)?"存在":"不存在")+curr);
        curr = 0;
        println("链表中"+(ListUtil.find(simpleList.getFirst(),curr)?"存在":"不存在")+curr);

    }

}
