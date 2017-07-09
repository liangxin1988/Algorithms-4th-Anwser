package Answer.base.convert;

/**
 * 将字符串类型的参数转为int
 */
class IntegerArgsConvert implements ArgsConvert<Integer> {
    @Override
    public int count() {
        return 1;
    }

    @Override
    public Integer convert(String ... args) {
        return Integer.parseInt(args[0]);
    }
}
