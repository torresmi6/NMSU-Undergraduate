

public class Circle2 extends Circle
{

public Circle2(double x, double y, double radius)
{
   super(y,x,radius);
}

public boolean intersects(Circle other)
{
   double d, c;
   d = Math.sqrt(Math.pow(center.x - other.center.x, 2));
                 
   c = Math.sqrt(Math.pow(center.y - other.center.y, 2));
   if ((d <= radius || d <= other.radius) && (c <= radius || c <= other.radius))
      return true;
   else
      return false;
}

}

