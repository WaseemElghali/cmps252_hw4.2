package Comparators;
import java.util.Comparator;
import cmps252.HW4_2.Customer;
public class LastNameComparator implements Comparator<Customer>{
	@Override
	public int compare(Customer arg0, Customer arg1) {
		return arg0.getLastName().compareTo(arg1.getLastName());
	}

}
