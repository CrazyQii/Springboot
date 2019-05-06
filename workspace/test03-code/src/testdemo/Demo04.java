package testdemo;

public class Demo04 {

	public static void main(String[] args) {
		String s1 = "A String";
		String s2 = "A String";
		String s3 = s1;

		compareString(s1, s2, s3);
	}
	public static void compareString(String s1, String s2, String s3) {
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s1.length());
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		System.out.println(s1.concat(s3));
		System.out.println(s1.indexOf('t'));
		System.out.println(s3.lastIndexOf('t'));
	}
}
