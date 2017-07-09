package Answer.base;

import Answer.base.convert.ArgsConvert;
import Answer.base.convert.ArgsConvertFactory;

/**
 * 定义需要使用3个字符串参数的答案类
 */
abstract public class Answer1Integer extends BaseArgsAnswer {

    public Answer1Integer() {
        super(1);
    }

    /**获取题目中要使用的第一个参数*/
    protected Integer getArgs1() {
        return (Integer) mArgs[0];
    }

    @Override
    protected ArgsConvert[] getConverts() {
        return ArgsConvertFactory.createIntegerArgsConvert(1);
    }
}
