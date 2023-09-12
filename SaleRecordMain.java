import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SaleRecordMain {
	
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("CSV File Name: ");
		String path = userInput.next();
		
		//String path = "car_sales_data.csv";
		long start = System.currentTimeMillis();
		ArrayList<SaleRecord> pathArray = storeArray(path);
		long stop = System.currentTimeMillis();
		
		//Converting milliseconds to seconds
		System.out.println((stop-start)/1000 + " seconds to read the file.");
		
		//resetting timer to use for averageSalePrice
		start = System.currentTimeMillis();
		double avg = averageSalePrice(pathArray);
		stop = System.currentTimeMillis();
		System.out.println((stop-start)/1000 + " seconds to calculate average sale price in 2022.");
		System.out.println("The average Sale Price in 2022: " + avg);
		
		//resetting timer to use for maxComRate
		start = System.currentTimeMillis();
		double mcr = maxComRate(pathArray);
		stop = System.currentTimeMillis();
		System.out.println((stop-start)/1000 + " seconds to find maximum commission rate");
		System.out.println("The maximum commission rate: " + mcr);
		
		//resetting timer to use for soldHonda
		start = System.currentTimeMillis();
		int honda = soldHonda(pathArray);
		stop = System.currentTimeMillis();
		System.out.println((stop-start)/1000 + " seconds to find the number of sales records for Honda");
		System.out.println("The number of cars sold with car make Honda: " + honda);
		
		//resetting timer to use for twoYearsUse
//		start = System.currentTimeMillis();
//		int twoYears = twoYearsUse(pathArray);
//		stop = System.currentTimeMillis();
//		System.out.println((stop-start)/1000 + " seconds to find the number of sales records for cars" +
//		" used for maximum of two years.");
//		System.out.println("Number of cars sold with 2 years of usage: " + twoYears);
		
	}

	/**
	 * Reads a csv file and stores the information in an arraylist 
	 * @param path the csv file to be read
	 * @return saleRecords the array list of SaleRecord objects created from 
	 * the csv file information
	 */
	public static ArrayList<SaleRecord> storeArray(String path) {
		String line = "";
		ArrayList<SaleRecord> saleRecords = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			//skipping the first line of headers
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] wordRead = line.split(",");
				saleRecords.add(new SaleRecord(wordRead[0], wordRead[1], wordRead[2], wordRead[3], wordRead[4], wordRead[5], wordRead[6], wordRead[7], wordRead[8]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saleRecords;
	}
	
	/** 
	 * Calculates the average sale price of the cars sold in the year 2022
	 * @param salesRecord the array list to assess
	 * @return average the average sale price of the cars sold in the year 2022
	 */
	public static double averageSalePrice(ArrayList<SaleRecord> salesRecord) {
		int total = 0;
		int count = 0;
		
		for (int i = 0; i < salesRecord.size(); i++) {
			if (salesRecord.get(i).getYear()==2022) {
				total+=salesRecord.get(i).getSalePrice();
				count+=1;
			}
		}
		double average = (total/count);
		return average;
	}
	
	/**
	 * Determines the maximum commission rate in a SaleRecord array list
	 * @param salesRecord the array list to assess
	 * @return max the maximum commission rate in the SaleRecord array list
	 */
	public static double maxComRate(ArrayList<SaleRecord> salesRecord) {
		double max = 0.0;
		
		for (int i = 0; i < salesRecord.size(); i++) {
			if (salesRecord.get(i).getCommissionRate() > max) {
				max = salesRecord.get(i).getCommissionRate();
			}
		}
		return max;
	}
	
	/**
	 * Determines the number of Hondas sold in a SaleRecord array list
	 * @param salesRecord the array list to assess
	 * @return count the number of Hondas sold in the SaleRecord array list
	 */
	public static int soldHonda(ArrayList<SaleRecord> salesRecord) {
		int count = 0;
		
		for (int i = 0; i < salesRecord.size(); i++) {
			if (salesRecord.get(i).getCarMake().equalsIgnoreCase("Honda")) {
				count+=1;
			}
		}
		return count;
	}
	
	/**
	 * Determines the number of cars sold with 2 years of usage
	 * @param salesRecord the array list to assess
	 * @return twoYears the number of cars sold with 2 years of usage
	 */
	public static int twoYearsUse(ArrayList<SaleRecord> salesRecord) {
		int twoYears = 0;
		for (int i = 0; i < salesRecord.size(); i++) {
			if (salesRecord.get(i).getYear()-salesRecord.get(i).getCarYear() <= 2) {
				twoYears+=1;
			}
		}
		return twoYears;
	}

}
