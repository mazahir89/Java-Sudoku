
public class Super {

	Rute[] rute;
	int d;

	Super(int d){
		this.d = d;
		rute = new Rute[d];
	}
	public boolean erTatt(String verdi) {
		for(int i = 0; i < d; i++) {
				
				if(rute[i].verdi.equals(verdi)) {
					return true;
			}
		}
		return false;
	}
}