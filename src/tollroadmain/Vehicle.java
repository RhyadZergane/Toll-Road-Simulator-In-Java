package tollroadmain;

public abstract class Vehicle 
{
   private String regNo;
   private String manufacturer;
   
   // Base constructor that will be used for all vehicles
   public Vehicle(String regNo, String manufacturer)
   {
      this.regNo        = regNo;
      this.manufacturer = manufacturer;
   }
   
   // Abstract method that will be implemented for all Vehicles
   public abstract int calculateBasicTripCost();
   
   // Accessor for getting registration number
   public String getRegNo()
   {
      return regNo;
   }
   
   // Accessor for getting Manufacturer
   public String getManufacturer()
   {
      return manufacturer;
   }

   // ToString method for vehicle
   @Override
   public String toString()
   {
      return "Registration number: " + regNo + "\nManufacturer:" + manufacturer;
   }
   
   // Test harness for vehicle class
   public static void main(String[] args)
   {
      // Test data
      Vehicle test = new Vehicle("BB15ZVB ", "Ford") {
         @Override
         public int calculateBasicTripCost() {
            throw new UnsupportedOperationException("Not supported yet.");
         }
      };
      
      System.out.println(test);
   }
}
