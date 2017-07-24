package util.canvas.shape;

public class Rect{
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

    public Rect(int left, int bottom, int right, int top){
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
}