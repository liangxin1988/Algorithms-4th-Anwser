package framework.bean;

import Answer.base.BaseAnswer;

import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;


/**
 * 用来封装抽象习题的类
 */
public class Question implements Comparable<Question>{

    private int questionNum;

    public String getQuestionName() {
        return questionName;
    }

    private String questionName;

    public Question(Class<?> clazz){
        AnnotatedType[] annotatedInterfaces = clazz.getAnnotatedInterfaces();

        String simpleName = clazz.getSimpleName();
        this.questionName = simpleName;
        questionNum = Integer.parseInt(simpleName.split("Ex_")[1]);
    }

    private boolean isFixme = false;
    /**习题是否未完成*/
    public boolean isFixme(){
        return isFixme;
    }

    @Override
    public String toString() {
        return "        "+questionName;
    }

    @Override
    public int compareTo(Question o) {
        return questionNum - o.questionNum;
    }
}
