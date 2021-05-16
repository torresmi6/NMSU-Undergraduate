
public class Circle1 extends Circle
{

public Circle1(double x, double y, double radius)
{
   super(x,y,radius);
}


public boolean intersects(Circle other)
{
   double xDif = Math.abs(center.x - other.center.x);
   double yDif = Math.abs(center.y - other.center.y);
   
   if ((xDif <= radius || xDif <= other.radius) &&
       (yDif <= radius || yDif <= other.radius))
      return true;
   return false;
}

}

