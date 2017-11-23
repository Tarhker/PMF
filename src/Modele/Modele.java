package Modele;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.IO;

import Controlleur.Controlleur;
import Controlleur.IObserver;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public class Modele {

	private double tempActuelle;
	private boolean ouverturePorte;
	private double consigne;
	private double humidite;
	private List<IObserver> listeObserveurs = new ArrayList<IObserver>();
	
	public Modele(){
		/*this.tempActuelle = 0;
		this.ouverturePorte = false;*/
		this.setConsigne(19);
		//this.humidite = 0;
	}

	public double getTempActuelle() {
		return tempActuelle;
	}

	public void setTempActuelle(double tempActuelle) {
		this.tempActuelle = tempActuelle;
		notifyTemperatureChanged();
	}

	public boolean isOuverturePorte() {
		return ouverturePorte;
	}

	public void setOuverturePorte(boolean ouverturePorte) {
		this.ouverturePorte = ouverturePorte;
	}

	public double getConsigne() {
		return consigne;
	}

	public void setConsigne(double consigne) {
		this.consigne = consigne;
		notifyConsigneChanged();
	}

	public double getHumidite() {
		return humidite;
	}

	public void setHumidite(double humidite) {
		this.humidite = humidite;
		notifyHumidityChanged();
	}
	
	public void addListener(IObserver listener) {
		// TODO Auto-generated method stub
		listeObserveurs.add(listener);
	}

	public void removeListener(IObserver listener) {
		// TODO Auto-generated method stub
		listeObserveurs.remove(listener);
	}
	
    private void notifyTemperatureChanged() {
        for (IObserver observer : listeObserveurs) {
            observer.notifyTempChanged(this.tempActuelle);
        }
    }
   
    private void notifyHumidityChanged() {
        for (IObserver observer : listeObserveurs) {
            observer.notifyHumidityChanged(this.humidite);
        }
}
	
    private void notifyConsigneChanged(){
    	for (IObserver observer : listeObserveurs){
    		observer.notifyConsigneChanged(this.consigne);
    	}
    }


}
