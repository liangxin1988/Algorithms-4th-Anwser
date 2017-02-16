package framework;
import static edu.princeton.cs.algs4.StdOut.println;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Executer {

	private ExerciseManager exerciseManager = ExerciseManager.getInstence();
	public void execute(String title,String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(!title.contains(".")){
			throw new RuntimeException("题目编号格式异常");
		}
		
		Method method = exerciseManager.getMethod(title);
		int paramsCount = method.getParameterCount();
		if(paramsCount == 0 || args[0].contains(",")){
			invokie(title,method,getParams(paramsCount));
		}else{
			String[] params = new String[args.length - 1];
			for(int i = 0;i<params.length;i++){
				params[i] = args[i + 1];
			}
			invokie(title,method,params.length == paramsCount?params:getParams(paramsCount));
		}
	}
	
	private void invokie(String title,Method method,String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		println("==============================================================");
		println("题目："+title);
		println("--------------------------------------------------------------");
		try{
			method.invoke(null, args);
		}catch(Exception e){
			e.printStackTrace();
		}
		println();
		println("==============================================================");
		println();
	}

	private String[] getParams(int count){
		if(count == 0){
			return null;
		}
		return new String[count];
	}
}
