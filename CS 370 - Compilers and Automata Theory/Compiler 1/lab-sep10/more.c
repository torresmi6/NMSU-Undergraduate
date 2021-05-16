#include <stdio.h>
#include "more.h"

extern int* p;
extern int a[5], x, y;

int doMore(float f)
{
   static int z=13;
   Feet m=1;
   Point p1;
   printf("doMore\n");
   p1.x = 5; 
   p1.y = 1;
   p1.z = 9;
   printf("p1 = (%d,%d,%d)\n",p1.x,p1.y,p1.z);
   return 0;
   printf("more: %g  m=%d\n",f,m);
   printf("z=%d\n",z++);
   p = &x;
   *p = 17;
   //BAD!!! p[2] = 99;
   printf("p=%p, *p=%d, x=%d p[0-2]=%d %d %d\n",
           p, *p, x, p[0], p[1], p[2]);
   printf("y=%d, a[]=%d %d %d %d %d\n",y, a[0], a[1], a[2],
          a[3], a[4]);
   return 0;
}

