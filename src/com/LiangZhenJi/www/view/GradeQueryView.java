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

import com.LiangZhenJi.www.service.ClassManage;
import com.LiangZhenJi.www.service.GradeManage;
import com.LiangZhenJi.www.service.SchoolManage;

public class GradeQueryView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JInternalFrame internalFrame;
	private JTextField textField7;
	private JTextField textField8;
	private JTextField textField10;
	
	/**
	 * Create the frame.
	 */
	public GradeQueryView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("年级查询界面");
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("查询年级");
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem = new JMenuItem("查询年级信息");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				internalFrame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
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
		internalFrame = new JInternalFrame("查找年级信息");
		internalFrame.setResizable(true);
		internalFrame.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel label_10 = new JLabel("请输入你要查找年级所属学校");
		label_10.setBounds(10, 10, 182, 37);
		internalFrame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("年级");
		label_11.setBounds(349, 15, 54, 26);
		internalFrame.getContentPane().add(label_11);
		
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
		internalFrame.getContentPane().add(comboBox9);
		
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
		internalFrame.getContentPane().add(comboBox10);
		
		JLabel label0 = new JLabel("级长姓名");
		label0.setBounds(20, 67, 113, 31);
		internalFrame.getContentPane().add(label0);
		label0.setVisible(false);
		
		JLabel label1 = new JLabel("班级");
		label1.setBounds(317, 67, 113, 31);
		internalFrame.getContentPane().add(label1);
		label1.setVisible(false);
		
		JLabel label2 = new JLabel("电话");
		label2.setBounds(20, 104, 113, 31);
		internalFrame.getContentPane().add(label2);
		label2.setVisible(false);
		
		JLabel label3 = new JLabel("邮箱");
		label3.setBounds(317, 104, 113, 31);
		internalFrame.getContentPane().add(label3);
		label3.setVisible(false);
		
		textField7= new JTextField();
		textField7.setBounds(143, 72, 102, 21);
		internalFrame.getContentPane().add(textField7);
		textField7.setColumns(10);
		textField7.setVisible(false);
		
		textField8 = new JTextField();
		textField8.setBounds(143, 109, 102, 21);
		internalFrame.getContentPane().add(textField8);
		textField8.setColumns(10);
		textField8.setVisible(false);
		
		textField10 = new JTextField();
		textField10.setBounds(440, 109, 121, 21);
		internalFrame.getContentPane().add(textField10);
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
		internalFrame.getContentPane().add(comboBox4);
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
		internalFrame.getContentPane().add(btnNewButton2);
		internalFrame.setVisible(false);
	}
}
