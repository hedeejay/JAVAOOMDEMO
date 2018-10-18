package com.jason.oom.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * 运行时常量池导致的内存溢出异常
 * 
 * 由于运行时常量池是方法区的一部分，因此这两个区域的溢出测试就放在一起进行。前面提到JDK 1.7开始逐步“去永久代”的事情，在此就以测试代码观察一下这件事对程序的实际影响。
 * 
 * String.intern()是一个Native方法，它的作用是：如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；否则，将此String对象包加到常量池中，
 * 并且返回此String对象的引用。在JDK 1.6及之前的版本中，由于常量池分配在永久代内，我们可以通过-XX:PermSize和-XX:MaxPermSize限制方法区大小，从而间接限制其中常量池的容量
 * 
 * JDK 1.6运行结果：
    Exception in thread"main"java.lang.OutOfMemoryError:PermGen space
 * 使用JDK 1.7运行这段程序就不会得到相同的结果，while循环将一直进行下去。
 *
 */
public class RuntimeConstantPoolOOM{

    public static void main(String[]args){
    
        //使用List保持着常量池引用，避免Full GC回收常量池行为
        List<String>list=new ArrayList<String>();
        //10MB的PermSize在integer范围内足够产生OOM了
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}