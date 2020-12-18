package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor18a {
	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor18input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");

		// System.out.println(Arrays.toString(input));

		Long sum = 0l;
		System.out.println(input[0]);
		for (int i = 0; i < input.length; i++) {
			 sum += calculater(input[i]);
			// System.out.println(input[i]);
			 System.out.println(sum);
		}
		//System.out.println(calculater("3 + (2 + 5)"));
		System.out.println(calculater("6 * ((5 * 3 * 2 + 9 * 4) * (8 * 8 + 2 * 3) * 5 * 8) * 2 + (4 + 9 * 5 * 5 + 8) * 4"));
		// System.out.println(Arrays.toString(calcuNoPar("5 + 3 * 4 + ( 6 + 1
		// )")));//954403037 too low
		//8977082375 too low
		//8298263963837 corrwect
		//8977082557
		 System.out.println("SUM "+sum);
	}

	static Long calculater(String line) {
		char[] l = line.strip().toCharArray();
	//	System.out.println(line);
		Long calculation = 0l;
		int i = l.length-1;
		if (l[i] == ')') {
			i--;
			calculation = calculater(line.substring(0,i+1));

			int parSum = 1;

			while (parSum != 0) {
				if (l[i] == ')')
					parSum++;
				else if (l[i] == '(')
					parSum--;
				i--;
			}
			i--;
			//System.out.println(i);
		} else {
			
			calculation= Long.parseLong(l[i]+"");
			i-=2;

		}
		if (i<=0) {
			return calculation;
		}
		if (l[i] == '*') {
			calculation= calculation* calculater(line.substring(0, i));

		} else if (l[i] == '+') {
			calculation= calculation+ calculater(line.substring(0, i));
		}
		//System.out.println(calculation);
		return calculation;
	}

	
}
