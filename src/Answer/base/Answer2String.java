package Answer.base;

import Answer.base.convert.ArgsConvert;

/**
 */
public abstract class Answer2String extends Answer2 {

    @Override
    protected ArgsConvert[] getConverts() {
        return new ArgsConvert[]{null,null};
    }

    @Override
    public String getArgs1() {
        return ""+super.getArgs1();
    }
    @Override
    public String getArgs2() {
        return ""+super.getArgs2();
    }
}
