package framework;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Answer.BaseChapterTest;

/**
 * 题目管理器
 * */
public class ExerciseManager {
	
	private Map<String,Method> answers = new HashMap<String,Method>();

	public Method getMethod(String title){
		return answers.get(title);
	}
	
	public void regiestQuestion(BaseChapterTest chapterTest){
		Method[] methods = chapterTest.getClass().getMethods();
		for(Method method : methods){
			Title title = method.getAnnotation(Title.class);
			if(title != null){
				answers.put(title.value(), method);
			}
		}
	}
	
	public static ExerciseManager getInstence(){
		return ExerciseManagerHolder.exerciseManager;
	}
	
	private static class ExerciseManagerHolder{
		private static ExerciseManager exerciseManager = new ExerciseManager();
	}
}
