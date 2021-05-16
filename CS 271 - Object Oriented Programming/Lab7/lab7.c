// CS 271 - Lab 7
// lab7
// includes methods to print the array into a table and 
// sort the table by columns
// Written by Michael Torres
// 10-17-19

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void printTable(const int * const array, const int rows, const int columns);

void columnSort(int * array, const int rows, const int columns);
int main(void){
    
    int array[80];
    
    srand(time(0));
    
    int x;
    for(x = 0; x < 80; x++){
        *(array + x) = rand() % 500 + 1;
    }

    
    //printf("
    printTable(array, 8, 10); // 8 rows, 10 columns
    
    columnSort(array, 8, 10);
    
    printf("\n");
    printTable(array, 8, 10); // 8 rows, 10 columns
    
}

void printTable(const int * const array, const int rows, const int columns){
    
    int i, x, index = 0;
    for(i = 0; i < rows; i++){
        
        for(x = 0; x < columns; x++){
            
            printf("%5d", *(array + index));
            index++;
        }
        printf("\n");
    }
            
}

void columnSort(int * array, const int rows, const int columns){
    
    int i, x, y, temp, arraySize,j;
    int sorted=0;
    arraySize = rows * columns;
    
    for(y = 0; y < columns; y++){
    
        for(i = 0; i < columns; i++){
        
            sorted = 1;
            for(x = y; x < arraySize - i * columns - columns; x = x + columns){
                if(array[x] > array[x+columns]){
                    temp = array[x];
                    array[x] = array[x+columns];
                    array[x+columns] = temp;
                    sorted = 0;
                } // end if
            } // end for
            if(sorted){
                printf("Sorted");
                break;
            }
        }
    }
}

