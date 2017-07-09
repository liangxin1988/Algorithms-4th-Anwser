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
}
