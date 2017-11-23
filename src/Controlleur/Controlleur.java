package Controlleur;

import Modele.Modele;
import Vue.Vue;

public class Controlleur implements IObserver{
	
	Vue maVue;
	Modele monModele;
	
	public Controlleur(Modele modele) {
		monModele = modele;
		maVue = new Vue(this);
		maVue.setVisible(true);
		
	}

	@Override
	public void notifyTempChanged(double temp) {
		maVue.setTempValue(temp);
		
	}

	@Override
	public void notifyHumidityChanged(double humidity) {
		maVue.setHumidityValue(humidity);
		
	}

	@Override
	public void notifyConsigneChanged(double consigne) {
		maVue.setConsigne(consigne);
		
	}
	
	public void plusConsigne(String oldConsigne) {
        String[] oldTemp = oldConsigne.split(" ");
        double newTemp = Double.parseDouble(oldTemp[0]) + 1;
        monModele.setConsigne(newTemp);
    }

    public void moinsConsigne(String oldConsigne) {
        String[] oldTemp = oldConsigne.split(" ");
        double newTemp = Double.parseDouble(oldTemp[0]) - 1;
        monModele.setConsigne(newTemp);
}

}
