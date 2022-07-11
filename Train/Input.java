package Train;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Input {
	public String FilePath;
	public String WritePath;
	
	
	public String next(int line) throws IOException{
		BufferedReader r = new BufferedReader(new FileReader(this.FilePath));
		String n = "";
		for(int i=0; i<line; i++) {
			n = r.readLine();
		}
		return n;
	}
	
	public int nextInt(int line, int token) throws IOException {
		StringTokenizer st = new StringTokenizer(next(line));
		for(int i=0; i< token-1; i++) {
			st.nextToken();
		}
		return Integer.parseInt(st.nextToken());
	}
	public double nextDouble(int line, int token) throws IOException {
		StringTokenizer st = new StringTokenizer(next(line));
		for(int i=0; i< token-1; i++) {
			st.nextToken();
		}
		return Double.parseDouble(st.nextToken());
	}
	public String nextString(int line, int token) throws IOException {
		StringTokenizer st = new StringTokenizer(next(line));
		for(int i=0; i< token-1; i++) {
			st.nextToken();
		}
		return st.nextToken();
	}
	public long nextLong(int line, int token) throws IOException {
		StringTokenizer st = new StringTokenizer(next(line));
		for(int i=0; i< token-1; i++) {
			st.nextToken();
		}
		return Long.parseLong(st.nextToken());
	}
	
	public void write(Object a, boolean changeLine) throws IOException {
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(this.WritePath, true)));
		if(changeLine) pw.println(a);
		else pw.print(a);
		pw.close();
	}
	
	public int getFileLineNum() {
	    try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(this.FilePath))){
	        lineNumberReader.skip(Long.MAX_VALUE);
	        int lineNumber = lineNumberReader.getLineNumber() + 1;
	        return lineNumber;
	    } catch (IOException e) {
	        return -1;
	    }
	}
	
	/* this is the version use in gift1.java
	 * int getFileLineNum() {
	*    try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(this.FilePath))){
	*        lineNumberReader.skip(Long.MAX_VALUE);
	*        int lineNumber = lineNumberReader.getLineNumber();
	*        return lineNumber;
	*    } catch (IOException e) {
	*        return -1;
	*    }
	}*/
}