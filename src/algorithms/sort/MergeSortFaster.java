package algorithms.sort;

/**
 * 归并排序的实现
 * */
public class MergeSortFaster extends BaseSort{

	public MergeSortFaster(Comparable[] a) {
		super(a);
	}

	public void sort() {
		sort(a,new Comparable[a.length],0,a.length - 1);
	}
	
	/**
	 * 将数组的两个部分按照大小顺序合并为一个数组。
	 * 合并前，要保障start-mid 与 mid + 1 - end这两个区间都是有序的。方法执行完毕后，保证start - end整个区间有序
	 * */
	protected void merge(Comparable[] a,Comparable[] cache,int start,int mid,int end){
		
		int i = start; 
		int j = mid + 1;
		
		for(int k = start;k <= end;k++){  
			cache[k] = a[k];
		}
		
		for(int k = start;k <= end;k++){ 
			if(i > mid){  
				a[k] = cache[j++];
			}else if(j > end){  
				a[k] = cache[i++];
			}else if(less(cache[i], cache[j])){ 
				a[k] = cache[i++];
			}else{
				a[k] = cache[j++];
			}
		}
	}
	
	/**
	 * 递归执行排序的过程
	 * */
	private void sort(Comparable[] a,Comparable[] cache,int start,int end){
		if(end <= start){  
			return;
		}
		
		if(end - start <= 5){
			//使用插入排序加快小数组的排序速度
			for(int i = start;i<=end;i++){
				for(int j = i + 1;j<end && less(a[j], a[j+1]);j++){
					exch(a, j, j+1);
				}
			}
		}
		int mid = start + (end - start) / 2; 
		
		sort(a,cache,start,mid);  
		sort(a,cache,mid + 1,end); 
		if(less(a[mid + 1],a[mid]))  //判断有序状态
			merge(a,cache, start, mid, end); 
	}

}
