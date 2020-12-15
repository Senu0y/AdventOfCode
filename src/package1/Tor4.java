package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Tor4 {

	public static void main(String[] args) throws FileNotFoundException {
		File input = new File("tor4input");
		Scanner scani = new Scanner(input);

		HashSet<String> abkr = new HashSet<String>();
		int counter = 0;
		int counterinput = 0;
		String inputtext = "";
		
		while (scani.hasNextLine()) {
			String s = scani.nextLine();

			if (s.isBlank()) {

				counterinput++;
				// System.out.println("hier");
				if (abkr.size() == 8) {
					// System.out.println("da");

					abkr.clear();
					if (tester(inputtext)) {
						counter++;
					}
					inputtext = "";

					continue;
				}
				if ((abkr.size() == 7) && (!abkr.contains("cid"))) {

					abkr.clear();
					if (tester(inputtext)) {
						counter++;
					}
					inputtext = "";

					continue;
				} else {
					abkr.clear();
					inputtext = "";
					continue;
				}
			}

			if (s.contains("byr")) { // 1920 and at most 2002.
				abkr.add("byr");
			}
			if (s.contains("iyr")) {
				abkr.add("iyr");
			}
			if (s.contains("eyr")) {
				abkr.add("eyr");
			}
			if (s.contains("hgt")) {
				abkr.add("hgt");
			}
			if (s.contains("hcl")) {
				abkr.add("hcl");
			}
			if (s.contains("ecl")) {
				abkr.add("ecl");
			}
			if (s.contains("pid")) {
				abkr.add("pid");
			}
			if (s.contains("cid")) {
				abkr.add("cid");
			}
			inputtext += " " + s;
			// System.out.println("loop");
		}
		System.out.println(counter);
		System.out.println("counterinput " + counterinput);
	}

	public static boolean tester(String big) {
		Scanner scani2 = new Scanner(big);
		String s = "";
		int counterloop = 0;
		while (scani2.hasNext()) {
			// System.out.println("hier");
			s = scani2.next();

			// System.out.println(s);
			String text = s.substring(4);
			// System.out.println(s);
			if (s.contains("byr")) { // 1920 and at most 2002.

				int zahl = Integer.parseInt(text);

				if ((zahl < 1920) || (zahl > 2002)) {
					return false;
				}
				// System.out.println("1");
			}
			if (s.contains("iyr")) {// four digits; at least 2010 and at most 2020.

				if (text.length() != 4) {
					return false;
				}
				int zahl = Integer.parseInt(text);
				if ((zahl < 2010) || (zahl > 2020)) {
					return false;
				}
				// System.out.println("2");

			}
			if (s.contains("eyr")) {// Expiration Year) - four digits; at least 2020 and at most 2030.
				// System.out.println("3");
				if (text.length() != 4) {
					return false;
				}
				int zahl = Integer.parseInt(text);
				if ((zahl < 2020) || (zahl > 2030)) {
					return false;
				}
			}
			if (s.contains("hgt")) { // Height) - a number followed by either cm or in:
										// If cm, the number must be at least 150 and at most 193.
										// If in, the number must be at least 59 and at most 76.

				if (text.contains("cm")) {
					if (text.length() != 5) {
						return false;
					}
					int zahl = Integer.parseInt(text.substring(0, 3));

					if ((zahl < 150) || (zahl > 193)) {
						return false;
					}
				} else if (text.contains("in")) {

					if (text.length() != 4) {
						return false;
					}
					int zahl = Integer.parseInt(text.substring(0, 2));

					if ((zahl < 59) || (zahl > 76)) {
						return false;
					}
				} else {
					return false;
				}
				// System.out.println("4");
			}
			if (s.contains("hcl")) { // hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.

				if (text.length() != 7) {
					return false;
				}

				if (text.charAt(0) != '#') {
					if (!text.matches("([a-f]|[0-9])+")) {
						return false;
					}

				}
				// System.out.println("5");
			}
			if (s.contains("ecl")) { // ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.

				if (!(text.equals("amb") || text.equals("blu") || text.equals("brn") || text.equals("gry")
						|| text.equals("grn") || text.equals("hzl") || text.equals("oth"))) {
					
					return false;
				}
				// System.out.println("6");
			}
			if (s.contains("pid")) {// a nine-digit number, including leading zeroes.
				if (text.length() != 9) {
					return false;
				}
			}
			// System.out.println("7");
			if (s.contains("cid")) {
				continue;
			}
			counterloop++;
		}
		if (counterloop > 7) {
			System.out.println(big);
		}

		System.out.println(counterloop);
		return true;
	}
}
