package Answer;

import chapter1.Chapter1_1Creative;
import chapter1.Chapter1_1Exercises;
import framework.ExerciseManager;

/**
 * 习题初始化管理器
 * */
public class InitChapterManager {

	private ExerciseManager exerciseManager = ExerciseManager.getInstence();
	
	public void init(){
		exerciseManager.regiestQuestion(new Chapter1_1Exercises());  //通过注册方法，将习题类中的习题通知给习题管理器
		exerciseManager.regiestQuestion(new Chapter1_1Creative());  //通过注册方法，将习题类中的习题通知给习题管理器
	}
	
	
	//单例
	public static InitChapterManager getInstance(){
		return InitChapterManagerHolder.initChapterManager;
	}
	
	private static class InitChapterManagerHolder{
		private static InitChapterManager initChapterManager = new InitChapterManager();
	}
}
