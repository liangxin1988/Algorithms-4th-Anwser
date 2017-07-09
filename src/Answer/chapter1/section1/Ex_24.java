package Answer.chapter1.section1;

import Answer.base.Answer2Integer;
import util.ChapterUtil;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_24 extends Answer2Integer {
    @Override
    public void answer() {
        int x = getArgs1();
        int y = getArgs2();
        Checker.checkPlus(x,y);
        println(Euclid(x, y,0));
    }

    private static int Euclid(int p, int q, int level){
        println(ChapterUtil.getEmptyChar(level)+"p = "+p+",q = "+q);
        if(q == 0) return p;
        int r = p % q;
        return Euclid(q,r,level + 1);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{1111111,1234567};
    }
}
