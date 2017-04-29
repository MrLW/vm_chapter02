package com.lw.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo3:����ʱ������
 * ����ʱ������ VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * ������δ�����jdk1.6��֮ǰ����׳��쳣(OOM:PermGen space) ��jdk1.7�����������һֱѭ����ȥ
 * ԭ��:����ʱ��������jdk1.6��֮ǰ�����ڷ�����(HotSpot������е����ô�)
 * 
 * @author lw
 *
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// test1();
		// test2();
		String str = new String("hello"); // ����
		String str2 = "hello"; // ������
		String str3 = str2;
	}

	/**
	 * ��jdk1.6���������false,��1.7�е�һ��true,�ڶ���false
	 */
	private static void test2() {
		String str1 = new StringBuilder().append("�����").append("���").toString();

		String str2 = new StringBuilder().append("ja").append("va").toString();

		String str3 = new StringBuilder().append("li").append("wen").toString();

		System.out.println(str1 == str1.intern());// true
		System.out.println(str3 == str3.intern());
		System.out.println(str2 == str2.intern()); // false
	}

	/**
	 * ������δ�����jdk1.6��֮ǰ����׳��쳣(OOM:PermGen space) ��jdk1.7�����������һֱѭ����ȥ
	 * ԭ��:����ʱ��������jdk1.6��֮ǰ�����ڷ�����(HotSpot������е����ô�)
	 */
	private static void test1() {
		// ʹ��List���ֳ����ص�����
		List<String> list = new ArrayList<String>();
		int i = 0;
		while (true) {
			System.out.println(i);
			list.add(String.valueOf(i++).intern());
		}
	}
}
