package Answer.chapter1.section3;

import Answer.base.Answer1String;
import data_structure.stack.FixedCapacityStackOfStrings;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_4 extends Answer1String {
    @Override
    public void answer() {
        String str = getArgs1();
        boolean result = true;
        FixedCapacityStackOfStrings parentheses = new FixedCapacityStackOfStrings(100);
        outer:
        for(char c : str.toCharArray()){
            switch(c){
                case '[':case '(':case '{':
                    parentheses.push(""+c);
                    break;
                case ']':
                    if(!parentheses.pop().equals("[")){  //右括号的顺序应该与出栈顺序一致，不一致说明不匹配
                        result = false;
                        break outer;
                    }
                    break;
                case ')':
                    if(!parentheses.pop().equals("(")){  //右括号的顺序应该与出栈顺序一致，不一致说明不匹配
                        result = false;
                        break outer;
                    }
                    break;
                case '}':
                    if(!parentheses.pop().equals("{")){  //右括号的顺序应该与出栈顺序一致，不一致说明不匹配
                        result = false;
                        break outer;
                    }
                    break;
            }
//			println(parentheses);  //打印轨迹
        }
        if(result){ //如果没发现不匹配的现象，则需要再次检查数量是否可以对应。如果完整匹配，所有左括号应该都出栈完毕
            result = parentheses.size() == 0;
        }
        println(result);
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"[()]{}{[()()]()}"};
    }
}
