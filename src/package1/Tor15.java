package package1;

import java.util.HashMap;

public class Tor15 {

	public static void main(String[] args) {

		int[] input = { 9, 3, 1, 0, 8, 4 };
		HashMap<Integer, Integer> hashi = new HashMap<Integer, Integer>();

		for (int i = 0; i < input.length - 1; i++) {
			hashi.put(input[i], i + 1);
		}
		System.out.println(hashi.toString());
		int lastnumber = input[input.length - 1];
		int newNumber = 0;
		for (int i = input.length + 1; i < 30000001; i++) {

			if (hashi.containsKey(lastnumber)) {

				newNumber = i - 1 - hashi.get(lastnumber);
				hashi.put(lastnumber, i - 1);

			} else {
				hashi.put(lastnumber, i - 1);
				newNumber = 0;
			}
			lastnumber = newNumber;
		}
		System.out.println(lastnumber);
	}
}
