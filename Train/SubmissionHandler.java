package Train;

import java.io.*;
import java.util.*;

public class SubmissionHandler {
	
	public static void main(String[] args) throws IOException {
		SubmissionHandler sh = new SubmissionHandler();
		sh.Handler();
		}
	
	public String program = "transform";
	public String WritePath = "C:\\Users\\benz1\\Desktop\\USACO_submitFiles\\"+program+".java";
	public String FilePath = System.getProperty("user.dir") + "\\src\\source\\"+program+".java";
	
	
	public void Handler() throws IOException {
	
		Input input = new Input();
		input.WritePath = this.WritePath;
		input.FilePath = this.FilePath;
		
        File file = new File(WritePath);
        FileWriter fileWriter =new FileWriter(file);
        if(file.createNewFile()) System.out.println("FileCreated");
        else {
            System.out.println("Using " + WritePath);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        }
		
		for(int i=0; i<input.getFileLineNum(); i++) {
			String nextLine = input.next(i);
			System.out.println(nextLine);
			if(nextLine.contains("package")) System.out.println("removed packages");
			else if(nextLine.contains("import Train.Input")) System.out.println("removed import Train.input");
			else if(nextLine.contains("input.FilePath")) input.write("		"+"input.FilePath =" +'"' + program +".in" + '"' + ";", true);
			else if(nextLine.contains("input.WritePath")) input.write("		"+"input.WritePath =" + '"' + program +".out" + '"' + ";", true);
			else {
				input.write(nextLine, true);
			}

		}
		Input getInputClass = new Input();
		getInputClass.FilePath="C:/Users/benz1/eclipse-workspace/USACO/src/Train/Input.txt";
		for(int j=0; j<72; j++) {
			input.write(getInputClass.next(j), true);
		}
		
	}
	
}