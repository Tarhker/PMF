#include <DHT.h>
#define DHTPIN A0     
#define DHTTYPE DHT22  

DHT dht(DHTPIN, DHTTYPE);

//Variables
double hum;  
double temp; 
int tempPin = A0;
int value_received;
int humidityPin = 2;

void setup(){
    Serial.begin(9600);
    dht.begin();

}

void loop(){
  
    double hum = dht.readHumidity();
    double temp= dht.readTemperature();
   
  
    Serial.print(temp);
    Serial.print(";");
    Serial.print(hum);
    Serial.println(";");

  
    if (Serial.available() > 0) {
      
      value_received = Serial.read();
      
        digitalWrite(tempPin, value_received);
        digitalWrite(humidityPin, value_received);
    }
    
    delay(1000); //1 sec
}
