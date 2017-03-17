package framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.FileHandler;

import edu.princeton.cs.algs4.StdOut;

import Answer.BaseChapter;

/**
 * 题目管理器
 * */
public class ExerciseManager {
	
	private File titleNameFile = new File("titleList.txt");
	
	public ExerciseManager(){
		if(titleNameFile.exists()){
			titleNameFile.delete();
		}
	}
	
	private Map<String,Method> answers = new HashMap<String,Method>();

	/**
	 * 通过题号获取题目
	 * */
	public Method getMethod(String title){
		return answers.get(title);
	}
	
	/**
	 * 注册习题集
	 * */
	public void regiestQuestion(BaseChapter chapterTest){
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(titleNameFile,true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Method[] methods = chapterTest.getClass().getMethods();
		ArrayList<String> methodTitle = new ArrayList<>();
		for(Method method : methods){
			Title title = method.getAnnotation(Title.class);
			if(title != null){
				String titleName = title.value();
				answers.put(titleName, method);
				methodTitle.add(titleName);
			}
		}
		methodTitle.sort(new TitleComparator());
		try{
			for(String title : methodTitle){
				fileWriter.write(title);
				fileWriter.write("\r\n");
			}
			fileWriter.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(fileWriter != null)
					fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//单例
	public static ExerciseManager getInstence(){
		return ExerciseManagerHolder.exerciseManager;
	}
	
	private static class ExerciseManagerHolder{
		private static ExerciseManager exerciseManager = new ExerciseManager();
	}
}
