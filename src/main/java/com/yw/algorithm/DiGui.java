package com.yw.algorithm;

public class DiGui {
	public static void main(String[] args) {
		//System.out.println(f2(5));
//		DiGui.digui99(9);
		System.out.println(DiGui.f(5));
	}
	//求阶乘
	public static Integer f(int n) {  
        if (1 == n)   
            return 1;  
        else   
            return n*f(n-1);  
    }  
	// 求数列：1，1，2，3，5，8......第40位的数 ,斐波那契,兔子数列。
	public static int f2(int n) {
		if (1 == n || 2 == n)
			return 1;
		else
			return f2(n - 1) + f2(n - 2);
	}
	//for循环
	public static void table99() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + " * " + i + " = " + (i * j) + " ");
			}
			System.out.println();
		}
	}
	//递归打印99乘法表
	public static void digui99(int n) {
		if(n==1) {
			System.out.println("1 * 1 = 1");
		}else {
			digui99(n-1);
			for (int j = 1; j <=n; j++) {
				 System.out.print(j + "*" + n + "=" + j * n + " "); 
			}
			System.out.println();
		}
	}
}
