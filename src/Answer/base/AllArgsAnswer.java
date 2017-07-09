package Answer.base;

/**
 * Created by liangxin on 2017/7/10.
 */
public abstract class AllArgsAnswer extends BaseAnswer {

    private String[] mArgs;

    @Override
    public void formatArgs(String... args) {
        mArgs = new String[args.length - 1];
        for(int i = 0;i<mArgs.length;i++){
            mArgs[i] = args[i + 1];
        }
    }

    public String[] getmArgs() {
        return mArgs.clone();
    }
}
