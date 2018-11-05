package com.LiangZhenJi.www.service;

import java.awt.EventQueue;

import com.LiangZhenJi.www.view.LoginView;


public class Main {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 LoginView lv = new  LoginView();
					lv.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
