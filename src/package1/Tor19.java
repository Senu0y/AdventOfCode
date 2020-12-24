package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Tor19 {
	static HashMap<Integer, String> hashimapi;

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("Tor19input");
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
		
		ArrayList<String> output =taucher(rulemaker(hashimapi.get(0)), 0);
		//System.out.println(elefant.get(0).toString());
		HashSet<String> result= new HashSet<String>();
		for (String current: output) {
			result.add(current);
		}
		String s=result.toString();

		//System.out.println(result.toString());
		//System.out.println(elefant.get(0).get(0));
		//System.out.println(elefant.get(0).get(100));
		
		//System.out.println(Arrays.deepToString(rulemaker(hashimapi.get(78))));
		int couter=0;
		for (int j = 0; j < data.length; j++) {
			
			if(result.contains(data[j])) {
				couter++;
			}
			
		}
		System.out.println(couter);
		System.out.println(elefant.get(8).size());
	}

	static int[][] rulemaker(String s) {

		String[] rules2 = s.split(" \\| ");
		int[][] output = new int[2][2];
		if (s.equals("a")) {
			int[][] ret = { { -1, 0 }, null };
			return ret;
		}
		if (s.equals("b")) {
			int[][] ret = { { -2, 0 }, null };
			return ret;
		}
		if (rules2.length == 1) {
			output[0][0] = Integer.parseInt(rules2[0].split(" ")[0]);
			if (rules2[0].split(" ").length != 1) {
				output[0][1] = Integer.parseInt(rules2[0].split(" ")[1]);
//				if (rules2[0].split(" ").length == 3) {
//					output[0][2] = Integer.parseInt(rules2[0].split(" ")[2]);
//
//				} else {
//					output[0][2] = 0;
//				}
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

	static ArrayList<String> taucher(int[][] regel, int nummer) {
		int[] links = regel[0];
		int[] rechts = regel[1];
		ArrayList<String> fertigL = new ArrayList<String>();
		ArrayList<String> fertigR = new ArrayList<String>();
		ArrayList<String> ganzFertig = new ArrayList<String>();

		if (!elefant.get(nummer).isEmpty()) {
			//System.out.println("hier");
			return elefant.get(nummer);
		}
		
		if (links[0] == -1 || links[0] == -2) {
			if (links[0] == -1) {
				ganzFertig.add("a");
			} else {
				ganzFertig.add("b");
			}
			
			elefant.set(nummer,ganzFertig);
			
			
			return ganzFertig;
		}

		ArrayList<String> danny = taucher(rulemaker(hashimapi.get(links[0])), links[0]);

		if (links[1] != 0) {
			ArrayList<String> leon = taucher(rulemaker(hashimapi.get(links[1])), links[1]);
			for (String current : danny) {
				for (String curr : leon) {
					fertigL.add(current + curr);
				}
			}
		} else {
			fertigL = danny;
		}

		if (rechts != null) {

			ArrayList<String> peter = taucher(rulemaker(hashimapi.get(rechts[0])), rechts[0]);
			if (rechts[1] != 0) {
				ArrayList<String> leon = taucher(rulemaker(hashimapi.get(rechts[1])), rechts[1]);
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
		elefant.set(nummer,ganzFertig);
//		System.out.println(nummer+"el "+ elefant.get(nummer));
		return ganzFertig;
	}

	static HashSet<String> magic(int[][] inp) { // key 12 = b 106 =a
		String holder1 = "";
		String holder2 = "";
		int[] rules1 = inp[0];
		int[] rules2 = inp[1];
		int a = 4;
		int b = 5;
		HashSet<String> hashi = new HashSet<String>();
		HashSet<String> hashi2 = new HashSet<String>();
		HashSet<String> mix2 = new HashSet<String>();
		System.out.println("new round " + Arrays.deepToString(inp));
		if (rules1[0] == b) {
			holder1 += "b";
		} else if (rules1[0] == a) {
			holder1 += "a";
		} else {
			hashi.addAll(magic(rulemaker(hashimapi.get(rules1[0]))));
		}

		if (rules1[1] != -1) {
			if (rules1[1] == b) {
				holder1 += "b";
			} else if (rules1[1] == a) {
				holder1 += "a";
			} else {

				HashSet<String> tmp = new HashSet<String>();
				HashSet<String> rec = magic(rulemaker(hashimapi.get(rules1[1])));
				for (String current : hashi) {
					for (String curri : rec) {
						tmp.add(holder1 + current + curri);
					}
				}
				holder1 = "";
				hashi = tmp;
			}
		}
		if (rules1[2] != 0) {

			if (rules1[2] == b) {
				holder1 += "b";
			} else if (rules1[2] == a) {
				holder1 += "a";
			} else {
//				System.out.println("hier" + rules1[2]);

				HashSet<String> tmp = new HashSet<String>();
				HashSet<String> rec = magic(rulemaker(hashimapi.get(rules1[2])));
				for (String current : hashi) {
					for (String curri : rec) {
						tmp.add(holder1 + current + curri);
					}
				}
				holder1 = "";
				hashi = tmp;
			}
		}
		if (rules2 != null) {

			if (rules2[0] == b) {
				holder2 += "b";
			} else if (rules2[0] == a) {
				holder2 += "a";
			} else {
				hashi2.addAll(magic(rulemaker(hashimapi.get(rules2[0]))));
			}

			if (rules2[1] != -1) {
				if (rules2[1] == b) {
					holder2 += "b";
				} else if (rules1[1] == a) {
					holder2 += "a";
				} else {
					hashi2.addAll(magic(rulemaker(hashimapi.get(rules2[1]))));
				}
			}
		}

		System.out.println("holder 1 " + holder1);
		System.out.println("holder 2 " + holder2);
//		System.out.println("v " + hashi.toString() + "h " + holder1);
		if (!holder1.equals(""))

		{
			HashSet<String> tmp = new HashSet<String>();
			for (String current : hashi) {
				tmp.add(holder1 + current);
			}
			hashi = tmp;
			if (hashi.isEmpty()) {
				hashi.add(holder1);
			}

		}
//		System.out.println("v " + hashi.toString());
		if (!holder2.equals("")) {
			HashSet<String> tmp = new HashSet<String>();
			for (String current : hashi2) {
				tmp.add(holder2 + current);
			}
			hashi2 = tmp;
			if (hashi2.size() == 0 && !holder2.equals("")) {
				hashi2.add(holder2);
			}
		}
//		System.out.println("n " + hashi.toString());
//		System.out.println(holder1);
		hashi.addAll(hashi2);
		System.out.println("Ende " + hashi.toString());

		return hashi;
	}

	static LinkedList<String> stringMaker(int[][] inp) {		// loop 1: 42 31 | 42 11 31
		int a = 106;											// : 42 | 42 8
		int b = 12;
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("hier");
		System.out.println(Arrays.deepToString(inp));
		int[] rulepack1 = inp[0];
		int[] rulepack2 = inp[1];
		LinkedList<String>[] list3 = new LinkedList[3];
		list3[0] = new LinkedList<String>();
		list3[1] = new LinkedList<String>();
		list3[2] = new LinkedList<String>();

		for (int i = 0; i < rulepack1.length; i++) {
			if (rulepack1[i] == a) {
				list3[i].add("a");
			} else if (rulepack1[i] == b) {
				list3[i].add("b");
			} else if (rulepack1[i] == 0) {
				continue;
			} else {
				for (String current : stringMaker(rulemaker(hashimapi.get(rulepack1[i])))) {
					list3[i].add(current);
				}
			}
		}
		if (list3[1].isEmpty() && list3[2].isEmpty()) {
			for (String current1 : list3[0]) {
				list.add(current1);
			}
		} else if (list3[2].isEmpty()) {
			for (String current1 : list3[0]) {
				for (String current2 : list3[1]) {
					list.add(current1 + current2);
				}
			}
		} else {
			for (String current1 : list3[0]) {
				for (String current2 : list3[1]) {
					for (String current3 : list3[2]) {
						list.add(current1 + current2 + current3);
					}
				}
			}
		}

		if (rulepack2 == null) {
			return list;
		}

		LinkedList<String>[] list3b = new LinkedList[3];
		list3b[0] = new LinkedList<String>();
		list3b[1] = new LinkedList<String>();
		list3b[2] = new LinkedList<String>();

		for (int i = 0; i < rulepack2.length; i++) {
			if (rulepack2[i] == a) {
				list3b[i].add("a");
			} else if (rulepack2[i] == b) {
				list3b[i].add("b");
			} else if (rulepack2[i] == 0) {
				continue;
			} else {
				for (String current : stringMaker(rulemaker(hashimapi.get(rulepack2[i])))) {
					list3b[i].add(current);
				}
			}
		}
		if (list3b[1].isEmpty() && list3b[2].isEmpty()) {
			for (String current1 : list3b[0]) {
				list.add(current1);
			}
		} else if (list3b[2].isEmpty()) {
			for (String current1 : list3b[0]) {
				for (String current2 : list3b[1]) {
					list.add(current1 + current2);
				}
			}
		} else {
			for (String current1 : list3b[0]) {
				for (String current2 : list3b[1]) {
					for (String current3 : list3b[2]) {
						list.add(current1 + current2 + current3);
					}
				}
			}
		}
		System.out.println(list.toString());

		return list;
	}
}
