package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tor14 {

	// static ArrayList<Integer> memoryInt;
	static long[] bigArr = new long[100000];

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
		for (int i = 0; i < bigArr.length; i++) {
			if (bigArr[i] != 0) {
				sum += bigArr[i];
				counter++;
			}
		}
		// 14683437866 too low
		// 3692540038666 too low
		// 14722016054794
		// System.out.println(Arrays.toString(bigArr));
		System.out.println("sum");
		System.out.println(sum);
		System.out.println(counter);

	}

	static void calculater(String mask, String mem) {

		String[] part = mem.split("] = ");
		int memory = Integer.parseInt(part[0].substring(4));
		long number = Integer.parseInt(part[1]);

		String numbBin = Long.toBinaryString(number);
		numbBin = String.format("%36s", numbBin).replaceAll(" ", "0");
		StringBuilder sb;
		System.out.println("o "+numbBin);
		System.out.println("m "+mask);
		sb = new StringBuilder(numbBin);
		for (int i = 0; i < numbBin.length(); i++) {

			if (numbBin.charAt(numbBin.length() - 1 - i) == mask.charAt(mask.length() - 1 - i)
					|| mask.charAt(mask.length() - 1 - i) == 'X') {
				continue;
			} else {
				sb.setCharAt(numbBin.length() - 1 - i, mask.charAt(mask.length() - 1 - i));
			}
		}
		numbBin = sb.toString();
		System.out.println("n "+numbBin);
		number = Long.parseLong(numbBin, 2);
		bigArr[memory] = number;
		// memoryInt.add(memory, number);
		/*
		 * System.out.println(sb.toString()); System.out.println("m "+ memory);
		 * System.out.println("n "+ number);
		 */

	}
}
