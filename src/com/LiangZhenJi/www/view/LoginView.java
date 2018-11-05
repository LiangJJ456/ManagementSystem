package com.LiangZhenJi.www.view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.LiangZhenJi.www.service.Login;

public class LoginView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JTextField textField;
	JPasswordField passwordField;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton1;
	JButton btnNewButton1;
	JButton btnNewButton;
	JLabel label;
	JLabel label1;
	
	public LoginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("ico/gdut.png"));
		setTitle("教务系统");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
		setBounds(100, 100, 740, 493);
		JPanel contentPane = new JPanel();
		contentPane.setForeground(new Color(204, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		/**
		 * 用标签容器设置背景图片
		 */
		ImageIcon backgroud=new ImageIcon("ico/background.jpg");
		JLabel labels=new JLabel(backgroud);
		labels.setBounds(0, 0, this.getWidth(), this.getHeight());
		JPanel imagejpanel=(JPanel) this.getContentPane();//把内容窗格转化成JPanel，否则不能用setOpaque来使内容窗格透明
		imagejpanel.setOpaque(false);
		this.getLayeredPane().add(labels,new Integer(Integer.MIN_VALUE));//把背景图片添加到分层窗格最底层		

		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(162, 343, 122, 50);
		btnNewButton.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				//连接数据库，验证用户名和密码
				if(Login.check(textField.getText(),passwordField.getText())!=0) {
					if(Login.select(textField.getText(),passwordField.getText()).equals("学生")) {
						Studentview sv=null;
						try {
							sv = new Studentview(textField.getText());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sv.setVisible(true);
						setVisible(false);
						dispose();
					}
					else {
						TeacherView tv=null;
						try {
							tv = new TeacherView(textField.getText());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						tv.setVisible(true);
						setVisible(false);
						dispose();
					}
				}
			
				else {
					JOptionPane.showMessageDialog(new JFrame(),"用户名或密码错误，请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		
		
		JButton btnNewButton1 = new JButton("重置");
		btnNewButton1.setBounds(387, 343, 122, 50);
		btnNewButton1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				textField.setText("工号/学号");
				passwordField.setText("");
			}
		});
		
		JLabel label = new JLabel("用户名");
		label.setOpaque(true);//必须设置不透明否则将不显示颜色
		label.setBackground(UIManager.getColor("Panel.background"));
		label.setIcon(new ImageIcon("ico/user.png"));
		label.setBounds(162, 122, 73, 39);
		
		JLabel label1 = new JLabel("密码");
		label1.setOpaque(true);//必须设置不透明否则将不显示颜色
		label1.setBackground(UIManager.getColor("Panel.background"));
		label1.setIcon(new ImageIcon("ico/password.png"));
		label1.setBounds(162, 205, 73, 39);
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(btnNewButton1);
		contentPane.add(label);
		contentPane.add(label1);
		
		
		textField = new JTextField();
		label.setLabelFor(textField);
		textField.setText("工号/学号");
		textField.setBackground(Color.WHITE);
		textField.setToolTipText("");
		textField.setBounds(265, 122, 244, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (textField.getText().isEmpty()==false) {
					textField.setText("");
				}
					}
			public void focusLost(FocusEvent arg0) {
				if (textField.getText().isEmpty()==true) {
					textField.setText("工号/学号");
				}
			}
		});
		
		passwordField = new JPasswordField();
		label1.setLabelFor(passwordField);
		passwordField.setBounds(265, 205, 244, 39);
		contentPane.add(passwordField);
	}
}