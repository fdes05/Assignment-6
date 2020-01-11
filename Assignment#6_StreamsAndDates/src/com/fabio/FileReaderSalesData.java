package com.fabio;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileReaderSalesData {

	
	public List<MonthlySalesDataPOJO> fileReaderInput(String fileName) throws IOException {
	
		List<MonthlySalesDataPOJO> listSalesData = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("LLL-YY");
		
		BufferedReader fileReader = null;
		String[] fileInput = null;
				
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
			
			String line = "";
			
			while ((line = fileReader.readLine()) != null) {
	
				fileInput = line.split(",");
				if (fileInput[0].equals("Date")) {
					
				}else {
					String salesDate = fileInput[0];
					String salesNumber = fileInput[1];
																				
					YearMonth salesDateParsed = YearMonth.parse(salesDate, formatter);
					Integer salesNumberParsed = Integer.parseInt(salesNumber);					
										
					MonthlySalesDataPOJO salesDataObject = new MonthlySalesDataPOJO(salesDateParsed,salesNumberParsed);
					
					listSalesData.add(salesDataObject);
				}
				
			}
			
		}catch(FileNotFoundException e){
			System.out.println("File was not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		return listSalesData;
		
		}
}
