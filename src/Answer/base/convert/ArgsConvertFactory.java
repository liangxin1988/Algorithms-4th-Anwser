package Answer.base.convert;

/**
 * 创建转换器使用的工厂。通过工厂可以减少转换器对象的创建
 */
public class ArgsConvertFactory {
    static IntegerArgsConvert integerArgsConvert = new IntegerArgsConvert();
    static DoubleArgsConvert doubleArgsConvert = new DoubleArgsConvert();

    public static DoubleArgsConvert[] createDoubleArgsConverts(int size){
        DoubleArgsConvert[] doubleArgsConverts = new DoubleArgsConvert[size];
        for(int i = 0;i<size;i++){
            doubleArgsConverts[i] = doubleArgsConvert;
        }
        return doubleArgsConverts;
    }

    public static IntegerArgsConvert createIntegerArgsConvert(){
        return integerArgsConvert;
    }

    /**获取指定数目的int类型转换器*/
    public static IntegerArgsConvert[] createIntegerArgsConvert(int size){
        IntegerArgsConvert[] integerArgsConverts = new IntegerArgsConvert[size];
        for(int i = 0;i<size;i++){
            integerArgsConverts[i] = integerArgsConvert;
        }
        return integerArgsConverts;
    }
}
