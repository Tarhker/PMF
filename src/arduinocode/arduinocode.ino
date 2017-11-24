
#include <DHT.h>
#define DHTPIN A0     
#define DHTTYPE DHT22  

/
DHT dht(DHTPIN, DHTTYPE);

//Variables
float hum;  
float temp; 
int ledPin = 13;
int value_received;
int fanPin = 9;

void setup(){
    Serial.begin(9600);
    dht.begin();
    pinMode(ledPin, OUTPUT);
    pinMode(fanPin, OUTPUT);
}

void loop(){
  
    float hum = dht.readHumidity();
    float temp= dht.readTemperature();
   
  
    Serial.print(temp);
    Serial.print(";");
    Serial.print(hum);
    Serial.println(";");

  
    if (Serial.available() > 0) {
      
      value_received = Serial.read();
      
        digitalWrite(ledPin, value_received);
        digitalWrite(fanPin, value_received);
    }
    
    delay(1000); //1 sec
}
