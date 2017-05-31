package com.octa44.hexfileviewer.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.octa44.hexfileviewer.data.HexLine;

import javax.swing.JScrollPane;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2706452145878275225L;
	private JTextField tfFileName;
	
	private JList lstLines;

	public MainWindow(){
		setSize(1024, 768);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
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
		
		
		
		lstLines = new JList();
		lstLines.setModel(new DefaultListModel<HexLine>());
		lstLines.setCellRenderer(new HexLineRenderer());
		
		JScrollPane scrollPane = new JScrollPane(lstLines);
		scrollPane.setPreferredSize(new Dimension(380, 100));
		panel.add(scrollPane, BorderLayout.WEST);
		
		
		JMenuBar jmb = new JMenuBar();
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiFile = new JMenuItem("Open File");
		jmiFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(1==1){
					try {
						loadFile("C:\\temp\\4\\Explorer16PIC32MX_1.X.production.hex");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
				
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Select a HEX file");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("HEX Files", "hex");
				jfc.addChoosableFileFilter(filter);
				
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					String strFileName = jfc.getSelectedFile().getPath();
					System.out.println("Opening: "+strFileName);
					try {
						loadFile(strFileName);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(MainWindow.this, "Error Loading File: "+strFileName+"\r\n"+e.getMessage());
						e.printStackTrace();
					}
					
					
				}
				}
			}
		});
		
		jmFile.add(jmiFile);
		jmb.add(jmFile);
		
		this.setJMenuBar(jmb);
		
	}
	
	
	private void loadFile(String strFilePath) throws Exception{

		FileReader fileReader = new FileReader(strFilePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			((DefaultListModel<HexLine>)lstLines.getModel()).addElement(new HexLine(line.substring(1))); //Skip the column in the beginning
		}
		fileReader.close();
		lstLines.repaint();
	}
	
}
