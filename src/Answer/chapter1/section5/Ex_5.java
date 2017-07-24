package Answer.chapter1.section5;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.StdDraw;
import framework.Fixme;
import util.canvas.MyCanvas;
import util.canvas.shape.Rect;

import java.awt.*;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;
@Fixme
public class Ex_5 extends Answer0 {
    @Override
    public void answer() {
        //借地方搞个测试，希望别被我提交了
        MyCanvas myCanvas = new MyCanvas(100,500);
        myCanvas.setColor(Color.RED);
        myCanvas.drawRect(new Rect(1,1,50,50));
//        double x = 0.05,y = 0.05;
//        StdDraw.clear();
//        StdDraw.setCanvasSize(100,500);
//        StdDraw.rectangle(0.5,0.5,0.1,0.3);
    }
}