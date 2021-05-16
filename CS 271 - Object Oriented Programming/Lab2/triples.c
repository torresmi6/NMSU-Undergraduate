// CS 271 - Lab 2
// triples
// Finds all pythagorean triples with hypotenuse less than or equal
// to 1000.
// Written by Michael Torres
// 9-5-19

#include <stdio.h>
#include <math.h>

void main(void){
    
    int hyp, side1, side2, hypTemp;
    
    // prints header of table
    printf("Side 1\t\tSide 2\t\tHypotenuse\n");
    printf("------\t\t------\t\t----------\n");
    
    // triple nested loopchecking if pythagorean theorem works with each // triple number combination
    for(hyp = 1; hyp <= 1000; hyp++){
        for(side1 = 1; side1 <= 1000; side1++){
            for(side2 = 1; side2 <= 1000; side2++){
                
                // Also checks if the hypotenuse is the same as the last // printed hypotenuse. If it is, it avoids printing the 
                // duplicate
                if(side1*side1 + side2*side2 == hyp*hyp && hyp != hypTemp){
                    printf("%6d\t\t", side1);
                    printf("%6d\t\t", side2);
                    printf("%10d\n", hyp);
                    hypTemp = hyp;
                }
            }
        }
    }
}
