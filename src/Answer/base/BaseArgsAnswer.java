package Answer.base;

import Answer.base.convert.ArgsConvert;

/**
 * 帮助解析参数的类
 */
abstract class BaseArgsAnswer extends BaseAnswer {

    /**
     * 题目中使用的参数个数
     * */
    private int argsCount = 0;
    /**
     * 用来保存所有的参数
     * */
    protected Object[] mArgs;

    /**
     * 使用答案个数来初始化答案类
     * 这个类可以帮助处理默认参数的初始化
     * */
    BaseArgsAnswer(int argsCount){
        if(argsCount < 0){
            throw new RuntimeException("你TM在逗我？");
        }
        this.argsCount = argsCount;
        mArgs = new Object[argsCount];
    }

    @Override
    public void formatArgs(String... args) {
        //控制台给定的参数格式不足
        if(!checkArgsSize(args)){
            setDefault();
            return;
        }
        //转换参数。需要先去掉第一个参数title
        convertArgs(subArray(args,1,args.length));
    }

    /**通过转换器对象和题目给出的参数，判断参数是否符合需求*/
    private boolean checkArgsSize(String ... args){
        int count = 0;
        ArgsConvert[] converts = getConverts();
        for(ArgsConvert ac : converts){
            count += ac.count();
        }
        if(args.length - 1 < count){
            return false;
        }
        return true;
    }

    /**根据子类提供的转换器，将String类型的参数转为子类要求的参数类型*/
    private void convertArgs(String ... args){
        int index = 0;
        for(int i = 0;i<argsCount;i++){
            ArgsConvert argsConvert = getConverts()[i];
            mArgs[i] = argsConvert.convert(subArray(args,index,index + argsConvert.count()));
            index += argsConvert.count();
        }
    }

    /**
     * 获取args数组中，start-end中所有元素组成(包括start 不包括 end)的数组
     * */
    private String[] subArray(String[] args,int start,int end){
        String[] sub = new String[end - start];
        for(int i = start;i<end;i++){
            sub[i - start] = args[i];
        }
        return sub;
    }

    /**为题目设置默认值*/
    private void setDefault(){
        Object[] defaultArgs = getDefault();
        if(defaultArgs.length != argsCount){
            throw new RuntimeException("默认参数不合法");
        }
        //由题目设置的默认值不需要进行转换
        for(int i = 0;i<argsCount;i++){
            mArgs[i] = defaultArgs[i];
        }
    }
    /**
     * 获取转换器对象
     * 子类通过实现这个方法，提供父类参数要怎么转换可以满足题目需求。
     * */
    abstract protected ArgsConvert[] getConverts();

    /**
     * 由题目自己设置，如果不存在参数时需要使用的默认值
     * */
    abstract protected Object[] getDefault();
}
