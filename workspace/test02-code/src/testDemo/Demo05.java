package testDemo;

import java.util.Calendar;

class MyTime {
	private int year;
	private int month;
	private int day;
	private int hh;
	private int mm;
	private int ss;

	Calendar cal = Calendar.getInstance();
	
	public String getDate() {
		this.day = cal.get(Calendar.DAY_OF_MONTH);
		this.month = cal.get(Calendar.MONTH) + 1;
		this.year = cal.get(Calendar.YEAR);
		return (this.year + "-" + this.month + "-" + this.day);
	}

	public String getTime() {
		this.hh = cal.get(Calendar.HOUR) + 12;
		this.mm = cal.get(Calendar.MINUTE);
		this.ss = cal.get(Calendar.SECOND);
		return (this.hh + ":" + this.mm + ":" + this.ss);
	}
}

class Test extends MyTime {
	MyTime mt = new MyTime();
	
	public void showTime() {
		System.out.println("当前时间为：" + mt.getDate() + "  " + mt.getTime());
	}
}

public class Demo05 {
	public static void main(String[] args) {
		Test time = new Test();	
		time.showTime();
	}
}
