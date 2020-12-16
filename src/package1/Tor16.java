package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor16 {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor16input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");
		String[] validnumbers = new String[20];
		scani.close();
		for (int i = 0; i < validnumbers.length; i++) {
			validnumbers[i] = input[i].strip();
		}
		for (int i = 0; i < validnumbers.length; i++) {
			validnumbers[i] = validnumbers[i].split(": ")[1].strip();
		}
		String[][] validnumbersAll = new String[20][2];
		for (int i = 0; i < validnumbers.length; i++) {
			validnumbersAll[i] = validnumbers[i].split(" or ");
		}
		String[] tickets = new String[236];
		for (int i = 0; i < tickets.length; i++) {
			tickets[i] = input[i + 25];
		}
		String[][] ticketsAll = new String[236][30];
		for (int i = 0; i < tickets.length; i++) {
			ticketsAll[i] = tickets[i].split(",");
		}

		int sum = 0;
		for (int i = 0; i < ticketsAll.length; i++) {
			for (int j = 0; j < ticketsAll[i].length; j++) {
				boolean isRange = false;
				int number = Integer.parseInt(ticketsAll[i][j].strip());
				for (int j2 = 0; j2 < validnumbersAll.length; j2++) {
					if (isInRange(validnumbersAll[j2], number)) {
						isRange = true;
					}
				}
				if (!isRange) {
					sum += number;
				}
			}
		}
		System.out.println(sum);// 26869
	}

	static boolean isInRange(String[] s, int number) {
		int[] range1 = { Integer.parseInt(s[0].split("-")[0]), Integer.parseInt(s[0].split("-")[1]) };
		int[] range2 = { Integer.parseInt(s[1].split("-")[0]), Integer.parseInt(s[1].split("-")[1]) };

		if (number >= range1[0] && number <= range1[1])
			return true;
		if (number >= range2[0] && number <= range2[1])
			return true;
		return false;
	}

}
