// CS 271 - Lab 2
// calls
// Take call lengths as input and organizes them into max length, minimum // length, and mean length.
// written by Michael Torres
// 9-5-19

#include <stdio.h>
#include <math.h>

void main(void){
double mean = 0.0;
int min = 0;
int max = 0;
int current = 0;
int sum = 0;
int count = 0;

// while loop to read input and update max, min, and count simultaneously
scanf("%d", &current);
while(current != -1){

    if(current < min){
        min = current;
    }
    if(min == 0){
        min = current;
    }
    if(current > max){
        max = current;
    }
    sum = sum + current;
    count++;
    
    scanf("%d", &current);
} // end while

// calculate mean by dividing the sum of all call lengths by the total 
// calls
mean = (double)sum/count;

// print table using widths for formatting
printf("Total Number of Calls\t");
printf("%15d\n", count);
printf("Mean Call Length");
printf("%15.1f\n", mean, " seconds");
printf("Minimum Call Length\t");
printf("%7d%7s\n", min, " seconds");
printf("Maximum Call Length\t");
printf("%7d%7s\n", max, " seconds");
} // end main
