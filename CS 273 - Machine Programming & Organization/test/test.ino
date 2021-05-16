extern "C" {
  void test();
}

void flashGoAggies() 
{
  // Add you code here
  test();
  Serial.println("Done");
  // You will call the GoAggies() function from assembly file GoAggies.S
}

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

  flashGoAggies();
}

void loop() {
  // put your main code here, to run repeatedly:

}
