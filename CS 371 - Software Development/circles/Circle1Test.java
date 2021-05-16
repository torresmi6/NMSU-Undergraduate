
/***
* JUnit testing class for Circle1 (and Circle)
***/

// Import all assertions and all annotations
// - see docs for lists and descriptions
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class Circle1Test
{
   // Data you need for each test case
   private Circle1 circle1;
   private Circle2 circle1;
// 
// Stuff you want to do before each test case
//
@BeforeEach
public void setup()
{
   System.out.println("\nTest starting...");
   circle1 = new Circle1(1,2,3);
}

//
// Stuff you want to do after each test case
//
@AfterEach
public void teardown()
{
   System.out.println("\nTest finished.");
}

//
// Test a simple positive move
//
@Test
public void simpleMove()
{
   Point p;
   System.out.println("Running test simpleMove.");
   p = circle1.moveBy(1,2);
   assertTrue(p.x == 2 && p.y == 4);
}

// 
// Test a simple negative move
//
@Test
public void simpleMoveNeg()
{
   Point p;
   System.out.println("Running test simpleMoveNeg.");
   p = circle1.moveBy(-1,-1);
   assertTrue(p.x == 0 && p.y == 1);
}

// 
// Test a scale by a factor of 2
//
@Test
public void scaleByTwo()
{
   Point p;
   System.out.println("Running test scaleByTwo.");
   p = circle1.scale(2.0);
   assertTrue(p.radius == 6);
}

// 
// Test a scale by a negative factor
//
@Test
public void scaleByNeg()
{
   Point p;
   System.out.println("Running test scaleByNeg.");
   p = circle1.scale(-2.0);
   assertTrue(p.radius == 3);
}

// 
// Test if two intersecting circles pass the intersect check
//
@Test
public void intersectTrue()
{
   circle2 = new Circle1(3, 2, 2);
   System.out.println("Running test intersectTrue.");
   assertTrue(circle1.intersects(circle2));
}

// 
// Test if two non-intersecting circles fail the intersect check
//
@Test
public void intersectFalse()
{
   circle2 = new Circle1(3, 2, 1);
   System.out.println("Running test intersectFalse.");
   assertTrue(circle1.intersects(circle2));
}

}

