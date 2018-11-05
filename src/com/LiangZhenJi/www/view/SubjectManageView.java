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

import com.LiangZhenJi.www.dao.SubjectCrud;
import com.LiangZhenJi.www.service.StudentQuery;
import com.LiangZhenJi.www.service.ToggleDeal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class SubjectManageView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JInternalFrame internalFrame;
	JInternalFrame internalFrame2;
	JInternalFrame internalFrame3;
	JButton btnNewButton3;
	JComboBox<String> comboBox ;


	/**
	 * Create the frame.
	 */
	public SubjectManageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("科目管理界面");
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("管理科目");
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem = new JMenuItem("添加科目");
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("删除科目");
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改科目名字");
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
		internalFrame = new JInternalFrame("添加科目");
		internalFrame.setResizable(true);
		internalFrame.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel label_3 = new JLabel("请输入要添加的科目");
		label_3.setBounds(166, 126, 156, 31);
		internalFrame.getContentPane().add(label_3);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		for(int i=0;i<10;i++) {
			if(StudentQuery.selfSubject()[i]!=null) {
				comboBox_3.addItem((String)StudentQuery.selfSubject()[i]);
			}
			else
				break;
		}
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(332, 126, 121, 31);
		internalFrame.getContentPane().add(comboBox_3);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(SubjectCrud.add((String)comboBox_3.getSelectedItem())!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.addSubjectDeal((String)comboBox_3.getSelectedItem());
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
		internalFrame2 = new JInternalFrame("删除科目");
		internalFrame2.setResizable(true);
		internalFrame2.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame2);
		internalFrame2.getContentPane().setLayout(null);
		
		JLabel label_9 = new JLabel("请输入你要删除的科目");
		label_9.setBounds(72, 124, 185, 37);
		internalFrame2.getContentPane().add(label_9);
		
		JComboBox<String> comboBox8 = new JComboBox<>();
		for(int i=0;i<10;i++) {
			if(StudentQuery.selfSubject()[i]!=null) {
				comboBox8.addItem((String)StudentQuery.selfSubject()[i]);
			}
			else
				break;
		}
		comboBox8.setEditable(false);
		comboBox8.setBounds(317, 124, 151, 37);
		internalFrame2.getContentPane().add(comboBox8);
		
		JButton btnNewButton1 = new JButton("确定");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SubjectCrud.delete((String)comboBox8.getSelectedItem())!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.deleteSubjectDeal((String)comboBox8.getSelectedItem());
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
		internalFrame3 = new JInternalFrame("修改科目名字");
		internalFrame3.setResizable(true);
		internalFrame3.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame3);
		internalFrame3.getContentPane().setLayout(null);
		
		JLabel label_10 = new JLabel("请输入你要修改科目的名字");
		label_10.setBounds(64, 10, 182, 37);
		internalFrame3.getContentPane().add(label_10);
		
		JComboBox<String> comboBox10 = new JComboBox<>();
		comboBox10.setBounds(320, 10, 125, 37);
		for(int i=0;i<10;i++) {
			if(StudentQuery.selfSubject()[i]!=null) {
				comboBox10.addItem((String)StudentQuery.selfSubject()[i]);
			}
			else
				break;
		}
		comboBox10.setEditable(false);
		internalFrame3.getContentPane().add(comboBox10);
		
		JLabel label0 = new JLabel("修改的科目");
		label0.setBounds(145, 163, 173, 37);
		internalFrame3.getContentPane().add(label0);
		label0.setVisible(false);
		
		JButton btnNewButton2 = new JButton("确定");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					btnNewButton3.setVisible(true);
					label0.setVisible(true);
					comboBox10.setVisible(true);
					comboBox.setVisible(true);
			}
		});
		btnNewButton2.setBounds(585, 10, 93, 37);
		internalFrame3.getContentPane().add(btnNewButton2);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(352, 163, 125, 37);
		for(int i=0;i<10;i++) {
			if(StudentQuery.selfSubject()[i]!=null) {
				comboBox.addItem((String)StudentQuery.selfSubject()[i]);
			}
			else
				break;
		}
		comboBox.setEditable(true);
		comboBox.setVisible(false);
		internalFrame3.getContentPane().add(comboBox);
		
		btnNewButton3 = new JButton("确定修改");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SubjectCrud.update((String)comboBox10.getSelectedItem(),(String)comboBox.getSelectedItem())!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"修改成功", "提示", JOptionPane.INFORMATION_MESSAGE);
					ToggleDeal.updateSubjectDeal((String)comboBox10.getSelectedItem(),(String)comboBox.getSelectedItem());
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

