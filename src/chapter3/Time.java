package chapter3;

public class Time implements Comparable<Time>{

	//表示时分秒
	private int hour,min,second;	

	@Override
	public int compareTo(Time arg0) {
		if(hour != arg0.hour){
			return hour - arg0.hour;
		}
		if(min != arg0.min){
			return min - arg0.min;
		}
		return second - arg0.second;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	
}
