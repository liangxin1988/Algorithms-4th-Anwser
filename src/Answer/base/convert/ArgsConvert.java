package Answer.base.convert;

/**
 * 对题目参数进行转换的转换接口
 * 这个转换器总是将String作为源数据类型，使用to定义目标的数据类型
 */
public interface ArgsConvert<to> extends BaseConvert<String,to> {
    /**
     * 定义一次转换需要使用多少数据
     * */
    int count();

    /**
     * 进行转换的方法
     * */
    to convert(String ... args);
}
