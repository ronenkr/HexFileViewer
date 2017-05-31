package com.octa44.hexfileviewer.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2706452145878275225L;
	private JTextField tfFileName;

	public MainWindow(){
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JList lstLines = new JList();
		lstLines.setModel(new AbstractListModel() {
			String[] values = new String[] {"aaaa", "bbbb", "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(lstLines, BorderLayout.WEST);
		
		JList lstHexView = new JList();
		panel.add(lstHexView, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Opened File:");
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		
		tfFileName = new JTextField();
		panel_1.add(tfFileName, BorderLayout.SOUTH);
		tfFileName.setColumns(10);
		
		
		
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiFile = new JMenuItem("Open File");
		jmiFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Select a HEX file");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("HEX Files", "hex");
				jfc.addChoosableFileFilter(filter);
				
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					System.out.println("Opening: "+jfc.getSelectedFile().getPath());
					
				}
			}
		});
		
		jmFile.add(jmiFile);
		jmb.add(jmFile);
		
		this.setJMenuBar(jmb);
		
	}
}
