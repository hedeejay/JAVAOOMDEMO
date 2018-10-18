package com.jason.oom.demo;

/**
 * 
 * VM Args:-Xss2M
 * 
 * 创建线程导致内存溢出异常
 * 运行结果：
    Exception in thread"main"java.lang.OutOfMemoryError:unable to create new native thread
 * 
 * @author zzm
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {}
    }
    
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
    
    public static void main(String[] args)
        throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        //oom.stackLeakByThread(); // 会导致操作系统假死。
    }
    
}