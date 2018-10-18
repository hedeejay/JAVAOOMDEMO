package com.jason.oom.demo;

/**
 * 
 * VM Args:-Xss128k
 * 
 * 在单个线程下，无论是由于栈帧太大还是虚拟机栈容量太小，当内存无法分配的时候，虚拟机抛出的都是StackOverflowError异常。
 * 如果测试时不限于单线程，通过不断地建立线程的方式倒是可以产生内存溢出异常，如代码清单2-5所示。
 * 但是这样产生的内存溢出异常与栈空间是否足够大并不存在任何联系，或者准确地说，在这种情况下，
 * 为每个线程的栈分配的内存越大，反而越容易产生内存溢出异常。
 * 
 * 如果是建立过多线程导致的内存溢出，在不能减少线程数或者更换64位虚拟机的情况下，就只能通过减少最大堆和减少栈容量来换取更多的线程。
 * 如果没有这方面的处理经验，这种通过“减少内存”的手段来解决内存溢出的方式会比较难以想到。
 * @author jason
 */

public class JavaVMStackSOF {
    
    private int stackLength = 1;
    
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    
    public static void main(String[] args)
        throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        }
        catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}