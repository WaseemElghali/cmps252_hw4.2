package Comparators;
import cmps252.HW4_2.Customer;
import java.util.*;
public class CityComparator implements Comparator<Customer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(Customer arg0, Customer arg1) {
		return arg0.getCity().compareTo(arg1.getCity());
	}

}
