
public class Employee {

	String name;
	int number;
	int age;
	String state;
	int zipCode;
	int [] advisors = new int [] {0, 0, 0};
	
	// simple constructor; no parameters or return. Sets everything to 0/null
	public Employee() {
		
		name = null;
		state = null;
		advisors = null;
		number = 0;
		age = 0;
		zipCode = 0;
	}
	// copy constructor; no return; parameter of same object type
	public Employee(Object obj) {
		
		// precondition that the argument must not be null and must be an
		// instance of the same class
		if((obj != null) && (obj instanceof Employee)) {
			Employee emp1 = (Employee) obj;
			this.number = emp1.number;
			this.age = emp1.age;
			this.zipCode = emp1.zipCode;
			this.name = new String(emp1.name);
			this.state = new String(emp1.state);
			this.advisors = new int[3];
			for(int i = 0; i < 3; i++) {
				if(i <= emp1.advisors.length-1) {
				advisors[i] = emp1.advisors[i];
				}
			}
			
		}
	}
	
	// Getters; return the value of the corresponding variable
	String getName() {
		
		return name;
	}
	
	int getNum() {
		
		return number;
	}
	
	int getAge() {
		
		return age;
	}
	
	String getState() {
		
		return state;
	}
	
	int getZip() {
		
		return zipCode;
	}
	
	int[] getAdvisors() {
		
		return advisors;
	}
	
	// Setters; set the corresponding variables using the parameter of the 
	// variable type. No return values.
	void setName(String replace) {
		
		name = replace;
	}
	
	void setNum(int replace) {
		
		number = replace;
	}
	
	void setAge(int replace) {
		
		age = replace;
	}
	
	void setState(String replace) {
		
		state = replace;
	}
	
	void setZip(int replace) {
		
		zipCode = replace;
	}
	
	// uses for loop to copy array contents
	void setAdvisors(int[] replace) {
		advisors = new int[] {0, 0, 0};
		for(int i = 0; i < 3; i++) {
			if(i <= replace.length-1) {
			advisors[i] = replace[i];
			}
		}
		
	}
	
	// Converts all class member variables into a single string
	// using concatenation and a for loop for the array
	// no parameters or return values.
	public String toString() {
		String employeeData;
		String advisorsNum = "";
		
		for(int i = 0; i < 3; i++) {
			
			if(advisors[i] != 0 && i == 0) {
			advisorsNum = advisorsNum + advisors[i];
				
			}
			
			// Only used for formatting the toString with commas
			if(advisors[i] != 0 && i != 0) {
				advisorsNum = advisorsNum + ", " + advisors[i]; 
			}
			
		}
		
		
		employeeData = name + ", " + number + ", " + age + ", " + state + ", " + zipCode + "\nAdvisors' Employee Numbers: \n" + advisorsNum;
		
		return employeeData;
	}
	
	// Checks if the instance that called the method and the argument
	// instance have the same employee number.
	// Returns a boolean with an object as a parameter.
	public boolean equals(Object obj) {
		
		// precondition is that the object must not be null and
		// must be an instance of the same class
		if( obj != null && obj instanceof Employee) {
			Employee empTemp = (Employee) obj;
			if(empTemp.getNum() == number) {
				return true;
			}
			
		}
		return false;
	}

	// Gets all the advisors' employee numbers from the 2 requested employees
	// Returns an array with the numbers and has 2 parameters for 2 instances
	// of the employee class
	public static int[] getAllAdvisors(Employee e1, Employee e2) {
		
		int[] advisorsCombined = new int[6];
		int count = 0;
		int array1Length = 0;
		if(e1 != null && e2 != null) {
			
			for(int i = 0; i < 6; i++) {
				if(i < 3 && e1.getAdvisors()[i] != 0) {
				advisorsCombined[i] = (e1.getAdvisors())[i];
				count++;
				array1Length++;
				}
				else {
				if((i-array1Length) < e2.getAdvisors().length && e2.getAdvisors()[i-array1Length] != 0) {
					advisorsCombined[i] = (e2.getAdvisors())[i-array1Length];
					count++;
				}
				}
			}
			// creates a new temp array that has the exact size needed and
			// copies everything from advisorsCombined over. Then makes 
			// advisorsCombined reference the temp array.
			int [] temp = new int[count];
			for(int i = 0; i < count; i++) {
				temp[i] = advisorsCombined[i];
			}
			advisorsCombined = temp;
		}
		return advisorsCombined;
		
	}

	
	// Tests all methods
	public static void main(String[] args) {
		
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();
		Employee employee5 = new Employee();
		
		int[] e1Advisors = new int[]{2546, 6598};
		int[] e5Advisors = new int[]{1568, 1698, 7823};
		
		// Tests if all setters work correctly
		employee1.setName("Michael");
		employee1.setNum(1234);
		employee1.setAge(18);
		employee1.setState("NM");
		employee1.setZip(88012);
		employee1.setAdvisors(e1Advisors);
		
		employee2.setNum(1234);
		employee3.setNum(1134);
		employee5.setAdvisors(e5Advisors);
		
		Employee employee4 = new Employee(employee1);
		
		// Tests if the getters works correctly
		System.out.println("Test Case #1");
		System.out.println(employee1.getName());
		System.out.println(employee1.getNum());
		System.out.println(employee1.getAge());
		System.out.println(employee1.getState());
		System.out.println(employee1.getZip());
		
		for(int i = 0; i < employee1.getAdvisors().length; i++) {
			
			if(employee1.getAdvisors()[i] != 0)
			System.out.print(employee1.getAdvisors()[i] + ", ");
		}
		
		// Tests if the toString method works correctly
		System.out.println("\n\nTest Case #2");
		System.out.println(employee1.toString());
		
		// Tests if the copy constructor worked on employee4
		// should return same toString as employee1
		System.out.println("\n\nTest Case #3");
		System.out.println(employee4.toString());
		
		// Tests if the equals method returns true for equal employee numbers
		System.out.println("\nTest Case #4");
		System.out.println(employee1.equals(employee2));
		
		// Tests if the equals method returns false for unequal numbers
		System.out.println("\nTest Case #5");
		System.out.println(employee1.equals(employee3));
		
		// Tests if the getAllAdvisors method returns advisors for 2
		// employees that share advisors
		System.out.println("\nTest Case #6");
		for(int i = 0; i < getAllAdvisors(employee1, employee4).length; i++) {
		
		System.out.println(getAllAdvisors(employee1, employee4)[i]);
		}
		
		// Tests if the getAllAdvisors method returns 5 different
		// numbers and that they are all correct
		System.out.println("\nTest Case #7");
		
		for(int i = 0; i < getAllAdvisors(employee1, employee5).length; i++) {
			
			System.out.println(getAllAdvisors(employee1, employee5)[i]);
			}
	}

}
