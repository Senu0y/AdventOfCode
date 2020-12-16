package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class Tor16 {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor16input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");
		// System.out.println(Arrays.toString(input));

		String[] validnumbers = new String[20];

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
		
	//	System.out.println(Arrays.toString(tickets));
		String[][] ticketsAll = new String[236][30];
		for (int i = 0; i < tickets.length; i++) {
			ticketsAll[i] = tickets[i].split(",");
		}
	//	 System.out.println((ticketsAll[235][0]));
		// System.out.println(Arrays.deepToString((ticketsAll)));
		// System.out.println(Arrays.toString(validnumbers));
	//	System.out.println(Arrays.deepToString((validnumbersAll)));
		int sum=0;
		int[] canFit;
		for (int i = 0; i < ticketsAll.length; i++) {
			canFit = new int[20];
			for (int j = 0; j < ticketsAll[i].length; j++) {
				boolean isRange=false;
			//	System.out.println(ticketsAll[i][j]);
				int number = Integer.parseInt(ticketsAll[i][j].strip());
				for (int j2 = 0; j2 < validnumbersAll.length; j2++) {
					if (isInRange(validnumbersAll[j2], number)) {
						canFit[j] += 1;
						isRange=true;
					}
					
				}
				if(!isRange) {
					sum+=number;
				}

			}

		}
		System.out.println(sum);//26869
		
		System.out.println((long)73*137*151*67*79*107);
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
