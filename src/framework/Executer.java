package framework;
import Answer.base.BaseAnswer;

import static edu.princeton.cs.algs4.StdOut.println;

import java.lang.reflect.InvocationTargetException;

/**
 * 习题执行类
 * */
public class Executer {
	/**
	 * 通过习题题号和习题参数执行习题
	 * */
	public void execute(String title,String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		try {
			Class<BaseAnswer> titleClass = TitleClassParser.parser(title);
			BaseAnswer baseAnswer = titleClass.newInstance();
			baseAnswer.formatArgs(args);  //由习题类自己管理怎样处理控制台参数
			invoke(title,baseAnswer); //执行回答方法
		} catch (NoAnswerException e) {
			e.printStackTrace();
			throw new RuntimeException("题目编号格式异常");
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new RuntimeException("习题执行失败");
		}
	}
	
	/**
	 * 以固定格式执行习题
	 * */
	private void invoke(String title, BaseAnswer answer) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		println("==============================================================");
		println("题目："+title);
		println("--------------------------------------------------------------");
		try{
			answer.answer();
		}catch(Exception e){
			e.printStackTrace();
		}
		println();
		println("==============================================================");
		println();
	}
}
