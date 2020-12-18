package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor18b {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor18input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");
		scani.close();
		Long sum = 0l;
		System.out.println(input[0]);

		for (int i = 0; i < input.length; i++) {
			sum += calculater(modifier(input[i]));
		}
		System.out.println(modifier("2 * 3 + (4 * 5)"));
		System.out.println(calculater(modifier("2 * 3 + (4 * 5)")));
		System.out.println(sum);
		// danny 314455761823725
	}

	static String modifier(String line) {
		
		line = line.replaceAll("\\)", ")))");
		line = line.replaceAll("\\(", "(((");
		line = line.replaceAll(" \\* ", ")) * ((");
		line = "(("+line;
		line = line +"))";
		return line;
	}

	/*
	 * static int parHelper(String s) { int parSum = 1; int i = 0; char[] l =
	 * s.toCharArray(); while (parSum != 0 && i < s.length()) { if (l[i] == '(')
	 * parSum++; else if (l[i] == ')') parSum--; i++; } return i - 1; }
	 */

	static Long calculater(String line) {
		char[] l = line.strip().toCharArray();
		Long calculation = 0l;
		int i = l.length - 1;
		if (l[i] == ')') {
			i--;
			calculation = calculater(line.substring(0, i + 1));

			int parSum = 1;

			while (parSum != 0) {
				if (l[i] == ')')
					parSum++;
				else if (l[i] == '(')
					parSum--;
				i--;
			}
			i--;
		} else {
			calculation = Long.parseLong(l[i] + "");
			i -= 2;
		}
		if (i <= 0) {
			return calculation;
		}
		if (l[i] == '*') {
			calculation = calculation * calculater(line.substring(0, i));

		} else if (l[i] == '+') {
			calculation = calculation + calculater(line.substring(0, i));
		}
		return calculation;
	}
}
