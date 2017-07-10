package framework.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * 用来封装题库的抽象对象
 */
public class QuestionBank {
    private Collection<Chapter> chapterList = new TreeSet<>();

    public void addQuestion(int chapterNum,int sectionNum,Class<?> clazz){
        Chapter c = findChapterByNum(chapterNum);
        if(c == null){
            c = new Chapter(chapterNum);
            chapterList.add(c);
        }

        Section s = c.findSectionByNum(sectionNum);
        if(s == null){
            s = new Section(sectionNum);
            c.addSection(s);
        }

        Question q = s.findQuestionByName(clazz.getSimpleName());
        if(q == null){
            q = new Question(clazz);
            s.addQuestion(q);
        }
    }

    private Chapter findChapterByNum(int chapterNum){
        for(Chapter c : chapterList){
            if(c.getChapterNum() == chapterNum){
                return c;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Chapter c : chapterList){
            sb.append(c);
            sb.append("\n");
        }
        return sb.toString();
    }
}
