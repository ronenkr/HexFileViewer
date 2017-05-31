package com.octa44.hexfileviewer.utils;

import java.awt.Font;

public class FontUtils {

	private static Font fMonospaced;
	
	public static Font getMonospacedFont(){
		if(fMonospaced == null){
			fMonospaced =new Font("Courier New",Font.BOLD,14); 
		}
		return fMonospaced;
	}
}
