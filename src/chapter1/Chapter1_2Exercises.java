package chapter1;

import static edu.princeton.cs.algs4.StdOut.*;

import java.util.Arrays;
import java.util.Calendar;

import edu.princeton.cs.algs4.*;
import util.ChapterUtil;

import Answer.BaseChapter;
import framework.Title;

public class Chapter1_2Exercises extends BaseChapter {

	@Title("1.2.1")
	public static void question1(String n) {
		int count = 5;
		if (n != null) {
			count = Integer.parseInt(n);
		}
		double x, y;
		StdDraw.setPenRadius(0.01);
		Point2D[] pois = new Point2D[count];
		for (int i = 0; i < count; i++) {
			x = StdRandom.uniform();
			y = StdRandom.uniform();
			pois[i] = new Point2D(x, y);
			StdDraw.point(x, y);
		}

		double min = Double.MAX_VALUE;
		for (int i = 0; i < pois.length; i++) {
			for (int j = i + 1; j < pois.length; j++) {
				double length = pois[i].distanceTo(pois[j]);
				if (min > length) {
					min = length;
				}
			}
		}
		println(min);

		// 以下部分是用来测试的，打开可以看到所有点的距离
		StdDraw.setPenRadius(0.005);
		for (int i = 0; i < pois.length; i++) {
			for (int j = i + 1; j < pois.length; j++) {
				StdDraw.setPenColor(ChapterUtil.getRandomColor());
				double length = pois[i].distanceTo(pois[j]);
				StdDraw.line(pois[i].x(), pois[i].y(), pois[j].x(), pois[j].y());
				StdDraw.text((pois[i].x() + pois[j].x()) / 2 + 0.05,
						(pois[i].y() + pois[j].y()) / 2 + 0.05,
						String.format("%.3f", length));
			}
		}
	}

	@Title("1.2.2")
	public static void question2(String n, String interval1dStr) {
		int count = 5;
		if (n != null) {
			count = Integer.parseInt(n);
		}
		String[] interval1d = null;
		if (interval1dStr != null) {
			interval1dStr.split(",");
		}
		Interval1D[] intervals = new Interval1D[count];

		boolean isRandom = interval1d == null || interval1d.length != count * 2;
		for (int i = 0; i < intervals.length; i++) {
			int min = 0, max = 0;
			if (isRandom) {
				min = StdRandom.uniform(100);
				max = StdRandom.uniform(100);
				if (min > max) {
					int temp = min;
					min = max;
					max = temp;
				}
			} else {
				min = Integer.parseInt(interval1d[i * 2]);
				max = Integer.parseInt(interval1d[i * 2 + 1]);
			}
			intervals[i] = new Interval1D(min, max);
		}

		println(Arrays.toString(intervals)); // 测试

		for (int i = 0; i < intervals.length; i++) {
			for (int j = i + 1; j < intervals.length; j++) {
				if (intervals[i].intersects(intervals[j])) {
					println("interval_1 = " + intervals[i] + ",interval_2 = "
							+ intervals[j]);
				}
			}
		}
	}

	@Title("1.2.3")
	public static void question3(String N, String minStr, String maxStr) {
		ChapterUtil.questionNo(); // 实在懒得做了
	}

	@Title("1.2.4")
	public static void question4() {
		String str1 = "hello";
		String str2 = str1;
		str1 = "world";
		println(str1);
		println(str2);
	}

	@Title("1.2.5")
	public static void question5() {
		ChapterUtil.questionLue();
	}

	@Title("1.2.6")
	public static void question6(String s1, String s2) {
		String str1 = "ACTGACG";
		String str2 = "TGACGAC";
		if (s1 != null && s2 != null) {
			str1 = s1;
			str2 = s2;
		}
		println(((str1 + str1).indexOf(str2) != -1)
				&& str1.length() == str2.length()); // 看了代码应该就理解了，不需要注释
	}

	@Title("1.2.7")
	public static void question7(String str) {
		if (str == null) {
			str = "123456789";
		}
		println(mystery(str));
	}

	@Title("1.2.8")
	public static void question8() {
		ChapterUtil.questionLue();
	}

	@Title("1.2.9")
	public static void question9() {
		Counter counter = new Counter("次");
		int[] x = new int[10000];
		ChapterUtil.initRandomArray(x, 10000);
		Arrays.sort(x);
		rank(5, x, counter); // 将counter传递给方法，相当于给方法传递地址。方法中通过地址修改的值，对所有对象的引用都起作用
		println(counter.tally());
	}

	@Title("1.2.10")
	public static void question10() {
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
	
	@Title("1.2.11")
	public static void question11(){
		println(new SmartDate(2017, 1, 1));
		try{
			println(new SmartDate(2017, 2, 29));
		}catch(Exception e){
			println(e.getMessage());
		}
	}
	
	@Title("1.2.12")
	public static void question12(){
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		print("year = "+year+",month = "+month+",day = "+day);
		println(new SmartDate(year, month, day).dayOfTheWeek());
		
//		//以下为测试用例，用系统Calendar和getDayCountToFirstDay()方法的返回结果进行对比。如果出现不匹配的情况则打印日期。如果没有打印任何日期，说明测试通过
//		StdOut.println("start");
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2000, 0 ,1, 0, 0, 0);  //从2000年1月1日开始测试
//		int count = 36600; //测试时间为超过100年（完整覆盖整个21世纪。实测10000年也没有问题，不过比较慢）
//		while(count--!=0){
//			int a = calendar.get(Calendar.DAY_OF_WEEK);
//			int b = new SmartDate(calendar.get(Calendar.YEAR),1 + calendar.get(Calendar.MONTH),
//					calendar.get(Calendar.DAY_OF_MONTH)).getDayCountToFirstDay();
//			if(a != b){
//				StdOut.println(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
//				StdOut.println(a);
//				StdOut.println(b);
//				break;
//			}
//			calendar.add(Calendar.DAY_OF_YEAR, 1);
//		}
//		StdOut.println("over");

	}

