package Comparators;
import cmps252.HW4_2.Customer;
import java.util.*;
public class AddressComparator implements Comparator<Customer> {

	public static void main(String[] args) {

	}

	@Override
	public int compare(Customer arg0, Customer arg1) {
		return arg0.getAddress().compareTo(arg1.getAddress());
	}

}
