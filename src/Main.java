import Controlleur.Controlleur;
import Modele.Modele;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		Modele model = new Modele();
		Controlleur controlleur = new Controlleur(model);
		model.addListener(controlleur);

		try {
			CAD cad = new CAD(model, "COM6");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
