package util.canvas;

import edu.princeton.cs.algs4.StdDraw;
import util.canvas.shape.Rect;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 * 提供一个绘图框架。封装stdDraw中的逻辑，并更换一些不习惯的逻辑（比如允许按照像素绘制图像）
 */
public class MyCanvas {

    /**默认画笔的宽度*/
    private static final double DEFAULT_PEN_RADIUS = 0.001;
    /**画布的默认宽度*/
    private static final int DEFAULT_WIDTH = 500;
    /**画布的默认高度*/
    private static final int DEFAULT_HEIGHT = 500;
    /**画板的宽度*/
    private int width = DEFAULT_WIDTH;
    /**画板的高度*/
    private int height = DEFAULT_HEIGHT;

    /**构造画板，并初始化画板的宽高*/
    public MyCanvas(int width,int height){
        this.width = width;
        this.height = height;
        init();
    }
    /**使用默认参数构造画板*/
    public MyCanvas(){
        init();
    }

    /**对画板参数执行初始化操作*/
    private void init(){
        StdDraw.clear();
        StdDraw.setCanvasSize(width,height);
        StdDraw.setPenRadius(DEFAULT_PEN_RADIUS);
    }

    /**设置画笔颜色*/
    public void setColor(Color color){
        StdDraw.setPenColor(color);
    }

    /**以给定坐标作为左下角绘制文字*/
    public void drawText(String text,int x,int y){
        FontRenderContext frc = new FontRenderContext(null, false, false);
        Rectangle2D stringBounds = StdDraw.getFont().getStringBounds(text, new FontRenderContext(null,false,true));
        println(stringBounds);
        StdDraw.text(px2Ratio((int) (x + stringBounds.getWidth() / 2),true),
                px2Ratio((int) (y + stringBounds.getHeight() / 2),false),text);
    }

    /**
     * 使用指定颜色绘制矩形
     * */
    public void drawRect(Rect rect, Color color){
        cacheStdStatus();
        StdDraw.setPenColor(color);
        drawRect(rect);
        restoreStdStatus();
    }

    /**
     * 绘制矩形
     * */
    public void drawRect(Rect rect){
        //stdDraw的绘制方式是指定中心点和宽度/高度的一般，不太使用，这里直接修改为绘制给定的矩形对象
        RatioRect ratioRect = new RatioRect(rect);
        StdDraw.rectangle(ratioRect.getCenterX(),ratioRect.getCenterY(),
                (ratioRect.right - ratioRect.left) / 2,
                (ratioRect.top - ratioRect.bottom) / 2);
    }

    /**将坐标指定为比例*/
    private double px2Ratio(int px,boolean isWidth){
        return  px * 1.0 / (isWidth?this.width:this.height);
    }

    private class RatioRect{
        double left,top,right,bottom;
        public RatioRect(Rect rect){
            left = px2Ratio(rect.getLeft(),true);
            top = px2Ratio(rect.getTop(),false);
            right = px2Ratio(rect.getRight(),true);
            bottom = px2Ratio(rect.getBottom(),false);
        }

        public double getCenterX(){
            return (left + right) / 2 + left;
        }

        public double getCenterY(){
            return (top + bottom) / 2 + bottom;
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