	@Title("1.2.13")
	public static void question13(){
        println(new Transaction("java",new Date(1,1,1988),100).toString());
    }
    @Title("1.2.14")
    public static void question14(){
        Transaction t1 = new Transaction("java",new Date(1,1,1988),100);
        Transaction t2 = new Transaction("java",new Date(1,1,1988),100);
        Transaction t3 = new Transaction("kotlin",new Date(1,1,1988),100);

        println("t1 == t2?"+t1.equals(t2));
        println("t1 == t3?"+t1.equals(t3));
    }

	/**题目1.2.11和1.2.12中要求的日期对象*/
	public static class SmartDate extends Date{
		int year, month, day;

		public SmartDate(int year, int month, int day) {
			super(month,day,year);
			this.year = year;
			this.month = month;
			this.day = day;
			check();  //构造后通过这个方法检查日期合法性
		}

		public int year() {
			return year;
		}

		public int month() {
			return month;
		}

		public int day() {
			return day;
		}

		@Override
		public String toString() {
			return year + "年" + month + "月" + day + "日";
		}

		private void check() {
			switch (month) {
			case 2:
				checkDay(1, isLeap(year) ? 29 : 28);
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				checkDay(1, 31);
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				checkDay(1, 30);
				break;
			default:
				throw new RuntimeException("日期" + this + "不合法");
			}
		}

		private void checkDay(int start, int end) {
			if (day < start || day > end) {
				throw new RuntimeException("日期" + this + "不合法");
			}
		}

		private boolean isLeap(int year) {
			return (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);  //判断闰年的方法（不精确，小年份足够用）
		}

		/*
		 * 题目要求为21世纪，则以2000年1月1号为参照。 这天是周六，通过计算与这一天相差几天，来完成星期的计算
		 */
		private int getDayCountToFirstDay() {
			int x = 7; // 假设当前为2000/1/1，则当天为周六（周六用7表示，与Calendar一致）

			// 计算已经经过的年份对星期的影响
			for (int i = 2000; i < year; i++) { // 从2000年计算，没过一年，则星期延后一天（平年，因为365% 7 == 1）或两天（闰年）
				x += isLeap(i) ? 2 : 1;
			}

			// 计算当前已经经过的月份对星期的影响
			for (int i = 1; i < month; i++) {
				switch (i) {
				case 2:
					if (isLeap(year)) { // 2月如果是平年，则不影响星期（28 % 7 == 0），闰年使星期延后一天
						x++;
					}
					break;
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					x += 3; // 大月使星期延后3天（31 % 7 == 3）
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					x += 2;
					break;
				}
			}
			x += (day - 1); // 每经过1天，星期延后一天
			x %= 7;
			return x == 0 ? 7 : x; // 为了跟Calendar格式统一，方便对照
		}

		public String dayOfTheWeek() {
			int count = getDayCountToFirstDay();
			String str = "";
			switch (count) {
			case 7:
				str = "星期六";
				break;
			case 1:
				str = "星期日";
				break;
			case 2:
				str = "星期一";
				break;
			case 3:
				str = "星期二";
				break;
			case 4:
				str = "星期三";
				break;
			case 5:
				str = "星期四";
				break;
			case 6:
				str = "星期五";
				break;
			}
			return str;
		}
	}

	/**1.2.10中使用的计数类*/
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

	/**1.2.9方法中使用的用来技术的二分法查找*/
	private static int rank(int key, int[] a, Counter counter) {
		return rank(key, a, 0, a.length - 1, counter);
	}

	private static int rank(int key, int[] a, int lo, int hi, Counter counter) {
		if (lo > hi)
			return -1;
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) {
			counter.increment(); // 题意不明确，暂时按照使用key进行比较的次数理解。原题考察对象传递是可以在方法内直接修改值的，这种理解不影响题目
			return rank(key, a, lo, mid - 1, counter);
		} else if (key > a[mid]) {
			counter.increment();
			return rank(key, a, mid + 1, hi, counter);
		} else
			return mid;
	}
    /**1.2.7中给出的方法*/
	private static String mystery(String s) {
		int N = s.length();
		if (N <= 1)
			return s;
		String a = s.substring(0, N / 2);
		String b = s.substring(N / 2, N);
		return mystery(b) + mystery(a); // 这个方法是将字符串的前后两个部分倒置。递归以后每个字串也进行倒置，最后的结果就是整个字符串倒序排列。
	}
}

/**1.2.13和1.2.14中要求的类*/
class Transaction{
    private String who;
    private Date when;
    private double amount;
    Transaction(String who,Date when,double amount){
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who(){
        return who;
    }

    public Date when(){
        return when;
    }

    public double amount(){
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "who='" + who + '\'' +
                ", when=" + when +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        if(that.amount != this.amount) return false;
        if(!that.when.equals(this.when)) return false;
        if(!that.who.equals(this.who)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = who != null ? who.hashCode() : 0;
        result = 31 * result + (when != null ? when.hashCode() : 0);
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    int compareTo(Transaction that){
        return (int)(this.amount - that.amount);
    }
}
