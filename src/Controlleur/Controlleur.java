package Controlleur;

import Modele.Modele;
import Vue.Vue;

public class Controlleur implements IObserver{
	
	Vue maVue;
	Modele monModele;
	
	public Controlleur(Modele modele) {
		monModele = modele;
		maVue = new Vue(this);
		maVue.frame.setVisible(true);
		
	}

	@Override
	public void notifyTempChanged(double temp) {
		maVue.changeTemp(temp);
		
	}

	@Override
	public void notifyHumidityChanged(double humidity) {
		maVue.changeHumidity(humidity);
		
	}

}
