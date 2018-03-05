
public class Test {
	
	static Rute rute;
	static Brett brett;
	static Rad rad;
	static Kolonne kolonne;
	static Boks boks;
	int b, h;
	static Sudoko s;

	public static void main(String[] args) {
		s = new Sudoko("data.txt");
		skrivUt();

	}
	public static void skrivUt() {
		int D = 6;
		System.out.println("\nSjekker boks, rute og kolonne! \n");
		for(int i = 0; i < D; i++) {
				System.out.println(boks.rute[i].verdi);
				System.out.println(rad.rute[i].verdi);
				System.out.println(kolonne.rute[i].verdi);
		}
	}

}
