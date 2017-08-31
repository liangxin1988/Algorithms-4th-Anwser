package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 关于文件操作的工具类
 * */
public class FileUtil {

	/**
	 * 获得用来存放测试数据的文件夹
	 * */
	private static File getDataFile(){
		File file = new File("data");
		if(!file.exists()){
			file.mkdirs();
		}
		return file;
	}

	/**获取待测试文件*/
	private static File getTestFile(String fileName){
		return new File(getDataFile(),fileName);
	}

	/**获取测试文件对应的输入流*/
	public static Scanner getScanner(String filename) {
		try {
			return new Scanner(getTestFile(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("找不到文件");
		}

	}
}
