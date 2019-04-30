package crazyqiqi.day03.demo01;

import java.io.FileReader;
import java.io.IOException;

public class Demo02FileReader {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("file02.txt");
		
		//获取文件当中一个文字的ASCII值
		int ch = fr.read();
		System.out.println(ch);
		
		//读取文件中所有文字
		while((ch = fr.read()) != -1) {
			System.out.println(ch);
		}
		fr.close();
	}

}
