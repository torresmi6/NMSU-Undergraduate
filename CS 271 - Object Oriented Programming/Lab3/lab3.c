// CS 271 - Lab 3
// lab3
// Tests all functions in lab3functions.c
// Written by Michael Torres
// 9-12-19
#include "lab3functions.h"
#include <stdio.h>
#include <math.h>
int main (void) {
// use the perfect function to print the positive, perfect 
// numbers less than 1000
    int i;
    for(i = 1; i < 1000; i++){

        if(perfect(i)){
            printf("%d , ", i);
        }
    } // end for
    
    printf("\n\n");
// use the prime function to print the first 20 positive, prime // numbers
// note: 1 is not a prime
    for(i = 2; i <= 20; i++){
        if(prime(i)){
            printf("%d , ", i);
        } // end if
    } // end for
    
// use the revDigits function to print the reverse of several 
// (at least 3) numbers with various numbers of digits
    printf("\n\n%d", revDigits(7631));
    printf("\n%d", revDigits(1840));
    printf("\n%d\n", revDigits(-945));
    
}
