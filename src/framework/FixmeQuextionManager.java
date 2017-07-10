package framework;

import framework.bean.QuestionBank;
import util.ChapterUtil;
import util.ClassUtil;

import java.util.*;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 针对Fixme标记的题进行管理（主要是打印题号），统计未做的题，并方便后续补充
 */
public class FixmeQuextionManager {

    /**题库对象*/
    private QuestionBank questionBank;
    private QuestionBank fixmeQuestionBank = new QuestionBank();

    /**初始化题库*/
    public QuestionBank initQuestionBank(){
        QuestionBank questions = new QuestionBank();
        List<Class<?>> classes = loadAnswerClasses();
        for(Class c : classes){
            if (!c.getSimpleName().startsWith("Ex_")) {
                continue;
            }
            int chapterNum = -1;
            int sectionNum = -1;
            String[] split = c.getPackage().getName().split("\\.");
            if(split.length > 1 && split[1].startsWith("chapter")){
                chapterNum = Integer.parseInt(split[1].split("chapter")[1]);
            }
            if(split.length > 2 && split[2].startsWith("section")){
                sectionNum = Integer.parseInt(split[2].split("section")[1]);
            }
            if(chapterNum != -1 && sectionNum != -1){
                questions.addQuestion(chapterNum,sectionNum,c);
                if(c.getAnnotation(Fixme.class) != null){
                    fixmeQuestionBank.addQuestion(chapterNum,sectionNum,c);
                }
            }
        }
        return questions;
    }

    public void printFixmeQuestion(){
        println(fixmeQuestionBank);
    }

    private List<Class<?>> loadAnswerClasses(){
        return ClassUtil.getClasses("Answer");
    }

    private FixmeQuextionManager(){
        questionBank = initQuestionBank();
    }
    public static FixmeQuextionManager getInstance(){
        return Holder.Instance;
    }
    private static final class Holder{
        private static final FixmeQuextionManager Instance = new FixmeQuextionManager();
    }
}
