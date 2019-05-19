package topic.demo;

class Cat{
	private String name;	// 猫的名字
	private int age;		// 猫的年龄
	private double weight;	// 猫的体重
	private String color;	// 猫的颜色
	
//	初始化猫的属性
	public Cat(String name, int age, double weight, String color) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
	}
	
//	函数重写，利用属性判断猫是否一样
	public boolean equals(Object obj) {
		if(this == obj) {	//如果对象一样，则返回正确
			return true;
		}
		if(obj == null) {	//如果对象为空，则返回错误
			return false;
		}
		if(getClass() != this.getClass()) {		//如果猫咪的类型不同则不同
			return false;
		}
		Cat cat = (Cat)obj;		//强制类型转换
		return name.equals(cat.name) && (age == cat.age) && (weight == cat.weight) && (color.equals(cat.color));
	}
	
//	函数重写，toString方法
	public String toString() {
//		创建StringBuilder对象
		StringBuilder sb = new StringBuilder();
//		追加内容到StringBuilder的末尾
		sb.append("名字:" + name + "\n");
		sb.append("年龄:" + age + "\n");
		sb.append("体重:" + weight + "\n");
		sb.append("颜色:" + color + "\n");
		return sb.toString();	// 将StringBuilder对象转化为String对象
	}
}

public  class CompareCat {
	public static void main(String[] args) {
		Cat cat1 = new Cat("Java", 18, 50, "black");
		Cat cat2 = new Cat("PHP", 15, 100, "white");
		Cat cat3 = new Cat("HTML", 23, 70, "pink");
		System.out.println("1号猫" + cat1);
		System.out.println("2号猫" + cat2);
		System.out.println("3号猫" + cat3);
		System.out.println("1号猫和3号猫的比较：" + cat1.equals(cat3));
		System.out.println("2号猫和3号猫的比较：" + cat2.equals(cat3));
		System.out.println("1号猫和2号猫的比较：" + cat1.equals(cat2));
	}
}
