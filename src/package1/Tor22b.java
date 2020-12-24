package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Tor22b {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Tor22input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("Player 2:");

		String[] player1 = input[0].split("\\n");
		String[] player2 = input[1].split("\\n");

		LinkedList<Integer> p1 = new LinkedList<Integer>();
		LinkedList<Integer> p2 = new LinkedList<Integer>();
		for (int i = 1; i < player2.length; i++) {

			p1.add(Integer.parseInt(player1[i].strip()));
			p2.add(Integer.parseInt(player2[i].strip()));
		}

		LinkedList<Integer> p1copy = null;
		while (!p1.isEmpty() && !p2.isEmpty()) {

			if (p1.equals(p1copy)) {
				System.out.println("infitnit");
				break;
			}

			p1copy = (LinkedList<Integer>) p1.clone();
			System.out.println(p1.getFirst() < p1.size());
			System.out.println("aussen" + p1.toString());
			System.out.println("p2 " + p2.toString());
			if (p1.getFirst() < p1.size() && p2.getFirst() < p2.size()) {

				LinkedList<Integer> p1rec = (LinkedList<Integer>) p1.clone();
				LinkedList<Integer> p2rec = (LinkedList<Integer>) p2.clone();
				LinkedList<Integer> p1out = new LinkedList<Integer>();
				LinkedList<Integer> p2out = new LinkedList<Integer>();

				if (p1.getFirst() > p1.size() - 2) {

					p1out.addAll(p1rec);
					p1out.removeFirst();
				} else {
					System.out.println("hier" + p1rec.toString());
					p1out.addAll(p1rec.subList(1, p1.getFirst() + 1));
					System.out.println(p1out.toString());
				}
				if (p2.getFirst() > p2.size() - 2) {
					p2out.addAll(p2rec);
					p2out.removeFirst();
				} else {
					p2out.addAll(p2rec.subList(1, p2.getFirst() + 1));
				}
				System.out.println("debug" + p1out.toString());
				System.out.println(p2out.toString());
				if (magic(p1out, p2out)) {

					p1.add(p1.removeFirst());
					p1.add(p2.removeFirst());
				} else {
					p2.add(p2.removeFirst());
					p2.add(p1.removeFirst());
				}

			} else {

				if (p1.getFirst() > p2.getFirst()) {
					p1.add(p1.removeFirst());
					p1.add(p2.removeFirst());
				} else {
					p2.add(p2.removeFirst());
					p2.add(p1.removeFirst());
				}

			}
		}

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		Long result = 0l;
		if (p1.isEmpty()) {

			for (int i = 1; i < p2.size() + 1; i++) {
				System.out.println(p2.get(p2.size() - i) * i);
				result += p2.get(p2.size() - i) * i;
			}
		} else {

			for (int i = 1; i < p1.size() + 1; i++) {
				result += p1.get(p1.size() - i) * i;
			}
		}
		System.out.println(result); // 33037 too low

	}

	public static boolean magic(LinkedList<Integer> p1, LinkedList<Integer> p2) {

		LinkedList<Integer> p1copy = null;
		System.out.println(p1.toString());
		System.out.println(p1.getFirst() < p1.size());
		System.out.println("p1" + p1.toString());
		System.out.println("p2 " + p2.toString());
		while (!p1.isEmpty() && !p2.isEmpty()) {
			if (p1.equals(p1copy)) {
				System.out.println("infitnit");
				return true;
			}

			p1copy = (LinkedList<Integer>) p1.clone();
			p1copy.removeFirst();
			if (p1.getFirst() < p1.size() && p2.getFirst() < p2.size()) {

				LinkedList<Integer> p1rec = (LinkedList<Integer>) p1.clone();
				LinkedList<Integer> p2rec = (LinkedList<Integer>) p2.clone();
				LinkedList<Integer> p1out = new LinkedList<Integer>();
				LinkedList<Integer> p2out = new LinkedList<Integer>();

				if (p1.getFirst() > p1.size() - 2) {

					p1out.addAll(p1rec);
					p1out.removeFirst();
				} else {
					System.out.println("hier" + p1rec.toString());
					p1out.addAll(p1rec.subList(1, p1.getFirst() + 1));
					System.out.println(p1out.toString());
				}
				if (p2.getFirst() > p2.size() - 2) {
					p2out.addAll(p2rec);
					p2out.removeFirst();
				} else {
					p2out.addAll(p2rec.subList(1, p2.getFirst() + 1));
				}

				if (magic(p1out, p2out)) {
					p1.add(p1.removeFirst());
					p1.add(p2.removeFirst());
				} else {
					p2.add(p2.removeFirst());
					p2.add(p1.removeFirst());
				}

			} else {
				if (p1.getFirst() > p2.getFirst()) {
					p1.add(p1.removeFirst());
					p1.add(p2.removeFirst());
				} else {
					p2.add(p2.removeFirst());
					p2.add(p1.removeFirst());
				}

			}
		}

		if (p1.isEmpty()) {

			return false;
		} else {

			return true;
		}

	}

}
