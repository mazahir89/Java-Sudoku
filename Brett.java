
public class Brett {

	Brett brett;
	Rute[][] rute;
	Rad[] rad;
	Kolonne[] kolonne;
	Boks[][] boks;
	int b, h;
	int D = b*h;

	public Brett(int h, int b) {

		this.h = h;
		this.b = b;
		rute = new Rute[h*b][h*b];
	}

	public void delInnRuter() {

		for(int i = 0; i < D; i++) {
			for(int j = 0; j < D; j++) {
				brett.boks[i/b][j/h] = brett.rute[i][j].boks;
				brett.rad[i] = brett.rute[i][j].rad;
				brett.kolonne[j] = brett.rute[i][j].kolonne;
			}
		}
	}
}