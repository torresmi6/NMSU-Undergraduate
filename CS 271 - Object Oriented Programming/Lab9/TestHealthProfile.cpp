// CS 271 - Lab 9
// TestHealthProfile
// Tests all of the member functions in HealthProfile.cpp
// Written by Michael Torres
// 11-12-19
#include <iostream>
#include <iomanip>
#include <string>
#include <stdexcept>
#include <ctime>
#include "HealthProfile.h"
using namespace std;

int main(){
    // using constructor to instantiate a HealthProfile object
    HealthProfile record1("Jessica", "Doe", "F", 10, 3, 1987);
    
    // After the following statements, the initial values
    //  given in the constructor should be replaced
    record1.setFirstName("Michael");
    record1.setLastName("Torres");
    record1.setGender("M");
    record1.setBirthDay(6);
    record1.setBirthMonth(8);
    record1.setBirthYear(2001);
    record1.setWeight(130);
    record1.setHeight(66);
    record1.setInsurance("Insurance Company");
    
    // All accessors should return the correct values that
    //  were passed to the mutators
    cout << "First Name changed to: " << record1.getFirstName() << endl;
    cout << "Last Name changed to: " << record1.getLastName() << endl;
    cout << "Gender changed to: " << record1.getGender() << endl;
    cout << "Birth day changed to: " << record1.getBirthDay() << endl;
    cout << "Birth month changed to: " << record1.getBirthMonth() << endl;
    cout << "Birth year changed to: " << record1.getBirthYear() << endl;
    cout << "Weight changed to: " << record1.getWeight() << endl;
    cout << "Height changed to: " << record1.getHeight() << endl;
    cout << "Insurance changed to: " << record1.getInsurance() << endl;
    
    record1.dateOfBirth(2, 16, 1995);
    cout << "Birth date changed to: " << record1.getBirthMonth() << ", "
         << record1.getBirthDay() << ", " << record1.getBirthYear()
         << endl << endl;
         
    cout << "Age is: " << record1.age() << endl;
    cout << "Max Heart Rate is: " << record1.maxHeartRate() << endl;
    // heartRange() returns an array, so must print the values
    //  using the index
    cout << "Target Heart Range is " << record1.heartRange()[0] << " - "
         << record1.heartRange()[1] << endl << endl;
         
    // Test for the overloaded insertion operator
    cout << record1;
}
