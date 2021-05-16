import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class EmployeeTable {

	
	int key[];
	Employee value[];
	boolean used[];
	int num;
	
	public EmployeeTable () {
		
		key = new int[701];
		value = new Employee [701];
		used = new boolean [701];
		num = 0;
		
		for(int i = 0; i < 701; i++) {
			used[i] = false;
		}
	}
	
	private int hash(int emp_no) {
		
		return emp_no % value.length;
	}
	
	public void put(Employee obj) {
		
		if(num == value.length) {
			throw new IllegalStateException();
		}
		
		int idx = findIndex(obj.getNum());
		if(idx != -1) {
			value[idx] = obj;
		}
		if(idx == -1) {
			idx = hash(obj.getNum());
			if(used[idx] == true) {
				while(used[idx] == true) {
					idx++;
					if(idx == value.length) {
						idx = 0;
					}
				}
			}
			this.key[idx] = obj.getNum();
			value[idx] = obj;
			used[idx] = true;
			num++;
		}
	}
	
	private int findIndex(int key) {
		
		int idx = hash(key);
		int counter = 0;
		
		while(counter < value.length && used[idx] == true) {
			if(key == this.key[idx]) {
				return idx;
			}
			else {
				idx++;
				counter++;
			}
		}
		return -1;
	}
	
	public boolean remove(int emp_no) {
		
		int idx = findIndex(emp_no);
		
		if(idx == -1) {
			return false;
		}
		
		else {
			value[idx] = null;
			used[idx] = false;
			num--;
			return true;
		}
	}
	
	public int search(int emp_no) {
		
		int idx = hash(emp_no);
		int counter = 0;
		
		while(counter < value.length && used[idx] == true) {
			if(emp_no == this.key[idx]) {
				return idx;
			}
			else {
				idx++;
				counter++;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee();
		
		e1.setNum(1234);
		e2.setNum(3025);
		e3.setNum(2785);
		e4.setNum(6614);

		EmployeeTable ht = new EmployeeTable();
		
		// should add e1 to the hash table
		// search should return the index of e1
		ht.put(e1);
		System.out.println(ht.search(e1.number));
		
		// adding multiple items at a time should
		// offer no different results
		ht.put(e2);
		ht.put(e3);
		ht.put(e4);
		
		System.out.println("\n" + ht.search(e2.number));
		System.out.println(ht.search(e3.number));
		System.out.println(ht.search(e4.number));
		
		// removing a present employee should return true
		// search should return -1
		System.out.println("\n" + ht.remove(e2.number));
		System.out.println(ht.search(e2.number));
		
		// removing an absent employee should return false
		System.out.println("\n" + ht.remove(1002));
		
		HashMap<Integer, Employee> hm = new HashMap<Integer, Employee>();
		
		int count = 0;
		String line = "";
		String comma = ",";
		
		try {
			FileReader fReader = new FileReader("core_dataset.csv");
			BufferedReader bReader = new BufferedReader(fReader);
			
			while((line = bReader.readLine()) != null) {
			count++;	
			
				if(count == 1) {
					
				}
				else {
					String[] data = line.split(comma);
					
					for(int i = 0; i < data.length; i++) {
						data[i].replaceAll("/s+", "");
					}
					Employee e = new Employee();
					e.setName(data[0]);
					e.setNum(Integer.parseInt(data[2]));
					e.setState(data[3]);
					e.setZip(Integer.parseInt(data[4]));
					e.setAge(Integer.parseInt(data[6]));
					hm.put(e.number, e);
					/*if(count != 303) {
					
						if(Integer.parseInt(data[6]) <= 30) {
							young.add(Arrays.toString(data));
						}	
					}*/
				}
				
			}
			bReader.close();
			fReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

}
