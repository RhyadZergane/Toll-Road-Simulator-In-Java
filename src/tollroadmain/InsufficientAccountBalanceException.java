package tollroadmain;

public class InsufficientAccountBalanceException extends Exception
{
   public InsufficientAccountBalanceException(String message)
   {
       super(message);
   }
   
   // Test harness for innsufficient fund exception
   public static void main(String[] args) throws 
           InsufficientAccountBalanceException
   {
      throw new InsufficientAccountBalanceException("This is a test");
   }
}
