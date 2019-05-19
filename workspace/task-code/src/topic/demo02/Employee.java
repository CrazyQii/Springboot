package topic.demo02;

import java.util.Date;

public class Employee {
	protected String name;		//员工姓名
	protected double salary;		//员工工资
	protected Date birthday;		//员工生日
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("姓名：" + name + "\n");
		sb.append("生日：" + birthday + "\n");
		sb.append("薪水：" + salary + "\n");
		return sb.toString();
	}
}
