package tollroadmain;

public class CustomerNotFoundException extends Exception
{
   public CustomerNotFoundException(String message)
   {
       super(message);
   }
   
   // Test harness for Customer Not Found Exception
   public static void main(String[] args) throws 
           CustomerNotFoundException
   {
      throw new CustomerNotFoundException("This is a test");
   }
}
