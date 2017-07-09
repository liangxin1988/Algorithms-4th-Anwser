package chapter1;

import framework.Fixme;

@Fixme
public class Chapter1_1Experiments {

    /**1.1.35中初始化骰子概率方法*/
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
