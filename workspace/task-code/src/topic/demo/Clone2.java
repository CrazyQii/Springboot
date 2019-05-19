package topic.demo;

class Address {
	private String state;		//国家
	private String province;	//省
	private String city;		//市
	public Address(String state, String province, String city) {			//构造方法
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
		StringBuilder sb = new StringBuilder();
		sb.append("国家:" + state + "; ");
		sb.append("省:" + province + "; ");
		sb.append("市:" + city);
		return sb.toString();	
	}
}

class Employees implements Cloneable {
	private String name;
	private int age;
	private Address address;
	public Employees(String name, int age, Address address) {
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
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
	public Employees clone() {
		Employees employee = null;
		try {
			employee = (Employees)super.clone();
		} catch(CloneNotSupportedException e) {
			e.printStackTrace();
			System.out.println("对象不能克隆");
		}
		return employee;
	}
}

public class Clone2 {

	public static void main(String[] args) {
		System.out.println("克隆之前:");
		Address address = new Address("中国", "浙江", "杭州");		//创建对象
		Employees employee1 = new Employees("张三", 40, address);	//创建员工对象
		System.out.println("员工信息:");
		System.out.println(employee1);
		
		System.out.println("拷贝之后:");
		Employees employee2 = employee1.clone();
		System.out.println(employee2);
		employee2.getAddress().setState("中国");
		employee2.getAddress().setProvince("陕西");
		employee2.getAddress().setCity("西安");
		employee2.setName("李四");
		employee2.setAge(18);
		System.out.println(employee2);
	}

}
