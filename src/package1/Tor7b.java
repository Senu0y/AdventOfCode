package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Tor7b {
	static HashMap<String, HashSet<String>> bags;

	public static void main(String[] args) throws FileNotFoundException {

		bags = new HashMap<String, HashSet<String>>();

		File input = new File("tor7input");
		Scanner scani = new Scanner(input);

		Scanner scaniline;

		while (scani.hasNextLine()) {
			String s = scani.nextLine();
			// System.out.println(s);
			scaniline = new Scanner(s);
			String name = scaniline.next() + " " + scaniline.next();
			HashSet<String> valueHashmap = new HashSet<String>();
			bags.put(name, valueHashmap);

			scaniline.next();
			scaniline.next();

			while (scaniline.hasNext()) {
				String text = scaniline.next() + " " + scaniline.next() + " " + scaniline.next();
				if (scaniline.hasNext()) {
					valueHashmap.add(text);
					scaniline.next();
					continue;
				} else {
					break;
				}

			}

		}
		

		System.out.println(magic("shiny gold"));

	}

	private static int magic(String key) {
		int total = 0;
		//System.out.println(key);
		HashSet<String> valueHashmap = bags.get(key);
		//System.out.println(valueHashmap.toString());

		for (String current : valueHashmap) {
			total+=Integer.parseInt(String.valueOf(current.charAt(0)));
			total = total + magic(current.substring(2))*Integer.parseInt(String.valueOf(current.charAt(0)));

		}
System.out.println(total);
		return total;
	}

}
