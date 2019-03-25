package tollroadmain;

public class Car extends Vehicle
{
   private int numSeats;

   // Constructor for car
   public Car(String regNo, String manufacturer,int numSeats) 
   {
      super(regNo, manufacturer);
      this.numSeats = numSeats;
   }  
   
   // Calculates the cost for a car at the toll road
   @Override
   public int calculateBasicTripCost() {
      if(numSeats <= 5)
      {
         // For £5.00
         return 500;
      }
      else
      {
         // For £6.00
         return 600;
      }
   }
   
   // Gets the number of seats
   public int getNumSeats()
   {
      return numSeats;
   }
    
   // ToString method for car
   @Override
   public String toString()
   {
      return "Registration no: "   + this.getRegNo()        + 
             "\nManufacturer: "    + this.getManufacturer() +
             "\nNumber of seats: " + numSeats;
   }
   
   // Test harness for Car
   public static void main(String[] args)
   {
      // Test data
      Car car = new Car("EX10MYP ","Suzuki", 5);
      System.out.println(car);
      System.out.println("The cost of the journey is: " +
              car.calculateBasicTripCost());
   }
}
