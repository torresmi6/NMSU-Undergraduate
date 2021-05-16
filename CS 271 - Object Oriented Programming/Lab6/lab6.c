#include <stdio.h>
#include <ctype.h>
#include "strFunctions.h"

int main(void){
    
    char sent1[50] = "Hello, this iS a TeSt";
    char sent2[50] = "I am AnoTheR TesT.";
    char sent3[10] = "abk123@XY";
    char sent4[10] = "srSrstuVW";
    
    char lower1[50];
    char upper1[50];
    char lower2[50];
    char upper2[50];
    
    splitAlpha(sent1, lower1, upper1);
    
    printf("%s\n", lower1);
    printf("%s\n\n", upper1);
    
    splitAlpha(sent2, lower2, upper2);
    
    printf("%s\n", lower2);
    printf("%s\n\n", upper2);
    
    printSequences(sent3);
    printSequences(sent4);
} //end main
    
