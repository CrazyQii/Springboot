package crazyqiqi.day03.demo01;

/*
 * 写入文件
 * 将数据写入文件当中，可以用FileWriter类
 * 1.导包
 * import java.io.FileWriter;
 * 
 * 2.创建
 * public FileWriter(String FileName); 参数字符串是文件路径名称
 * FileWriter fw = new FileWriter("flie01.txt");
 * 
 * 3.使用
 * 3.1写数据 
 * public void write(String str)参数就是写入文件当中的字符串
 * 3.2关闭流
 * public void close() 关闭，释放相关资源
 *
 */

import java.io.FileWriter;
import java.io.IOException;

public class DemoFileWriter {
	public static void main(String[] args) throws IOException {
		//1.创建FileWriter对象
		FileWriter fw = new FileWriter("file01.txt", true);
		
		//2.调用write方法写参数
		fw.write("我是岐岐\n");
		
		//3.关闭文件
		fw.close();
	}
}
