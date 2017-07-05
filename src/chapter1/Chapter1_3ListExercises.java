package chapter1;

import edu.princeton.cs.algs4.StdRandom;
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

	/**创建链表并填充测试数据*/
	private static SimpleList<Integer> createSimpleList(int start,int end){
        SimpleList<Integer> simpleList = new SimpleList<>();
        for(int i = start;i<=end;i++){
            simpleList.addFirst(i);
        }
        return simpleList;
    }

	@Title("1.3.25")
	public static void question25(){
        SimpleList<Integer> simpleList = createSimpleList(0,5);
        SimpleList<Integer> simpleList2 = createSimpleList(6,10);
        simpleList.insertAfter(simpleList.getFirst(),simpleList2.getFirst());
        println(simpleList);

        simpleList = createSimpleList(0,5);
        simpleList2 = createSimpleList(6,10);
        simpleList.insertAfter(simpleList.getLast(),simpleList2.getFirst());
        println(simpleList);

        simpleList = createSimpleList(0,5);
        simpleList2 = createSimpleList(6,10);
        simpleList.insertAfter(simpleList.getItemForIndex(3),simpleList2.getFirst());
        println(simpleList);
    }

    @Title("1.3.26")
    public static void question26(){
		SimpleList<Integer> simpleList = new SimpleList<>();
		for(int i = 0;i<11;i++){
			if(i % 2 == 0){
				simpleList.addFirst(1);
			}else{
				simpleList.addFirst(i / 2);
			}
		}
		println(simpleList);
		simpleList.removeForKey(1);
		println(simpleList);

		simpleList.clearLink();
		for(int i = 0;i<10;i++){
			simpleList.addFirst(1);
		}
		println(simpleList);
		simpleList.removeForKey(1);
		println(simpleList);
	}

	@Title("1.3.27")
	public static void question27(){
		SimpleList<Integer> simpleList = new SimpleList<>();
		for(int i = 0;i<10;i++){
			int rand = StdRandom.uniform(20);
			print(rand + "  ");
			simpleList.addFirst(rand);
		}
		println();
		println("最大值："+simpleList.max());
	}

    @Title("1.3.28")
    public static void question28(){
        SimpleList<Integer> simpleList = new SimpleList<>();
        for(int i = 0;i<10;i++){
            int rand = StdRandom.uniform(20);
            print(rand + "  ");
            simpleList.addFirst(rand);
        }
        println();
        println("最大值："+simpleList.max(simpleList.getFirst()));
    }
}
