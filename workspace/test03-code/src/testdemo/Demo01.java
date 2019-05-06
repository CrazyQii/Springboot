package testdemo;


//父类
class Computer {
	String name;
	
	public void setName(String name) {	
		this.name = name;
	}
	
	public String getName() {
		return "this is " + name;
	}
}

//子类Desktop
class Desktop extends Computer {
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name = "my Desktop name is " + name;
	}
}

//子类Notebook
class Notebook extends Computer {
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name = "my Notebook name is " + name;
	}
}

public class Demo01 {

	public static void main(String[] args) {
		Computer c1 = new Computer();
		Computer c2 = new Computer();
		Desktop d1 = new Desktop();
		Notebook n1 = new Notebook();
		
		d1.setName("desktop");
		c1 = d1;
		System.out.println(c1.getName());
		
		
		n1.setName("notebook");
		c2 = n1;
		System.out.println(c2.getName());
	}

}
