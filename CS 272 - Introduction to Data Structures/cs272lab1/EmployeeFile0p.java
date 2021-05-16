import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeFile0p {

	static ArrayList<String> young = new ArrayList<String>();
	static ArrayList<String> head = new ArrayList<String>();
	static String lastH = "";
	static String tempString = "";
	
	public static void read(String fileName) {
	
	int count = 0;
	String line = "";
	String comma = ",";
	
	String partial = "";
	try {
		FileReader fReader = new FileReader(fileName);
		BufferedReader bReader = new BufferedReader(fReader);
		
		while((line = bReader.readLine()) != null) {
		count++;	
		
		if(count == 1) {
			String[] header = line.split(comma);
			for(int i = 0; i < 7; i++) {
				partial = partial + (header[i]+",");
			}
			head.add(partial);
		}
		
		else {
			String[] data = line.split(comma);
			
			if(count != 303) {
				
				if(Integer.parseInt(data[6]) <= 30) {
					young.add(Arrays.toString(data));
			}
			}
			
		}
		}
		bReader.close();
		fReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	
		lastH = head.get(0);
		
		for(int i = 0; i < young.size(); i++ ) {
			String[] temp = young.get(i).split(comma);
			partial = temp[0] + "," + temp[1] + "," + temp[2] + "," + temp[3] + "," + temp[4] + "," + temp[5] + "," + temp[6] + "," + temp[7];
			young.set(i, partial);
		}
		
	}
	
	public static void write(String fileName) {
		
		try {
			File file = new File(fileName);
			
			FileWriter fWriter = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			
			bWriter.write(lastH + "\n");
			
			for(int i = 0; i < young.size(); i++) {
			tempString = young.get(i);
			tempString.replaceAll(" ", ",");
			tempString = tempString.replaceFirst("\\[", "");
			young.set(i, tempString);			
			
			}
			//Turn array list indexes into strings and replace spaces with commas
			for(int i=0;i<young.size();i++){
				bWriter.write(young.get(i)+"\n");
			}
			bWriter.close();
			fWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
public static void main(String[] args) {
	
	read("core_dataset.csv");
	write("young_employee.csv");
	
}
}