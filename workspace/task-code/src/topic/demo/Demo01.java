package topic.demo;

/** 
 * 属性: 速度(speed)、体积(size)
 * 方法: 移动(move())、设置速度(setSpeed(dint speed))、加速speedUp(),减速speedDown()。 
*/

class Bus {
	private int speed;	
	private String size;
	
	public Bus() {}
	
	public Bus(int speed, String size) {
		this.speed = speed;
		this.size = size;
	}
	
	public void saySize() {
		System.out.println("Bus is " + this.size);
	}
	
	public void move() {
		System.out.println("The Bus is moving, now speed is " + this.speed);
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void speedUp(int addSpeed) {
		int currentSpeed;
		currentSpeed = this.speed + addSpeed;
		System.out.println("I will speedUp " + currentSpeed); 
	}
	
	public void speedDown(int downSpeed) {
		int currentSpeed;
		currentSpeed = this.speed + downSpeed;
		System.out.println("I will speedDown " + currentSpeed); 
	}
}

public class Demo01 {
	
	public static void main(String[] args) {
		Bus bus1 = new Bus(1000, "big");
		bus1.move();
		bus1.saySize();
		bus1.speedUp(50);
		bus1.speedDown(100);
	}

}
