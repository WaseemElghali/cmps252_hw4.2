package asst4;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.*;

import org.junit.jupiter.api.Test;

class FileParserTest {

	@Test
	void testGetCustomers() throws FileNotFoundException {
		FileParser p = new FileParser("5000.csv");
		ArrayList<Customer> customers = p.getCustomers();
		assertEquals("Portia", customers.get(0).getFirstName());
		assertEquals("Mcfann", customers.get(0).getLastName());
		assertEquals("Beachcomber Realty", customers.get(0).getCompany());
		assertEquals("4891 Pacific Hwy", customers.get(0).getAddress());
		assertEquals("San Diego", customers.get(0).getCity());
		assertEquals("San Diego", customers.get(0).getCounty());
		assertEquals("CA", customers.get(0).getState());
		assertEquals("92110", customers.get(0).getZIP());
		assertEquals("858-294-0682", customers.get(0).getPhone());
		assertEquals("858-294-1695", customers.get(0).getFax());
		assertEquals("portia@mcfann.com", customers.get(0).getEmail());
		assertEquals("http://www.portiamcfann.com", customers.get(0).getWeb());

	}

}
