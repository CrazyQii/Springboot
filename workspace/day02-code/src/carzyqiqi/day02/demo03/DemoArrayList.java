package carzyqiqi.day02.demo03;

/*
 * 集合泛型必须是引用类型，不能是基本类型
 * ArrayList<泛型> name = new ArrayList<>();
 * 如果必须要使用基本类型，那么就要使用基本类型的包装类（全部都位于java.lang包下，共8种）
 * 
 * 如何使用创建好的集合，常用的方法有三个：
 * 1.添加元素
 * public boolean add(E element)
 * 
 * 2.获取元素
 * public E get(int index)
 * 
 * 3.获取集合长度
 * public int size()
 */

//导入数组集合
import java.util.ArrayList;

public class DemoArrayList {
	public static void main(String[] args) {
		//创建动态字符串集合
		ArrayList<String> list = new ArrayList<>();
		//添加元素
		list.add("apple");
		list.add("orange");
		list.add("banana");
		System.out.println(list);
		System.out.println("=============");
		
		//获取元素
		String name = list.get(1);
		System.out.println("第二个元素是：" + name);
		System.out.println("=============");
		
		//获取集合长度
		int length = list.size();
		System.out.println("集合的长度是:" + length);
		
	}
}
