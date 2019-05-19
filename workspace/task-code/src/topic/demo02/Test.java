package topic.demo02;

import java.util.Date;

public class Test {

	public static void main(String[] args) {
		Employee employee = new Employee();		//创建员工对象
		employee.setName("张三");
		employee.setSalary(6000);
		employee.setBirthday(new Date());
		Manager manager = new Manager();		//创建经理对象
		manager.setName("李经理");
		manager.setSalary(5000);
		manager.setBonus(8000);
		manager.setBirthday(new Date());
		System.out.println(employee);
		System.out.println(manager);
	}

}
