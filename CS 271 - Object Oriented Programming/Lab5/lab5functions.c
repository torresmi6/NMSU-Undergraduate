// CS 271 - Lab 5
// lab5functions
// duplicates - function that counts how many numbers have duplicates in // the array
// highestTwo - function that determines the two highest numbers in the
// array
// columnSums - function that calculates the sum of each column in a 2D 
// array and stores them into a 1D array
// Written by Michael Torres
// 9-26-19

#include <stdio.h>

int duplicates(int array[], int size){
    
    int x, y, z, dupe = 0;
    int dupeNums[size];
    
    for(x = 0; x < size; x++){
        for(y = x; y < size; y++){
            if(y != x && array[x] == array[y] && array[x]){
                for(z = 0; z < size; z++){
                    if(array[x] == dupeNums[z]){
                        z = -1;
                        break;
                    } // end if
                } //end for
                if(z != -1){
                    dupe++;
                    dupeNums[x] = array[x];
                    break;
                } //end if
            } // end if
        } // end for y
    } // end for x
    return dupe;
} // end duplicates

void highestTwo(float array[], int size){
    
    float highest = 0, secondHighest = 0;
    int x, highIndex;
    for(x = 0; x < size; x++){
        if(highest < array[x]){
            secondHighest = highest;
            highest = array[x];
            highIndex = x;
            
        } // end if
        if(secondHighest < array[x] && x != highIndex){
            secondHighest = array[x];
        } // end if
    } // end for
    printf("The two highest numbers are %f and %f.\n", highest, secondHighest);
} // end highestTwo

void columnSums(int rows, int columns, double array[][columns], double array2[]){
    
    double sum = 0;
    int x, y;
    
    for(x = 0; x < columns; x++){
        sum = 0;
        for(y = 0; y < rows; y++){
            
            sum = sum + array[y][x];
        } // end for
        array2[x] = sum;
    } // end for
} // end columnSums
