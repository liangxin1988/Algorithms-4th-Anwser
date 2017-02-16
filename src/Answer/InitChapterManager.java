package Answer;

import chapter1.Chapter1_1NormalTest;
import framework.ExerciseManager;

public class InitChapterManager {

	private ExerciseManager exerciseManager = ExerciseManager.getInstence();
	
	public void init(){
		exerciseManager.regiestQuestion(new Chapter1_1NormalTest());
	}
	
	public static InitChapterManager getInstance(){
		return InitChapterManagerHolder.initChapterManager;
	}
	
	private static class InitChapterManagerHolder{
		private static InitChapterManager initChapterManager = new InitChapterManager();
	}
}
