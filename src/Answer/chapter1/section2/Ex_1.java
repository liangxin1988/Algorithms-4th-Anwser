package Answer.chapter1.section2;

import Answer.base.Answer1Integer;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import util.ChapterUtil;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_1 extends Answer1Integer{
    @Override
    public void answer() {
        int count = getArgs1();
        Checker.checkPlus(count);
        double x, y;
        StdDraw.setPenRadius(0.01);
        Point2D[] pois = new Point2D[count];
        for (int i = 0; i < count; i++) {
            x = StdRandom.uniform();
            y = StdRandom.uniform();
            pois[i] = new Point2D(x, y);
            StdDraw.point(x, y);
        }

        double min = Double.MAX_VALUE;
        for (int i = 0; i < pois.length; i++) {
            for (int j = i + 1; j < pois.length; j++) {
                double length = pois[i].distanceTo(pois[j]);
                if (min > length) {
                    min = length;
                }
            }
        }
        println(min);

        // 以下部分是用来测试的，打开可以看到所有点的距离
        StdDraw.setPenRadius(0.005);
        for (int i = 0; i < pois.length; i++) {
            for (int j = i + 1; j < pois.length; j++) {
                StdDraw.setPenColor(ChapterUtil.getRandomColor());
                double length = pois[i].distanceTo(pois[j]);
                StdDraw.line(pois[i].x(), pois[i].y(), pois[j].x(), pois[j].y());
                StdDraw.text((pois[i].x() + pois[j].x()) / 2 + 0.05,
                        (pois[i].y() + pois[j].y()) / 2 + 0.05,
                        String.format("%.3f", length));
            }
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{5};
    }
}
