package com.jason.oom.demo;

/**
 * 
 * VM Args:-Xss2M
 * 
 * �����̵߳����ڴ�����쳣
 * ���н����
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
        //oom.stackLeakByThread(); // �ᵼ�²���ϵͳ������
    }
    
}