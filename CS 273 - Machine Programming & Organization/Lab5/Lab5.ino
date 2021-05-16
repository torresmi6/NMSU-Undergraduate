/*
  Showing number 0-9 on a Common Anode 7-segment LED display
  Displays the numbers 0-9 on the display, with one second inbetween.
    A
   ---
F |   | B
  | G |
   ---
E |   | C
  |   |
   ---
    D
  This example code is in the public domain.
 */
//Michael Torres
// 3/5/20
// Uses assembly to output a rotational output of digits 0-9
extern byte segment;
extern byte digit;

extern "C" {
 void setup_ports();
}



extern "C" {
  void display_segment();
}
// Pin 2-8 is connected to the 7 segments of the display.

// the setup routine runs once when you press reset:
void setup() {    
    Serial.begin(9600);            
  // initialize the digital pins as outputs.
  setup_ports();
}

// the loop routine runs over and over again forever:
void loop() {

  segment = 1;
  digit = 8;
  display_segment();  
  delay(1000);               // wait for a second

  segment = 3;
  digit = 1;
  display_segment();  
  delay(1000);               // wait for a second

//  segment = 2;
//  digit = 2;
//  display_segment();  
//  delay(1000);               // wait for a second
//
//  segment = 3;
//  digit = 3;
//  display_segment();  
//  delay(1000);               // wait for a second
//
//  segment = 0;
//  digit = 4;
//  display_segment();  
//  delay(1000);               // wait for a second
//
//  segment = 1;
//  digit = 5;
//  display_segment();  
//  delay(1000);               // wait for a second
//
//  segment = 2;
//  digit = 6;
//  display_segment();  
//  delay(1000);               // wait for a second
//
//  segment = 3;
//  digit = 7;
//  display_segment();  
//  delay(1000);               // wait for a second
//
//  segment = 0;
//  digit = 8;
//  display_segment();  
//  delay(1000);               // wait for a second
//
//  segment = 1;
//  digit = 9;
//  display_segment();  
//  delay(1000);               // wait for a second

 
}
