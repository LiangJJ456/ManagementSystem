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

import com.LiangZhenJi.www.dao.ScoreCrud;
import com.LiangZhenJi.www.po.Score;
import com.LiangZhenJi.www.service.StudentQuery;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ScoreManageView extends JFrame {

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
	JInternalFrame internalFrame3;
	JButton btnNewButton3;
	private JTextField textField_4;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ScoreManageView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("成绩管理界面");
		setBounds(100, 100, 740, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(77, 0, 576, 39);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("管理成绩");
		menuBar.add(mnNewMenu_1);
		JMenuItem mntmNewMenuItem = new JMenuItem("添加学生成绩");
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("删除成绩");
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
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("修改成绩");
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
		internalFrame = new JInternalFrame("添加学生成绩");
		internalFrame.setResizable(true);
		internalFrame.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		JLabel label_2 = new JLabel("学生姓名");
		label_2.setBounds(20, 67, 113, 31);
		internalFrame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("科目");
		label_3.setBounds(317, 67, 113, 31);
		internalFrame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("成绩");
		label_4.setBounds(20, 108, 113, 31);
		internalFrame.getContentPane().add(label_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 72, 102, 21);
		internalFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 116, 102, 21);
		internalFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox<String> comboBox_3 = new JComboBox<String>();
		for(int i=0;i<10;i++) {
			if(StudentQuery.selfSubject()[i]!=null) {
				comboBox_3.addItem((String)StudentQuery.selfSubject()[i]);
			}
			else
				break;
		}
		comboBox_3.setEditable(false);
		comboBox_3.setBounds(440, 72, 121, 21);
		internalFrame.getContentPane().add(comboBox_3);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Score score=new Score();
				score.setScoreId((String)StudentQuery.stuQuery(textField_1.getText())[0]);
				score.setScoSubject((String)comboBox_3.getSelectedItem());
				float i=Float.parseFloat(textField_2.getText());
				score.setScore(i);
				if(ScoreCrud.add(score)!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"添加成功", "提示", JOptionPane.INFORMATION_MESSAGE);
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
		internalFrame2 = new JInternalFrame("删除学生成绩");
		internalFrame2.setResizable(true);
		internalFrame2.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame2);
		internalFrame2.getContentPane().setLayout(null);
		
		JLabel label_8 = new JLabel("请输入你要删除成绩所属学生姓名");
		label_8.setBounds(52, 97, 185, 37);
		internalFrame2.getContentPane().add(label_8);
		
		textField_4 = new JTextField();
		textField_4.setBounds(247, 101, 149, 29);
		internalFrame2.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_9 = new JLabel("请输入你要删除的成绩所属科目");
		label_9.setBounds(52, 169, 185, 37);
		internalFrame2.getContentPane().add(label_9);
		
		JComboBox<String> comboBox8 = new JComboBox<>();
		for(int i=0;i<10;i++) {
			if(StudentQuery.selfSubject()[i]!=null) {
				comboBox8.addItem((String)StudentQuery.selfSubject()[i]);
			}
			else
				break;
		}
		comboBox8.setBounds(247, 173, 149, 29);
		internalFrame2.getContentPane().add(comboBox8);
		
		JButton btnNewButton1 = new JButton("确定");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ScoreCrud.delete(textField_4.getText(),(String)comboBox8.getSelectedItem())!=0) {
					JOptionPane.showMessageDialog(new JFrame(),"删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
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
		internalFrame3 = new JInternalFrame("修改成绩");
		internalFrame3.setResizable(true);
		internalFrame3.setBounds(10, 39, 704, 372);
		contentPane.add(internalFrame3);
		internalFrame3.getContentPane().setLayout(null);
		
		JLabel label_10 = new JLabel("请输入你要修改学生姓名");
		label_10.setBounds(10, 10, 182, 37);
		internalFrame3.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("科目");
		label_11.setBounds(10, 77, 54, 26);
		internalFrame3.getContentPane().add(label_11);
		
		JComboBox<String> comboBox10 = new JComboBox<>();
		comboBox10.setBounds(202, 78, 93, 24);
		for(int i=0;i<10;i++) {
			if(StudentQuery.selfSubject()[i]!=null) {
				comboBox10.addItem((String)StudentQuery.selfSubject()[i]);
			}
			else
				break;
		}
		internalFrame3.getContentPane().add(comboBox10);
		
		textField = new JTextField();
		textField.setBounds(202, 18, 102, 21);
		internalFrame3.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label0 = new JLabel("修改的成绩");
		label0.setBounds(10, 168, 113, 31);
		internalFrame3.getContentPane().add(label0);
		label0.setVisible(false);
		
		textField7= new JTextField();
		textField7.setBounds(144, 173, 102, 21);
		internalFrame3.getContentPane().add(textField7);
		textField7.setColumns(10);
		textField7.setVisible(false);
		
		JButton btnNewButton2 = new JButton("确定");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					btnNewButton3.setVisible(true);
					label0.setVisible(true);
					textField7.setVisible(true);
			}
		});
		btnNewButton2.setBounds(369, 72, 93, 37);
		internalFrame3.getContentPane().add(btnNewButton2);
		
		btnNewButton3 = new JButton("确定修改");
		btnNewButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Score score=new Score();
				score.setScoreId((String)StudentQuery.stuQuery(textField.getText())[0]);
				score.setScoSubject((String)comboBox10.getSelectedItem());
				float i=Float.parseFloat(textField7.getText());
				score.setScore(i);
				if(ScoreCrud.update(score)!=0) {
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

