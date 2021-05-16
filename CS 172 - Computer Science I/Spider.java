public class Spider {

  
  private String myName;
  private float myLegLength;
  private int myNumberofLegs;
  private float myWeight;
  private float myHeight;
  private String myColor;
  private String mySpecies;
  private int myNumberofEyes;

  // default constructor
  public Spider()
  {
    myName = "default name";
    myLegLength = 0f;
    myNumberofLegs = 0;
    myWeight = 0;
    myHeight = 0;
    myColor = "Black";
    mySpecies = "None";
    myNumberofEyes = 0;
  }

  // constructor initializing all values.
  public Spider(String name, float legLength, int numberofLegs, float weight, float height, String color, String species, int numberofEyes)
  {
    myName = name;
    myLegLength = legLength;
    myNumberofLegs = numberofLegs;
    myWeight = weight;
    myHeight = height;
    myColor = color;
    mySpecies = species;
    myNumberofEyes = numberofEyes;
  }

 
  public void setName(String name)
  {
    myName = name;
  }

  public String getName() 
  {
    return (myName);
  }
  
  public void setLegLength(float legLength)
  {
    myLegLength = legLength;
  }

  public float getLegLength() 
  {
    return (myLegLength);
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
  
  public void setSpecies(String species)
  {
    mySpecies = species;
  }

  public String getSpecies() 
  {
    return (mySpecies);
  }
  
  public void setNumberofEyes(int numberofEyes)
  {
    myNumberofEyes = numberofEyes;
  }

  public int getNumberofEyes() 
  {
    return (myNumberofEyes);
  }
  

  public void print()
  {
    System.out.println("Name: " + myName);
    System.out.println("Leg length: " + myLegLength);
    System.out.println("Number of Legs: " + myNumberofLegs);
    System.out.println("Weight: " + myWeight);
    System.out.println("Height: " + myHeight);
    System.out.println("Color: " + myColor);
    System.out.println("Species: " + mySpecies);
    System.out.println("Number of Eyes: " + myNumberofEyes);
  }
}
