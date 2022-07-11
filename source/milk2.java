package source;

/*
ID: wangq
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

import Train.Input;

public class milk2 {
	public static void main(String args[]) throws IOException {
		long start=System.currentTimeMillis();

		Input inputs = new Input();
		inputs.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		inputs.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		Inputs input = new Inputs();
		
		input.arr = input.sort();
		

		
		int N = inputs.nextInt(1, 1);
		ArrayList<int[]> workperiod = new ArrayList<int[]>();
		workperiod.add(new int[] {input.nextInt(2, 1), input.nextInt(2, 2)});
		int idx = 0;
		

		for(int i=3; i<N+2; i++) {
			
			if((input.nextInt(i, 1)>workperiod.get(idx)[1])) {
				idx++;
				workperiod.add(new int[2]);
				workperiod.get(idx)[0] = input.nextInt(i, 1);
				workperiod.get(idx)[1] = input.nextInt(i, 2);
			}
			
				
			if((input.nextInt(i, 1)<workperiod.get(idx)[0] || input.nextInt(i, 2)>workperiod.get(idx)[1])) {
				if(input.nextInt(i, 1)<workperiod.get(idx)[0])  {
					workperiod.get(idx)[0] = input.nextInt(i, 1);
				}
				if(input.nextInt(i, 2)>workperiod.get(idx)[1])  {
					workperiod.get(idx)[1] = input.nextInt(i, 2);

				}
			}

			
		}
		
		int max_cont = 0;
		int max_idle = 0;
		/*
		 * int index = -1; ArrayList<int[]> copy = new ArrayList<int[]>();
		 * copy.addAll(0, workperiod); for(int i=0; i<copy.size(); i++) { index++;
		 * if(isWorking(copy, copy.get(i)[1])) {
		 * System.out.println(Arrays.toString(workperiod.get(index)));
		 * 
		 * workperiod.remove(index); index--; } }
		 */

		for(int i=0; i<workperiod.size(); i++) {
						
			int cont = workperiod.get(i)[1] - workperiod.get(i)[0];
			int idle = 0;
			if(i < workperiod.size()-1) {
				//System.out.println(workperiod.get(i + 1)[0]);
				//System.out.println(workperiod.get(i)[1]);
				idle = workperiod.get(i + 1)[0] - workperiod.get(i)[1];
			}
			
			if(idle > max_idle) max_idle = idle;
			if(cont > max_cont) max_cont = cont;


		}
		System.out.println("Max Idle : " + max_idle);
		System.out.println("Max Cont :" + max_cont);
		inputs.write(max_cont, false);
		inputs.write(" ", false);
		inputs.write(max_idle, true);
		
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
	}
	
}

class Inputs{
	
	public int[][] arr;
	
	public int[][] sort() throws IOException {
		Input co = new Input();
		co.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		co.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		BufferedReader r = new BufferedReader(new FileReader(co.FilePath));
		String n = r.readLine();

		int[][] arr = new int[co.nextInt(1,1)][2];
		for(int i=0; i<arr.length; i++) {
			n = r.readLine();
			StringTokenizer st = new StringTokenizer(n);
			int i0 = Integer.parseInt(st.nextToken());
			arr[i][0] = i0; //co.nextInt(i + 2, 1)
			int i2 = Integer.parseInt(st.nextToken());
			arr[i][1] = i2;
		}


		Arrays.sort(arr, (a, b)->a[0]-b[0]);

		
		return arr;
	}
			
	public int ans(int q, int w) throws IOException {
		return this.arr[q][w];
	}
	
	public int nextInt(int a, int b) throws IOException {
		return ans(a - 2, b - 1);
	}
}