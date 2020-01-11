package com.fabio;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class TeslaSalesReportApplication {

	public static void main(String[] args) throws IOException {
		
		FileReaderSalesData fileReader = new FileReaderSalesData();
		
		List<MonthlySalesDataPOJO> model3 = fileReader.fileReaderInput("model3.csv");
		
		model3.stream()
			  .forEach(line -> System.out.println(line));
		      
	}
	
}
