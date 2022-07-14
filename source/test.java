package source;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import Train.SubmissionHandler;
import Train.Input;

public class test {
	public static void main(String[] args) throws IOException {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(2, 1020);
		map.put(3, 300);
		map.put(1, 100);
		map.put(5, 500);
		List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		list.sort(Entry.comparingByValue());
		System.out.println(list.toString());
	}
}