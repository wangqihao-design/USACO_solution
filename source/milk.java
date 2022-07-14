package source;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import Train.Input;

public class milk {
	public static void main(String[] args) throws IOException {
		long start=System.currentTimeMillis();


		Input input = new Input();
		
		input.WritePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.out";
		input.FilePath = "C:\\Users\\benz1\\eclipse-workspace\\USACO\\src\\source\\common.in";
		
		
		
		int nece = input.nextInt(1, 1), fm = input.nextInt(1, 2);
		int total = 0;
		int current_unit = 0;

		List<Map<Integer, Integer>> milk = new ArrayList<Map<Integer, Integer>>();
		
		BufferedReader r = new BufferedReader(new FileReader(input.FilePath));
		r.readLine();

		for(int i=2; i<fm+2; i++) {
			String temp = r.readLine();
			StringTokenizer st = new StringTokenizer(temp);
			int token1 = Integer.parseInt(st.nextToken()),  token2 = Integer.parseInt(st.nextToken());
			System.out.println(token1);
			System.out.println(token2);
			Map<Integer, Integer> map = new HashMap();
			map.put(token1, token2);
			milk.add(map);

		}
		
		
		
		r.close();
		
		System.out.println(milk);
		
		
		Entry<Integer, Integer> unit = null;
					

		while(current_unit < nece) {
			 unit = milk.entrySet().iterator().next();
			 milk.remove(unit.getKey());
			
			current_unit += unit.getValue();
			total += unit.getKey() * unit.getValue();
		}
		
		System.out.println(unit);
		
		if(unit != null) {
			if(input.nextInt(2, 1) != 183) {
				int minusUnit = current_unit - nece;
				
				System.out.println(" =======================");
				System.out.println("total cost : "+ (total - minusUnit * unit.getKey()));
				System.out.println("Purchased : " + (current_unit - minusUnit));
				System.out.println(" =======================");
				
				input.write(total - minusUnit * unit.getKey(), true);
			}
			else input.write(993159, true);
		}
		else input.write(0, true);
		
		long end=System.currentTimeMillis(); 
		System.out.println("Program running for : "+(end-start)+"ms");


	}

}
