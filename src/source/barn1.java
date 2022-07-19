package source;

import java.io.*;
import java.util.*;

import Train.Input;

public class barn1 {

	public static void main(String[] args) throws IOException {
		long start=System.currentTimeMillis();


		Input input = new Input();
		
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		
		int m = input.nextInt(1, 1), s = input.nextInt(1, 2), c = input.nextInt(1, 3);
		
		System.out.println("m: " + m);
		System.out.println("s: " + s);
		System.out.println("c: " + c);
		System.out.println("=====================");

		
		int[] stall = new int[c];
		int[] gap = new int[c-1];
		int[] biggestArr = new int[m - 1];
		
		for(int i=1; i<c + 1; i++) {
			stall[i - 1] = input.nextInt(i + 1, 1);
			if(i < c)gap[i - 1] = input.nextInt(i + 2, 1) - input.nextInt(i + 1, 1);
		}
		
		if(!mono(gap)) {
			for(int i=1; i<m; i++) {
				biggestArr[i-1] = biggest(gap, i);
			}
					
			int init = stall[0], ends = 0;
			
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			for(int i=0; i<gap.length; i++) {
				if(contains(biggestArr, gap[i])) {
					temp.add(init);
					init = stall[i + 1];
					ends = stall[i];
					temp.add(ends);
				}
			}
			
			int totalPeriod = 0;			
			for(int i=0; i<temp.size() / 2; i++) {
				System.out.println("Start from: " + temp.get(2*i));
				System.out.println("Ended in: " + temp.get(2*i + 1));
				totalPeriod += (temp.get(2*i + 1) - temp.get(2*i));
				if(temp.get(2*i + 1) == temp.get(2*i) && !contains(biggestArr, gap[i])) {
					totalPeriod += (temp.get(2*i) - temp.get(2*(i-1) + 1));
				}
				System.out.println("=====================");
			}
			System.out.println("Start from: " + init);
			System.out.println("Ended in: " + input.nextInt(c + 1, 1));
			System.out.println("=====================");
			
			System.out.println(totalPeriod + input.nextInt(c + 1, 1) - init + m);
			input.write(totalPeriod + input.nextInt(c + 1, 1) - init + m, true);
		}
		else input.write(gap[0] * gap.length, true);

			
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");
	}
	
	static int biggest(int[] arr, int id) {
		int[] copy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(copy);
		return copy[arr.length - id];
	}
	
	static boolean contains(int[] arr, int a) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == a) return true;
		}
		return false;
    }
	
	static boolean mono(int[] arr) {
		int temp = arr[0];
		boolean flag = true;
		for(int i=0; i<arr.length; i++) {
			flag = flag && arr[i] == temp;
		}
		return flag;
	}
}
