package Answer.base;

import Answer.base.convert.ArgsConvert;

/**
 */
public abstract class Answer2 extends BaseArgsAnswer {
    public Answer2() {
        super(2);
    }

    public Object getArgs1(){
        return mArgs[0];
    }
    public Object getArgs2(){
        return mArgs[1];
    }


}
