package Answer.chapter1.section2;

import Answer.base.Answer0;
import edu.princeton.cs.algs4.Date;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_11 extends Answer0 {
    @Override
    public void answer() {
        println(new SmartDate(2017, 1, 1));
        try{
            println(new SmartDate(2017, 2, 29));
        }catch(Exception e){
            println(e.getMessage());
        }
    }

    public static class SmartDate extends Date {
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
}
