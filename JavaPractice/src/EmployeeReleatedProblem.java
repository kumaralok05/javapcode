import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeReleatedProblem {

	public static void main(String[] args) {
		// i have a list of employee i have to print empoyee based on city
		 List<Employee> employees = Arrays.asList(
		            new Employee("Amit", "Bangalore","Developer",100.00),
		            new Employee("Raj", "Mumbai","Developer",1000.00),
		            new Employee("Sneha", "Bangalore","HR",200000.00),
		            new Employee("Vikram", "Delhi","IT",300.00),
		            new Employee("Neha", "Bangalore","Finance",400.00)
		        );
		 
		 Map<String, List<Employee>> empMap=employees.stream().
				 collect(Collectors.groupingBy(Employee::getCity));
		 empMap.forEach((key, value) -> 
         System.out.println("City: " + key + ", Employees: " + value)
     );
		 // List of Employee who staying in Bnagalore
		List<String> bangaloreEmployee= employees.stream().filter(e ->"Bangalore".equalsIgnoreCase(e.getCity())).map(Employee::getName).
				 collect(Collectors.toList());
		bangaloreEmployee.forEach(System.out::println);
		 

	}
	 public static class Employee {
		 public String Name;
		 public String City;
		 public String Department;
		 public Double Salary;
		public String getName() {
			return Name;
		}
		public String getCity() {
			return City;
		}
		public String getDepartment() {
			return Department;
		}
		public Double getSalary() {
			return Salary;
		}
		public Employee(String name, String city, String department, Double salary) {
			this.Name = name;
			this.City = city;
			this.Department = department;
			this.Salary = salary;
		}
		@Override
		public String toString() {
			return Name;
		}
		
		  
		 
		
	}
	
		
	}
