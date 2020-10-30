package Comparators;
import java.util.Comparator;
import cmps252.HW4_2.Customer;
public class StateComparator implements Comparator<Customer>{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(Customer arg0, Customer arg1) {
		return arg0.getState().compareTo(arg1.getState());
	}

}
