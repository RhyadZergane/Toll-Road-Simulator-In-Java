package tollroadmain;

public class CustomerAccount implements Comparable<CustomerAccount>
{
   // List of variables
   private String customerForename;
   private String customerSurname;
   private Vehicle vehicle;
   private int accountBalance;
   private enum DiscountType{NONE, STAFF, FRIENDS_AND_FAMILY};
   private int cost;
   private String discount;
   // Temp method for splitting customers from text file
   private String customer;
   // Temporary string used for checking vehicle types
   private String vehicleType;
   // Temporary DiscountType used for activating the discounts
   private DiscountType discounts = DiscountType.NONE;
   
   // Constructor for creating a new customer
   public CustomerAccount(String customerForename, String customerSurname,
               Vehicle vehicle, int accountBalance, String discount)
   {
      this.customerForename = customerForename;
      this.customerSurname = customerSurname;
      this.accountBalance = accountBalance;
      this.vehicle = vehicle;
      this.discount = discount;
   }
   
   // Constructor for parsing data from the "customers.txt"
   public CustomerAccount(String customer)
   {
      // Tempoary array list used for splitting the string
      String customerList[];
      this.customer = customer;
      customerList  = customer.split(",");
      vehicleType   = customerList[0];
      
      // If statement that cheks what type of vehicle the customers
      if(vehicleType.contains("Car"))
      {
         vehicle = new Car(customerList[1],customerList[4]
                 ,Integer.parseInt(customerList[5]));
      }
      
      else if(vehicleType.contains("Van"))
      {
         vehicle = new Van(customerList[1],customerList[4]
                 ,Integer.parseInt(customerList[5]));
      }
      
      else
      {
         vehicle = new Truck(customerList[1],customerList[4]
                 ,Integer.parseInt(customerList[5]));
      }
      
      customerForename = customerList[2];
      customerSurname  = customerList[3];
      accountBalance   = Integer.parseInt(customerList[6]);
      discount         = customerList[7];
   }

   // Calls the staff discount
   public boolean activateStaffDiscount()
   {
      return discounts == DiscountType.STAFF;
   }
   
   // Calls the friends and family discount if the staff discount is not active
   public boolean activateFriendsAndFamilyDiscount()
   {
      if (discount.equals(DiscountType.STAFF.toString()))
      {
         System.out.println("You cannot activate this discount as you already "
                 + "have the staff discount");
         return discounts == DiscountType.STAFF;
      }
      else
      {
         return discounts == DiscountType.FRIENDS_AND_FAMILY;
      }
   }
   
   // Deactivates discount
   public boolean deactivateDiscount()
   {
      return discounts == DiscountType.NONE;
   }
   
   public void addFunds(int ammount)
   {
      this.accountBalance += ammount;
   }
   
   // Calculates the total cost of the trip and includes discounts if any.
   public int makeTrip() throws InsufficientAccountBalanceException
   {
      vehicle.calculateBasicTripCost();
      
      // Calculates cost for staff discount
      if(discount.equals(discounts.STAFF.toString()))
      {
         cost = vehicle.calculateBasicTripCost()/2;
      }
      // Calculates cost for friends and family discount
      else if(discount.equals(discounts.FRIENDS_AND_FAMILY.toString()))
      {
         activateFriendsAndFamilyDiscount();
            cost = vehicle.calculateBasicTripCost()- 
            (vehicle.calculateBasicTripCost()/10);  
      }
      // Calculates cost for no discount
      else
      {
         cost = vehicle.calculateBasicTripCost();
      }
          
      if(accountBalance < cost)
      {
         throw new InsufficientAccountBalanceException("Insufficient funds");
      }
      else
      {
        accountBalance -= cost;
      }
      return cost;
   }
   
   // To string method for customer account
   @Override
   public String toString()
   {
      return "Name: " + customerForename + " " + customerSurname + "\n" +
              "Vehicle Type: " + vehicle.getClass().getSimpleName() + "\n" + 
      vehicle + "\nYour account balance is: " + accountBalance +
              "\nDiscountType: "+ discount;
   }
   
   // comaparator for ordeing registration numbers
   @Override
    public int compareTo(CustomerAccount otherAccount) 
    {
      if(vehicle.getRegNo().compareTo(otherAccount.vehicle.getRegNo()) < 0)
      {
         // Returns 0 if the registration number comes before the other customer
         return -1;
      }
       
      else if (vehicle.getRegNo().compareTo(otherAccount.vehicle.getRegNo())> 0)
      {
         //Returns 1 if the registration number comes after the other customer
         return 1;
      }
       
      else
      {
         return 0;
      }
    }
    
    // Accessor methods for customer account
    public String getForeName()
    {
      return customerForename;
    }
    
    public String getSurName()
    {
      return customerSurname;
    }
    
    public String getRegNo()
    {
      return vehicle.getRegNo();
    }
    
    public int getCost()
    {
      return cost;
    }
    
    public int getAccountBalance()
    {
      return accountBalance;
    }
   
    // Test harness for CustomerAccount class
   public static void main(String[] args) throws 
           InsufficientAccountBalanceException
   {
      // Test data
      CustomerAccount customer = new CustomerAccount("Dave"," Smith",
      new Car("EX10MYP","Suzuki",6),10000,"STAFF");
      
      customer.activateStaffDiscount();
      //customer.activateFriendsAndFamilyDiscount();
  
      System.out.println(customer.makeTrip());    
   }
}
