import java.util.*;
public class Zoo1
{

static ArrayList<Animal> zoo = new ArrayList<Animal>(); //The storage of the animals

static Scanner scnr = new Scanner(System.in);
static Random rand = new Random();
static String name = ""; // Name of the animal
static String type = ""; // type of animal
static char input = ' '; // user input for menu
static int random = 0;

   public static void main(String [] args)
   {
      do {  // Main menu for user to add, delete, and display animals in the zoo
   
   System.out.println("\nMENU");
   System.out.println("a - Add animal to zoo");
   System.out.println("d - Remove animal from zoo");
   System.out.println("c - Display all animals");
   System.out.println("i - Display specific animal by name");
   System.out.println("o - Display random animal");
   System.out.println("u - Display specific animals by type");
   System.out.println("q - Quit\n");
      
      do{
      System.out.println("Choose an option:");
      input = scnr.nextLine().charAt(0);
      } while(input != 'a' && input != 'd' && input != 'c' && input != 'i' && input != 'o' && input != 'u' && input != 'q');  // Asks for input until user submits a valid character
   switch (input) {
      case 'a':   System.out.println("ADD ANIMAL TO ZOO");
                  System.out.println("Enter the animal's name:");
                  name = scnr.next();
                  System.out.println("Enter the animal type:");
                  type = scnr.next();
                  scnr.nextLine();
                  type = type.toLowerCase();
                     if(type.equals("tiger")){                    // uses user's type input to decide what class instance is created
                                                                  // is then added to the zoo arraylist
                     zoo.add(new Tiger(name, "Tiger"));
                     }
                     if(type.equals("bear")){ 
                     zoo.add(new Bear(name, "Bear"));
                     }
                     if(type.equals("elephant")){ 
                     zoo.add(new Elephant(name, "Elephant"));
                     }
                     if(type.equals("chameleon")){ 
                     zoo.add(new Chameleon(name, "Chameleon"));
                     }
                     if(type.equals("turtle")){ 
                     zoo.add(new Turtle(name, "Turtle"));
                     }
                     if(type.equals("snake")){ 
                     zoo.add(new Snake(name, "Snake"));
                     }
                     if(type.equals("duck")){ 
                     zoo.add(new Duck(name, "Duck"));
                     }
                     if(type.equals("penguin")){ 
                     zoo.add(new Penguin(name, "Penguin"));
                     }
                     if(type.equals("owl")){ 
                     zoo.add(new Owl(name, "Owl"));
                     }
                  break;
                  
      case 'd':   System.out.println("REMOVE ANIMAL FROM ZOO");
                  System.out.println("Enter name of animal to remove:");
                  name = scnr.next();
                  for(int i = 0; i < zoo.size(); i++){                  // Searches the entire arraylist for the name the user gave.
                  if(((zoo.get(i)).getName()).equals(name) == true){    // then removes it from the zoo arraylist
                  zoo.remove(i);
                  }
                  }
                  scnr.nextLine();
                  break;
                  
      case 'c':   System.out.println("DISPLAY ALL ANIMALS");   // goes through each array element and displays it using the displayAnimal() method
                  for(int i = 0; i < zoo.size(); i++){
                  (zoo.get(i)).displayAnimal();
                  }
                  break;

      
      case 'i':   System.out.println("DISPLAY SPECIFIC ANIMAL BY NAME");
                  System.out.println("Enter name of animal to display:");
                  name = scnr.next();
                  for(int i = 0; i < zoo.size(); i++){                     // Searches entire arraylist for the name the user gave.
                  if(((zoo.get(i)).getName()).equals(name) == true){       // then displays it using the displayAnimal() mehthod
                  (zoo.get(i)).displayAnimal();
                  }
                  }
                  scnr.nextLine();
                  break;
                  
      case 'o':   System.out.println("DISPLAY RANDOM ANIMAL");    //Generates a random number between 0 and the arraylist size
                  random = rand.nextInt(zoo.size() + 1);          // then displays the element in the array with that index
                  (zoo.get(random)).displayAnimal();
                  break;
      
      case 'u':   System.out.println("DISPLAY SPECIFIC ANIMALS BY TYPE");
                  System.out.println("Enter the type of animal:");
                  type = scnr.next();
                  for(int i = 0; i < zoo.size(); i++){                  // Searches the arraylist for all animals of a single type, then displays them
                  if(((zoo.get(i)).getType()).equals(type) == true){
                  (zoo.get(i)).displayAnimal();
                  }
                  }
                  scnr.nextLine();
                  break;
     
}
}
while (input != 'q'); // if char is q, quits the program

   }
}

class Animal
{
String name = "";
String type = "";
String superType = "";
public String properties = "";   
   Animal(String inputName, String inputType){ // constructor that sets the name and type of the animal
   name = inputName;
   type = inputType;
   }
   
   public String getName(){   // getter for the name
   return name;
   }
   
   public String getType(){   // getter fpr the type
   return type;
   }
   
   public void displayAnimal(){ // method that displays the name, type, and properties of the animal
   System.out.println(name + " - " + superType + " - " + type + properties);
   }
}

class Mammal extends Animal
{
                     
Mammal(String inputName, String inputType){  //Overrides inherited constructor by also setting the properties string for mammals
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Mammal";
   properties = "\nProperties\nHas Hair or fur\nWarm blooded\nMammary glands that produce milk\n"; // specific properties for mammals
   }
}

class Reptile extends Animal
{
Reptile(String inputName, String inputType){ //Overrides inherited constructor by also setting the properties string for reptiles
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Reptile";
   properties = "\nProperties\nHas scales\nCold blooded\nLays eggs\n";  // specific properties for reptiles
   }
}

class Bird extends Animal
{
Bird(String inputName, String inputType){ //Overrides inherited constructor by also setting the properties string for birds
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Bird";
   properties = "\nProperties\nFlight\nWarm blooded\nHas feathers\n";   // specific properties for birds
   }
}

class Tiger extends Mammal
{
Tiger(String inputName, String inputType){ //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Mammal";
   properties = "\nProperties\nHas fur\nWarm blooded\nMammary glands that produce milk\n";
   }
}

class Bear extends Mammal
{
Bear(String inputName, String inputType){ //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Mammal";
   properties = "\nProperties\nHas fur\nWarm blooded\nMammary glands that produce milk\n";
   }
}

class Elephant extends Mammal
{
Elephant(String inputName, String inputType){   //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Mammal";
   properties = "\nProperties\nHas Hair\nWarm blooded\nMammary glands that produce milk\n";
   }
}

class Chameleon extends Reptile
{
Chameleon(String inputName, String inputType){  //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Reptile";
   }
}

class Turtle extends Reptile
{
Turtle(String inputName, String inputType){  //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Reptile";
   properties = "\nProperties\nHas a shell made of scales\nCold blooded\nLays eggs\n"; // Properties are changed slightly by adding the property of a shell
   }
}

class Snake extends Reptile
{
Snake(String inputName, String inputType){   //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Reptile";
   }
}

class Duck extends Bird
{

Duck(String inputName, String inputType){   //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Bird";
   }
}

class Owl extends Bird
{
Owl(String inputName, String inputType){   //Inherited constructor from animal class
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Bird";
   }
}

class Penguin extends Bird
{

Penguin(String inputName, String inputType){ //Overrides inherited constructor by changing the properties specific to penguins
   super(inputName, inputType);
   name = inputName;
   type = inputType;
   superType = "Bird";
   properties = "\nProperties\nAlthough a bird, cannot fly\nWarm blooded\nHas feathers\n"; // Properties are changed slightly by explaining that penguins cannot fly
   }
}