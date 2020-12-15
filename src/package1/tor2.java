package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import java.lang.StringBuffer;

public class tor2 {

	public static void main(String[] args) throws FileNotFoundException {

		File text = new File("tor2text");
		Scanner scani = new Scanner(text);
		String line = new String();
		StringBuilder stribu = new StringBuilder();
		int counter = 0;
		while (scani.hasNextLine()) {
			line = scani.nextLine();
			// System.out.println(line);
			Scanner scaniLine = new Scanner(line);
			String zahlen = scaniLine.next();

			stribu = new StringBuilder(zahlen);
			int indexi = stribu.indexOf("-");

			int zahl1 = Integer.parseInt(zahlen.substring(0, indexi));
			int zahl2 = Integer.parseInt(zahlen.substring(indexi + 1));

			char charbu = scaniLine.next().charAt(0);
			String passwort = scaniLine.next();
			stribu = new StringBuilder(passwort);
			int counterklein = 0;
			while (stribu.toString().contains(charbu + "")) {

				int indexofchar = stribu.indexOf(charbu + "");
				stribu.deleteCharAt(indexofchar);
				System.out.println(stribu.toString());
				counterklein++;
			}
			if ((counterklein <= zahl2) && (counterklein >= zahl1)) {
				counter++;
			}
			// System.out.println(buchstabe);

			scaniLine.close();
		}

		scani.close();
System.out.println(counter);
	}

}
