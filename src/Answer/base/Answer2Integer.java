package Answer.base;

import Answer.base.convert.ArgsConvert;
import Answer.base.convert.ArgsConvertFactory;

/**
 * 定义需要使用3个字符串参数的答案类
 */
abstract public class Answer2Integer extends BaseArgsAnswer {

    public Answer2Integer() {
        super(2);
    }

    /**获取题目中要使用的第一个参数*/
    protected Integer getArgs1() {
        return (Integer) mArgs[0];
    }

    /**获取题目中要使用的第二个参数*/
    protected Integer getArgs2() {
        return (Integer) mArgs[1];
    }

    @Override
    protected ArgsConvert[] getConverts() {
        return ArgsConvertFactory.createIntegerArgsConvert(2);
    }
}
