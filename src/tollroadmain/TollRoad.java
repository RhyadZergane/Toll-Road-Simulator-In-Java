package tollroadmain;
import java.util.*;

public class TollRoad 
{
   private int moneyMade;
   private List<CustomerAccount> customers;
   
   public TollRoad()
   {
      moneyMade = 0;
      customers = new ArrayList<>();
   }
   
   // Adds customer to list and sorts by registration number
   public void addCustomer(CustomerAccount acc)
   {
      customers.add(acc);
      Collections.sort(customers);
   }
   
   // Finds customers based on registration number
   public CustomerAccount findCustomer(String regNo) throws 
           CustomerNotFoundException
   {
      for(CustomerAccount cus: customers)
      {
         if(cus.getRegNo().equals(regNo))
         {
            return cus;
         }
      }
      throw new CustomerNotFoundException("CustomerAccount does not exist");
   }
   
   // Charges customers based on registration number
   public void chargeCustomer(String regNum) throws CustomerNotFoundException, 
           InsufficientAccountBalanceException
   {
      int counter = 0;
      for(CustomerAccount cus: customers)
      {
         if(cus.getRegNo().equals(regNum))
         {
            moneyMade += cus.makeTrip();
            counter++;
         }
      }
      
      // Counter that checks if customer account exists
      if (counter == 0)
      {
         throw new CustomerNotFoundException(" CustomerAccount does not exist");
      }
   }
   
   public int getMoneyMade()
   {
      return moneyMade;
   }
   
   public List getCustomers()
   {
      return customers;
   }
   
   // toString method for toll road class
    @Override
   public String toString()
   {
      StringBuilder strBuild = new StringBuilder();
      
      // Uses string builder to create information for all of the customers 
      for(CustomerAccount customer: customers)
      {
         strBuild.append(customer).append("\n").append("\n");
      }
      
      return strBuild.toString();
   }
   
   // Test harness for the TollRoad class
   public static void main(String[] args) throws CustomerNotFoundException, 
           InsufficientAccountBalanceException
   {
      // Test data
      TollRoad test = new TollRoad();
      
      CustomerAccount dave = new CustomerAccount("Dave","Smith",
              new Car("EX10MYP","Suzuki",5),10000,"NONE");
      CustomerAccount barry = new CustomerAccount("Barry","Walker",
              new Van("EK02DEU","Ford",700),10000,"STAFF");
      
      test.addCustomer(dave);
      test.addCustomer(barry);
      
      test.chargeCustomer("EK02DEU");
      test.chargeCustomer("EX10MYP");
      System.out.println(test);
      System.out.println("Money made: " + test.getMoneyMade());
   }
}
