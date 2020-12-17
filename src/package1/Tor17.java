package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor17 {

	public static void main(String[] args) throws FileNotFoundException {

		File file = new File("tor17input");
		Scanner scani = new Scanner(file);
		String[] input = scani.useDelimiter("\\A").next().split("\\n");
		scani.close();
		char[][] gitter = new char[input.length][input[0].length() - 1];

		for (int i = 0; i < gitter.length; i++) {
			String line = input[i].strip();

			for (int j = 0; j < gitter[0].length; j++) {
				gitter[i][j] = line.charAt(j);
			}
		}
		int grosse = 30;
		boolean[][][] gitter3d = new boolean[grosse * 2][gitter.length + grosse][gitter[0].length + grosse];

		for (int i = 0; i < gitter.length; i++) {
			for (int j = 0; j < gitter[0].length; j++) {
				if (gitter[i][j] == '#') {
					gitter3d[grosse / 2][i + grosse / 2][grosse / 2 + j] = true;
				}
			}
		}

		boolean[][][] gitter3dnew;
		for (int j3 = 0; j3 < 6; j3++) {
			gitter3dnew = new boolean[grosse * 2][gitter.length + grosse][gitter[0].length + grosse];

			for (int j2 = 0; j2 < gitter3d.length; j2++) {
				for (int i = 0; i < gitter3d[0].length; i++) {
					for (int j = 0; j < gitter3d[0][0].length; j++) {

						if (gitter3d[j2][i][j]) {
							int neigh = nachAktiv(j2, i, j, gitter3d);
							if (neigh == 2 || neigh == 3) {

								gitter3dnew[j2][i][j] = true;
								continue;
							}
						} else {
							if (nachAktiv(j2, i, j, gitter3d) == 3) {

								gitter3dnew[j2][i][j] = true;

							}
						}
					}

				}
			}
			gitter3d = gitter3dnew;
		}
		int counter = 0;
		for (int j2 = 0; j2 < gitter3d.length; j2++) {
			for (int i = 0; i < gitter3d[0].length; i++) {
				for (int j = 0; j < gitter3d[0][0].length; j++) {

					if (gitter3d[j2][i][j]) {
						counter++;
					}
				}
			}
		}

		for (int i = 0; i < gitter3d.length; i++) {
		}
		System.out.println(counter);

	}

	/*
	 * static boolean[][][] cloner(boolean[][][] gitter) { boolean[][][] gitterclone
	 * = gitter.clone(); for (int i = 0; i < gitter.length; i++) { for (int j = 0; j
	 * < gitter[0].length; j++) { gitterclone[i][j] = gitter[i][j].clone(); // array
	 * cloner für Zukunft } }
	 * 
	 * return gitterclone;
	 * 
	 * }
	 */

	static int nachAktiv(int z, int i, int j, boolean[][][] gitter) {
		int counter = 0;
		int[] ar = { -1, 0, 1 };
		int[] br = { -1, 0, 1 };
		int[] cr = { -1, 0, 1 };

		for (int a : ar) {
			for (int b : br) {
				for (int c : cr) {

					if ((a == 0 && b == 0) && c == 0) {
						continue;
					}
					if ((z + a < 0 || i + b < 0) || (j + c < 0)) {
						continue;
					}
					if (z + a > gitter.length - 1 | i + b > gitter[0].length - 1 | (j + c > gitter[0][0].length - 1)) {
						continue;
					}

					if (gitter[z + a][i + b][j + c] == true) {
						System.out.println(" " + (z + a) + " " + (i + b) + " " + (j + c));
						counter++;
					}
				}
			}
		}
		return counter;
	}
}
