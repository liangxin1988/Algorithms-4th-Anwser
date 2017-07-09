package chapter2;

import static edu.princeton.cs.algs4.StdOut.println;

import sort.SortDrawable;
import sort.SortDrawableState;
import util.ChapterUtil;

public class Chapter2_1Exercises {

	public static void question1(){
		ChapterUtil.questionNo();  //先尝试自己画吧，用程序写比较麻烦
	}
	
	public static void question2(){
		println("每次外层循环都必然执行一次交换，也仅有每次外层循环执行了交换，所以交换次数是固定的n次");
	}
	
	public static void question3(){
		println("[9,8,7,6,5,4,3,2,1,0]");
	}
	
	public static void question4(){
		ChapterUtil.questionNo();  //先尝试自己画吧，用程序写比较麻烦
	}
	
	public static void question5(){
		println("[0,1,2,3,4,5,6,7,8,9]");
	}
	
	//辅助绘制排序轨迹的类
	private static class SortDrawGridHelper{

		private SortDrawable sd;
		
		private static final String topFormat = "%2s %4s";
		private static final String itemFormat = "%6s";
			
		public SortDrawGridHelper(SortDrawable sd){
			this.sd = sd;
		}
		
		public void draw(){
			drawTitle();
			sd.execute();
			drawItem();
		}
		
		public void drawItem(){
			for(int i = 0;i<sd.getCount();i++){
				SortDrawableState sortDrawableState = sd.getState(i);
				String str = String.format(topFormat, ""+i,""+sortDrawableState.getBold());
				str += arrayToString(sortDrawableState.getArrays());
				drawLineStr(str);
			}
		}
		
		private void drawTitle(){
			String str = String.format(topFormat, "i","min");
			for(int i = 0;i<sd.getCount();i++){
				str+=String.format(itemFormat, i+"");
			}
			drawLineStr(str);
			str = String.format(topFormat,"","");
			str += arrayToString(sd.getArray());
			drawLineStr(str);
		}
		
		private String arrayToString(Comparable[] a){
			String str = "";
			for(Comparable c : a){
				str += String.format(itemFormat, c+"");
			}
			return str;
		}
		
		private void drawLineStr(String str){
			println(str);
		}
	}
	

}
