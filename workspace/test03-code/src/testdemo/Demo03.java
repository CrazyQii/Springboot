package testdemo;

//输入接口
interface InputDevice {
	String read();
}

//输出接口
interface OutDevice {
	void write(String data);
}

//磁盘,接口的实现
class HardDisk implements InputDevice, OutDevice{
	String content;
	
	public String read() {
		return content;
	}
	public void write(String data) {
		this.content = data;
	}
	
}

public class Demo03 {

	public static void main(String[] args) {
		HardDisk h1 = new HardDisk();
		h1.write("123");
		read(h1);
	}
	
	public static void read(InputDevice inputdevice) {
		System.out.println(inputdevice.read());
	}
}
