package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Tor18 {
	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor18input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");

		// System.out.println(Arrays.toString(input));

		Long sum = 0l;
		for (int i = 0; i < input.length; i++) {
			 sum += calculater(input[i]);
			// System.out.println(sum);
		}
		System.out.println(calculater("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2"));
		// System.out.println(Arrays.toString(calcuNoPar("5 + 3 * 4 + ( 6 + 1
		// )")));//954403037 too low
				// 8977082375 too low
		// System.out.println("SUM "+sum);
	}

	static int calculater(String line) {
		char[] l = line.strip().toCharArray();
		int calculation = 0;
		int i = 0;
		if (l[0] == '(') {
			i++;
			calculation = calculater(line.substring(1));

			int parSum = 1;

			while (parSum != 0) {
				if (l[i] == '(')
					parSum++;
				else if (l[i] == ')')
					parSum--;
				i++;
			}
		} else {
			int[] result = calcuNoPar(line.substring(i));
			calculation = result[0];
			i += result[1];

		}
		if (i >= l.length) {
			return calculation;
		}
		if (l[i] == '*') {
			int[] result = calcuNoPar(line.substring(i + 2));
			// System.out.println(result[0]);
			if (calculation == 0) {
				calculation = 1;
			}
			//System.out.println(calculation+" "+ result[0]);
			if(result[0]!=0) {
				calculation = calculation * result[0];
			}
			
			i += result[1];
			if (i >= l.length) {
				return calculation;
			}
			calculation = calculation * calculater(line.substring(i + 2));

		} else if (l[i] == '+') {

			int[] result = calcuNoPar(line.substring(i + 2));
			// System.out.println(result[0]);
			calculation = calculation + result[0];
			i += result[1];
			if (i >= l.length) {
				return calculation;
			}
			calculation = calculation + calculater(line.substring(i + 2));
		}
		//System.out.println(calculation);
		return Math.abs(calculation);
	}

	static int[] calcuNoPar(String line) {
	//	System.out.println(line);
		int[] returner = new int[2];
		char[] l = line.strip().toCharArray();
		int calculation = 0;
		int i = 0;
		if (l[0] == '(') {
			return returner;
		} else {
			calculation = Integer.parseInt(l[0] + "");
			i += 2;
		}

		if (i >= l.length) {
			returner[0] = calculation;
			returner[1] = i;
			return returner;
		}

		while (i + 2 < l.length) {
			if (l[i] == '*') {
				if (l[i + 2] != '(') {
					calculation = calculation * Integer.parseInt(l[i + 2] + "");
				} else
					break;
			} else if (l[i] == '+') {

				if (l[i + 2] != '(') {
					calculation = calculation + Integer.parseInt(l[i + 2] + "");
			//		System.out.println(calculation);
				} else {
					break;
				}

			}
			i += 2;
		}

		// System.out.println(calculation);
		returner[0] = Math.abs( calculation);
		returner[1] = i;
	//	System.out.println("hier " + returner[0]);
		return returner;

	}
}
