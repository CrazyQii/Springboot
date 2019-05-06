package testDemo;

class Circle {
	private double radius;
	
	Circle() {
		radius = 5;
	}
	
	Circle(double radius) {
		this.radius = radius;
	}
	
	public void setRadius(double radius) {
		if (radius > 0) {
			this.radius = radius;
		}
	}
	
	public double getRadius() {
		return radius;
	}
}

public class Demo02 {

	public static void main(String[] args) {
		Circle circle1 = new Circle();
		Circle circle2 = new Circle(8);
		Circle circle3 = new Circle(10);
		Circle circle4 = new Circle(5);
		compareCircle(circle1, circle2);
		System.out.println("====================");
		compareCircle(circle1, circle3);
		System.out.println("====================");
		compareCircle(circle1, circle4);
	}
	
	public static void compareCircle(Circle c1, Circle c2) {
		if (c1.getRadius() > c2.getRadius()) {
			System.out.println("circle1面积大");
		}
		else if (c1.getRadius() < c2.getRadius()) {
			System.out.println("circle1面积小");
		}
		else {
			System.out.println("两者面积相等");
		}
	}

}
