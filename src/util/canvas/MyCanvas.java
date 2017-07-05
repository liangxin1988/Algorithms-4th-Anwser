package util.canvas;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;

/**
 * Created by liangxin on 2017/7/3.
 */
public class MyCanvas {

    private int width,height;

    /**构造画板，并初始化画板的宽高*/
    public MyCanvas(int width,int height){
        this.width = width;
        this.height = height;
        StdDraw.setCanvasSize(width,height);
    }

    public void drawRect(Rect rect,Color color){
        cacheStdStatus();
        StdDraw.setPenColor(color);
        RatioRect ratioRect = new RatioRect(rect);
        StdDraw.rectangle(ratioRect.left,ratioRect.top,ratioRect.right,ratioRect.bottom);
        restoreStdStatus();
    }

    private double px2Ratio(int px,boolean isWidth){
        return  px * 1.0 / (isWidth?this.width:this.height);
    }

    private class RatioRect{
        double left,top,right,bottom;
        public RatioRect(Rect rect){
            left = px2Ratio(rect.left,true);
            top = px2Ratio(rect.top,false);
            right = px2Ratio(rect.right,true);
            bottom = px2Ratio(rect.bottom,false);
        }
    }

    public static class Rect{
        private int left,top,right,bottom;
        public Rect(){

        }

        public int getLeft() {
            return left;
        }

        public int getTop() {
            return top;
        }

        public int getRight() {
            return right;
        }

        public int getBottom() {
            return bottom;
        }

        public Rect(int left, int top, int right, int bottom){
            this.left = left;
            this.top = top;
            this.right = right;
            this.bottom = bottom;
        }
    }

    private class StdStatusCache{
        private Color color;
    }
    private StdStatusCache stdStatusCache = new StdStatusCache();
    private void cacheStdStatus(){
        stdStatusCache.color = StdDraw.getPenColor();
    }

    private void restoreStdStatus(){
        StdDraw.setPenColor(stdStatusCache.color);
    }
}
