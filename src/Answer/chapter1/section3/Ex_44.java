package Answer.chapter1.section3;

import Answer.base.Answer0;
import data_structure.stack.LinkedStack;
import util.ChapterUtil;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_44 extends Answer0 {
    @Override
    public void answer() {
        Buffer buffer = new Buffer();
        buffer.insert("My name is java");
        println(buffer);
        print("删除以下字符:");
        for(int i = 0;i<4;i++){
            print(buffer.delete());
        }
        println();
        buffer.insert("kotlin");
        println(buffer);
        buffer.left(14);
        buffer.insert("program ");
        println(buffer);
        buffer.right(4);
        buffer.insert("eeeeeeee");
        println(buffer);
    }

    /**
     * 文件缓冲区
     * */
    class Buffer{
        private LinkedStack<Character> left = new LinkedStack<>();
        private LinkedStack<Character> right = new LinkedStack<>();
        /**
         * 在光标位置插入字符
         * */
        void insert(char c){
            left.push(c);
        }

        void insert(String str){
            for(char c : str.toCharArray()){
                insert(c);
            }
        }

        /**刪除光标位置的字符*/
        char delete(){
            if(!left.isEmpty())
                return left.pop();
            throw new RuntimeException("已经没有字符可删除");
        }

        /**将光标左移k位*/
        void left(int k){
            for(int i = 0;i<k;i++){
                if(left.size() != 0)
                    right.push(left.pop());
            }
        }

        /**将光标右移k位*/
        void right(int k){
            for(int i = 0;i<k;i++){
                if(right.size() != 0){
                    left.push(right.pop());
                }
            }
        }

        /**缓冲区中字符数量*/
        int size(){
            return left.size() + right.size();
        }

        @Override
        public String toString() {
            LinkedStack<Character> cacheRightStack = new LinkedStack<>(right);
            LinkedStack<Character> cacheLeftStack = new LinkedStack<>(left);
            while(!cacheLeftStack.isEmpty()){
                cacheRightStack.push(cacheLeftStack.pop());
            }
            StringBuilder stringBuilder = ChapterUtil.getStringBuilder();
            while(!cacheRightStack.isEmpty()){
                stringBuilder.append(cacheRightStack.pop());
            }
            return stringBuilder.toString();
        }
    }

}