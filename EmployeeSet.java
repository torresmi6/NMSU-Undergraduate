import java.io.*;
public class EmployeeSet {
	
	int capacity;
	int employeeCount;
	Employee[] set1 = null;
	
	// no-argument constructor; no parameters or return. Creates array size 10
	public EmployeeSet() {
		capacity = 10;
		employeeCount = 0;
		set1 = new Employee[10];
	}
	
	// copy constructor; no return, parameter of an object of same class. Copies array contents
	// @precondition argument must not be null and must be an instance of the same class
	public EmployeeSet(Object obj) {
		if(obj != null && obj instanceof EmployeeSet) {
			EmployeeSet setCopy = (EmployeeSet) obj;
			this.capacity = setCopy.capacity;
			this.employeeCount = setCopy.employeeCount;
			this.set1 = new Employee[this.capacity];
			for(int i = 0; i < this.capacity; i++) {
				this.set1[i] = setCopy.set1[i];
			}
		}
	}
	
	// returns employeeCount variable. No parameters.
	public int size() {
		return employeeCount;
		
	}
	
	// returns capacity variable. No parameters.
	public int capacity() {
		return capacity;
	}
	
	// Adds an Employee to the employee array. If the array capacity is too small, doubles the size.
	// no return, parameter of an Employee instance
	// @precondition Employee must not be null
	public void add(Employee a) {
		if(a != null) {
			if(employeeCount < capacity) {
				for(int i = 0; i < capacity; i++) {
				
					if(set1[i] != null && a.number == set1[i].number && set1[i].number != 0) {
						return;
					}
					if(set1[i] == null) {
						set1[i] = a;
						employeeCount++;
						return;
					}
				}
				
			}
		else {
			ensureCapacity(capacity * 2);
			
			for(int i = 0; i < capacity; i++) {
				
				if(set1[i] != null && a.number == set1[i].number && a.number != 0) {
					return;
				}
				if(set1[i] == null) {
					set1[i] = a;
					employeeCount++;
					return;
				}
			}

		}
		}
		
	}
	
	// Checks if the employee set contains the given employee
	// returns a boolean; true if it does contain it, false if not
	// parameter of an Employee
	// No precondition
	public boolean contains(Employee a) {
		if(a == null) {
			return false;
		}
		else {
			for(int i = 0; i < capacity; i++) {
				if(set1[i] == a) {
					return true;
				}
			}
			return false;	
		}
	}
	
	// removes the employee with the given employee number from the collection
	// returns a booleans that tells if something was removed or not
	// parameter of an int employee number
	// no precondition
	public boolean remove(int eno) {
		for(int i = 0; i < capacity; i++) {
			if(set1[i] != null && set1[i].number == eno) {
				set1[i] = null;
				return true;
			}
		}
		return false;
	}
	
	// Checks if the current capacity is smaller than the given wanted minimum capacity
	// If true, it doubles the size of the array and copies everything from the original array
	// no return; parameter of an int minimum capacity
	// @precondition input minimumCapacity should be positive
	public void ensureCapacity(int minimumCapacity) {
		
		if(minimumCapacity > 0 && capacity < minimumCapacity) {
			Employee[] temp = new Employee[minimumCapacity];
			
			
			for(int i = 0; i < capacity; i++) {
				temp[i] = set1[i];
			}
			capacity = minimumCapacity;
			set1 = temp;
		}
	}
	
