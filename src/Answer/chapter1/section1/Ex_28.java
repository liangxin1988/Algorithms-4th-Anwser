package Answer.chapter1.section1;

import Answer.base.Answer0;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_28 extends Answer0{
    @Override
    public void answer() {
        int a[] = {85, 54, 6, 5, 8, 52, 6, 8, 6, 65, 6, 85, 3};  //白名单
        int count = a.length;
        Arrays.sort(a);  //进行排序
        for (int i = 0; i < count - 1; i++) {  //遍历整个数组
            while (i < count) {
                if (a[i] == a[i + 1]) {  //判断当前元素与下一个元素是否一致。这个过程需要不停重复，直到不一致
                    for (int j = i; j < count - 1; j++) {
                        a[j] = a[j + 1];  //一致，则移动数组后面的元素，覆盖掉重复元素
                    }
                    a[--count] = 0;  //置为0，表示数组元素为空。
                } else {  //不一致了，退出while循环
                    break;
                }
            }
        }
        println(Arrays.toString(a));

    }
}
