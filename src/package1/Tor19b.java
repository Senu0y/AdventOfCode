package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Tor19b {
	static HashMap<Integer, String> hashimapi;

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor19binput");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");
		hashimapi = new HashMap<Integer, String>();
		scani.close();
		int i = 0;
		while (!input[i].isBlank()) {
			String[] split = input[i].split(": ");
			int ruleNumber = Integer.parseInt(split[0]);
			hashimapi.put(ruleNumber, split[1].strip());
			i++;
		}

		String[] data = new String[input.length - i - 1];
		for (int j = i + 1; j < input.length; j++) {
			data[j - i - 1] = input[j].strip();
		}

		for (int j = 0; j < hashimapi.size(); j++) {
			elefant.add(new ArrayList<String>());
		}

//		System.out.println(hashimapi.get(108));
//		System.out.println(Arrays.deepToString(rulemaker(hashimapi.get(108))));

		ArrayList<String> output = dannyDerTaucher(rulemaker(hashimapi.get(0)), 0);
//		// System.out.println(elefant.get(0).toString());
		HashSet<String> result = new HashSet<String>();
		for (String current : output) {
			result.add(current);
		}
//		String s=result.toString();
		// System.out.println(Arrays.deepToString(rulemaker(hashimapi.get(11))));
		// System.out.println(result.toString());
		// System.out.println(elefant.get(0).get(0));
		// System.out.println(elefant.get(0).get(100));

		// System.out.println(Arrays.deepToString(rulemaker(hashimapi.get(78))));
		int couter = 0;
		for (int j = 0; j < data.length; j++) {

			if (result.contains(data[j])) {
				couter++;
			}

		}
		System.out.println(couter);

	}

	static int[][] rulemaker(String s) {

		String[] rules2 = s.split(" \\| ");
		int[][] output = new int[2][3];
		if (s.equals("a")) {
			int[][] ret = { { -1, 0, 0 }, null };
			return ret;
		}
		if (s.equals("b")) {
			int[][] ret = { { -2, 0, 0 }, null };
			return ret;
		}

		if (s.equals("42 31 | 42 11 31")) {
			int[][] ret = { { 42, 31, 0 }, { 42, 11, 31 } };
			return ret;
		}

		if (rules2.length == 1) {
			output[0][0] = Integer.parseInt(rules2[0].split(" ")[0]);
			if (rules2[0].split(" ").length != 1) {
				output[0][1] = Integer.parseInt(rules2[0].split(" ")[1]);

			} else {

				output[0][1] = 0;
			}

			output[1] = null;
			return output;
		}

		if (rules2[1].split(" ").length != 1) {
			output[1][1] = Integer.parseInt(rules2[1].split(" ")[1]);
		} else {
			output[1][1] = 0;

		}
		if (rules2[0].split(" ").length != 1) {
			output[0][1] = Integer.parseInt(rules2[0].split(" ")[1]);
		} else {
			output[0][1] = 0;
		}
		output[0][0] = Integer.parseInt(rules2[0].split(" ")[0]);
		output[1][0] = Integer.parseInt(rules2[1].split(" ")[0]);

		return output;

	}

	static HashSet<String> allekombis = new HashSet<String>();

	static ArrayList<ArrayList<String>> elefant = new ArrayList<ArrayList<String>>();

	// 11: 42 31 | 42 11 31
	static ArrayList<String> dannyDerTaucher(int[][] regel, int nummer) { // 8: 42 | 42 8
		int[] links = regel[0];
		int[] rechts = regel[1];
		ArrayList<String> fertigL = new ArrayList<String>();
		ArrayList<String> fertigR = new ArrayList<String>();
		ArrayList<String> ganzFertig = new ArrayList<String>();

		if (nummer == 8) {
			System.out.println(elefant.get(nummer).size());
			if (elefant.get(nummer).size() >= 300) {
				System.out.println("hier");
				rechts = null;
			}
		}

		if (nummer == 11) {
			System.out.println("11 " + elefant.get(nummer).size());
			if (elefant.get(nummer).size() >= 26384) {
				System.out.println("hier");
				rechts = null;
			}
		}
		if (!elefant.get(nummer).isEmpty()) {
			// System.out.println("hier");
			return elefant.get(nummer);
		}

		if (links[0] == -1 || links[0] == -2) {
			if (links[0] == -1) {
				ganzFertig.add("a");
			} else {
				ganzFertig.add("b");
			}
			elefant.set(nummer, ganzFertig);
			return ganzFertig;
		}

		ArrayList<String> danny = dannyDerTaucher(rulemaker(hashimapi.get(links[0])), links[0]);
		if (links[1] != 0) {
			ArrayList<String> leon = dannyDerTaucher(rulemaker(hashimapi.get(links[1])), links[1]);
			for (String current : danny) {
				for (String curr : leon) {
					fertigL.add(current + curr);
				}
			}
		} else {
			fertigL = danny;
		}

		if (rechts != null) {

			ArrayList<String> peter = dannyDerTaucher(rulemaker(hashimapi.get(rechts[0])), rechts[0]);
			if (rechts[2] != 0) {

				if (nummer == 11) {
					ArrayList<String> hoffnig = new ArrayList<String>();
					System.out.println("hier2");
					if (!elefant.get(nummer).isEmpty()) {
						for (String itr : elefant.get(nummer)) {
							hoffnig.add(itr);
							for (String itr2 : fertigL) {

								hoffnig.add(itr + itr2);
							}

						}
						System.out.println("hoffnig " + hoffnig.size());
						elefant.set(nummer, hoffnig);
					} else {
						System.out.println("hier");
						elefant.set(nummer, fertigL);
					}

				}
				ArrayList<String> leon = dannyDerTaucher(rulemaker(hashimapi.get(rechts[1])), rechts[1]);
				ArrayList<String> yoda = dannyDerTaucher(rulemaker(hashimapi.get(rechts[1])), rechts[1]);
				for (String current : peter) {
					for (String curr : leon) {
						for (String curri : yoda) {
							fertigR.add(current + curr + curri);
						}
					}
				}

			} else if (rechts[1] != 0) {
				if (nummer == 8) {
					
					ArrayList<String> hoffnig = new ArrayList<String>();
					if (!elefant.get(nummer).isEmpty()) {
						for (String itr : elefant.get(nummer)) {
							hoffnig.add(itr);
							for (String itr2 : fertigL) {

								hoffnig.add(itr + itr2);
							}

						}
						System.out.println("hoffnig " + hoffnig.size());
						elefant.set(nummer, hoffnig);
					} else {
						System.out.println("hier");
						elefant.set(nummer, fertigL);
					}
				}

				ArrayList<String> leon = dannyDerTaucher(rulemaker(hashimapi.get(rechts[1])), rechts[1]);
				for (String current : peter) {
					for (String curr : leon) {
						fertigR.add(current + curr);
					}
				}
			} else {
				fertigR = peter;
			}

			ganzFertig.addAll(fertigL);
			ganzFertig.addAll(fertigR);

		} else {

			ganzFertig = fertigL;
		}
//		elefant.get(nummer).addAll(ganzFertig);
		elefant.set(nummer, ganzFertig);
//		System.out.println(nummer+"el "+ elefant.get(nummer));
		return ganzFertig;
	}

}
