package Answer.chapter1.section3;

import Answer.base.Answer1String;
import data_structure.queue.CircularLinkedQueue;
import data_structure.queue.Queue;
import util.ChapterUtil;
import util.Checker;

import java.io.File;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;

public class Ex_43 extends Answer1String {
    @Override
    public void answer() {
        String fileName = getArgs1();
        Checker.checkStringNull(fileName);
        File file = new File(fileName);
        if(file.isFile() || !file.exists()){
            println("给定文件不合法");
        }else{
            Queue<String> queue = new CircularLinkedQueue<>();
            parserFileList(file,queue,0);
            while(!queue.isEmpty()){
                print(queue.dequeue());
            }
        }
    }

    private static void parserFileList(File file,Queue<String> queue,int level){
        StringBuilder sb = new StringBuilder(ChapterUtil.getEmptyChar(2 * level));
        sb.append(file.getName());
        sb.append("\n");
        queue.enqueue(sb.toString());
        if(file.isDirectory()){
            File[] files = file.listFiles();
            if(files == null){
                return;
            }
            for(File f : files){
                parserFileList(f,queue,level + 1);
            }
        }
    }

    @Override
    protected Object[] getDefault() {
        return new Object[]{"d:\\"};
    }
}