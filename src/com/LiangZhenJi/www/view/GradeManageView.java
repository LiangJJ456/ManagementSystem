package com.LiangZhenJi.www.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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

import com.LiangZhenJi.www.dao.GradeCrud;
import com.LiangZhenJi.www.po.Grade;
import com.LiangZhenJi.www.service.ClassManage;
import com.LiangZhenJi.www.service.GradeManage;
import com.LiangZhenJi.www.service.SchoolManage;
import com.LiangZhenJi.www.service.ToggleDeal;

public class GradeManageView extends JFrame {

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
	private JTextField textField_4;

	/**
	 * Create the frame.
	 */
	public GradeManageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("年级管理界面");
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("管理年级");
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem = new JMenuItem("增加年级");
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("删除年级");
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改年级信息");
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
		internalFrame = new JInternalFrame("增加年级");
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
		
		JLabel label_2 = new JLabel("级长姓名");
		label_2.setBounds(20, 67, 113, 31);
		internalFrame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("班级");
		label_3.setBounds(317, 67, 113, 31);
		internalFrame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("电话");
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
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
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
		comboBox_2.setEditable(true);
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
		comboBox_3.setEditable(false);
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
				Grade grade=new Grade();
				grade.setGraSchool((String)comboBox_1.getSelectedItem());
				grade.setGrade((String)comboBox_2.getSelectedItem());
				grade.setGraclass((int)comboBox_3.getSelectedItem());
				grade.setGraorName(textField_1.getText());
				grade.setTelphone(textField_2.getText());
				grade.setGraEmail(textField.getText());
				if(GradeCrud.add(grade)==1) {
					JOptionPane.showMessageDialog(new JFrame(),"添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.addGradeDeal();
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
		internalFrame2 = new JInternalFrame("删除年级");
		internalFrame2.setResizable(true);
		internalFrame2.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame2);
		internalFrame2.getContentPane().setLayout(null);
		
		JLabel label_8 = new JLabel("请输入你要删除班级所属的学校");
		label_8.setBounds(52, 97, 185, 37);
		internalFrame2.getContentPane().add(label_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(247, 169, 149, 29);
		internalFrame2.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_9 = new JLabel("请输入你要删除年级");
		label_9.setBounds(52, 169, 185, 37);
		internalFrame2.getContentPane().add(label_9);
		
		JComboBox<String> comboBox8 = new JComboBox<>();
		for(int i=0;i<10;i++) {
			if(SchoolManage.allSchool()[i][1]!=null) {
				comboBox8.addItem((String)SchoolManage.allSchool()[i][1]);
			}
			else
				break;
		};
		comboBox8.setEditable(false);
		comboBox8.setBounds(247, 97, 149, 29);
		internalFrame2.getContentPane().add(comboBox8);
		
		JButton btnNewButton1 = new JButton("确定");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(GradeCrud.delete(textField_4.getText(),(String)comboBox8.getSelectedItem())!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.deleteGrade(textField_4.getText(),(String)comboBox8.getSelectedItem());
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
		internalFrame3 = new JInternalFrame("修改年级信息");
		internalFrame3.setResizable(true);
		internalFrame3.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame3);
		internalFrame3.getContentPane().setLayout(null);
		
		JLabel label_10 = new JLabel("请输入你要修改年级所属学校");
		label_10.setBounds(10, 10, 182, 37);
		internalFrame3.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("年级");
		label_11.setBounds(349, 15, 54, 26);
		internalFrame3.getContentPane().add(label_11);
		
		JComboBox <String>comboBox9 = new JComboBox<>();
		comboBox9.setBounds(202, 15, 113, 24);
		for(int i=0;i<10;i++) {
			if(SchoolManage.allSchool()[i][1]!=null) {
				comboBox9.addItem((String)SchoolManage.allSchool()[i][1]);
			}
			else
				break;
		}
		comboBox9.setEditable(false);
		internalFrame3.getContentPane().add(comboBox9);
		
		JComboBox<String> comboBox10 = new JComboBox<>();
		comboBox10.setBounds(413, 15, 93, 24);
		for(int i=0;i<10;i++) {
			if(GradeManage.schoolAllGrade((String)comboBox9.getSelectedItem())[i][2]!=null) {
				comboBox10.addItem((String)GradeManage.schoolAllGrade((String)comboBox9.getSelectedItem())[i][2]);
			}
			else
				break;
		}
		comboBox10.setEditable(false);
		internalFrame3.getContentPane().add(comboBox10);
		
		JLabel label0 = new JLabel("级长姓名");
		label0.setBounds(20, 67, 113, 31);
		internalFrame3.getContentPane().add(label0);
		label0.setVisible(false);
		
		JLabel label1 = new JLabel("班级");
		label1.setBounds(317, 67, 113, 31);
		internalFrame3.getContentPane().add(label1);
		label1.setVisible(false);
		
		JLabel label2 = new JLabel("电话");
		label2.setBounds(20, 104, 113, 31);
		internalFrame3.getContentPane().add(label2);
		label2.setVisible(false);
		
		JLabel label3 = new JLabel("邮箱");
		label3.setBounds(317, 104, 113, 31);
		internalFrame3.getContentPane().add(label3);
		label3.setVisible(false);
		
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
		
		textField10 = new JTextField();
		textField10.setBounds(440, 109, 121, 21);
		internalFrame3.getContentPane().add(textField10);
		textField10.setColumns(10);
		textField10.setVisible(false);
		
		JComboBox<Integer> comboBox4 = new JComboBox<>();
		for(int i=0;i<10;i++) {
			if(ClassManage.gradeAllClass((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[i][1]!=null) {
				comboBox4.addItem((int)ClassManage.gradeAllClass((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[i][1]);
			}
			else
				break;
		}
		comboBox4.setEditable(false);
		comboBox4.setBounds(440, 72, 121, 21);
		internalFrame3.getContentPane().add(comboBox4);
		comboBox4.setVisible(false);
		
		//JComboBox事件
		comboBox9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox10.removeAllItems();
				for(int i=0;i<10;i++) {
					if(GradeManage.schoolAllGrade((String)comboBox9.getSelectedItem())[i][2]!=null) {
						comboBox10.addItem((String)GradeManage.schoolAllGrade((String)comboBox9.getSelectedItem())[i][2]);
					}
					else
						break;
				}
				
			}
		});
		
		comboBox10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBox4.removeAllItems();
				for(int i=0;i<10;i++) {
					if(ClassManage.gradeAllClass((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[i][1]!=null) {
						comboBox4.addItem((int)ClassManage.gradeAllClass((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[i][1]);
					}
					else
						break;
				}
				
			}
		});
		
		JButton btnNewButton2 = new JButton("确定");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(GradeManage.selfGrade((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())!=null) {
					btnNewButton3.setVisible(true);
					label0.setVisible(true);
					label1.setVisible(true);
					label2.setVisible(true);
					label3.setVisible(true);
					textField7.setText((String)GradeManage.selfGrade((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[3]);
					textField8.setText((String)GradeManage.selfGrade((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[5]);
					textField10.setText((String)GradeManage.selfGrade((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[6]);
					comboBox4.addItem((int)GradeManage.selfGrade((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[4]);
					comboBox4.setSelectedItem((int)GradeManage.selfGrade((String)comboBox10.getSelectedItem(),(String)comboBox9.getSelectedItem())[4]);
					textField7.setVisible(true);
					textField8.setVisible(true);
					textField10.setVisible(true);
					comboBox4.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(),"没有此年级", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton2.setBounds(585, 10, 93, 37);
		internalFrame3.getContentPane().add(btnNewButton2);
		
		btnNewButton3 = new JButton("确定修改");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Grade grade=new Grade();
				grade.setGraSchool((String)comboBox9.getSelectedItem());
				grade.setGrade((String)comboBox10.getSelectedItem());
				grade.setGraclass((int)comboBox4.getSelectedItem());
				grade.setGraorName(textField7.getText());
				grade.setTelphone(textField8.getText());
				grade.setGraEmail(textField10.getText());
				if(GradeCrud.update(grade)==1) {
					JOptionPane.showMessageDialog(new JFrame(),"修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
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
