package com.LiangZhenJi.www.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import com.LiangZhenJi.www.service.StudentQuery;

public class Studentview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public String userid;
	JInternalFrame internalFrame;
	JInternalFrame internalFrame2;
	JInternalFrame internalFrame3;
	JInternalFrame internalFrame4;
	JInternalFrame internalFrame5;
	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Studentview(String userid) throws Exception {
		setIconImage(Toolkit.getDefaultToolkit().getImage("ico/student.png"));
		setTitle("学生信息查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("查询学籍");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("查询学生个人信息");
		mnNewMenu.add(menuItem);
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame3.setVisible(false);
				internalFrame4.setVisible(false);
				internalFrame5.setVisible(false);
				internalFrame.dispose();
				internalFrame3.dispose();
				internalFrame4.dispose();
				internalFrame5.dispose();
				internalFrame2.setVisible(true);
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("查询其他学生信息");
		mnNewMenu.add(menuItem_1);
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame2.setVisible(false);
				internalFrame4.setVisible(false);
				internalFrame5.setVisible(false);
				internalFrame.dispose();
				internalFrame2.dispose();
				internalFrame4.dispose();
				internalFrame5.dispose();
				internalFrame3.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("查询分数");//查询各个科目成绩
		menuBar.add(mnNewMenu_1);
		
		JMenuItem menuItem2 = new JMenuItem("查询各科成绩");
		mnNewMenu_1.add(menuItem2);
		
		 menuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame2.setVisible(false);
				internalFrame3.setVisible(false);
				internalFrame5.setVisible(false);
				internalFrame.dispose();
				internalFrame2.dispose();
				internalFrame3.dispose();
				internalFrame5.dispose();
				internalFrame4.setVisible(true);
			}
		});
		
		JMenu menu = new JMenu("查询课程");
		menuBar.add(menu);
		
		JMenuItem menuItem3 = new JMenuItem("查询科目");
		menu .add(menuItem3);
		
		menuItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame2.setVisible(false);
				internalFrame3.setVisible(false);
				internalFrame4.setVisible(false);
				internalFrame.dispose();
				internalFrame2.dispose();
				internalFrame3.dispose();
				internalFrame4.dispose();
				internalFrame5.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("菜单");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon("ico/menu.png"));
		lblNewLabel.setBounds(10, 0, 72, 39);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("退出登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				LoginView loginview=new LoginView();
				loginview.setVisible(true);
			}
		});
		button.setBounds(621, 421, 93, 23);
		contentPane.add(button);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(20, 229, 296, -179);
		contentPane.add(desktopPane);
		
		/**
		 * 桌面1
		 */
		internalFrame = new JInternalFrame("我的桌面");
		internalFrame.setResizable(true);
		internalFrame.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		internalFrame.setVisible(true);
		
		/**
		 * 桌面2(表，返回按钮）
		 */
		internalFrame2 = new JInternalFrame("学生信息");
		internalFrame2.setResizable(true);
		internalFrame2.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame2);
		internalFrame2.getContentPane().setLayout(null);
		internalFrame2.setVisible(false);
		
		/**
		 * 返回学生信息的表
		 */
		JTable selfInformation;
		Object[][] tableDate= new Object[1][8];
		for(int i=0;i<8;i++){
			if(StudentQuery.stuQuery(userid)!=null) {
				tableDate[0][i]=StudentQuery.stuQuery(userid)[i];//传递数据库的学生信息
			}
			else {
				break;
			}
				
		}
		Object[] columnTitle= {"学号","姓名","性别","邮箱","紧急联络人电话","学校","年级","班级"};
		selfInformation=new JTable(tableDate,columnTitle);
		JScrollPane jsp=new JScrollPane(selfInformation);
		jsp.setSize(700, 200);
		jsp.setLocation(0, 50);
		internalFrame2.getContentPane().add(jsp);
		
		
		JButton button1 = new JButton("返回");
		button1.setBounds(595,311, 93,31);
		internalFrame2.getContentPane().add(button1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				internalFrame2.setVisible(false);
				internalFrame2.dispose();
				internalFrame.setVisible(true);
			}
		});
		
		/**
		 * 桌面3(表，输入框，确定按钮，返回按钮）
		 */
		internalFrame3= new JInternalFrame("学生信息");
		internalFrame3.setResizable(true);
		internalFrame3.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame3);
		internalFrame3.getContentPane().setLayout(null);
		internalFrame3.setVisible(false);
		
		/**
		 * 返回模糊查找学生的表
		 */
		JLabel lblNewLabel_1 = new JLabel("请输入你要查找的学生的学号或姓名");
		lblNewLabel_1.setIcon(new ImageIcon("ico/SQ.png"));
		lblNewLabel_1.setBounds(10, 10, 239, 40);
		internalFrame3.getContentPane().add(lblNewLabel_1);
		
		JTextField textField = new JTextField();
		textField.setBounds(246, 15, 152, 31);
		internalFrame3.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton but = new JButton("确定");
		but.setBounds(408, 15, 93, 31);
		internalFrame3.getContentPane().add(but);
		but.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTable selfInformation1;//要设置表的大小
				Object[][] tableDate1= new Object[150][8];
				int i=0;
				for(int j=0;;j++){
					for(i=0;i<8;i++) {
					tableDate1[j][i]=StudentQuery.likeStuQuery(textField.getText())[j][i];//传递模糊查找数据库的学生信息
					}
					if(StudentQuery.likeStuQuery(textField.getText())[j][0]==null) {
						break;
					}
				}
				Object[] columnTitle1= {"学号","姓名","性别","邮箱","紧急联络人电话","学校","年级","班级"};
				selfInformation1=new JTable(tableDate1,columnTitle1);
				JScrollPane jsp2=new JScrollPane(selfInformation1);
				internalFrame3.getContentPane().add(jsp2);
				jsp2.setSize(700, 200);
				jsp2.setLocation(0, 70);
				jsp2.setVisible(true);
			}
		});
		
		JButton button2 = new JButton("返回");
		button2.setBounds(595,311, 93,31);
		internalFrame3.getContentPane().add(button2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				internalFrame3.setVisible(false);
				internalFrame3.dispose();
				internalFrame.setVisible(true);
			}
		});
		
		/**
		 * 桌面4(表，返回按钮）
		 */
		internalFrame4= new JInternalFrame("分数信息");
		internalFrame4.setResizable(true);
		internalFrame4.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame4);
		internalFrame4.getContentPane().setLayout(null);
		internalFrame4.setVisible(false);
		/**
		 * 查看各科目成绩
		 */
		JTable selfScore;
		Object[][] tableDate2= new Object[15][4];
		int i=0;
		for(int j=0;j<15;j++){
			for(i=0;i<4;i++)
			tableDate2[j][i]=StudentQuery.scoreQuery(userid)[j][i];//传递数据库的学生各科成绩
			if(StudentQuery.scoreQuery(userid)[j][0]==null) {
				break;
			}
		}
		Object[] columnTitle2= {"学号","姓名","科目","分数"};
		selfScore=new JTable(tableDate2,columnTitle2);
		JScrollPane jsp3=new JScrollPane(selfScore);
		jsp3.setSize(700, 200);
		jsp3.setLocation(0, 70);
		internalFrame4.getContentPane().add(jsp3);
		
		
		JButton button3 = new JButton("返回");
		button3.setBounds(595,311, 93,31);
		internalFrame4.getContentPane().add(button3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				internalFrame4.setVisible(false);
				internalFrame4.dispose();
				internalFrame.setVisible(true);
			}
		});
		
		/**
		 * 桌面5(表，返回按钮）
		 */
		internalFrame5= new JInternalFrame("科目信息");
		internalFrame5.setResizable(true);
		internalFrame5.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame5);
		internalFrame5.getContentPane().setLayout(null);
		internalFrame5.setVisible(false);
		/**
		 * 查看课程
		 */
		JTable selfSubject;
		Object[][] tableDate3= new Object[15][1];
		for(int j=0;j<15;j++){
			for(i=0;i<=0;i++)
				tableDate3[j][i]=StudentQuery.selfSubject()[j];//传递数据库的学生课程
			if(StudentQuery.selfSubject()[j]==null) {
				break;
				}
			}
		Object[] columnTitle3= {"科目"};
		selfSubject=new JTable(tableDate3,columnTitle3);
		JScrollPane jsp4=new JScrollPane(selfSubject);
		jsp4.setSize(700, 200);
		jsp4.setLocation(0, 70);
		internalFrame5.getContentPane().add(jsp4);
		
		
		JButton button4 = new JButton("返回");
		button4.setBounds(595,311, 93,31);
		internalFrame5.getContentPane().add(button3);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				internalFrame5.setVisible(false);
				internalFrame5.dispose();
				internalFrame.setVisible(true);
			}
		});
		
			
}
}
	
	
	
	
	
	