	// Adds the input Employee into the collection after ordering the array in ascending employee numbers
	// no return; parameter of an Employee object
	// @precondition Employee object must not be null and the collection must already be ordered to add it
	public void addOrdered(Employee a) {
		int tempNum = 0;
		boolean ordered = false;
		
		for (int i = 0; i < capacity; i++) {
		    for (int j = i; j > 0; j--) {
		    	if(set1[j] != null && set1[j-1] != null) {
		    		if (set1[j].number < set1[j-1].number) {
		    			tempNum = set1[j].number;
		    			set1[j].number = set1[j-1].number;
		    			set1[j-1].number = tempNum;
		    		}
		    	}
		    }
		   }
		
		ordered = true;
		
		if(a != null && ordered == true) {
			if(employeeCount < capacity) {
				for(int i = 0; i < capacity; i++) {
					if(set1[i] != null) {
						if(a.number < set1[i].number) {
							for(int b = capacity-1; b > i; b--) {
								set1[b] = set1[b-1];
							}
							set1[i] = a;
							employeeCount++;
							break;
						}
					}
				}
			}
			else {
				ensureCapacity(capacity*2);
				for(int i = 0; i < capacity; i++) {
					if(a.number < set1[i].number) {
						for(int b = capacity; b < i; b--) {
							set1[b] = set1[b-1];
						}
						set1[i] = a;
						employeeCount++;
						break;
					}
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		Employee emp1 = new Employee();
		emp1.setNum(1234);
		Employee emp2 = new Employee();
		emp2.setNum(2468);
		Employee emp3 = new Employee();
		emp3.setNum(1234);
		
		Employee emp4 = new Employee();
		emp4.setNum(1235);
		Employee emp5 = new Employee();
		emp5.setNum(1236);
		Employee emp6 = new Employee();
		emp6.setNum(1237);
		Employee emp7 = new Employee();
		emp7.setNum(1238);
		Employee emp8 = new Employee();
		emp8.setNum(1239);
		Employee emp9 = new Employee();
		emp9.setNum(2234);
		Employee emp10 = new Employee();
		emp10.setNum(3234);
		Employee emp11 = new Employee();
		emp11.setNum(4234);
		Employee emp12 = new Employee();
		emp12.setNum(5234);
		Employee emp13 = new Employee();
		emp13.setNum(3235);
		
		// Test Case 1
		// Tests to make sure the no argument constructor makes a 10 capacity array
		System.out.println("Test Case 1");
		EmployeeSet empSet = new EmployeeSet();
		System.out.println(empSet.capacity());

		
		// Test Case 2
		// Tests that the size when the collection is new, is 0
		System.out.println("Test Case 2");
		System.out.println(empSet.size());

		
		// Test Case 3
		// Tests that the add method works when the capacity is big enough and if the 
		// contains method returns true
		System.out.println("Test Case 3");
		empSet.add(emp1);
		System.out.println(empSet.contains(emp1));

		
		// Test Case 4
		// Tests that the add method fails when the employee number is the same as one already
		// in the collection
		System.out.println("Test Case 4");
		empSet.add(emp3);
		System.out.println(empSet.contains(emp3));
		
		// Test Case 5
		// Tests that the add method uses ensureCapacity to double the array size when
		// adding an Employee outside of the capacity.
		// contains emp12 should be true, capacity should equal 20, and employee count should be 11
		System.out.println("Test Case 5");
		empSet.add(emp2);
		empSet.add(emp4);
		empSet.add(emp5);
		empSet.add(emp6);
		empSet.add(emp7);
		empSet.add(emp8);
		empSet.add(emp9);
		empSet.add(emp10);
		empSet.add(emp11);
		empSet.add(emp12);
		System.out.println(empSet.contains(emp12));
		System.out.println(empSet.capacity());
		System.out.println(empSet.size());
		
		// Test Case 6
		// Tests if remove works when the employee number is found in the set
		// remove should return true, and emp1 should no longer be in the set
		System.out.println("Test Case 6");
		System.out.println(empSet.remove(1234));
		System.out.println(empSet.contains(emp1));
		
		
		// Test Case 7
		// Tests if remove fails when the employee number is not found in the set
		// should print false
		System.out.println("Test Case 7");
		System.out.println(empSet.remove(1111));

		
		// Test Case 8
		// Tests if addOrdered correctly orders the collection and adds the new employee
		System.out.println("Test Case 8");
		empSet.addOrdered(emp13);
		for(int i = 0; i < empSet.employeeCount; i++) {
			if(empSet.set1[i] != null) {
			System.out.println(empSet.set1[i].number);
			}
		}
		
		// Test Case 9 
		// Tests if the copy constructor copies all contents correctly
		System.out.println("Test Case 9");
		EmployeeSet empSet2 = new EmployeeSet(empSet);
		for(int i = 0; i < empSet2.employeeCount; i++) {
			if(empSet2.set1[i] != null) {
			System.out.println(empSet2.set1[i].number);
			}
		}
		
		// Test Case 10 
		// Tests if this collection can read a file and import those employees into the array
		// Should print the capacity: 320, employeeCount: 300, the first 5 employee names and their numbers
		EmployeeSet empSet3 = new EmployeeSet();
		String line = "";
		String comma = ",";
		int count = 1;
		try {
			FileReader fReader = new FileReader("core_dataset.csv");
			BufferedReader bReader = new BufferedReader(fReader);
			
			while((line = bReader.readLine()) != null) {
				
				if(count != 1) {
				String[] data = line.split(comma);
				String[] temp = new String[6];
				temp[0] = data[0] + data[1];
				for(int i = 1; i < 6; i++) {
					temp[i] = data[i+1];
				}
				data = temp;
				
				Employee emp = new Employee();
				emp.setName(data[0]);
				emp.setNum(Integer.parseInt(data[1]));
				emp.setState(data[2]);
				emp.setZip(Integer.parseInt(data[1]));
				emp.setAge(Integer.parseInt(data[5]));
				empSet3.add(emp);
				
				}
				count++;
			}
			bReader.close();
			fReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		System.out.println("\nTest Case 10");
		System.out.println(empSet3.capacity());
		System.out.println(empSet3.size());
		
		for(int i = 0; i < 6; i++) {
		System.out.println(empSet3.set1[i].getName());
		System.out.println(empSet3.set1[i].getNum());
		}
	}
}
