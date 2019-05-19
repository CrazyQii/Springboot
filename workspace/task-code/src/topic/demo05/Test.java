package topic.demo05;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(3, "张三", 21));
		list.add(new Employee(2, "李四", 30));
		list.add(new Employee(1, "王五", 15));
		System.out.println("排序前:");
		for(Employee employee: list) {
			System.out.println(employee);
		}
		System.out.println("排序后:");
		Collections.sort(list);		//自动排序
		for(Employee employee: list) {
			System.out.println(employee);
		}
	}
}
