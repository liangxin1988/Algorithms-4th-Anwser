package algorithms.sort;

/**
 * 如果要实现排序可绘制，需要对排序类实现这个接口
 * */
public interface SortDrawable{
	
	/**
	 * 获得待排序数组的元素个数
	 * */
	int getCount();
	
	Comparable[] getArray();
	
	SortDrawableState getState(int index);
	
	void execute();
}