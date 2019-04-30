package com.hanlq.calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import javafx.scene.layout.Border;

//定义JFrame的一个子类FrameWithPanel
//向JFrame框架中添加JPanel容器
class FrameWithPanel extends JFrame {
	//初始化清零按钮和文本域
	private JTextField result_field = new JTextField(20);
	private JButton button_clear = new JButton("Clear");
	
	//初始化数字和运算符按钮
	private JButton button0 = new JButton("0");
	private JButton button1 = new JButton("1");
	private JButton button2 = new JButton("2");
	private JButton button3 = new JButton("3");
	private JButton button4 = new JButton("4");
	private JButton button5 = new JButton("5");
	private JButton button6 = new JButton("6");
	private JButton button7 = new JButton("7");
	private JButton button8 = new JButton("8");
	private JButton button9 = new JButton("9");
	private JButton button_dian = new JButton(".");
	private JButton button_jia = new JButton("+");
	private JButton button_jian = new JButton("-");
	private JButton button_cheng = new JButton("*");
	private JButton button_chu = new JButton("/");
	private JButton button_deng = new JButton("=");
	
	private double a1;
	private double a2;
	private double result = 0;
	
	//构造方法
	public FrameWithPanel() {
		//设计布局，两个JPanel容器
		//一个JPanel包含输入框和clear键，一个JPanel包含数字键和逻辑键
		
		//创建第一个JPanel容器
		JPanel topPan = new JPanel();
		
		//设计输入框和清除按钮布局
		topPan.setLayout(new BorderLayout());
		topPan.add(result_field, BorderLayout.WEST);
		topPan.add(button_clear, BorderLayout.EAST);
		
		//创建第二个JPanel容器
		JPanel bottomPan = new JPanel();
		//设置pan的间距
		bottomPan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		//设置数字按钮布局同时添加按钮
		bottomPan.setLayout(new GridLayout(4, 4, 5, 5));
		bottomPan.add(button7);
		bottomPan.add(button8);
		bottomPan.add(button9);
		bottomPan.add(button_chu);
		bottomPan.add(button4);
		bottomPan.add(button5);
		bottomPan.add(button6);
		bottomPan.add(button_cheng);
		bottomPan.add(button1);
		bottomPan.add(button2);
		bottomPan.add(button3);
		bottomPan.add(button_jia);
		bottomPan.add(button0);
		bottomPan.add(button_dian);
		bottomPan.add(button_jian);
		bottomPan.add(button_deng);
		
		//将两个容器添加到Frame当中
		add(topPan, BorderLayout.NORTH);
		add(bottomPan, BorderLayout.CENTER);
		
		//添加事件监听
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print(((JButton)e.getSource()).getText());
			}
		});
		
		
	}
}


public class Calculator {

	public static void main(String[] args) {
		//实例化frame，创建框架
		FrameWithPanel frame = new FrameWithPanel();
		//设置窗口名称
		frame.setTitle("Calculator");
		//框架关闭时结束运行
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置框架大小
		frame.setSize(300, 300);
		//显示框架
		frame.setVisible(true);
	}

}
