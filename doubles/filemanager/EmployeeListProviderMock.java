package filemanager;

import java.util.List;

import greeter.Employee;
import greeter.EmployeeListProvider;

public class EmployeeListProviderMock implements EmployeeListProvider {
	private List<Employee> employees;
	
	public EmployeeListProviderMock(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public List<Employee> getEmployeeList() {
		return employees;
	}
}
