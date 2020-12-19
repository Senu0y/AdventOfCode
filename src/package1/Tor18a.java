package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor18a {
	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor18input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");
		Long sum = 0l;
		scani.close();
		for (int i = 0; i < input.length; i++) {
			sum += calculater(input[i]);
		}
		// 8298263963837 correct
		System.out.println("SUM " + sum);
	}

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
