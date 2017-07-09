package Answer.chapter1.section1;

import Answer.base.Answer0;

import java.util.Scanner;

import static edu.princeton.cs.algs4.StdOut.printf;
import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_21 extends Answer0 {
    @Override
    public void answer() {
        println("请输入数据\n");
        Scanner scanner = new Scanner(System.in);
        String format = "%10s%4d%4d%10.3f";
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            int a = Integer.parseInt(strs[1]);
            int b = Integer.parseInt(strs[2]);
            printf(format, strs[0],a,b,a * 1.0 /b);
        }
    }
}
