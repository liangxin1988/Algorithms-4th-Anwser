package Answer.base.convert;

/**
 * 将参数转为double类型
 */
public class DoubleArgsConvert implements ArgsConvert<Double> {
    @Override
    public int count() {
        return 1;
    }

    @Override
    public Double convert(String... args) {
        return Double.parseDouble(args[0]);
    }
}
