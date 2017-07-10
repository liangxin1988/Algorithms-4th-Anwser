package framework.bean;

import java.util.*;

/**
 * 封装章节
 */
public class Chapter implements Comparable<Chapter>{
    private Collection<Section> sectionList = new TreeSet<>();

    private int chapterNum;
    public Chapter(int chapterNum){
        this.chapterNum = chapterNum;
    }

    public int getChapterNum(){
        return chapterNum;
    }
    /**添加小节*/
    public void addSection(Section section){
        sectionList.add(section);
    }

    public Section findSectionByNum(int sectionNum){
        for(Section s : sectionList){
            if(s.getSectionNum() == sectionNum){
                return s;
            }
        }
        return null;
    }

    /**章节越大，对象越靠后*/
    @Override
    public int compareTo(Chapter o) {
        return chapterNum - o.chapterNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("第").append(chapterNum).append("章").append("\n");
        for(Section s : sectionList){
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}
