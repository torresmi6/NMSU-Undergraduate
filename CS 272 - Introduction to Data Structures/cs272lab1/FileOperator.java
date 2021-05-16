
/**
 * This class gives an example of reading text files in the following format to an array
 * total_number (n) 
 * int_number1 tab float_number1
 * int_number2 tab float_number2
 * ...
 * int_numbern tab float_numbern
 * 
 * To run this program, make sure that you have the file test.txt
 * Then, run the following commands:
 * 
 * $ javac FileOperator.java
 * $ java FileOperator
 * $ diff test.txt test_copy.txt
 * The command should not give any difference
 * @author Huiping Cao
 */

import java.io.*;

class mypair{
	int num1;
	float num2;
}
public class FileOperator {
	private static mypair[] numberpairs = null;
	
	public static void read(String fname){
		int no = 0; 
		String line = "";
		try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fname);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //parse line
                if(no==0){
                	int totalNumber = Integer.parseInt(line);
                	numberpairs = new mypair[totalNumber];
                }else{
                	String[] lineStr = line.split("\t");
                	if(lineStr.length!=2) continue;
                	
                	if(no > numberpairs.length){
                		System.out.println("There are too many students in the file. ");
                		break;
                	}
                	numberpairs[no-1] = new mypair();
                	numberpairs[no-1].num1 = Integer.parseInt(lineStr[0]);
                	numberpairs[no-1].num2 = Float.parseFloat(lineStr[1]);
                }
                no++;
            }   
            bufferedReader.close(); // Always close files.         
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" +  fname + "'");                
        }catch(IOException ex) {
            System.out.println("Error reading file '" + fname + "'");                  
        }
		System.out.println("Finish reading pairs from file "+ fname);
	}
	
	public static void generate(int N){
		numberpairs = new mypair[N];
		for(int i=0;i<N;i++){
			numberpairs[i] = new mypair();
			numberpairs[i].num1 = (int)(Math.random()*N*10);
			numberpairs[i].num2 = (float)((int)(Math.random()*100)/100.0);
			System.out.println(numberpairs[i].num1+" "+numberpairs[i].num2);
		}
		System.out.println("Finish generating "+ N + " pairs");
	}
	
	public static void write(String fname){
		try {
			File file = new File(fname);
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(numberpairs.length+"\n");
			for(int i=0;i<numberpairs.length;i++){
				//System.out.println("i="+i+":" + numberpairs[i].num1+"\t"+numberpairs[i].num2);
				bw.write(numberpairs[i].num1+"\t"+numberpairs[i].num2+"\n");
			}
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finish writing pairs to file "+ fname);
	}
	
	public static void main(String[] args) {
		//Generate initial data pairs
		//generate(10);			//generate 100 pairs
		//write("test.txt");		//write 100 pairs to a file
		
		numberpairs = null;		//clear the memory
		read("test.txt");		//read back the 100 pairs
		write("test_copy.txt"); //write the pairs to another file
	}

}

