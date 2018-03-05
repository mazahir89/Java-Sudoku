import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sudoko {
	public Brett brett;
	Rute forrige;
	public int rad, kolonne;
	public int h, b;
	Scanner scan;
	int count;

	public static void main(String[] args) {

		if (args.length > 0) {
			String fil = args[0];
			new Sudoko(fil);
		}
		else {
			System.out.println("Feil, finner ikke filen!");
		}
	}

	public Sudoko(String fil) {

		brett = null;
		rad = 0;
		kolonne = 0;
		b = 0;
		h = 0;

		lesFil(fil);
	}
	public void lesFil(String fil) {

		try {
			scan = new Scanner(new File(fil));
			h = scan.nextInt();
			b = scan.nextInt();
			scan.nextLine();
			count = 0;
			brett = new Brett(h,b);

			System.out.println("Leser inn brettet!\n");
			while(scan.hasNext()) {
				char[] line = scan.nextLine().toCharArray();
				for(int i = 0; i < line.length; i++) {
					System.out.print(line[i] + " ");
					for(int j = 0; j < line.length; j++) {
						brett.rute[i][j] = new Rute(line[i], h, b);
						if(forrige != null) {
							forrige.neste = brett.rute[i][j];
							forrige = forrige.neste;
							


						}
					}
				}
				System.out.println();

				count++;
			}
			int D = b*h;

			brett.rad = new Rad[D];
			brett.kolonne = new Kolonne[D];
			brett.boks =  new Boks[h][b];

			for(int i = 0; i < D; i++) {

				brett.rad[i] = new Rad(D);
				brett.kolonne[i] = new Kolonne(D);
			}

			for(int i = 0; i < D; i++) {
				for(int j = 0; j < D; j++){

					brett.rute[i][j].rad = brett.rad[i];
					brett.rute[i][j].kolonne = brett.kolonne[j];
					//System.out.println(brett.rad[i]);
					//System.out.println(brett.kolonne[i]);
				}
			}
			for(int i = 0; i < h; i++) {
				for (int j = 0; j < b; j++) {
					brett.boks[i][j] = new Boks(h, b);
				}
			}
			for(int i = 0; i < D; i++) {
				for(int j = 0; j < D; j++){
					brett.rute[i][j].boks = brett.boks[i/b][j/h];

				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IndexOutOfBoundsException e){
			e.printStackTrace();
		} 
	}
}