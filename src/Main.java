import framework.Executer;
import framework.FixmeQuextionManager;
import framework.bean.QuestionBank;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 主类
 * */
public class Main {

	private void handler(String command){
	}

	public static void main(String[] args) {
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
