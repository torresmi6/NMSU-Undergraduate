// CS 271 - Lab 4
// lab4
// linearSearch function - searches the array from the first
// element to the end, for the first match of the given key
// binarySearch function - searches the array using the binary
// method and returns the index of the first match
// printIntArray function - prints the entire array
// bubbleSort function - sorts the array in non-descending order
// Written by Michael Torres
// 9-26-19
#include <stdio.h>
#include <math.h>

int linearSearch (int array[], int arraySize, int key){

    int cnt;
    for(cnt = 0; cnt < arraySize; cnt++){
        if(array[cnt] == key){
            return cnt;
        } // end if
    } // end for
    return -1;
} // end linearSearch

int binarySearch (int array[], int arraySize, int key){
    
    int first = 0;
    int last = arraySize - 1;
    int mid = last / 2;
    
    while(first < last){
        if(key == array[mid]){
            return mid;
        } // end if
    
        if(key < array[mid]){
            last = mid - 1;
            mid = last / 2;
        } // end if
        else {
            if(key > array[mid]){
                first = mid + 1;
                mid = (last + first) / 2;
            } // end if
        } // end else
    } // end while
    return -1;
} // end binarySearch

void printIntArray (int array [], int arraySize){
    
    int cnt;
    
    for(cnt = 0; cnt < arraySize; cnt++){
        
        if(cnt % 10 == 0){
            printf("\n");
        } // end if
            
        printf("%d, ", array[cnt]);
    } // end for
} // end printIntArray

void bubbleSort (int array[], int arraySize){
    
    int i, j, temp;
    int sorted;
    
    for(i = 1; i <= arraySize-1; i++){
        sorted = 1;
        for(j = 0; j <= arraySize-1-i; j++){
            if(array[j] > array[j+1]){
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
                sorted = 0;
            } // end if
        } // end for
        if(sorted){
            break;
        }
    } // end for
} // end bubbleSort
        
