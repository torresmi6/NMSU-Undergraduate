#include <stdio.h>
#include <stdlib.h>
#include "more.h"

int* p;
int a[5], x=13, y;
static int z=42;

int main(int argc, char *argv[])
{
   Point p1;
   printf("Hello World!\n");
   p1.x = 3; 
   p1.y = 12;
   p1.z = 7;
   printf("p1 = (%d,%d,%d)\n",p1.x,p1.y,p1.z);
   doMore(42000);
   printf("p1 = (%d,%d,%d)\n",p1.x,p1.y,p1.z);
   return 0;
   doMore(11000);
   printf("z=%d\n",z);
   printf("argc=%d\n",argc);
   //printf("argv = (%s) (%s) (%s)\n", argv[0], argv[1], argv[2]);
   printf("p=%p, *p=%d, x=%d p[0-2]=%d %d %d\n",
           p, *p, x, p[0], p[1], p[2]);
   printf("y=%d, a[]=%d %d %d %d %d\n",y, a[0], a[1], a[2],
          a[3], a[4]);
   return 0;
}
