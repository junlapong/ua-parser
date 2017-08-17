package com.bay.useragent.app;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ua_parser.Client;
import ua_parser.Parser;

public class ReportUtils {

	private static final String FILENAME = "D:\\file_log\\master_log.log";

	public static void main(String[] args) {
		BufferedReader br = null;
		FileReader fr = null;

		try {

			br = new BufferedReader(new FileReader(FILENAME));
			String line;
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Java Books");
			String[] temp;
			String[] temp1;
			String[] temp2;
			int rowCount = 0;
			Row head = sheet.createRow(0);
			Cell column = head.createCell(0);
			column.setCellValue((String) "Date Time");
			Cell column1 = head.createCell(1);
			column1.setCellValue((String) "Device");
			Cell column2 = head.createCell(2);
			column2.setCellValue((String) "UA family");
			Cell column3 = head.createCell(3);
			column3.setCellValue((String) "UA major");
			Cell column4 = head.createCell(4);
			column4.setCellValue((String) "UA minor");
			Cell column5 = head.createCell(5);
			column5.setCellValue((String) "OS family");
			Cell column6 = head.createCell(6);
			column6.setCellValue((String) "OS major");
			Cell column7 = head.createCell(7);
			column7.setCellValue((String) "OS minor");
			
			while ((line = br.readLine()) != null) {
				if (line.indexOf("page=directDebitLogin,") >= 0) {
					try {
						temp = line.split("SystemOut");
						temp1 = temp[1].split("user-agent=");
						temp2 = temp1[1].split(",referer=");
						Parser uaParser = new Parser();
						Client c = uaParser.parse(temp2[0]);
						
						String[] contents = {temp[0],c.device.family , c.userAgent.family 
								,c.userAgent.major ,c.userAgent.minor,c.os.family 
								, c.os.major , c.os.minor};
						
						Row row = sheet.createRow(++rowCount);
						int cellCount = 0;
						for(String content : contents) {
							Cell cell = row.createCell(cellCount++);
							if (content instanceof String) {
								cell.setCellValue((String) content);
							}	
						}	
					}catch (Exception e) {
						System.out.println( "line error : " + line);
						e.printStackTrace();
						continue;
					}

				}
			}
			try (FileOutputStream outputStream = new FileOutputStream("D:\\file_log\\data_agent.xlsx")) {
				workbook.write(outputStream);
				workbook.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
	}

}
