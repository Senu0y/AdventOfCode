package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Tor14b {

	// static ArrayList<Integer> memoryInt;
	static long[] bigArr = new long[100000];
	static HashMap<Long, Long> hashi = new HashMap<Long, Long>();

	public static void main(String[] args) throws FileNotFoundException {
//memoryInt = new ArrayList<Integer>();

		File file = new File("tor14input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("mask = ");

//	String[] input = scani.useDelimiter("\\A").next().split("\n");
		scani.close();
		// System.out.println(Arrays.toString(input));

		for (int i = 1; i < input.length; i++) {
			scani = new Scanner(input[i]);
			String mask = scani.next();
			ArrayList<String> mem = new ArrayList<String>();
			while (scani.hasNext()) {
				mem.add(scani.nextLine());
			}

			mem.remove(0);

			for (String current : mem) {
				calculater(mask, current);
			}
			// System.out.println(mem.toString());

		}
		long sum = 0l;
		int counter = 0;
		for(Long dama: hashi.values()) {
			sum+=dama;
		}

		System.out.println("sum");
		System.out.println(sum);
		System.out.println(counter);

	}

	static HashSet<String> xCoder(String mask, String memory) {
		HashSet<String> marlene = new HashSet<String>();
		
		if (!memory.contains("X")) {
			marlene.add(memory);
			marlene.size();
			return marlene;
		}
		for (int i = 0; i < mask.length(); i++) {
			if (memory.charAt(i) == 'X') {
			//	System.out.println("v "+memory);
				String mem1 = memory.substring(0, i) + '1' + memory.substring(i + 1);
				System.out.println("n "+mem1);
				marlene.addAll(xCoder(mask, mem1));
				
				String mem2 = memory.substring(0, i) + '0' + memory.substring(i + 1);
				marlene.addAll(xCoder(mask, mem2));
					break;	
		}		
		}
		System.out.println(marlene.size());
		return marlene;
	}

	static void calculater(String mask, String mem) {

		String[] part = mem.split("] = ");
		int memory = Integer.parseInt(part[0].substring(4));
		long number = Integer.parseInt(part[1]);

		String memoryBin = Long.toBinaryString(memory);
		memoryBin = String.format("%36s", memoryBin).replaceAll(" ", "0");

		System.out.println("o " + memoryBin);
		System.out.println("m " + mask);

		for (int i = 0; i < memoryBin.length(); i++) {
			if (mask.charAt(i) == '1') {
				memoryBin = memoryBin.substring(0, i) + '1' + memoryBin.substring(i + 1);
			}
			if (mask.charAt(i) == 'X') {
				memoryBin = memoryBin.substring(0, i) + 'X' + memoryBin.substring(i + 1);
			}
		}

		System.out.println(xCoder(mask, memoryBin).toString());
		HashSet<String> danny= xCoder(mask, memoryBin);
		for(String current:danny ) {
			
			hashi.put(Long.parseLong(current, 2), number);
		}
		
		/*
		 * memoryBin = sb.toString(); System.out.println("n " + memoryBin); number =
		 * Long.parseLong(memoryBin, 2); bigArr[memory] = number;
		 */

	}
}
