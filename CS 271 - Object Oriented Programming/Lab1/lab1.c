// CS 271 - Lab 1
// Program name:    lab1.c
// Michael Torres
// Aug 29, 2019
#include <stdio.h>
#include <math.h>

// The purpose of this program is to calculate the length of hypotenuse
// of a right triangle.

int main (void) {

    double radius, circumference, area;

    // input the radius of a circle

    printf("Enter the radius of the circle: \n");
    scanf("%lf", &radius);


    // calculate the circumference

    circumference = 2*M_PI*radius;
    
    //  calculate the area
    area = M_PI*radius*radius;

    // output the circumference and area along with meaningful messages

    printf("The circumference is %f.\nThe area is %f.\n", circumference, area);

} // end main function
