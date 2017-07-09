package Answer.base;


/**
 * Created by liangxin on 2017/7/9.
 */
public abstract class BaseAnswer {
    BaseAnswer(){  //缩小构造函数的访问权限，是为了避免章节继承BaseAnswer。

    }
    /**
     * 展示答案的方法，需要各个答案子类具体实现
     * */
    public abstract void answer();

    /**
     * 解析控制台参数
     * 该方法传入的参数为带答案编号的原始数据组成，由直接子类直接解析
     * */
    public abstract void formatArgs(String ... args);

}
