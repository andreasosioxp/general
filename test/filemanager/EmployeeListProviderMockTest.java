package filemanager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import filemanager.EmployeeListProviderMock;
import greeter.Employee;
import greeter.EmployeeListProvider;

public class EmployeeListProviderMockTest {

	@Test
	public void getEmployeeListReturnsCustomList() {
		List<Employee> anyList = new ArrayList<Employee>();
		EmployeeListProvider providerMock = new EmployeeListProviderMock(anyList);
		assertEquals(anyList, providerMock.getEmployeeList());
	}

}
