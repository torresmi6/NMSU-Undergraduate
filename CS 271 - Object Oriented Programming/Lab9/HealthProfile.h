// CS 271 - Lab 9
// HealthProfile.h
// Class definition for HealthProfile
// Written by Michael Torres
// 11-12-19

#ifndef HEALTHPROFILE_H
#define HEALTHPROFILE_H

#include <string>
using namespace std;

class HealthProfile{
    
friend ostream& operator<< (ostream& out, const HealthProfile& profile);
public:
    HealthProfile(string f, string l, string g, int m, int d, int y);
    string getFirstName( ) const;
    string getLastName( ) const;
    string getGender( ) const;
    int getBirthMonth( ) const;
    int getBirthDay( ) const;
    int getBirthYear( ) const;
    double getHeight( ) const;
    double getWeight( ) const;
    string getInsurance( ) const;
    void setFirstName(string f);
    void setLastName(string l);
    void setGender(string g);
    void setBirthMonth(int m);
    void setBirthDay(int d);
    void setBirthYear(int y);
    void setHeight(double h);
    void setWeight(double w);
    void setInsurance(string i);
    void dateOfBirth(int m, int d, int y);
    float age( ) const;
    float maxHeartRate( ) const;
    float * heartRange( ) const;
    
private:
    string firstName;
    string lastName;
    string gender;
    int month;
    int day;
    int year;
    double height;
    double weight;
    string insurance;
};
#endif
