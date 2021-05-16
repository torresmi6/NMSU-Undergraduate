
public class EmployeeSet {
	
	int capacity;
	int employeeCount;
	Employee[] set1 = null;
	
	public EmployeeSet() {
		capacity = 10;
		set1 = new Employee[10];
	}
	
	public EmployeeSet(Object obj) {
		if(obj != null && obj instanceof EmployeeSet) {
			EmployeeSet setCopy = (EmployeeSet) obj;
			this.capacity = setCopy.capacity;
			this.employeeCount = setCopy.employeeCount;
			
			for(int i = 0; i < setCopy.set1.length; i++) {
				this.set1[i] = setCopy.set1[i];
			}
		}
	}
	
	public int size() {
		return employeeCount;
		
	}
	
	public int capacity() {
		return capacity;
	}
	
	public void add(Employee a) {
		
	}
	
	public boolean contains(Employee a) {
		
	}
	
	public boolean remove(int eno) {
		
	}
	
	public void ensureCapacity(int minimumCapacity) {
		
	}
	
	public void addOrederd(Employee a) {
		
	}
	
	public static void main(String[] args) {
		
	}
}
