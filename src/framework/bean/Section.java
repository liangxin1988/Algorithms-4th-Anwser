package framework.bean;

import java.util.Collection;
import java.util.TreeSet;

/**
 * 用来封装小节的对象
 */
public class Section implements Comparable<Section> {
    private Collection<Question> questions = new TreeSet<>();

    private int sectionNum;
    public Section(int sectionNum){
        this.sectionNum = sectionNum;
    }

    public Question findQuestionByName(String questionName){
        for(Question q : questions){
            if(q.getQuestionName().equals(questionName)){
                return q;
            }
        }
        return null;
    }

    public int getSectionNum(){
        return sectionNum;
    }

    /**添加问题*/
    public void addQuestion(Question question){
        questions.add(question);
    }

    /**小节越大，排序越靠后*/
    @Override
    public int compareTo(Section o) {
        return sectionNum - o.sectionNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("    第").append(sectionNum).append("节:\n");
        for(Question q : questions){
            sb.append(q);
            sb.append("\n");
        }
        return sb.toString();
    }
}
