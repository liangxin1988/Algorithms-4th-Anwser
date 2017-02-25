package util;

import java.io.File;

/**
 * 关于文件操作的工具类
 * */
public class FileUtil {

	/**
	 * 获得用来存放数据的文件夹
	 * */
	public static File getDataFile(){
		File file = new File("data");
		if(!file.exists()){
			file.mkdirs();
		}
		return file;
	}
}
