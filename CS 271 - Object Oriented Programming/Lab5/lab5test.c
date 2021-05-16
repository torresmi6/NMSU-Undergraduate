// CS 271 - Lab 5
// lab5test
// tests all the functions in lab5functions.c
// Written by Michael Torres
// 9-26-19

#include <stdio.h>
#include "lab5functions.h"

int main(void){
    
    int dupeArray[] = {1, 2, 2, 3, 5, 6, 9, 6, 7, 6};
    int dupeArray2[] = {2, 3, 5, 2, 5, 6, 9, 6, 5, 9,};
    printf("There are %d numbers that appear more than once\n", duplicates(dupeArray, 10));
    
    printf("There are %d numbers that appear more than once\n", duplicates(dupeArray2, 10));
    printf("\n");
    
    float highArray[] = {1, 2, 3, 5, 5};
    float highArray2[] = {1.2, 1.0, 2.5, 3.6, 5.2, 6.0, 9.2, 6.1, 7.5, 6.7};
    highestTwo(highArray2, 10);
    highestTwo(highArray, 5);
    printf("\n");
    
    double array2D[5][5] = {
        {1.5, 2.6, 3.7, 4.2, 5.0},
        {5.5, 6.7, 7.6, 20.0, 4.2},
        {8.5, 5.4, 62.4, 14.0, 25.4},
        {10.2, 23.3, 70.1, 52.6, 12.2},
        {2.5, 6.7, 3.5, 48.5, 1.7}
    };
    double sumArray[5];
    columnSums(5, 5, array2D, sumArray);
    
    int x;
    for(x = 0; x < 5; x++){
        printf("%f\n", sumArray[x]);
    }
}
    
