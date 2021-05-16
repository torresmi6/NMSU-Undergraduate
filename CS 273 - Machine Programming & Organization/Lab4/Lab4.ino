//Lab4.ino
//Feb 27, 2020
// Michael Torres
// Flashes GoAggies in morse code a number of times depending on user input
//    Takes an ioput morse string in binary and converts it into letters
extern byte val;
extern byte width;
extern byte ascii;

extern "C" { 
  void decode_morse();
}

extern "C" {
  void goaggies();
}
//
// function to read a 2-digit decimal value from user
//
byte read2DigitValue()
{
  byte inch; int val;
  Serial.println("Enter a 2-digit decimal value:");
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val = (inch - '0') * 10;
  while (!Serial.available()) delay(100);
  inch = Serial.read();
  val += (inch - '0');
  Serial.print("The value entered is ");
  Serial.println(val,DEC);
  return (byte) val;
}

void flashGoAggies() 
{
  // Add you code here
  byte count = read2DigitValue();

  for(byte i = 0; i < count; i++){  //calls goaggies subroutine i times where i is input
    goaggies();
  }
  // You will call the GoAggies() function from assembly file GoAggies.S
}

void decodeMorse(const String & string, char message[])
{
  // Write your code below.
  // string contains the input binary string separated by single spaces
  //for( string length)
  //  count
  // store char in temp string
  //  until space
  // store width with count, val with temp, and decode morse
  //  store ascii in message[i]
  //  
  int a = 0, b = 0;
  val = 0;
  width = 0;
  while(a < string.length()){
   /* temp = "";
    val = 0;
    width = 0;
    while(string[a] != ' ' && a < string.length()){
      temp = temp + string[a];
      a++;
      width++;
 
    }*/
    if(string[a] == ' '){ // If char in string is a space, call decodeMorse, store ascii in message array, and reset val and width values
      decode_morse();
      val = 0;
      width = 0;
      message[b++] = ascii;
    }
    else{ // if char is not a space, convert binary string into bytes
      val = val * 2 + (string[a] - '0');
      width = width + 1;
    }

    a++;
  }
  message[b] = '\0';
  // message contains the decoded English characters and numbers    
  // You will call the assembly function decode_morse()
}



void decodeMorse() 
{
  Serial.println("Input a Morse code string (separate the code for characters by a space):");

  while (!Serial.available()) delay(100);
  String string = Serial.readString();

  Serial.print("The Morse code string is: ");
  Serial.println(string);

  //string = "1000 100 0"; // "01 1000";
  char message[100];

  decodeMorse(string, message);

  if(strlen(message) > 0) {
    Serial.print("The decoded message is: ");
    Serial.println(message);
  } else {
    Serial.print("Failure in decoding the input Morse code\n");
    Serial.println(message);
  }  
}

void setup() {
  //
  // Initialize serial communications
  //
  Serial.begin(9600);

  flashGoAggies();

  decodeMorse();
  
}

void loop() {
  // put your main code here, to run repeatedly:
  delay(20000); // 20,000 millisecs == 20 seconds
  Serial.println("*");
}
