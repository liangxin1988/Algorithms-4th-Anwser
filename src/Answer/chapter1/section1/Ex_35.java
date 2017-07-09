package Answer.chapter1.section1;

import Answer.base.Answer0;
import framework.Fixme;
import util.ChapterUtil;

/**
 */
@Fixme
public class Ex_35 extends Answer0 {
    @Override
    public void answer() {
        ChapterUtil.questionNo();
    }

    private static double[] initdist(){
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for(int i = 1;i<=SIDES;i++){
            for(int j = 1;j<=SIDES;j++){
                dist[i + j] += 1.0;
            }
        }
        for(int k = 2;k<=2 * SIDES;k++){
            dist[k] /= 36.0;
        }
        return dist;
    }

}
