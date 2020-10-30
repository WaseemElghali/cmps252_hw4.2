package Comparators;
import java.util.*;
import cmps252.HW4_2.Customer;
public class CompanyComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer arg0, Customer arg1) {
		return arg0.getCompany().compareTo(arg1.getCompany());
	}

}
