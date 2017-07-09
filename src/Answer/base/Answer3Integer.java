package Answer.base;

import Answer.base.convert.ArgsConvert;
import Answer.base.convert.ArgsConvertFactory;

/**
 * 定义需要使用3个字符串参数的答案类
 */
abstract public class Answer3Integer extends BaseArgsAnswer {

    public Answer3Integer() {
        super(3);
    }

    /**获取题目中要使用的第一个参数*/
    protected Integer getArgs1() {
        return (Integer) mArgs[0];
    }

    /**获取题目中要使用的第二个参数*/
    protected Integer getArgs2() {
        return (Integer) mArgs[1];
    }

    /**获取题目中要使用的第三个参数*/
    protected Integer getArgs3() {
        return (Integer) mArgs[2];
    }

    @Override
    protected ArgsConvert[] getConverts() {
        return ArgsConvertFactory.createIntegerArgsConvert(3);
    }
}
