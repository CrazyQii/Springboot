package topic.demo;

class Addressed implements Cloneable {
	private String state;
	private String province;
	private String city;
	public Addressed(String state, String province, String city) {
		this.state = state;
		this.province = province;
		this.city = city;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String toString() {
//		创建StringBuilder对象
		StringBuilder sb = new StringBuilder();
//		追加内容到StringBuilder的末尾
		sb.append("国家:" + state + "\n");
		sb.append("省:" + province + "\n");
		sb.append("市:" + city + "\n");
		return sb.toString();	// 将StringBuilder对象转化为String对象
	}
	
	protected Addressed clone() {		//实现浅克隆
		Addressed address = null;
		try {
			address = (Addressed)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return address;
	}
}

class Employee3 implements Cloneable {
	private String name;
	private int age;
	private Addressed address;
	public Employee3(String name, int age, Addressed address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Addressed getAddress() {
		return address;
	}
	public void setAddress(Addressed address) {
		this.address = address;
	}
	
	public String toString() {
//		创建StringBuilder对象
		StringBuilder sb = new StringBuilder();
//		追加内容到StringBuilder的末尾
		sb.append("名字:" + name + "\n");
		sb.append("年龄:" + age + "\n");
		sb.append("地址:" + address + "\n");
		return sb.toString();	// 将StringBuilder对象转化为String对象
	}
	
//	实现浅克隆
	public Employee3 clone() {
		Employee3 employee = null;
		try {
			employee = (Employee3)super.clone();
			employee.address = address.clone();	
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
			System.out.println("对象不能克隆");
		}
		return employee;
	}
}

public class Clone3 {

	public static void main(String[] args) {
		System.out.println("克隆之前:");
		Addressed address = new Addressed("中国", "浙江", "杭州");		//创建对象
		Employee3 employee1 = new Employee3("张三", 40, address);	//创建员工对象
		System.out.println("员工信息:");
		System.out.println(employee1);
		
		System.out.println("拷贝之后:");
		Employee3 employee2 = employee1.clone();
		System.out.println(employee2);
		employee2.getAddress().setState("中国");
		employee2.getAddress().setProvince("陕西");
		employee2.getAddress().setCity("西安");
		employee2.setName("李四");
		employee2.setAge(18);
		System.out.println(employee2);
	}

}
