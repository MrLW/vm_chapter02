package com.lw.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo1:java�����
 * ���ڴ�����쳣���� �ѵ�����ֵ������ֵ����һ��������Զ���չ 
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * �쳣��Ϣ��java.lang.OutOfMemoryError: Java heap space
 * @author lw
 */
public class HeapOOM {

	static class OOMObject {

	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		int i = 0 ;
		while (true) {
			System.out.println(++i);
			list.add(new OOMObject());
		}
	}
}
