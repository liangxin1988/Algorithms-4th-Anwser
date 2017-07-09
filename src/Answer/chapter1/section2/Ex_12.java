package Answer.chapter1.section2;

import Answer.base.Answer0;

import java.util.Calendar;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_12 extends Answer0 {
    @Override
    public void answer() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        print("year = "+year+",month = "+month+",day = "+day);
        println(new Ex_11.SmartDate(year, month, day).dayOfTheWeek());

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
}
