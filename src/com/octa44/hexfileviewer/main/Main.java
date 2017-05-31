package com.octa44.hexfileviewer.main;

import javax.swing.UIManager;

public class Main {

	public static void main(String[] args) {

		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Look and feel not supported");
			e.printStackTrace();
			System.exit(1);

		}

		MainWindow mw = new MainWindow();
		mw.setVisible(true);

	}

}
