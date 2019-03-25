package tollroadmain;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TollRoadMain 
{
   // Method for reading in the file
   public TollRoad initialiseTollRoadFromFile() throws FileNotFoundException
   {
      File customerData = new File("customerData.txt");
      String line;
      TollRoad road = new TollRoad();
      Scanner reader = new Scanner(customerData);
      
      // Reads file from customerData and adds it to the tollroad
      while(reader.useDelimiter("#").hasNext())
      {
         line = reader.next();
         CustomerAccount acc = new CustomerAccount(line);
         road.addCustomer(acc);
      }
      return road;
   }
   
   // Method for simulating the TollRoad 
   public void simulateFromFile(TollRoad road) throws FileNotFoundException
   {
      File transactions = new File("transactions.txt");
      String line;
      String tempMethods[];
      String regNum = "";
      int addBalance;
      Scanner reader = new Scanner(transactions);
      while(reader.useDelimiter("\\$").hasNext())
      {
         try
         {
            line = reader.next();

            tempMethods = line.split(",");
            // If the string contains addFunds then it will addFunds to
            // The customer's account
            if(tempMethods[0].equals("addFunds"))
            {
               regNum = tempMethods[1];
               addBalance = Integer.parseInt(tempMethods[2]);
               road.findCustomer(regNum).addFunds(addBalance);
               System.out.println(regNum + ": " + addBalance +
                       " added sucessfully");
            }
            // Otherwise it will try to make trip
            else
            {
               regNum = tempMethods[1];
               road.chargeCustomer(regNum);
               System.out.println(regNum + ": Trip completed sucessfully");
            }
         }

         catch (CustomerNotFoundException e) 
         {
            System.err.println(regNum + ":" + " addFunds failed. "
                    +e.getMessage());
         }
         catch(InsufficientAccountBalanceException e)
         {
            System.err.println(regNum + ":" + " makeTrip failed. " 
                    +e.getMessage());
         }
      }
      reader.close();
   }
 
   // Main method for the TollRoad main method
   public static void main(String[] args)
   { 
      try 
      {
         TollRoadMain main = new TollRoadMain();
         // Creates TollRoad from initialiseTollRoadFromFile
         TollRoad rd = main.initialiseTollRoadFromFile();
         main.simulateFromFile(rd);
         System.out.println("Money made: " + rd.getMoneyMade());
      } 
      catch (FileNotFoundException e) 
      {
         System.err.println("File could not be read" + e);
      } 
   }
}
