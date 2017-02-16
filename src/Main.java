import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import framework.Executer;
import Answer.InitChapterManager;

/**
 * 主类
 * */
public class Main {

	public static void main(String[] args) {
		InitChapterManager.getInstance().init();  //进行题目的初始化
		
		try{
			if(args[0].contains(",")){  //如果是多道习题
				String[] titles = args[0].split(",");
				for(String title : titles){
					new Executer().execute(title,args);  //执行习题代码
				}
			}else{  //如果是单道习题
				new Executer().execute(args[0],args);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
