package com.lw.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo3:运行时常量池
 * 运行时常量池 VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 下面这段代码在jdk1.6及之前则会抛出异常(OOM:PermGen space) 在jdk1.7及其以上则会一直循环下去
 * 原因:运行时常量池在jdk1.6及之前是属于方法区(HotSpot虚拟机中的永久代)
 * 
 * @author lw
 *
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// test1();
		// test2();
		String str = new String("hello"); // 堆中
		String str2 = "hello"; // 常量池
		String str3 = str2;
	}

	/**
	 * 在jdk1.6中输出两个false,在1.7中第一个true,第二个false
	 */
	private static void test2() {
		String str1 = new StringBuilder().append("计算机").append("软件").toString();

		String str2 = new StringBuilder().append("ja").append("va").toString();

		String str3 = new StringBuilder().append("li").append("wen").toString();

		System.out.println(str1 == str1.intern());// true
		System.out.println(str3 == str3.intern());
		System.out.println(str2 == str2.intern()); // false
	}

	/**
	 * 下面这段代码在jdk1.6及之前则会抛出异常(OOM:PermGen space) 在jdk1.7及其以上则会一直循环下去
	 * 原因:运行时常量池在jdk1.6及之前是属于方法区(HotSpot虚拟机中的永久代)
	 */
	private static void test1() {
		// 使用List保持常量池的引用
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			System.out.println(i);
			list.add(String.valueOf(i++).intern());
		}
	}
}
