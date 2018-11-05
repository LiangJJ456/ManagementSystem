package com.LiangZhenJi.www.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.LiangZhenJi.www.dao.StudentCrud;
import com.LiangZhenJi.www.po.Student;
import com.LiangZhenJi.www.service.ClassManage;
import com.LiangZhenJi.www.service.GradeManage;
import com.LiangZhenJi.www.service.SchoolManage;
import com.LiangZhenJi.www.service.StudentQuery;
import com.LiangZhenJi.www.service.ToggleDeal;


public class StudentManageView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JInternalFrame internalFrame;
	JInternalFrame internalFrame2;
	private JTextField textField;//姓名
	private JTextField textField_1;//学号
	private JTextField textField_2;//紧急联系人
	private JTextField textField_6;//邮箱
	private JTextField textField_3;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField9;
	private JTextField textField10;
	JInternalFrame internalFrame3;
	JButton btnNewButton3;

	/**
	 * Create the frame.
	 */
	public StudentManageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("学生管理界面");
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("管理学生");
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem = new JMenuItem("增加学生");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame2.setVisible(false);
				internalFrame3.setVisible(false);
				internalFrame2.dispose();
				internalFrame3.dispose();
				internalFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("删除学生");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame3.setVisible(false);
				internalFrame.dispose();
				internalFrame3.dispose();
				internalFrame2.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改学生信息");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(false);
				internalFrame2.setVisible(false);
				internalFrame.dispose();
				internalFrame2.dispose();
				internalFrame3.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
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
		internalFrame = new JInternalFrame("增加学生");
		internalFrame.setResizable(true);
		internalFrame.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(20, 26, 113, 31);
		internalFrame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("性别");
		label_1.setBounds(317, 26, 113, 31);
		internalFrame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("学号");
		label_2.setBounds(20, 67, 113, 31);
		internalFrame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("邮箱");
		label_3.setBounds(317, 67, 113, 31);
		internalFrame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("紧急联系人电话");
		label_4.setBounds(20, 108, 113, 31);
		internalFrame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("学校");
		label_5.setBounds(317, 108, 113, 31);
		internalFrame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("年级");
		label_6.setBounds(20, 149, 113, 31);
		internalFrame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("班级");
		label_7.setBounds(317, 144, 113, 31);
		internalFrame.getContentPane().add(label_7);
		
		textField = new JTextField();
		textField.setBounds(143, 31, 102, 21);
		internalFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 72, 102, 21);
		internalFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 116, 102, 21);
		internalFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(440, 72, 121, 21);
		internalFrame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"男", "女"}));
		comboBox.setEditable(false);
		comboBox.setBounds(440, 31, 121, 21);
		internalFrame.getContentPane().add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		for(int i=0;i<10;i++) {
			if(SchoolManage.allSchool()[i][1]!=null) {
				comboBox_1.addItem((String)SchoolManage.allSchool()[i][1]);
			}
			else
				break;
		}
		comboBox_1.setEditable(false);
		comboBox_1.setBounds(440, 113, 121, 21);
		internalFrame.getContentPane().add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		for(int i=0;i<10;i++) {
			if(GradeManage.schoolAllGrade((String)comboBox_1.getSelectedItem())[i][2]!=null) {
				comboBox_2.addItem((String)GradeManage.schoolAllGrade((String)comboBox_1.getSelectedItem())[i][2]);
			}
			else
				break;
		}
		comboBox_2.setEditable(false);
		comboBox_2.setBounds(143, 154, 102, 21);
		internalFrame.getContentPane().add(comboBox_2);
		
		JComboBox<Integer> comboBox_3 = new JComboBox<Integer>();
		for(int i=0;i<10;i++) {
			if(ClassManage.gradeAllClass((String)comboBox_2.getSelectedItem(),(String)comboBox_1.getSelectedItem())[i][1]!=null) {
				comboBox_3.addItem((int)ClassManage.gradeAllClass((String)comboBox_2.getSelectedItem(),(String)comboBox_1.getSelectedItem())[i][1]);
			}
			else
				break;
		}
		comboBox_3.setEditable(false);
		comboBox_3.setBounds(440, 154, 121, 21);
		internalFrame.getContentPane().add(comboBox_3);
		
		//JComboBox事件
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_2.removeAllItems();
				for(int i=0;i<10;i++) {
					if(GradeManage.schoolAllGrade((String)comboBox_1.getSelectedItem())[i][2]!=null) {
						comboBox_2.addItem((String)GradeManage.schoolAllGrade((String)comboBox_1.getSelectedItem())[i][2]);
					}
					else
						break;
				}
				
			}
		});
		
		comboBox_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_3.removeAllItems();
				for(int i=0;i<10;i++) {
					if(ClassManage.gradeAllClass((String)comboBox_2.getSelectedItem(),(String)comboBox_1.getSelectedItem())[i][1]!=null) {
						comboBox_3.addItem((int)ClassManage.gradeAllClass((String)comboBox_2.getSelectedItem(),(String)comboBox_1.getSelectedItem())[i][1]);
					}
					else
						break;
				}
				
			}
		});
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Student student=new Student();
				student.setStuId(textField_1.getText());
				student.setStuName(textField.getText());
				student.setStuSex((String)comboBox.getSelectedItem());
				student.setStuEmail(textField_6.getText());
				student.setStuConNum(textField_2.getText());
				student.setStuSchool((String)comboBox_1.getSelectedItem());
				student.setStuGrade((String)comboBox_2.getSelectedItem());
				student.setStuClass((int)comboBox_3.getSelectedItem());
				if(StudentCrud.add(student)==1) {
					JOptionPane.showMessageDialog(new JFrame(),"添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.studentAddDeal();
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"添加失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(585, 301, 93, 31);
		internalFrame.getContentPane().add(btnNewButton);
		internalFrame.setVisible(false);
		
		/**
		 * 桌面2
		 */
		internalFrame2 = new JInternalFrame("删除学生");
		internalFrame2.setResizable(true);
		internalFrame2.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame2);
		internalFrame2.getContentPane().setLayout(null);
		
		JLabel label_8 = new JLabel("请输入你要删除学生的姓名或学号");
		label_8.setBounds(23, 97, 214, 37);
		internalFrame2.getContentPane().add(label_8);
		
		textField_3 = new JTextField();
		textField_3.setBounds(247, 97, 192, 37);
		internalFrame2.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton1 = new JButton("确定");
		btnNewButton1.setBounds(449, 97, 93, 37);
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StudentCrud.delete(textField_3.getText())!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.studentDeleteDeal((String)StudentQuery.stuQuery(textField_3.getText())[0]);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"删除失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		internalFrame2.getContentPane().add(btnNewButton1);
		internalFrame2.setVisible(false);
		
		/**
		 * 桌面3
		 */
		internalFrame3 = new JInternalFrame("修改学生信息");
		internalFrame3.setResizable(true);
		internalFrame3.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame3);
		internalFrame3.getContentPane().setLayout(null);
		
		JLabel label_9 = new JLabel("请输入你要修改学生的姓名或学号");
		label_9.setBounds(10, 10, 223, 37);
		internalFrame3.getContentPane().add(label_9);
		
		textField_3 = new JTextField();
		textField_3.setBounds(243, 10, 192, 37);
		textField_3.setText("");
		internalFrame3.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label0 = new JLabel("姓名");
		label0.setBounds(20, 67, 113, 31);
		internalFrame3.getContentPane().add(label0);
		label0.setVisible(false);
		
		JLabel label1 = new JLabel("性别");
		label1.setBounds(317, 67, 113, 31);
		internalFrame3.getContentPane().add(label1);
		label1.setVisible(false);
		
		JLabel label2 = new JLabel("学号");
		label2.setBounds(20, 104, 113, 31);
		internalFrame3.getContentPane().add(label2);
		label2.setVisible(false);
		
		JLabel label3 = new JLabel("邮箱");
		label3.setBounds(317, 104, 113, 31);
		internalFrame3.getContentPane().add(label3);
		label3.setVisible(false);
		
		JLabel label4 = new JLabel("紧急联系人电话");
		label4.setBounds(20, 145, 113, 31);
		internalFrame3.getContentPane().add(label4);
		label4.setVisible(false);
		
		JLabel label5 = new JLabel("学校");
		label5.setBounds(317, 145, 113, 31);
		internalFrame3.getContentPane().add(label5);
		label5.setVisible(false);
		
		JLabel label6 = new JLabel("年级");
		label6.setBounds(20, 186, 113, 31);
		internalFrame3.getContentPane().add(label6);
		label6.setVisible(false);
		
		JLabel label7 = new JLabel("班级");
		label7.setBounds(317, 186, 113, 31);
		internalFrame3.getContentPane().add(label7);
		label7.setVisible(false);
		
		textField7= new JTextField();
		textField7.setBounds(143, 72, 102, 21);
		internalFrame3.getContentPane().add(textField7);
		textField7.setColumns(10);
		textField7.setVisible(false);
		
		textField8 = new JTextField();
		textField8.setBounds(143, 109, 102, 21);
		internalFrame3.getContentPane().add(textField8);
		textField8.setColumns(10);
		textField8.setVisible(false);
		
		textField9 = new JTextField();
		textField9.setBounds(143, 150, 102, 21);
		internalFrame3.getContentPane().add(textField9);
		textField9.setColumns(10);
		textField9.setVisible(false);
		
		textField10 = new JTextField();
		textField10.setBounds(440, 109, 121, 21);
		internalFrame3.getContentPane().add(textField10);
		textField10.setColumns(10);
		textField10.setVisible(false);
		
		JComboBox<String> comboBox4 = new JComboBox<>();
		comboBox4.addItem("男");
		comboBox4.addItem("女");
		comboBox4.setEditable(false);
		comboBox4.setBounds(440, 72, 121, 21);
		internalFrame3.getContentPane().add(comboBox4);
		comboBox4.setVisible(false);
		
		JComboBox<String> comboBox5 = new JComboBox<String>();
		for(int i=0;i<10;i++) {
			if(SchoolManage.allSchool()[i][1]!=null) {
				comboBox5.addItem((String)SchoolManage.allSchool()[i][1]);
			}
			else
				break;
		}
		comboBox5.setEditable(false);
		comboBox5.setBounds(440, 150, 121, 21);
		internalFrame3.getContentPane().add(comboBox5);
		comboBox5.setVisible(false);
		
		JComboBox<String> comboBox6 = new JComboBox<String>();
		for(int i=0;i<10;i++) {
			if(GradeManage.schoolAllGrade((String)comboBox5.getSelectedItem())[i][2]!=null) {
				comboBox6.addItem((String)GradeManage.schoolAllGrade((String)comboBox5.getSelectedItem())[i][2]);
			}
			else
				break;
		}
		comboBox6.setEditable(false);
		comboBox6.setBounds(143, 191, 102, 21);
		internalFrame3.getContentPane().add(comboBox6);
		comboBox6.setVisible(false);
		
		JComboBox<Integer> comboBox7 = new JComboBox<Integer>();
		for(int i=0;i<10;i++) {
			if(ClassManage.gradeAllClass((String)comboBox6.getSelectedItem(),(String)comboBox5.getSelectedItem())[i][1]!=null) {
				comboBox7.addItem((int)ClassManage.gradeAllClass((String)comboBox6.getSelectedItem(),(String)comboBox5.getSelectedItem())[i][1]);
			}
			else
				break;
		}
		comboBox7.setEditable(false);
		comboBox7.setBounds(440, 191, 121, 21);
		internalFrame3.getContentPane().add(comboBox7);
		comboBox7.setVisible(false);
		
		//JComboBox事件
		comboBox5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox6.removeAllItems();
				for(int i=0;i<10;i++) {
					if(GradeManage.schoolAllGrade((String)comboBox5.getSelectedItem())[i][2]!=null) {
						comboBox6.addItem((String)GradeManage.schoolAllGrade((String)comboBox5.getSelectedItem())[i][2]);
					}
					else
						break;
				}
				
			}
		});
		
		comboBox6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox7.removeAllItems();
				for(int i=0;i<10;i++) {
					if(ClassManage.gradeAllClass((String)comboBox6.getSelectedItem(),(String)comboBox5.getSelectedItem())[i][1]!=null) {
						comboBox7.addItem((int)ClassManage.gradeAllClass((String)comboBox6.getSelectedItem(),(String)comboBox5.getSelectedItem())[i][1]);
					}
					else
						break;
				}
				
			}
		});
		
		JButton btnNewButton2 = new JButton("确定");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(StudentQuery.stuQuery(textField_3.getText())== null) {
					JOptionPane.showMessageDialog(new JFrame(),"查无此人,请重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					btnNewButton3.setVisible(true);
					label0.setVisible(true);
					label1.setVisible(true);
					label2.setVisible(true);
					label3.setVisible(true);
					label4.setVisible(true);
					label5.setVisible(true);
					label6.setVisible(true);
					label7.setVisible(true);
					textField7.setVisible(true);
					textField8.setVisible(true);
					textField9.setVisible(true);
					textField10.setVisible(true);
					textField7.setText((String)StudentQuery.stuQuery(textField_3.getText())[1]);//姓名
					textField8.setText((String)StudentQuery.stuQuery(textField_3.getText())[0]);//学号
					textField9.setText((String)StudentQuery.stuQuery(textField_3.getText())[4]);//紧急联系人
					textField10.setText((String)StudentQuery.stuQuery(textField_3.getText())[3]);//邮箱
					comboBox4.setModel(new DefaultComboBoxModel<String>(new String[] {(String)StudentQuery.stuQuery(textField_3.getText())[2]}));
					comboBox5.setModel(new DefaultComboBoxModel<String>(new String[] {(String)StudentQuery.stuQuery(textField_3.getText())[5]}));
					comboBox6.setModel(new DefaultComboBoxModel<String>(new String[] {(String)StudentQuery.stuQuery(textField_3.getText())[6]}));
					comboBox7.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {(int)StudentQuery.stuQuery(textField_3.getText())[7]}));
					comboBox4.setVisible(true);
					comboBox5.setVisible(true);
					comboBox6.setVisible(true);
					comboBox7.setVisible(true);
				}
			}
		});
		btnNewButton2.setBounds(445, 10, 93, 37);
		internalFrame3.getContentPane().add(btnNewButton2);
		
		btnNewButton3 = new JButton("确定修改");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student1=new Student();
				student1.setStuId(textField8.getText());
				student1.setStuName(textField7.getText());
				student1.setStuSex((String)comboBox4.getSelectedItem());
				student1.setStuEmail(textField10.getText());
				student1.setStuConNum(textField9.getText());
				student1.setStuSchool((String)comboBox5.getSelectedItem());
				student1.setStuGrade((String)comboBox6.getSelectedItem());
				student1.setStuClass((int)comboBox7.getSelectedItem());
				if(StudentCrud.add(student1)!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.studentUpdateDeal((String)StudentQuery.stuQuery(textField_3.getText())[0], student1.getId());
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"修改失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton3.setBounds(600,300, 93, 37);
		internalFrame3.getContentPane().add(btnNewButton3);
		btnNewButton3.setVisible(false);
		internalFrame3.setVisible(false);
	}
}


