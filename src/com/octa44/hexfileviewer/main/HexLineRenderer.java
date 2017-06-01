package com.octa44.hexfileviewer.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

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
	
	private Color backColor = Color.WHITE;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3525467230074919344L;

	
	public HexLineRenderer(){
		setLayout(null);
		setBorder(null);
		setPreferredSize(new Dimension(356, 16));
		setMinimumSize(new Dimension(356, 16));
		
		dataBytes = new JLabel("XX");
		dataBytes.setForeground(Color.BLUE);
		dataBytes.setFont(FontUtils.getMonospacedFont());
		dataBytes.setBounds(0, 0, 16, 16);
		//dataBytes.setBorder(null);
		this.add(dataBytes);
		
		dataAddress = new JLabel("AAAA");
		dataAddress.setForeground(Color.MAGENTA);
		dataAddress.setFont(FontUtils.getMonospacedFont());
		dataAddress.setBounds(20, 0, 32, 16);
		
		this.add(dataAddress);
		
		recordType = new JLabel("TT");
		recordType.setForeground(Color.RED);
		recordType.setFont(FontUtils.getMonospacedFont());
		recordType.setBounds(56, 0, 16, 16);

		this.add(recordType);
		
		
		data = new JLabel("DDDDDD");
		data.setForeground(Color.DARK_GRAY);
		data.setFont(FontUtils.getMonospacedFont());
		data.setBounds(78, 0, 256, 16);

		this.add(data);
		
		checksum = new JLabel("CC");
		checksum.setForeground(Color.orange.darker());
		checksum.setFont(FontUtils.getMonospacedFont());
		checksum.setBounds(338, 0, 16, 16);

		this.add(checksum);
		
		this.setBackground(backColor);
		
	}
	
	@Override
	public Component getListCellRendererComponent(JList<? extends HexLine> list, HexLine dataLine, int index, boolean isSelected,
			boolean cellHasFocus) {
		dataBytes.setText(dataLine.getDataBytes());
		dataAddress.setText(dataLine.getDataAddress());
		recordType.setText(dataLine.getRecordType());
		data.setText(dataLine.getData());
		checksum.setText(dataLine.getChecksum());
		
		switch(dataLine.getRecordType()){
		case "00":{
			backColor = Color.white;
			break;
		}
		
		case "01":{
			backColor = Color.RED.brighter();
			break;
		}
		
		case "02":{
			backColor = Color.green.brighter().brighter();
			break;
		}
		
		case "04":{
			backColor = Color.PINK.brighter();
			break;
		}
		}
		
		if(isSelected){
			setBackground(Color.LIGHT_GRAY);
		}else{
			setBackground(backColor);
		}
		
		return this;
	}

}
