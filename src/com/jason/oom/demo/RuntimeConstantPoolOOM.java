package com.jason.oom.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * ����ʱ�����ص��µ��ڴ�����쳣
 * 
 * ��������ʱ�������Ƿ�������һ���֣���������������������Ծͷ���һ����С�ǰ���ᵽJDK 1.7��ʼ�𲽡�ȥ���ô��������飬�ڴ˾��Բ��Դ���۲�һ������¶Գ����ʵ��Ӱ�졣
 * 
 * String.intern()��һ��Native���������������ǣ�����ַ������������Ѿ�����һ�����ڴ�String������ַ������򷵻ش����������ַ�����String���󣻷��򣬽���String������ӵ��������У�
 * ���ҷ��ش�String��������á���JDK 1.6��֮ǰ�İ汾�У����ڳ����ط��������ô��ڣ����ǿ���ͨ��-XX:PermSize��-XX:MaxPermSize���Ʒ�������С���Ӷ�����������г����ص�����
 * 
 * JDK 1.6���н����

    Exception in thread"main"java.lang.OutOfMemoryError:PermGen space

 * ʹ��JDK 1.7������γ���Ͳ���õ���ͬ�Ľ����whileѭ����һֱ������ȥ��
 *
 */
public class RuntimeConstantPoolOOM{

    public static void main(String[]args){
    
        //ʹ��List�����ų��������ã�����Full GC���ճ�������Ϊ
        List<String>list=new ArrayList<String>();
        //10MB��PermSize��integer��Χ���㹻����OOM��
        int i=0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}