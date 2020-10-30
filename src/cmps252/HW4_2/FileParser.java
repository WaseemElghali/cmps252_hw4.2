package cmps252.HW4_2;
import java.io.*;
import java.util.*;
public class FileParser {
	private static ArrayList<Customer> Customers;

	public static ArrayList<Customer> getCustomers(String filename) throws FileNotFoundException{ // returns an array of Customer objects
		String[][] records = new String[5000][12]; // creates an empty two-dimensional array
		Scanner read = new Scanner(new File(filename));
		read.nextLine(); // skips the first line because it has the headings
		for(int i = 0; i<5000; i++) {
			records[i] = (read.nextLine()).split("\",\""); // populates the array with arrays for every line (customer)
			}
		ArrayList<Customer> customers = new ArrayList<Customer>(); // creates an array for Customer objects
		for(String[] record : records) { // loops through the 2D array
			customers.add(new Customer(record[0].substring(1, record[0].length()),record[1],record[2],record[3],record[4],record[5],record[6],record[7],record[8],record[9],record[10],record[11].substring(0, record[11].length()-1))); // populates the array with customer objects with the appropriate strings as parameters);
		}
		FileParser.Customers = customers;
		return Customers;
	}
	
	

}

