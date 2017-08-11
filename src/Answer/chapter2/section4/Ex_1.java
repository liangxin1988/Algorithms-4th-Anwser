package Answer.chapter2.section4;

import Answer.base.Answer0;
import Answer.base.Answer1String;
import data_structure.max_pq.MaxPQHelper;

/**
 */
public class Ex_1 extends Answer1String {
    @Override
    public void answer() {
        MaxPQHelper.execute(getArgs1());
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"P R I O * R * * I * T * Y * * * Q U E * * * U * E"};
    }
}
