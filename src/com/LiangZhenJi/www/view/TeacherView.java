package com.LiangZhenJi.www.view;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import com.LiangZhenJi.www.dao.TeacherInformation;

public class TeacherView extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public String userid;
		private JPanel contentPane;
		JInternalFrame internalFrame;
		JInternalFrame internalFrame2;
		JInternalFrame internalFrame3;
		JInternalFrame internalFrame4;
		JInternalFrame internalFrame5;
		private JTextField textField_2;
		private JTextField textField_3;

		/**
		 * Create the frame.
		 */
		public  TeacherView(String userid) throws Exception {
			setIconImage(Toolkit.getDefaultToolkit().getImage("ico/tea.png"));
			setTitle("老师管理界面");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 740, 493);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(77, 0, 576, 39);
			contentPane.add(menuBar);
			
			JMenu mnNewMenu = new JMenu("查询信息");
			menuBar.add(mnNewMenu);
			
			JMenuItem menuItem = new JMenuItem("查询个人信息");
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
			
			JMenuItem menuItem1 = new JMenuItem("查询学生信息");
			mnNewMenu.add(menuItem1);
			menuItem1.addActionListener(new ActionListener() {
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
			
			JMenuItem menuItem2 = new JMenuItem("查询科目");
			mnNewMenu.add(menuItem2);
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
			
			JMenuItem menuItem3 = new JMenuItem("查询分数");
			mnNewMenu.add(menuItem3);
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
			
			JMenuItem menuItem4 = new JMenuItem("查询班级");
			mnNewMenu.add(menuItem4);
			menuItem4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClassQueryView cv=new ClassQueryView();
					cv.setVisible(true);
					
				}
			});
			
			JMenuItem menuItem5 = new JMenuItem("查询年级");
			mnNewMenu.add(menuItem5);
			menuItem5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GradeQueryView gq=new GradeQueryView();
					gq.setVisible(true);
					
				}
			});
			
			
			JMenu mnNewMenu_1 = new JMenu("管理学生");
			menuBar.add(mnNewMenu_1);
			
			JMenuItem item = new JMenuItem("管理学生");
			mnNewMenu_1.add(item);
			item.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StudentManageView stu=new StudentManageView();
					stu.setVisible(true);
				}
			});
			
			JMenu mnNewMenu_2 = new JMenu("管理科目");
			menuBar.add(mnNewMenu_2);
			
			JMenuItem item2 = new JMenuItem("管理科目");
			mnNewMenu_2.add(item2);
			item2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SubjectManageView sub=new SubjectManageView();
					sub.setVisible(true);
				}
			});
			
			JMenu mnNewMenu_3 = new JMenu("管理成绩");
			menuBar.add(mnNewMenu_3);
			
			JMenuItem item3= new JMenuItem("管理成绩");
			mnNewMenu_3.add(item3);
			item3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ScoreManageView sco=new ScoreManageView();
					sco.setVisible(true);
				}
			});
			
			JMenu mnNewMenu_4= new JMenu("管理学校");
			menuBar.add(mnNewMenu_4);
			
			JMenuItem item4 = new JMenuItem("管理学校");
			mnNewMenu_4.add(item4);
			item4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SchoolManageView sch=new SchoolManageView();
					sch.setVisible(true);
				}
			});
			
			JMenu mnNewMenu_5= new JMenu("管理年级");
			menuBar.add(mnNewMenu_5);
			
			JMenuItem item5= new JMenuItem("管理年级");
			mnNewMenu_5.add(item5);
			item5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GradeManageView gra=new GradeManageView();
					gra.setVisible(true);
				}
			});
			
			JMenu mnNewMenu_6 = new JMenu("管理班级");
			menuBar.add(mnNewMenu_6);
			
			JMenuItem item6 = new JMenuItem("管理班级");
			mnNewMenu_6.add(item6);
			item6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ClassManageView cla=new ClassManageView();
					cla.setVisible(true);
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
			 * 桌面2(查询老师信息）
			 */
			internalFrame2= new JInternalFrame("个人信息");
			internalFrame2.setResizable(true);
			internalFrame2.setBounds(10, 39, 704, 372);
			contentPane.add(internalFrame2);
			internalFrame2.getContentPane().setLayout(null);
			internalFrame2.setVisible(false);
			
			/**
			 * 返回老师个人信息
			 */
			
			JTable teacherInformation1;
			Object[][] tableDate2= new Object[1][8];
			int i=0;
			for(int j=0;j<1;j++){
				for(i=0;i<8;i++) {
				tableDate2[j][i]=TeacherInformation.teaInformation(userid)[i];//传递教师信息
				}
			}
			Object[] columnTitle2= {"工号","姓名","学校","年级","班级","电话","邮箱","科目"};
			teacherInformation1=new JTable(tableDate2,columnTitle2);
			JScrollPane jsp0=new JScrollPane(teacherInformation1);
			jsp0.setSize(700, 200);
			jsp0.setLocation(0, 50);
			internalFrame2.getContentPane().add(jsp0);
			jsp0.setVisible(true);
			
			JButton butt = new JButton("返回");
			butt.setBounds(595,311, 93,31);
			internalFrame2.getContentPane().add(butt);
			butt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					internalFrame2.setVisible(false);
					internalFrame2.dispose();
					internalFrame.setVisible(true);
				}
			});
			
			/**
			 * 桌面3(查询学生）
			 */
			internalFrame3= new JInternalFrame("查询学生");
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
					JTable selfInformation1;
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
					jsp2.setSize(700, 200);
					jsp2.setLocation(0, 50);
					internalFrame3.getContentPane().add(jsp2);
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
			 * 桌面4(查询科目）
			 */
			internalFrame4= new JInternalFrame("查询科目");
			internalFrame4.setResizable(true);
			internalFrame4.setBounds(10, 39, 704, 372);
			contentPane.add(internalFrame4);
			internalFrame4.getContentPane().setLayout(null);
			internalFrame4.setVisible(false);
			/**
			 * 查看课程
			 */
			JTable selfSubject;
			Object[][] tableDate3= new Object[15][1];
			for(int j=0;j<15;j++){
				if(StudentQuery.selfSubject()[j]==null) {
					break;
					}
				tableDate3[j][0]=StudentQuery.selfSubject()[j];//传递数据库的学生课程
				}
			Object[] columnTitle3= {"科目"};
			selfSubject=new JTable(tableDate3,columnTitle3);
			JScrollPane jsp4=new JScrollPane(selfSubject);
			jsp4.setSize(700, 200);
			jsp4.setLocation(0, 50);
			internalFrame4.getContentPane().add(jsp4);
			
			
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
			 * 桌面5(查询分数）
			 */
			internalFrame5= new JInternalFrame("查询分数");
			internalFrame5.setResizable(true);
			internalFrame5.setBounds(10, 39, 704, 372);
			contentPane.add(internalFrame5);
			internalFrame5.getContentPane().setLayout(null);
			internalFrame5.setVisible(false);
			
			/**
			 * 查询分数
			 */
			JLabel label_2 = new JLabel("请输入要查找的科目：");
			label_2.setIcon(new ImageIcon("ico/class.png"));
			label_2.setBounds(0, 36, 178, 27);
			internalFrame5.getContentPane().add(label_2);
			
			JLabel label2 = new JLabel("请输入学生姓名或学号：");
			label2.setIcon(new ImageIcon("ico/student.png"));
			label2.setBounds(0, 10, 178, 26);
			internalFrame5.getContentPane().add(label2);
			
			textField_2 = new JTextField();
			textField_2.setText("");
			textField_2.setBounds(177, 13, 150, 21);
			internalFrame5.getContentPane().add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setText("");
			textField_3.setBounds(177, 39, 150, 21);
			internalFrame5.getContentPane().add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("（可以为空）");
			lblNewLabel_3.setBounds(326, 10, 240, 27);
			internalFrame5.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("（可以为空）");
			lblNewLabel_4.setBounds(326, 36, 240, 27);
			internalFrame5.getContentPane().add(lblNewLabel_4);
			
			JButton btnNewButton = new JButton("查询");
			btnNewButton.setBounds(576, 21, 99, 42);
			internalFrame5.getContentPane().add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(textField_2.getText().equals("")) {
						if( textField_3.getText().equals("")) {
							/**
							 * 查询所有学生的成绩
							 */
							JTable allScore;
							Object[][] tableDate4= new Object[150][4];
							for(int j=0;j<150;j++){
								int i=0;
								if(StudentQuery.allScoQuery()[j][0]==null) {
									break;
									}
								for(i=0;i<4;i++) {
									tableDate4[j][i]=StudentQuery.allScoQuery()[j][i];//传递数据库的学生课程
							}
							}
							Object[] columnTitle4= {"学号","姓名","科目","分数"};
							allScore=new JTable(tableDate4,columnTitle4);
							JScrollPane jsp5=new JScrollPane(allScore);
							jsp5.setSize(700, 200);
							jsp5.setLocation(0, 70);
							internalFrame5.getContentPane().add(jsp5);
							jsp5.setVisible(true);
						}
						else {
							/**
							 * 查询某科目的学生成绩
							 */
							JTable subScore;//要设置表的大小,或者滚动条大小
							Object[][] tableDate5= new Object[150][3];
							for(int j=0;j<150;j++){
								int i;
								for(i=0;i<3;i++)
									tableDate5[j][i]=StudentQuery.subScoQuery(textField_3.getText())[j][i];//传递数据库的学生课程
								if(StudentQuery.subScoQuery(textField_3.getText())[j][0]==null) {
									break;
									}
								}
							Object[] columnTitle5= {"科目","姓名","分数"};
							subScore=new JTable(tableDate5,columnTitle5);
							JScrollPane jsp6=new JScrollPane(subScore);
							internalFrame5.getContentPane().add(jsp6);
							jsp6.setSize(700, 200);
							jsp6.setLocation(0, 70);
							jsp6.setVisible(true);
							
						}
						
					}
					else {
						if(textField_3.getText().equals("")) {
							/**
							 * 查询某学生各科目成绩
							 */
							JTable selfScore;
							Object[][] tableDate6= new Object[15][4];
							for(int j=0;j<15;j++){
								int i=0;
								for(i=0;i<4;i++)
									tableDate6[j][i]=StudentQuery.scoreQuery(textField_2.getText())[j][i];//传递数据库的学生课程
								if(StudentQuery.scoreQuery(textField_2.getText())[j][0]==null) {
									break;
									}
								}
							Object[] columnTitle6= {"学号","姓名","科目","分数"};
							selfScore=new JTable(tableDate6,columnTitle6);
							JScrollPane jsp7=new JScrollPane(selfScore);
							internalFrame5.getContentPane().add(jsp7);
							jsp7.setSize(700, 200);
							jsp7.setLocation(0, 70);
							jsp7.setVisible(true);
						}
						else {
							/**
							 * 查询某学生某科目的成绩
							 */
							JTable selfSubScore;
							Object[][] tableDate7= new Object[1][4];
							for(int j=0;j<1;j++){
								int i=0;
								for(i=0;i<4;i++)
									tableDate7[j][i]=StudentQuery.selfScoQuery(textField_2.getText(),textField_3.getText())[i];//传递数据库的学生课程
								}
							Object[] columnTitle7= {"学号","姓名","科目","分数"};
							selfSubScore=new JTable(tableDate7,columnTitle7);
							JScrollPane jsp8=new JScrollPane(selfSubScore);
							internalFrame5.getContentPane().add(jsp8);
							jsp8.setSize(700, 200);
							jsp8.setLocation(0, 70);
							jsp8.setVisible(true);
							
						}
					}
				}
			});
			
			JButton button4 = new JButton("返回");
			button4.setBounds(595,311, 93,31);
			internalFrame5.getContentPane().add(button4);
			button4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					internalFrame5.setVisible(false);
					internalFrame5.dispose();
					internalFrame.setVisible(true);
				}
			});
			
		}
}


