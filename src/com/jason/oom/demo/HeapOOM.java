package com.jason.oom.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * �ȷ���������ǳ������ڴ�й©��Memory Leak�������ڴ������Memory Overflow����

    ������ڴ�й¶���ɽ�һ��ͨ�����߲鿴й¶����GC Roots����������
    ���Ǿ����ҵ�й¶������ͨ��������·����GC Roots����������������ռ����޷��Զ��������ǵġ�
    ������й¶�����������Ϣ��GC Roots����������Ϣ���Ϳ��ԱȽ�׼ȷ�ض�λ��й¶�����λ�á�
    
    ���������й¶�����仰˵�������ڴ��еĶ���ȷʵ�����������ţ��Ǿ�Ӧ�����������ĶѲ�����-Xmx��-Xms����
    ����������ڴ�Աȿ��Ƿ񻹿��Ե��󣬴Ӵ����ϼ���Ƿ����ĳЩ�����������ڹ���������״̬ʱ������������
    ���Լ��ٳ��������ڵ��ڴ����ġ�
 * 
 * @author jason
 */

public class HeapOOM {
    
    static class OOMObject {
    }
    
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
    
}

/**

**/