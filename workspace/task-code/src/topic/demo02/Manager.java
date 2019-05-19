package topic.demo02;

public class Manager extends Employee{
	private double bonus;		//经理的奖金

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("姓名：" + name + "\n");
		sb.append("生日：" + birthday + "\n");
		sb.append("薪水：" + salary + "\n");
		sb.append("奖金:" + bonus);
		return sb.toString();
	}
}
