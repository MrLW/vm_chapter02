package com.lw.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo1:java堆溢出
 * 堆内存溢出异常测试 堆的上限值和下限值设置一样避免堆自动扩展 
 * VM Args:-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 异常信息：java.lang.OutOfMemoryError: Java heap space
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
