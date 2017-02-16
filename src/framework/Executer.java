package framework;
import static edu.princeton.cs.algs4.StdOut.println;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 习题执行类
 * */
public class Executer {

	private ExerciseManager exerciseManager = ExerciseManager.getInstence();
	
	/**
	 * 通过习题题号和习题参数执行习题
	 * */
	public void execute(String title,String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		if(!title.contains(".")){
			throw new RuntimeException("题目编号格式异常");
		}
		
		Method method = exerciseManager.getMethod(title);
		int paramsCount = method.getParameterCount();
		if(paramsCount == 0  //习题中没有参数 
				|| args[0].contains(",")){  //习题为多道习题
			invokie(title,method,getParams(paramsCount));  //执行习题，传递默认参数（null）
		}else{
			String[] params = new String[args.length - 1];
			for(int i = 0;i<params.length;i++){
				params[i] = args[i + 1];  //去掉参数中的第一个参数（题号），传递给习题中的参数为真正的参数
			}
			invokie(title,method,params.length == paramsCount?params:getParams(paramsCount));  //如果参数中的习题个数不匹配，传递默认参数
		}
	}
	
	/**
	 * 执行习题
	 * */
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

	/**
	 * 获取默认参数的方法。
	 * 传入负数或者0，则返回null。传入正整数，则返回对应元素个数的字符串数组，其中每个元素都为Null
	 * */
	private String[] getParams(int count){
		if(count <= 0){
			return null;
		}
		return new String[count];
	}
}
