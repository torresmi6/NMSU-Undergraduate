public class Zoo
{
  public static void main(String[] args)
  {
     Duck d1 = new Duck();
     d1.setName("Joey");
     d1.setBeakLength(2.5f);
     d1.setNumberofLegs(2);
     d1.setWeight(10);
     d1.setHeight(3);
     d1.setColor("Green");
     d1.setBreed("American Pekin");
     d1.setNumberofFeathers(500);
     d1.print();

     // Example with constructor initializing all private fields.
     Duck d2 = new Duck("Sammy", 2.43f, 2, 15, 3, "Brown", "Mallard", 200);
     d2.print();
     
     d2.getName();
     d2.getBeakLength();
     d2.getNumberofLegs();
     d2.getWeight();
     d2.getHeight();
     d2.getColor();
     d2.getBreed();
     d2.getNumberofFeathers();

     Fox f1 = new Fox();
     f1.setName("Todd");
     f1.setTailLength(5);
     f1.setNumberofWhiskers(10);
     f1.setEyeColor("Green");
     f1.print();
     f1.getTailLength();
     f1.getNumberofWhiskers();
     f1.getEyeColor();
     
     Spider s1 = new Spider();
     s1.setName("Charolette");
     s1.setLegLength(1);
     s1.setSpecies("Black Widow");
     s1.setNumberofEyes(8);
     s1.print();
     s1.getLegLength();
     s1.getSpecies();
     s1.getNumberofEyes();
  }
}
