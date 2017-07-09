package Answer.base;

import Answer.base.convert.ArgsConvert;

/**
 */
public abstract class Answer1String extends Answer1 {

    @Override
    protected ArgsConvert[] getConverts() {
        return new ArgsConvert[]{null};
    }

    @Override
    public String getArgs1() {
        return super.getArgs1() + "";
    }
}
