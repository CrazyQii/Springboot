package carzyqiqi.day02.demo04;

/*
 * 创建一个英雄对象
 * 成员变量包含：姓名，战斗力 
 */

public class Hero {
	private String name; 	//姓名
	private int attack; 	//战斗力
	
	//构造方法，重载方法
	public Hero() {
		
	}
	public Hero(String name, int attack) {
		this.name = name;
		this.attack = attack;
	}
	
	//获取英雄信息
	public String getName() {
		return name;
	}
	public int getAttack() {
		return attack;
	}
	
	//设置英雄信息
	public void setName(String name) {
		this.name = name;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
}
