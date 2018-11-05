package com.LiangZhenJi.www.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.LiangZhenJi.www.service.ClassManage;
import com.LiangZhenJi.www.service.GradeManage;
import com.LiangZhenJi.www.service.SchoolManage;

public class ClassQueryView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JInternalFrame internalFrame;
	JInternalFrame internalFrame2;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField10;
	JScrollPane jsp4;
	
	/**
	 * Create the frame.
	 */
	public ClassQueryView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("班级查询界面");
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("查询班级");
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem = new JMenuItem("查询班级信息");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame2.setVisible(false);
				internalFrame2.dispose();
				internalFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("查询该班级的学生");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame.dispose();
				internalFrame2.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("菜单");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setIcon(new ImageIcon("ico/menu.png"));
		lblNewLabel.setBounds(10, 0, 72, 39);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("返回");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
			}
		});
		back.setBounds(621, 421, 93, 23);
		contentPane.add(back);
	
	/**
	 * 桌面1
	 */
	internalFrame = new JInternalFrame("查找班级信息");
	internalFrame.setResizable(true);
	internalFrame.setBounds(10, 39, 704, 372);
	contentPane.add(internalFrame);
	internalFrame.getContentPane().setLayout(null);
	
	JLabel label_10 = new JLabel("请输入你要查找班级所属学校");
	label_10.setBounds(10, 10, 182, 37);
	internalFrame.getContentPane().add(label_10);
	
	JLabel label_11 = new JLabel("年级");
	label_11.setBounds(349, 15, 54, 26);
	internalFrame.getContentPane().add(label_11);
	
	JLabel label_13 = new JLabel("班级");
	label_13.setBounds(10, 46, 54, 26);
	internalFrame.getContentPane().add(label_13);
	
	JComboBox <String>comboBox9 = new JComboBox<>();
	comboBox9.setBounds(202, 15, 113, 24);
	comboBox9.setEditable(false);
	for(int i=0;i<10;i++) {
		if(SchoolManage.allSchool()[i][1]!=null) {
			comboBox9.addItem((String)SchoolManage.allSchool()[i][1]);
		}
		else
			break;
	}
	internalFrame.getContentPane().add(comboBox9);
	
	JComboBox<String> comboBox10 = new JComboBox<>();
	comboBox10.setBounds(413, 15, 93, 24);
	comboBox10.setEditable(false);
	for(int i=0;i<10;i++) {
		if(GradeManage.graAll()[i][1]!=null) {
			comboBox10.addItem((String)GradeManage.graAll()[i][2]);
		}
		else
			break;
	}
	internalFrame.getContentPane().add(comboBox10);
	
	JComboBox<Integer> comboBox13 = new JComboBox<Integer>();
	for(int i=0;i<10;i++) {
		if(ClassManage.allClass()[i][1]!=null) {
			comboBox13.addItem((int)ClassManage.allClass()[i][1]);
		}
		else
			break;
	}
	comboBox13.setEditable(false);
	comboBox13.setBounds(202, 49, 113, 24);
	internalFrame.getContentPane().add(comboBox13);
	
	JLabel label0 = new JLabel("班主任姓名");
	label0.setBounds(20, 99, 113, 31);
	internalFrame.getContentPane().add(label0);
	label0.setVisible(false);
	
	JLabel label1 = new JLabel("邮箱");
	label1.setBounds(317, 99, 113, 31);
	internalFrame.getContentPane().add(label1);
	label1.setVisible(false);
	
	JLabel label2 = new JLabel("电话");
	label2.setBounds(20, 148, 113, 31);
	internalFrame.getContentPane().add(label2);
	label2.setVisible(false);
	
	textField7= new JTextField();
	textField7.setBounds(143, 104, 102, 21);
	internalFrame.getContentPane().add(textField7);
	textField7.setColumns(10);
	textField7.setVisible(false);
	
	textField8 = new JTextField();
	textField8.setBounds(143, 153, 102, 21);
	internalFrame.getContentPane().add(textField8);
	textField8.setColumns(10);
	textField8.setVisible(false);
	
	textField10 = new JTextField();
	textField10.setBounds(413, 104, 121, 21);
	internalFrame.getContentPane().add(textField10);
	textField10.setColumns(10);
	textField10.setVisible(false);
	
	JButton btnNewButton2 = new JButton("确定");
	btnNewButton2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(ClassManage.classQuery((int)comboBox13.getSelectedIndex(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())!=null) {
				textField7.setText((String)ClassManage.classQuery((int)comboBox13.getSelectedItem(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[2]);
				textField8.setText((String)ClassManage.classQuery((int)comboBox13.getSelectedItem(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[3]);
				textField10.setText((String)ClassManage.classQuery((int)comboBox13.getSelectedItem(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[4]);
				label0.setVisible(true);
				label1.setVisible(true);
				label2.setVisible(true);
				textField7.setVisible(true);
				textField8.setVisible(true);
				textField10.setVisible(true);
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"没有此班级", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	});
	btnNewButton2.setBounds(585, 35, 93, 37);
	internalFrame.getContentPane().add(btnNewButton2);
	internalFrame.setVisible(false);
	
	/**
	 * 桌面2
	 */
	internalFrame2 = new JInternalFrame("查找班级信息");
	internalFrame2.setResizable(true);
	internalFrame2.setBounds(10, 39, 704, 372);
	contentPane.add(internalFrame2);
	internalFrame2.getContentPane().setLayout(null);
	
	JLabel label10 = new JLabel("请输入你要查找班级所属学校");
	label10.setBounds(10, 10, 182, 37);
	internalFrame2.getContentPane().add(label10);
	
	JLabel label11 = new JLabel("年级");
	label11.setBounds(349, 15, 54, 26);
	internalFrame2.getContentPane().add(label11);
	
	JLabel label13 = new JLabel("班级");
	label13.setBounds(10, 46, 54, 26);
	internalFrame2.getContentPane().add(label13);
	
	JComboBox <String>comboBox1 = new JComboBox<>();
	comboBox1.setBounds(202, 15, 113, 24);
	comboBox1.setEditable(false);
	for(int i=0;i<10;i++) {
		if(SchoolManage.allSchool()[i][1]!=null) {
			comboBox1.addItem((String)SchoolManage.allSchool()[i][1]);
		}
		else
			break;
	}
	internalFrame2.getContentPane().add(comboBox1);
	
	JComboBox<String> comboBox2= new JComboBox<>();
	comboBox2.setBounds(413, 15, 93, 24);
	comboBox2.setEditable(false);
	for(int i=0;i<10;i++) {
		if(GradeManage.graAll()[i][1]!=null) {
			comboBox2.addItem((String)GradeManage.graAll()[i][2]);
		}
		else
			break;
	}
	internalFrame2.getContentPane().add(comboBox10);
	
	JComboBox<Integer> comboBox3 = new JComboBox<Integer>();
	for(int i=0;i<10;i++) {
		if(ClassManage.allClass()[i][1]!=null) {
			comboBox3.addItem((int)ClassManage.allClass()[i][1]);
		}
		else
			break;
	}
	comboBox3.setEditable(false);
	comboBox3.setBounds(202, 49, 113, 24);
	internalFrame2.getContentPane().add(comboBox3);
	
	
	JButton btn = new JButton("确定");
	btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(ClassManage.classQuery((int)comboBox3.getSelectedItem(),(String)comboBox2.getSelectedItem(),(String)comboBox1.getSelectedItem())!=null) {
				//返回班级学生的表
				JTable classStudent;
				Object[][] tableDate3= new Object[50][1];
				for(int j=0;j<50;j++){
					if(ClassManage.classStudent((int)comboBox3.getSelectedItem(),(String)comboBox2.getSelectedItem(),(String)comboBox1.getSelectedItem())[j][0]==null) {
						break;
						}
					tableDate3[j][0]=ClassManage.classStudent((int)comboBox3.getSelectedItem(),(String)comboBox2.getSelectedItem(),(String)comboBox1.getSelectedItem())[j][0];//传递数据库的班级学生
					}
				Object[] columnTitle3= {"学生"};
				classStudent=new JTable(tableDate3,columnTitle3);
				jsp4=new JScrollPane(classStudent);
				jsp4.setSize(696,192);
				jsp4.setLocation(0,90);
				jsp4.setVisible(true);
				internalFrame2.getContentPane().add(jsp4);
			}
			else {
				JOptionPane.showMessageDialog(new JFrame(),"没有此班级", "提示", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	});
	btn.setBounds(585, 35, 93, 37);
	internalFrame2.getContentPane().add(btn);
	internalFrame2.setVisible(false);

	}
	
}
