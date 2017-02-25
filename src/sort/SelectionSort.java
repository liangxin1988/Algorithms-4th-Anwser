package sort;

import java.util.ArrayList;

/**
 * 实现了选择排序的算法
 * */
public class SelectionSort extends BaseSort implements SortDrawable{

	public SelectionSort(Comparable[] a) {
		super(a);
	}
	
	private ArrayList<SortDrawableState> states = new ArrayList<>();

	public void sort() {
		for(int i = 0;i<a.length;i++){  //外层循环遍历数组。
			SelectionSortState selectionSortState = new SelectionSortState();
			selectionSortState.setArrays(a.clone());
			int min = i;
			for(int j = i + 1;j<a.length;j++){  //内层循环找到从外层循环开始位置到数组结束这个区间内的最小元素，并于i指向的元素交换
				if(less(a[j], a[min])){  //如果j中的元素小于min指向的元素，则将j设置给min，保证内层循环结束后，min保存着最小元素的索引
					min = j;
				}
			}
			exch(a, min, i);
			
			selectionSortState.setGray(getIndexs(i, a.length));
			selectionSortState.setBold(min);
			states.add(selectionSortState);
		}
	}
	
	private int[] getIndexs(int start,int end){
		int[] indexs = new int[end - start];
		for(int i = 0;i<end - start;i++){
			indexs[i] = start + i;
		}
		return indexs;
	}

	@Override
	public int getCount() {
		return a.length;
	}

	@Override
	public Comparable[] getArray() {
		return a.clone();
	}
	
	private class SelectionSortState implements SortDrawableState{
		
		private Comparable[] a;
		private int[] gray;
		private int bold;
		
		private void setBold(int bold){
			this.bold = bold;
		}
		
		private void setArrays(Comparable[] a){
			this.a = a;
		}
		
		private void setGray(int[] gray){
			this.gray = gray;
		}

		@Override
		public Comparable[] getArrays() {
			return a;
		}

		@Override
		public int[] getGray() {
			return gray;
		}

		@Override
		public int getBold() {
			return bold;
		}
		
	}

	@Override
	public SortDrawableState getState(int index) {
		return states.get(index);
	}

	@Override
	public void execute() {
		sort();
	}
}
