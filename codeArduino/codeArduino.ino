#include <DHT.h>
#define DHTPIN A0     
#define DHTTYPE DHT22  

DHT dht(DHTPIN, DHTTYPE);

//Variables
double hum;  
double temp; 
int digtalPin = 9;
int value_received;
int analogPin = 13;

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
      
        digitalWrite(digtalPin, value_received);
        digitalWrite(analogPin, value_received);
    }
    
    delay(1000); //1 sec
}
