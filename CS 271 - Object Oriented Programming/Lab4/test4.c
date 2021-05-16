// CS 271 - Lab 4
// test4
// Tests all functions in lab4.c
// Written by Michael Torres
// 9-26-19
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "lab4.h"

int main(void){
    
    int array[100];
    int x;
    int size = 100;
    srand(time(NULL));
    
    for(x = 0; x < size; x++){
        array[x] = rand() % 1000 + 1;
    }
    
    printIntArray(array, size);
    printf("\n\n");
    printf("%d", linearSearch(array, size, 30));
    printf("\n");
    printf("%d", linearSearch(array, size, 86));
    printf("\n");
    printf("%d", linearSearch(array, size, 87));
    printf("\n\n");
    
    bubbleSort(array, size);
    printf("\n");
    printIntArray(array, size);
    printf("\n\n");
    printf("%d", binarySearch(array, size, 11));
    printf("\n");
    printf("%d", binarySearch(array, size, 28));
    printf("\n");
    printf("%d", binarySearch(array, size, 74));
    printf("\n");
    printf("%d", binarySearch(array, size, 99));
    
}

