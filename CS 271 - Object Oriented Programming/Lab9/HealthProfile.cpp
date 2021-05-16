// CS 271 - Lab 9
// HealthProfile
// Manages a health profile with 9 data members
// Includes all setters and getters for the 9 members
// Includes 3 functions to calculate age, max heart rate
//  and target heart range
// Written by Michael Torres
// 11-12-19
#include <iostream>
#include <iomanip>
#include <string>
#include <stdexcept>
#include <ctime>
#include "HealthProfile.h"
using namespace std;

// printing a HealthProfile object should print all the
//  data members and the info tied to the other functions
ostream& operator<< (ostream& out, const HealthProfile& profile){
    
    out << "Health Profile" << endl << "First Name: " 
        << profile.getFirstName() << endl << "Last Name: " 
        << profile.getLastName() << endl << "Gender: " 
        << profile.getGender() << endl << "Date of Birth: "
        << profile.getBirthMonth() << ", " << profile.getBirthDay() 
        << ", " << profile.getBirthYear() << endl << "Height: " 
        << profile.getHeight() << " inches" << endl << "Weight: " 
        << profile.getWeight() << " pounds" << endl << "Age: " 
        << profile.age() << endl << "Maximum Heart Rate: " 
        << profile.maxHeartRate() << endl << "Target Heart Range: " 
        << profile.heartRange()[0] << " to " << profile.heartRange()[1] 
        << endl;
        return out;
}
// constructor for instantiating a HealthProfile object
//  with 6 of the 9 data members
HealthProfile::HealthProfile(string f, string l, string g, int m, int d, int y){
    setFirstName(f);
    setLastName(l);
    setGender(g);
    setBirthMonth(m);
    setBirthDay(d);
    setBirthYear(y);
}

// Accessors
string HealthProfile::getFirstName( ) const{
    return firstName;
}

string HealthProfile::getLastName( ) const{
    return lastName;
}

string HealthProfile::getGender( ) const{
    return gender;
}

int HealthProfile::getBirthMonth( ) const{
    return month;
}

int HealthProfile::getBirthDay( ) const{
    return day;
}

int HealthProfile::getBirthYear( ) const{
    return year;
}

double HealthProfile::getHeight( ) const{
    return height;
}

double HealthProfile::getWeight( ) const{
    return weight;
}

string HealthProfile::getInsurance( ) const{
    return insurance;
}

// Mutators
void HealthProfile::setFirstName(string f){
    firstName = f;
}

void HealthProfile::setLastName(string l){
    lastName = l;
}

void HealthProfile::setGender(string g){
    
    if(g == "M" || g == "F"){
        gender = g;
    }
    else{
        throw invalid_argument("gender is not valid");
    }
}   

void HealthProfile::setBirthMonth(int m){
    if(m >= 1 && m <= 12){
        month = m;
    }
    else{
        throw invalid_argument("month is out of range");
    }
}

void HealthProfile::setBirthDay(int d){
    int monthArray[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if(d >= 1 && d <= monthArray[month]){
        day = d;
    }
    else{
        throw invalid_argument("year is out of range");
    }
}

void HealthProfile::setBirthYear(int y){

    if(y >= 0){
        year = y;
    }
    else{
        throw invalid_argument("year is out of range");
    }
}

void HealthProfile::setHeight(double h){
    
    if(h >= 0){
        height = h;
    }
    else{
        throw invalid_argument("height is out of range");
    }
}

void HealthProfile::setWeight(double w){
    
    if(w >= 0){
        weight = w;
    }
    else{
        throw invalid_argument("weight is out of range");
    }
}

void HealthProfile::setInsurance(string i){

    insurance = i;
}

// Other functions
void HealthProfile::dateOfBirth(int m, int d, int y){
    
    setBirthMonth(m);
    setBirthDay(d);
    setBirthYear(y);
}

float HealthProfile::age( ) const{
    
    time_t t = time(NULL);
	tm* timePtr = localtime(&t);
    float daysLeft, daysSinceJan, ageDays, years;
    float monthArray[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    for(int i = month + 1; i <= 12; i++){
        daysLeft = daysLeft + monthArray[i];
    }
    daysLeft = daysLeft + (monthArray[month] - day);
    daysSinceJan = timePtr->tm_yday;
    years = (timePtr->tm_year + 1900) - year -1;
    ageDays = years * 365;
    ageDays = ageDays + daysLeft + daysSinceJan;
    years = ageDays / 365;
    return years;
    
}

float HealthProfile::maxHeartRate( ) const{
    
    float mhr;
    mhr = 220 - age();
}

float * HealthProfile::heartRange ( ) const{
    
    float * array = new float[2];
    array[0] = maxHeartRate() * .50;
    array[1] = maxHeartRate() * .85;
    return array;
}
