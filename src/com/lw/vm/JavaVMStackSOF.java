package com.lw.vm;

/**
 * Demo2:JavaÕ»Òç³ö
 * VM Args:-Xss128k
 * @author lw
 *
 */
public class JavaVMStackSOF {

	private int stackLength = 1 ;
	
	public void stackLeak(){
		stackLength++; 
		stackLeak();
	}
	
	public static void main(String[] args) {
		JavaVMStackSOF oom=new JavaVMStackSOF();
		try {
			oom.stackLeak();
			System.out.println("stack length:" + oom.stackLength);
		} catch (Exception e) {
			System.out.println("stack length:" + oom.stackLength);
			e.printStackTrace(); 
		}
	}
}
