import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import framework.Executer;
import Answer.InitChapterManager;


public class Main {

	public static void main(String[] args) {
		System.out.println("start");
		InitChapterManager.getInstance().init();
		
		try{
			if(args[0].contains(",")){
				String[] titles = args[0].split(",");
				for(String title : titles){
					new Executer().execute(title,args);
				}
			}else{
				new Executer().execute(args[0],args);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
