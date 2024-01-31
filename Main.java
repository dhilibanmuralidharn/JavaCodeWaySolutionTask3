import java.util.*;

class ATM{
    private BankAccount bankAccount;
     public ATM( BankAccount bankAccount){
         this.bankAccount = bankAccount;
     }
     public void displayMenu(){
         System.out.println("1. Check Balance");
         System.out.println("2. withdraw");
         System.out.println("3. Deposit");
         System.out.println("4.Exit");
     }

     public void start(){
         Scanner input = new Scanner(System.in);
         int choice;

         do{
             displayMenu();
             System.out.print("Enter Your Choice: ");
             choice = input.nextInt();

             switch (choice){
                 case 1:
                     checkBalance();
                     break;
                 case 2:
                     withdraw();
                     break;
                 case 3:
                     deposit();
                     break;
                 case 4:
                     System.out.println("Exiting.....");
                     break;
                 default:
                     System.out.println("Invalid choice. Please try again");
             }
         } while (choice != 4);
     }
     private void checkBalance(){
         System.out.println("Your current Balance is: " + bankAccount.getBalance());
     }

     private void withdraw(){
         Scanner input = new Scanner(System.in);
         System.out.print("Enter the amount to withdraw: ");
         int amount = input.nextInt();

         if(bankAccount.getBalance() >= amount){
             bankAccount.withdraw(amount);
             System.out.println("Withdrawal successful. Your new Balance is: " + bankAccount.getBalance());
         } else{
             System.out.println("Insufficient Balance. Please try again.");
         }
     }
     private void deposit(){
         Scanner input = new Scanner(System.in);
         System.out.print("Enter the amount to deposit: ");
         int amount = input.nextInt();

         bankAccount.deposit(amount);
         System.out.println("Deposit successful. Your new Balance is: " + bankAccount.getBalance());
     }
}

class BankAccount{
    private int balance;

    public BankAccount(int balance){
        this.balance = balance;
    }
    public int getBalance(){
        return balance;
    }
    public void withdraw(int amount){
        balance -= amount;
    }
    public void deposit(int amount){
        balance += amount;
    }
}

class Main{
    public static void main(String[] args){
        /* create a BankAccount instance with an initial balance of 1000 */
        BankAccount bankAccount = new BankAccount(1000);

        /* Create an ATM instance using the BankAccount */
        ATM atm = new ATM(bankAccount);

        /* Call the start method to initiate the ATM menu */
        atm.start();
    }
}