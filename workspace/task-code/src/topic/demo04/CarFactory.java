package topic.demo04;

public class CarFactory {
	public static Car getCar(String name) {
		if(name.equalsIgnoreCase("BMW")) {	// 如果需要BMW，则创建BMW对象
			return new BMW();
		} else if(name.equalsIgnoreCase("Benz")) {
			return new Benz();
		} else {
			return null;
		}
	}
}
