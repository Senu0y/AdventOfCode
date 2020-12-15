package package1;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class Tor8 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("tor8input");
		Scanner scani = new Scanner(file);

		String[] input = scani.useDelimiter("\\A").next().split("\n");

		for (int i = 0; i < input.length; i++) {
			String[] input2 = input.clone();

			if (input2[i].contains("jmp")) {
				input2[i] = "nop " + input2[i].split(" ")[1];
			//	System.out.println(input2[i]);
			} else if (input2[i].contains("nop")) {
				input2[i] = "jmp " + input2[i].split(" ")[1];
			}

			int acc = program(input2);
			//System.out.println(acc);
			if (acc == -1) {
				continue;
			} else
				System.out.println(acc);
		}

	}

	static int program(String[] input) {
		int curIdx = 0;
		int acc = 0;
		boolean[] visited = new boolean[input.length];
		while (true) {
			// System.out.println("OLD " + oldidx);
			// System.out.println("cur " + curIdx);
if(curIdx==input.length) {
	break;
}
			
			if (visited[curIdx]) {

				break;

			}

			visited[curIdx] = true;

			if (input[curIdx].contains("jmp")) {

				curIdx += Integer.parseInt(input[curIdx].split(" ")[1]);

			} else if (input[curIdx].contains("acc")) {
				// System.out.println("acc: "+input[curIdx].split(" ")[1]);
				acc += Integer.parseInt(input[curIdx].split(" ")[1]);
				curIdx++;
			} else {

				curIdx++;
			}

		}
		if (curIdx != input.length) {
			return -1;
		}
		return acc;
	}
}
