package framework;

import Answer.base.BaseAnswer;

/**
 * 将标准题号解析为习题类对象
 */
public class TitleClassParser {

    /**
     * 习题类的包名
     * */
    public static final String PACKAGE_NAME = "Answer";

    /**
     * 习题类的标准类名头。所有习题类在定义时需要添加
     * */
    public static final String TITLE_FORMAT = "Ex_%d";
    /**
     * 表示章的格式化名称
     * */
    public static final String CHAPTER_FORMAT = "chapter%d";
    /**
     * 表示小节的格式化名称
     * */
    public static final String SECTION_FORMAT = "section%d";

    /**
     * 解析标准的题号
     * 标准题号格式为1.1.1，其中，第一个点用来分割章和节，第二个点用来分割节和节中的题号。这个格式与书中定义的格式相同
     *
     * @param title 标准题号
     * @return 题号对应的习题答案对象类
     * */
    public static Class<BaseAnswer> parser(String title) throws NoAnswerException {
        String[] t = title.split("\\.");  //根据题号格式，可知使用.可以将题号分割为章、节、题号三部分。
        //通过题号拼接习题类的类名
        //Answer.chapter1.section1
        StringBuilder sb = new StringBuilder(PACKAGE_NAME);
        sb.append(".");
        sb.append(String.format(CHAPTER_FORMAT,Integer.parseInt(t[0]))).append(".");
        sb.append(String.format(SECTION_FORMAT,Integer.parseInt(t[1]))).append(".");
        sb.append(String.format(TITLE_FORMAT,Integer.parseInt(t[2])));
        try {
            Class<BaseAnswer> titleClass = (Class<BaseAnswer>) Class.forName(sb.toString());
            return titleClass;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new NoAnswerException(title);
        }
    }


}
