package com.LiangZhenJi.www.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.LiangZhenJi.www.service.ClassManage;
import com.LiangZhenJi.www.service.GradeManage;
import com.LiangZhenJi.www.service.SchoolManage;
import com.LiangZhenJi.www.service.ToggleDeal;
import com.LiangZhenJi.www.dao.ClassCrud;
import com.LiangZhenJi.www.po.Class;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ClassManageView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JInternalFrame internalFrame;
	JInternalFrame internalFrame2;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField10;
	JInternalFrame internalFrame3;
	JButton btnNewButton3;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ClassManageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("班级管理界面");
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("管理班级");
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem = new JMenuItem("增加班级");
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("删除班级");
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改班级信息");
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
		internalFrame = new JInternalFrame("增加班级");
		internalFrame.setResizable(true);
		internalFrame.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("学校");
		label.setBounds(20, 26, 113, 31);
		internalFrame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("年级");
		label_1.setBounds(317, 26, 113, 31);
		internalFrame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("班主任姓名");
		label_2.setBounds(20, 67, 113, 31);
		internalFrame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("班级");
		label_3.setBounds(317, 67, 113, 31);
		internalFrame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("班主任电话");
		label_4.setBounds(20, 108, 113, 31);
		internalFrame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("邮箱");
		label_5.setBounds(317, 108, 113, 31);
		internalFrame.getContentPane().add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 72, 102, 21);
		internalFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 116, 102, 21);
		internalFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		for(int i=0;i<10;i++) {
			if(SchoolManage.allSchool()[i][1]!=null) {
				comboBox_1.addItem((String)SchoolManage.allSchool()[i][1]);
			}
			else
				break;
		}
		comboBox_1.setEditable(false);
		comboBox_1.setBounds(143, 31, 102, 21);
		internalFrame.getContentPane().add(comboBox_1);
		
		JComboBox<String> comboBox_2 = new JComboBox<String>();
		for(int i=0;i<10;i++) {
			if(GradeManage.schoolAllGrade((String)comboBox_1.getSelectedItem())[i][2]!=null) {
				comboBox_2.addItem((String)GradeManage.schoolAllGrade((String)comboBox_1.getSelectedItem())[i][2]);
			}
			else
				break;
		}
		comboBox_2.setBounds(440, 31, 121, 21);
		internalFrame.getContentPane().add(comboBox_2);
		
		JComboBox<Integer> comboBox_3 = new JComboBox<Integer>();
		for(int i=0;i<10;i++) {
			if(ClassManage.gradeAllClass((String)comboBox_2.getSelectedItem(),(String)comboBox_1.getSelectedItem())[i][1]!=null) {
				comboBox_3.addItem((int)ClassManage.gradeAllClass((String)comboBox_2.getSelectedItem(),(String)comboBox_1.getSelectedItem())[i][1]);
			}
			else
				break;
		}
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(440, 72, 121, 21);
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
		
		textField = new JTextField();
		textField.setBounds(440, 113, 121, 21);
		internalFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Class cla=new Class();
				cla.setClaSchool((String)comboBox_1.getSelectedItem());
				cla.setClagade((String)comboBox_2.getSelectedItem());
				cla.setClaName((int)comboBox_3.getSelectedItem());
				cla.setHeadteaName(textField_1.getText());
				cla.setHeadteaNumber(textField_2.getText());
				cla.setClaEmail(textField.getText());
				if(ClassCrud.add(cla)==1) {
					JOptionPane.showMessageDialog(new JFrame(),"添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.addClassDeal();
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
		internalFrame2 = new JInternalFrame("删除班级");
		internalFrame2.setResizable(true);
		internalFrame2.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame2);
		internalFrame2.getContentPane().setLayout(null);
		
		JLabel label_8 = new JLabel("请输入你要删除班级所属的学校");
		label_8.setBounds(52, 97, 185, 37);
		internalFrame2.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("请输入你要删除年级");
		label_9.setBounds(52, 169, 185, 37);
		internalFrame2.getContentPane().add(label_9);
		
		JLabel label_12= new JLabel("请输入你要删除班级");
		label_12.setBounds(52, 229, 185, 37);
		internalFrame2.getContentPane().add(label_12);
		
		JComboBox<String> comboBox8 = new JComboBox<>();
		for(int i=0;i<10;i++) {
			if(SchoolManage.allSchool()[i][1]!=null) {
				comboBox8.addItem((String)SchoolManage.allSchool()[i][1]);
			}
			else
				break;
		}
		comboBox8.setEditable(false);
		comboBox8.setBounds(247, 97, 149, 29);
		internalFrame2.getContentPane().add(comboBox8);
		
		JComboBox<String> comboBox11= new JComboBox<>();
		for(int i=0;i<10;i++) {
			if(GradeManage.schoolAllGrade((String)comboBox8.getSelectedItem())[i][2]!=null) {
				comboBox11.addItem((String)GradeManage.schoolAllGrade((String)comboBox8.getSelectedItem())[i][2]);
			}
			else
				break;
		}
		comboBox11.setEditable(false);
		comboBox11.setBounds(247, 173, 149, 29);
		internalFrame2.getContentPane().add(comboBox11);
		
		JComboBox<Integer> comboBox12= new JComboBox<>();
		for(int i=0;i<10;i++) {
			if(ClassManage.gradeAllClass((String)comboBox11.getSelectedItem(),(String)comboBox8.getSelectedItem())[i][1]!=null) {
				comboBox12.addItem((int)ClassManage.gradeAllClass((String)comboBox11.getSelectedItem(),(String)comboBox8.getSelectedItem())[i][1]);
			}
			else
				break;
		}
		comboBox12.setEditable(false);
		comboBox12.setBounds(247,233, 149, 29);
		internalFrame2.getContentPane().add(comboBox12);
		
		//JComboBox事件
		comboBox8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox11.removeAllItems();
				for(int i=0;i<10;i++) {
					if(GradeManage.schoolAllGrade((String)comboBox8.getSelectedItem())[i][2]!=null) {
						comboBox11.addItem((String)GradeManage.schoolAllGrade((String)comboBox8.getSelectedItem())[i][2]);
					}
					else
						break;
				}
				
			}
		});
		
		comboBox11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox12.removeAllItems();
				for(int i=0;i<10;i++) {
					if(ClassManage.gradeAllClass((String)comboBox11.getSelectedItem(),(String)comboBox8.getSelectedItem())[i][1]!=null) {
						comboBox12.addItem((int)ClassManage.gradeAllClass((String)comboBox11.getSelectedItem(),(String)comboBox8.getSelectedItem())[i][1]);
					}
					else
						break;
				}
				
			}
		});
		
		JButton btnNewButton1 = new JButton("确定");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ClassCrud.delete((int)comboBox12.getSelectedItem(),(String)comboBox11.getSelectedItem(),(String)comboBox8.getSelectedItem())==1) {
					JOptionPane.showMessageDialog(new JFrame(),"删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.deleteClassDeal((int)comboBox12.getSelectedItem(),(String)comboBox11.getSelectedItem(),(String)comboBox8.getSelectedItem());
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"删除失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton1.setBounds(585, 295, 93, 37);
		internalFrame2.getContentPane().add(btnNewButton1);
		internalFrame2.setVisible(false);
		
		/**
		 * 桌面3
		 */
		internalFrame3 = new JInternalFrame("修改班级信息");
		internalFrame3.setResizable(true);
		internalFrame3.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame3);
		internalFrame3.getContentPane().setLayout(null);
		
		JLabel label_10 = new JLabel("请输入你要修改班级所属学校");
		label_10.setBounds(10, 10, 182, 37);
		internalFrame3.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("年级");
		label_11.setBounds(349, 15, 54, 26);
		internalFrame3.getContentPane().add(label_11);
		
		JLabel label_13 = new JLabel("班级");
		label_13.setBounds(10, 46, 54, 26);
		internalFrame3.getContentPane().add(label_13);
		
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
		internalFrame3.getContentPane().add(comboBox9);
		
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
		internalFrame3.getContentPane().add(comboBox10);
		
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
		internalFrame3.getContentPane().add(comboBox13);
		
		JLabel label0 = new JLabel("班主任姓名");
		label0.setBounds(20, 99, 113, 31);
		internalFrame3.getContentPane().add(label0);
		label0.setVisible(false);
		
		JLabel label1 = new JLabel("邮箱");
		label1.setBounds(317, 99, 113, 31);
		internalFrame3.getContentPane().add(label1);
		label1.setVisible(false);
		
		JLabel label2 = new JLabel("电话");
		label2.setBounds(20, 148, 113, 31);
		internalFrame3.getContentPane().add(label2);
		label2.setVisible(false);
		
		textField7= new JTextField();
		textField7.setBounds(143, 104, 102, 21);
		internalFrame3.getContentPane().add(textField7);
		textField7.setColumns(10);
		textField7.setVisible(false);
		
		textField8 = new JTextField();
		textField8.setBounds(143, 153, 102, 21);
		internalFrame3.getContentPane().add(textField8);
		textField8.setColumns(10);
		textField8.setVisible(false);
		
		textField10 = new JTextField();
		textField10.setBounds(413, 104, 121, 21);
		internalFrame3.getContentPane().add(textField10);
		textField10.setColumns(10);
		textField10.setVisible(false);
		
		JButton btnNewButton2 = new JButton("确定");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(ClassManage.classQuery((int)comboBox13.getSelectedIndex(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())!=null) {
					textField7.setText((String)ClassManage.classQuery((int)comboBox13.getSelectedItem(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[2]);
					textField8.setText((String)ClassManage.classQuery((int)comboBox13.getSelectedItem(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[3]);
					textField10.setText((String)ClassManage.classQuery((int)comboBox13.getSelectedItem(),(String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[4]);
					btnNewButton3.setVisible(true);
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
		internalFrame3.getContentPane().add(btnNewButton2);
		
		btnNewButton3 = new JButton("确定修改");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Class cla1=new Class();
				cla1.setClaSchool((String)comboBox9.getSelectedItem());
				cla1.setClagade((String)comboBox10.getSelectedItem());
				cla1.setClaName((int)comboBox13.getSelectedItem());
				cla1.setHeadteaName(textField7.getText());
				cla1.setHeadteaNumber(textField8.getText());
				cla1.setClaEmail(textField10.getText());
				if(ClassCrud.update(cla1)==1) {
					JOptionPane.showMessageDialog(new JFrame(),"修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"修改失败", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton3.setBounds(585,295, 93, 37);
		internalFrame3.getContentPane().add(btnNewButton3);
		btnNewButton3.setVisible(false);
		internalFrame3.setVisible(false);
	}
}


