package tollroadmain;

public class Van extends Vehicle 
{
   private int payload;

   public Van(String regNo, String manufacturer, int payload) 
   {
      // Inherits constructor from vehicle
      super(regNo, manufacturer);
      this.payload = payload;
   }

   // Calculates the cost for tthe toll for a Van
   @Override
   public int calculateBasicTripCost() 
   {
      if(payload <= 600)
      {
         // For £5.00
         return 500;
      }
      
      else if((payload<= 800) && (payload > 600))
      {
         // For £7.50
         return 750;
      }
      
      else 
      {
         // For £10
         return 1000;
      }
   }
   
   // ToString method for van
   @Override
   public String toString()
   {
      return "Registration no: "   + this.getRegNo()        + 
             "\nManufacturer: "    + this.getManufacturer() +
             "\nPayload: "         + payload + " KG";
   }
   
   // Test harness for Van
   public static void main(String[] args)
   {
      // Test data
      Van van = new Van("BZ11NBV ","Ford", 600);
      System.out.println(van.calculateBasicTripCost());
   }
   
}
