package Controlleur;

public interface IObserver {
	 void notifyTempChanged(double temp);
	 void notifyHumidityChanged(double humidity);
	 void notifyConsigneChanged(double consigne);
	
}
