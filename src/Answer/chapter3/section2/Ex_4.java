package Answer.chapter3.section2;

import Answer.base.Answer0;
import data_structure.st.BST;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_4 extends Answer0{
    @Override
    public void answer() {
        execute("10 9 8 7 6 5 4 3 2 1",5);println("可能");
        execute("4 10 8 7 5 3 2 1 9 6",5);println("不可能，查到5以后不会继续查询了");
        execute("1 10 2 9 3 8 4 7 6 5",5);println("可能");
        execute("2 7 3 8 4 5 1 6 9 10",5);println("不可能，插入7后无法顺序插入3和8（3和8会成为7的两个子节点，无法全部遍历）");
        execute("1 2 10 4 8 5 3 6 7 9",5);println("可能");
    }

    /**根据给定数据构造数，并查找给定元素，打印轨迹*/
    private void execute(String str,int s){
        BST bst = new BST();
        String[] strs = str.split(" ");
        for(String myString : strs){
            bst.put(Integer.parseInt(myString),myString);
        }
        bst.setShowTrip(true);
        bst.get(s);
    }
}
