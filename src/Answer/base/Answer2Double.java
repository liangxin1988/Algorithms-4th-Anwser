package Answer.base;

import Answer.base.convert.ArgsConvert;
import Answer.base.convert.ArgsConvertFactory;

/**
 */
public abstract class Answer2Double extends BaseArgsAnswer {

    /**
     * 使用答案个数来初始化答案类
     * 这个类可以帮助处理默认参数的初始化
     */
    public Answer2Double() {
        super(2);
    }

    public double getArgs1(){
        return (double) mArgs[0];
    }
    public double getArgs2(){
        return (double) mArgs[1];
    }

    @Override
    protected ArgsConvert[] getConverts() {
        return ArgsConvertFactory.createDoubleArgsConverts(2);
    }
}
