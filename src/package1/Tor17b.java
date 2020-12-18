package package1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tor17b {

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
		boolean[][][][] gitter4d = new boolean[grosse * 2][grosse * 2][gitter.length + grosse][gitter[0].length
				+ grosse];

		for (int i = 0; i < gitter.length; i++) {
			for (int j = 0; j < gitter[0].length; j++) {
				if (gitter[i][j] == '#') {
					gitter4d[grosse / 2][grosse / 2][i + grosse / 2][grosse / 2 + j] = true;
				}
			}
		}

		boolean[][][][] gitter4dnew;
		for (int j3 = 0; j3 < 6; j3++) {
			gitter4dnew = new boolean[grosse * 2][grosse * 2][gitter.length + grosse][gitter[0].length + grosse];

			for (int j4 = 0; j4 < gitter4d.length; j4++) {
				for (int j2 = 0; j2 < gitter4d[0].length; j2++) {
					for (int i = 0; i < gitter4d[0][0].length; i++) {
						for (int j = 0; j < gitter4d[0][0][0].length; j++) {

							if (gitter4d[j4][j2][i][j]) {
								int neigh = nachAktiv(j4, j2, i, j, gitter4d);
								if (neigh == 2 || neigh == 3) {

									gitter4dnew[j4][j2][i][j] = true;
									continue;
								}
							} else {
								if (nachAktiv(j4, j2, i, j, gitter4d) == 3) {

									gitter4dnew[j4][j2][i][j] = true;

								}
							}

						}

					}
				}
			}
			gitter4d = gitter4dnew;
		}
		int counter = 0;
		for (int j3 = 0; j3 < gitter4d.length; j3++) {
			for (int j2 = 0; j2 < gitter4d[0].length; j2++) {
				for (int i = 0; i < gitter4d[0][0].length; i++) {
					for (int j = 0; j < gitter4d[0][0][0].length; j++) {

						if (gitter4d[j3][j2][i][j]) {
							counter++;
						}
					}
				}
			}
		}

		for (int i = 0; i < gitter4d.length; i++) {
		}
		System.out.println(counter);

	}

	static int nachAktiv(int k, int z, int i, int j, boolean[][][][] gitter) {
		int counter = 0;

		int[] ar = { -1, 0, 1 };
		int[] br = { -1, 0, 1 };
		int[] cr = { -1, 0, 1 };
		int[] dr = { -1, 0, 1 };
		for (int a : ar) {
			for (int b : br) {
				for (int c : cr) {
					for (int d : dr) {
						if ((a == 0 && b == 0) && (c == 0) && (d == 0)) {
							continue;
						}
						if (((z + a < 0 || i + b < 0) || (j + c < 0)) || (k + d < 0)) {
							continue;
						}
						if (k + d > gitter.length - 1 || z + a > gitter[0].length - 1
								|| (i + b > gitter[0][0].length - 1) || (j + c > gitter[0][0][0].length - 1)) {
							continue;
						}

						if (gitter[k + d][z + a][i + b][j + c] == true) {
							// System.out.println(" " + (z + a) + " " + (i + b) + " " + (j + c));
							counter++;
						}
					}
				}
			}
		}

		return counter;

	}
}
