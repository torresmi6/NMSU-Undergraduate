public class Duck {

  
  private String myName;
  private float myBeakLength;
  private int myNumberofLegs;
  private float myWeight;
  private float myHeight;
  private String myColor;
  private String myBreed;
  private int myNumberofFeathers;

  // default constructor
  public Duck()
  {
    myName = "default name";
    myBeakLength = 0f;
    myNumberofLegs = 0;
    myWeight = 0;
    myHeight = 0;
    myColor = "Black";
    myBreed = "None";
    myNumberofFeathers = 0;
  }

  // constructor initializing all values.
  public Duck(String name, float beakLength, int numberofLegs, float weight, float height, String color, String breed, int numberofFeathers)
  {
    myName = name;
    myBeakLength = beakLength;
    myNumberofLegs = numberofLegs;
    myWeight = weight;
    myHeight = height;
    myColor = color;
    myBreed = breed;
    myNumberofFeathers = numberofFeathers;
  }

 
  public void setName(String name)
  {
    myName = name;
  }

  public String getName() 
  {
    return (myName);
  }
  
  public void setBeakLength(float beakLength)
  {
    myBeakLength = beakLength;
  }

  public float getBeakLength() 
  {
    return (myBeakLength);
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
  
  public void setBreed(String breed)
  {
    myBreed = breed;
  }

  public String getBreed() 
  {
    return (myBreed);
  }
  
  public void setNumberofFeathers(int numberofFeathers)
  {
    myNumberofFeathers = numberofFeathers;
  }

  public int getNumberofFeathers() 
  {
    return (myNumberofFeathers);
  }
  

  public void print()
  {
    System.out.println("Name: " + myName);
    System.out.println("Beak length: " + myBeakLength);
    System.out.println("Number of Legs: " + myNumberofLegs);
    System.out.println("Weight: " + myWeight);
    System.out.println("Height: " + myHeight);
    System.out.println("Color: " + myColor);
    System.out.println("Breed: " + myBreed);
    System.out.println("Number of Feathers: " + myNumberofFeathers);
  }
}
