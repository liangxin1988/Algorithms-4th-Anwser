package framework;

/**
 * 题号没有对应题目的异常
 */
public class NoAnswerException extends Exception {

    /**构造方法传入原题号*/
    public NoAnswerException(String title){
        super(title + "题没有找到对应答案");
    }
}
