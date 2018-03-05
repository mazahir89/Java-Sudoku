
public class Rute {

	int h;
	int b;
	int D = h*b;
	Rad rad;
	Kolonne kolonne;
	String verdi = null;
	Boks boks;
	Brett brett;
	Rute nyRute;
	Rute neste;
	String symbol = "123456789";



	public Rute(char verdi, int h, int b) {
		this.h = h;
		this.b = b;
		rad = null;
		kolonne = null;
		boks = null;
		this.verdi = String.valueOf(verdi);
	}	
	public int[] finnAlleMuligeTall() {
		int[] tabel = new int[D];

		for(int i = 0; i < D; i++) {

			if(!boks.rute[i].verdi.equals(symbol.charAt(i))) {
				tabel[i] = i;
			}
		}
		for(int j = 0; j < D; j++) {
			if(!rad.rute[j].verdi.equals(symbol.charAt(j))) {
				tabel[j] = j;
			}
		}
		for(int k = 0; k < D; k++) {
			if(!kolonne.rute[k].verdi.equals(symbol.charAt(k))) {
				tabel[k] = k;
			}
		}
		return tabel;
	}

}