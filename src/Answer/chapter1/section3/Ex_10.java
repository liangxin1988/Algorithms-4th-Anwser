package Answer.chapter1.section3;

import Answer.base.Answer1String;
import edu.princeton.cs.algs4.Stack;
import util.Checker;

import static edu.princeton.cs.algs4.StdOut.println;

/**
 */
public class Ex_10 extends Answer1String {
    @Override
    public void answer() {
        String str = getArgs1();
        Checker.checkStringNull(str);
        println(new InfixToPostfix(str).execute());
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"((1+2)*((3-4)*(5-6)))"};
    }

    /** 将中序表达式转换为后序表达式的工具类（表达式必须拥有完整的括号）*/
    class InfixToPostfix{
        private String str;
        public InfixToPostfix(String str){
            this.str = str;
        }

        public String execute(){
            return getPostfix(str);
        }

        /**
         * 给出一个两边带括号的中序表达式，返回一个两边带括号的后序表达式
         * */
        private String getPostfix(String str){
            if(!str.startsWith("(")){  //不是表达式，直接返回
                return str;
            }

            str = str.substring(1,str.length() - 1);//去掉首尾的括号，方便后续解析
            String start,end;  //每个表达式都有唯一的运算符（子表达式中的运算符不算，如((1+2)*4)中，只有*号算运算符），将运算符前半部分和后半部分拆为start和end
            int index = -1;  //保存当前表达式中运算符的位置

            Stack<Integer> opt = new Stack<>();
            char[] chars = str.toCharArray();
            for(int i = 0;i<chars.length;i++){  //遇到符号入栈，遇到右括号出栈，这样保证循环完毕后栈中只有一个运算符，即表达式的运算符
                switch (chars[i]) {
                    case '+':case '-':case '*':case '/':
                        opt.push(i);
                        break;
                    case ')':
                        opt.pop();
                        break;
                    default:
                        break;
                }
//				println("data_structure.stack = "+opt);  //打印轨迹
            }
            index = opt.pop();  //注意：这里用了最容易理解的机制找index，缺点是每次递归都要遍历字符串。其实可以考虑用一次遍历找到所有符号位，有兴趣的小伙伴可以优化一下
            start = str.substring(0,index);  //以运算符为分界，将左右部分进行切割
            end= str.substring(index + 1,str.length());

            start = getPostfix(start);  //左右两部分有可能也是表达式，通过递归将子表达式拼接为后序表达式
            end = getPostfix(end);
            return "("+start+end+str.charAt(index)+")";  //将括号拼接回来，并将括号中的字符拼接为后序表达式。
        }

    }

}
