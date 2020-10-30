package Comparators;

import java.util.*;
import cmps252.HW4_2.Customer;

public class ZIPComparator implements Comparator<Customer> {

	@Override
	public int compare(Customer arg0, Customer arg1) {
		return arg0.getZIP().compareTo(arg1.getZIP());
	}

}
