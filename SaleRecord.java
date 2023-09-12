import java.util.Scanner;
import java.io.Reader;

public class SaleRecord {
	private String date;
	private String salesPerson;
	private String customerName;
	private String carMake;
	private String carModel;
	private int carYear;
	private int salePrice;
	private double commissionRate;
	private double commissionEarned;
	
	/**
	 * Constructor for the SaleRecord class; initializes the 
	 * variables for the date, the sales person, the customer name, the car make,
	 * the car model, the car year, the sale price, the price of the commission
	 * rate and the price of the commission earned
	 * @param date the date of the purchase
	 * @param salesPerson the sales person in charge of the sale
	 * @param customerName the name of the customer purchasing the car
	 * @param carMake the make of the car sold
	 * @param carModel the model of the car sold
	 * @param carYear the year of the car that was sold
	 * @param salePrice the price of the car sold
	 * @param commissionRate the commission rate at which the car was sold
	 * @param commissionEarned the commission earned from the sale of the car
	 */
	public SaleRecord(String date, String salesPerson, String customerName, String carMake, String carModel, String carYear, String salePrice, String commissionRate, String commissionEarned) {
		this.date = date;
		this.salesPerson = salesPerson;
		this.customerName = customerName;
		this.carMake = carMake;
		this.carModel = carModel;
		this.carYear = Integer.parseInt(carYear);
		this.salePrice = Integer.parseInt(salePrice);
		this.commissionRate = Double.parseDouble(commissionRate);
		this.commissionEarned = Double.parseDouble(commissionEarned);
	}
	
	/**
	 * Default constructor for the SaleRecord class; initializes
	 * the variables for the default date, sales person, customer name, 
	 * car make, car model, car year, sale price, commission rate, and 
	 * commission earned
	 */
	public SaleRecord() {
		date = "No date";
		salesPerson = "No sales person";
		customerName = "No customer";
		carMake = "No car make";
		carModel = "No car model";
		carYear = 0;
		salePrice = 0;
		commissionRate = 0;
		commissionEarned = 0;
		
	}
	
	public String getDate() {
		return date;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getCarMake() {
		return carMake;
	}
	public String getCarModel() {
		return carModel;
	}
	public int getCarYear() {
		return carYear;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public double getCommissionRate() {
		return commissionRate;
	}
	public double getCommissionEarned() {
		return commissionEarned;
	}
	
	/**
	 * Determines the year of the car sale
	 * @return year the year of the car sale
	 */
	public int getYear() {
		Scanner sc = new Scanner(date);
		sc.useDelimiter("-");
		int year = sc.nextInt();
		return year;
	}
	
//	public void deBug() {
//		System.out.println(date + " " + salesPerson + " " + customerName + " " + carMake + " " +
//				carModel + " " + carYear + " " + salePrice + " " + commissionRate + " " + commissionEarned);
//	}
	
	@Override
	/**
	 * Converts the sale record information to a String suitable for text-view
	 * @return a String with the sale record information for the date, sales person, 
	 * customer name, car make, car model, car year, sale price, commission rate, 
	 * and commission earned
	 */
	public String toString() {
		return (getDate() + ", " + getSalesPerson() + ", " + getCustomerName() + ", " + 
	            getCarMake() + ", " + getCarModel() + ", " + getCarYear() + ", " + getSalePrice() + ", " +
				getCommissionRate() + ", " + getCommissionEarned());
	}

}
