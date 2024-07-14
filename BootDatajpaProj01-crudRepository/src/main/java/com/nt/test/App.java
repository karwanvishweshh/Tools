package com.nt.test;

public class App {
	public  int sum(int x,int y)
	{
		return x+y;
	}
	public int sub(int x,int y)
	{
		return x-y;
	}
	public int mul(int x,int y) {
		return x*y;
	}
	public static void main(String[] args) {
		App app=new App();
		
		System.out.println("Sum is::"+app.sum(50, 70));
		System.out.println("Sub is::"+app.sub(80,20));
	}

}
