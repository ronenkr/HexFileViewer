package com.octa44.hexfileviewer.data;

public class HexLine {
	private String dataBytes;
	private String dataAddress;
	private String recordType;
	private String data;
	private String checksum;
	
	//The hex line format is :NNAAAATTXXXXXXXXXCC
	//NN - Number of bytes
	//AAAA - lower address
	//TT - REcord type
	//XXXXX NN size data
	//CC - Checksum
	
	public HexLine(String dataLine){
		dataBytes = dataLine.substring(0,2).toUpperCase();
		dataAddress = dataLine.substring(2,6).toUpperCase();
		recordType = dataLine.substring(6,8).toUpperCase();
		data = dataLine.substring(8, dataLine.length()-2).toUpperCase();
		checksum = dataLine.substring(dataLine.length()-2).toUpperCase();
	}


	public String getDataBytes() {
		return dataBytes;
	}


	public String getDataAddress() {
		return dataAddress;
	}


	public String getRecordType() {
		return recordType;
	}


	public String getData() {
		return data;
	}


	public String getChecksum() {
		return checksum;
	}
	
	
}
