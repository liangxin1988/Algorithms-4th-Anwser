package util;

/**
 * 对各种异常情况的检查类
 */
public class Checker {

    /**检查给定数据是否为正整数*/
    public static void checkPlus(int x){
        if(x <= 0){
            throw new RuntimeException("编号非正数");
        }
    }

    /**检查给定多个数据是否为正整数*/
    public static void checkPlus(int ... xs){
        for(int x : xs){
            checkPlus(x);
        }
    }

    public static void checkStringNull(String str){
        if(str == null || str.length() == 0){
            throw new RuntimeException("字符串不能为空");
        }
    }

    public static void checkStringNull(String ... strs){
        for(String s : strs){
            checkStringNull(s);
        }
    }
}
