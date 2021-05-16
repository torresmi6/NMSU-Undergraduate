public class Fox {

  
  private String myName;
  private float myTailLength;
  private int myNumberofLegs;
  private float myWeight;
  private float myHeight;
  private String myColor;
  private String myEyeColor;
  private int myNumberofWhiskers;

  // default constructor
  public Fox()
  {
    myName = "default name";
    myTailLength = 0f;
    myNumberofLegs = 0;
    myWeight = 0;
    myHeight = 0;
    myColor = "Black";
    myEyeColor = "None";
    myNumberofWhiskers = 0;
  }

  // constructor initializing all values.
  public Fox(String name, float tailLength, int numberofLegs, float weight, float height, String color, String eyeColor, int numberofWhiskers)
  {
    myName = name;
    myTailLength = tailLength;
    myNumberofLegs = numberofLegs;
    myWeight = weight;
    myHeight = height;
    myColor = color;
    myEyeColor = eyeColor;
    myNumberofWhiskers = numberofWhiskers;
  }

 
  public void setName(String name)
  {
    myName = name;
  }

  public String getName() 
  {
    return (myName);
  }
  
  public void setTailLength(float tailLength)
  {
    myTailLength = tailLength;
  }

  public float getTailLength() 
  {
    return (myTailLength);
  }
  
  public void setNumberofLegs(int numberofLegs)
  {
    myNumberofLegs = numberofLegs;
  }

  public int getNumberofLegs() 
  {
    return (myNumberofLegs);
  }
  
  public void setWeight(float weight)
  {
    myWeight = weight;
  }

  public float getWeight() 
  {
    return (myWeight);
  }
  
  public void setHeight(float height)
  {
    myHeight = height;
  }

  public float getHeight() 
  {
    return (myHeight);
  }
   
   public void setColor(String color)
  {
    myColor = color;
  }

  public String getColor() 
  {
    return (myColor);
  }
  
  public void setEyeColor(String eyeColor)
  {
    myEyeColor = eyeColor;
  }

  public String getEyeColor() 
  {
    return (myEyeColor);
  }
  
  public void setNumberofWhiskers(int numberofWhiskers)
  {
    myNumberofWhiskers = numberofWhiskers;
  }

  public int getNumberofWhiskers() 
  {
    return (myNumberofWhiskers);
  }
  

  public void print()
  {
    System.out.println("Name: " + myName);
    System.out.println("Tail length: " + myTailLength);
    System.out.println("Number of Legs: " + myNumberofLegs);
    System.out.println("Weight: " + myWeight);
    System.out.println("Height: " + myHeight);
    System.out.println("Color: " + myColor);
    System.out.println("Eye Color: " + myEyeColor);
    System.out.println("Number of Whiskers: " + myNumberofWhiskers);
  }
}
