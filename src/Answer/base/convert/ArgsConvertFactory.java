package Answer.base.convert;

/**
 * 创建转换器使用的工厂。通过工厂可以减少转换器对象的创建
 */
public class ArgsConvertFactory {
    static IntegerArgsConvert integerArgsConvert = new IntegerArgsConvert();

    /**获取指定数目的int类型转换器*/
    public static IntegerArgsConvert[] integerArgsConvertFactory(int size){
        IntegerArgsConvert[] integerArgsConverts = new IntegerArgsConvert[size];
        for(int i = 0;i<size;i++){
            integerArgsConverts[i] = integerArgsConvert;
        }
        return integerArgsConverts;
    }
}
