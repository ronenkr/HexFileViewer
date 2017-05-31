package com.octa44.hexfileviewer.main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

import com.octa44.hexfileviewer.data.HexLine;
import com.octa44.hexfileviewer.utils.FontUtils;

public class HexLineRenderer extends JPanel implements ListCellRenderer<HexLine>{

	private JLabel dataBytes;
	private JLabel dataAddress;
	private JLabel recordType;
	private JLabel data;
	private JLabel checksum;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3525467230074919344L;

	
	public HexLineRenderer(){
		setLayout(null);
		dataBytes = new JLabel();
		dataBytes.setForeground(Color.BLUE);
		dataBytes.setFont(FontUtils.getMonospacedFont());
		dataBytes.setBounds(0, 0, 16, 25);
		this.add(dataBytes);
		
		
		
		
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends HexLine> list, HexLine dataLine, int index, boolean isSelected,
			boolean cellHasFocus) {
		dataBytes.setText(dataLine.getDataBytes());
		return this;
	}

}
