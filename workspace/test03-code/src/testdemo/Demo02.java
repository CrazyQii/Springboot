package testdemo;


//父类
abstract class Computer1 {
	String name;
	
	abstract public void setName(String name);
	
    abstract public String getName();
	
	abstract public void mySize();
}

//子类Desktop
class Desktop1 extends Computer1 {
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name = "my Desktop name is " + name;
	}
	
	public void mySize() {
		System.out.println("I am small");
	}
}

//子类Notebook
class Notebook1 extends Computer1 {
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name = "my Notebook name is " + name;
	}
	
	public void mySize() {
		System.out.println("I am big");
	}
}

public class Demo02 {

	public static void main(String[] args) {
		Desktop1 c1 = new Desktop1();
		c1.setName("desktop");
		System.out.println(c1.getName());
		saySize(c1);
		
		
		Notebook1 c2 = new Notebook1();
		c2.setName("notebook");
		System.out.println(c2.getName());
		saySize(c2);
	}
	
	public static void saySize(Computer1 comput) {
		comput.mySize();
	}

}
