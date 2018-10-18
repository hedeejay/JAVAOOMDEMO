package com.jason.oom.demo;

/**
 * 
 * VM Args:-Xss128k
 * 
 * �ڵ����߳��£�����������ջ̫֡���������ջ����̫С�����ڴ��޷������ʱ��������׳��Ķ���StackOverflowError�쳣��
 * �������ʱ�����ڵ��̣߳�ͨ�����ϵؽ����̵߳ķ�ʽ���ǿ��Բ����ڴ�����쳣��������嵥2-5��ʾ��
 * ���������������ڴ�����쳣��ջ�ռ��Ƿ��㹻�󲢲������κ���ϵ������׼ȷ��˵������������£�
 * Ϊÿ���̵߳�ջ������ڴ�Խ�󣬷���Խ���ײ����ڴ�����쳣��
 * 
 * ����ǽ��������̵߳��µ��ڴ�������ڲ��ܼ����߳������߸���64λ�����������£���ֻ��ͨ���������Ѻͼ���ջ��������ȡ������̡߳�
 * ���û���ⷽ��Ĵ����飬����ͨ���������ڴ桱���ֶ�������ڴ�����ķ�ʽ��Ƚ������뵽��
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