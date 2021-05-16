// CS 271 - Lab 3
// lab3functions
// perfect function to check if input is a perfect number
// prime function to check if input is aprime number
// revDigits function to reverse an integer's digits
// Written by Michael Torres
// 9-12-19
#include "lab3functions.h"
#include <stdio.h>
#include <math.h>

int perfect(int num){
    
    int factorsSum = 0;
    int i;
    for(i = 1; i < num; i++){
        if(num % i == 0){
            factorsSum = factorsSum + i;
        } // end if
    } // end for
    if(factorsSum == num){
        return 1;
    } // end if
    else {
        return 0;
    } // end else
} // end function perfect

int prime(int num){
    
    int x;
    for(x = 2; x<= sqrt(num); x++){
        if(num % x == 0){
            return 0;
        } // end if
    } // end for
    return 1;
} // end function prime


    
int revDigits(int num){
    int x;
    int answer = 0;
    while(num != 0){
        answer = (answer * 10) + (num % 10);
        num = num / 10;
    } // end while
    return answer;
} // end function revDigits
