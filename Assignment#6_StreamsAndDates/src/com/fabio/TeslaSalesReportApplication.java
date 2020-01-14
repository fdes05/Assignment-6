package com.fabio;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeslaSalesReportApplication {

	public static void main(String[] args) throws IOException {
		
		FileReaderSalesData fileReader = new FileReaderSalesData();
		
		List<MonthlySalesDataPOJO> model3List = fileReader.fileReaderInput("model3.csv");
		
		
		Integer model3Sales2017 = model3List.stream()
											.filter(b -> b.getDate().getYear() == 2017)
											.collect(Collectors.summingInt(b -> b.getSalesNumber()));
		Integer model3Sales2018 = model3List.stream()
											.filter(b -> b.getDate().getYear() == 2018)
											.collect(Collectors.summingInt(b -> b.getSalesNumber()));		 
		
		Integer model3Sales2019 = model3List.stream()
											.filter(b -> b.getDate().getYear() == 2019)
											.collect(Collectors.summingInt(b -> b.getSalesNumber()));
		
		System.out.println("Model 3 Yearly Sales 2017 -> " + model3Sales2017); 
		System.out.println("Model 3 Yearly Sales 2018 -> " + model3Sales2018);
		System.out.println("Model 3 Yearly Sales 2019 -> " + model3Sales2019); 
		 										
				  											
		Integer maxSales = model3List.stream()
									  .map(o -> o.getSalesNumber())
									  .max(Integer::compare).get();
						
		List<Boolean> maxSalesObject = model3List.stream()
													    .map(o -> o.getClass().equals(maxSales))
													    .collect(Collectors.toList());
		
		System.out.println("the maximum number of Models 3 sold in a one month period is " + maxSales);
		System.out.println(maxSalesObject);
	}
	
}
