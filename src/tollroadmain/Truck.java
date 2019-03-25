package tollroadmain;

public class Truck extends Vehicle
{
   private int numTrailers;

   public Truck(String regNo, String manufacturer, int numTrailers) 
   {
      super(regNo, manufacturer);
      this.numTrailers = numTrailers;
   }

   // Calculates the cost for tthe toll for a Van
   @Override
   public int calculateBasicTripCost() 
   {
      if(numTrailers <= 1)
      {
         // For £12.50
         return 1250;
      }
      else 
      {
         // For £15
         return 1500;
      }
   }
   
   // ToString method for van
   @Override
   public String toString()
   {
      return "Registration no: "              + this.getRegNo()        + 
             "\nManufacturer: "               + this.getManufacturer() +
             "\nNumber of trailers: "         + numTrailers;
   }
   
   // Test harness for Truck
   public static void main(String[] args)
   {
      Truck truck = new Truck("BZ11NBV ","Scania", 3);
      System.out.println(truck);
   }
   
}
