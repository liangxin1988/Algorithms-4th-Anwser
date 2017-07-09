package Answer.chapter1.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_10 extends Answer0 {
    @Override
    public void answer() {
        int count = 10;
        VisualCounter visuCounter = new VisualCounter(count, 10);

        for (int i = 0; i < count; i++) {
            if (StdRandom.bernoulli()) {
                visuCounter.add();
            } else {
                visuCounter.minus();
            }
        }
    }
    private static class VisualCounter {

        private int count = 0;
        private int N;

        private int cacheN;

        private VisualCounterDraw visualCounterDraw; // 辅助绘制的类

        public VisualCounter(int N, int max) {
            this.N = N;
            this.cacheN = N;
            visualCounterDraw = new VisualCounterDraw(N, max);
        }

        public void add() {
            count++;
            exec();
        }

        public void minus() {
            count--;
            exec();
        }

        private void exec() {
            if (N == 0) {
                throw new RuntimeException("超过最大使用次数");
            }
            N--;
            println("count = " + count);
            visualCounterDraw.drawPoint(cacheN - N - 1, count);
        }
    }

    /**
     * 辅助VisualCounter进行绘制的类
     * */
    private static class VisualCounterDraw {
        private int width, height;

        private int x = -1, y = -1; // 将上一次绘制的点进行保存，方便绘制连接线

        private int widthLevel = 30; // 横向坐标跨度
        private int heightLevel = 30; // 纵向坐标跨度

        private int xCount, yCount;
        private int pointCount; // 当前已经绘制点的个数;

        // 构造方法，指定横向最大值和纵向最大值
        public VisualCounterDraw(int xCount, int yCount) {
            this.width = xCount * widthLevel;
            this.height = yCount * 2 * heightLevel;
            this.xCount = xCount;
            this.yCount = yCount;
            StdDraw.setCanvasSize(width, height);
        }

        private int getX(int n) {
            return n * widthLevel;
        }

        private int getY(int count) {
            return (yCount + count) * heightLevel;
        }

        /** 将像素转换为比例 */
        private double getXScale(int x) {
            return (x * 1.0 + widthLevel / 2) / width;
        }

        private double getYScale(int y) {
            return y * 1.0 / height;
        }

        /** 绘制点第n个点，点的位置为count */
        public void drawPoint(int n, int count) {
            drawPointByPosition(getX(n), getY(count));
            pointCount++;
        }

        private void drawPointByPosition(int x, int y) {
            double px = getXScale(x), py = getYScale(y);
            StdDraw.setPenRadius(0.01);
            StdDraw.point(px, py);
            StdDraw.text(px, py + 0.05, y + "");
            if (this.x != -1) {
                StdDraw.setPenRadius(0.001);
                StdDraw.line(getXScale(x), getYScale(y), getXScale(this.x),
                        getYScale(this.y));
            }
            this.x = x;
            this.y = y;
        }
    }

}
