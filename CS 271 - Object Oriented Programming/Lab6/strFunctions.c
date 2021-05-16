#include <stdio.h>
#include <ctype.h>

void splitAlpha(const char * original, char * lower, char * upper ){
    
    int indexOrig = 0, indexLow = 0, indexUp = 0;
    while(original[indexOrig] != '\0'){
        
        if(isalpha(original[indexOrig]) != 0){
            
            if(islower(original[indexOrig]) != 0){
                lower[indexLow] = original[indexOrig];
                indexLow++;
                indexOrig++;
            } // end if
            else if(isupper(original[indexOrig]) != 0){
                upper[indexUp] = original[indexOrig];
                indexUp++;
                indexOrig++;
            } // end else if
        } // end if
        else{
            indexOrig++;
        } // end else
    } // end while
    
    upper[indexUp] = '\0';
    lower[indexLow] = '\0';
} // end splitAlpha

void printSequences(const char * text){
    
    int index = 0, x, y, count;
    
    while(text[index] != '\0'){

        if(text[index] - text[index + 1] == -1){
                
            x = index;
            count = 1;
            while(text[x] - text[x+1] == -1){
                count++;
                x++;
            } // end while
                
            for(y = 0; y < count; y++){
                    
                printf("%c", text[index]);
                index++;
            } // end for
            printf("\n");
        } // end if
        else {
            index++;
        } //end else
    } //end while
    printf("\n");
} // end printSequences
