package algorithms.sort;

/**
 * 归并排序的实现(在merge中new数组)
 * */
public class MergeSortNewCache extends BaseSort{

	public MergeSortNewCache(Comparable[] a) {
		super(a);
	}

	public void sort() {
		sort(a,0,a.length - 1);
	}
	
	/**
	 * 将数组的两个部分按照大小顺序合并为一个数组。
	 * 合并前，要保障start-mid 与 mid + 1 - end这两个区间都是有序的。方法执行完毕后，保证start - end整个区间有序
	 * */
	protected void merge(Comparable[] a,int start,int mid,int end){
		Comparable[] cache = new Comparable[a.length];
		int i = start;  //用i和j当作待合并的两个区域的指针，默认指向当前区域的第一个元素
		int j = mid + 1;
		
		for(int k = start;k <= end;k++){  //将待操作的区间缓存到cache数组中
			cache[k] = a[k];
		}
		
		for(int k = start;k <= end;k++){  //遍历待操作的区间
			if(i > mid){  //如果i>mid，说明i区间的内容已经用完，此时只能从j区间获取数据
				a[k] = cache[j++];
			}else if(j > end){  //如果j>end，说明j区间的内容已经用完，此时只能从i区间获取数据
				a[k] = cache[i++];
			}else if(less(cache[i], cache[j])){  //如果两个区间都有数据，则将小的数据取出来
				a[k] = cache[i++];
			}else{
				a[k] = cache[j++];
			}
		}
	}
	
	/**
	 * 递归执行排序的过程
	 * */
	private void sort(Comparable[] a,int start,int end){
		if(end <= start){  //递归结束条件
			return;
		}
		int mid = start + (end - start) / 2;  //计算中点
		
		sort(a,start,mid);  //递归的进行前半部分的排序操作
		sort(a,mid + 1,end);  //递归的进行后半部分的排序操作
		merge(a, start, mid, end);  //合并前两个排序。使得整个数组有序
	}

}
