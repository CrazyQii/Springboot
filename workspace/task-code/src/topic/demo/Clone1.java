package topic.demo;

class Employee {
	private String name;
	private int age;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	重写toString方法
	public String toString() {
		return "姓名：" + this.name + "\n年龄：" + this.age + "岁";
	}
}


public class Clone1 {

	public static void main(String[] args) {
		System.out.println("克隆前：");
		Employee employee1 = new Employee();		//创建对象
		employee1.setName("张三");
		employee1.setAge(25);
		System.out.println("员工信息：");
		System.out.println(employee1);
		
		
		System.out.println("克隆后：");
		Employee employee2 = employee1;
		System.out.println("员工信息：");
		System.out.println(employee2);
		
		System.out.println("克隆修改后:");
		employee2.setAge(66);
		employee2.setName("李四");
		System.out.println("员工信息：");
		System.out.println("employee1:" + employee1);
		System.out.println("employee2:" + employee2);
	}

}
