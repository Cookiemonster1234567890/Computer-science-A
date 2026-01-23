import java.util.ArrayList;
import java.util.Scanner;

public class MyProgram
{
    public static void main(String[] args)
    {
        int keepGoing = 1;          //more transactions?
        int anotherDay = 1;         //more days
        int count = 1;              //track number of days
        double amount;              //how much to deposit or withdraw
        char transaction;   //transaction type
        int acctNumber;             //which account to access
        int indexOf;    //acctNumber's index in ArrayList
        Scanner scan = new Scanner(System.in);

        // ArrayList of Account objects
        ArrayList<Account> customers = new ArrayList<Account>();
        Account a = new Account("I.P. Freely", 500, 54327);
        Account b = new Account("U.R. Smart", 192, 74839);
        Account c = new Account("I.O. Ewe", 275, 62439);
        Account d = new Account("C.A. Butt", 850, 84235);
        Account e = new Account("I.C. You", 900, 91214);
        customers.add(a);
        customers.add(b);
        customers.add(c);
        customers.add(d);
        customers.add(e);

        while(anotherDay == 1)
        {
            //Visual output for reference
            System.out.println("The following accounts are available:\n");
            for(Account temp: customers)
                System.out.println(temp.toString() + "\n");
            while(keepGoing == 1)
            {
                //get account number
                do
                {
                    System.out.println("Enter the number of the account you would like to access: ");
                    acctNumber = scan.nextInt();
                    indexOf = validateAccountNumber(customers, acctNumber);
                }while(indexOf == -1);

                // get transaction type
                do{
                    System.out.println("Would you like to make a deposit (D) or withdraw (W)? ");
                    transaction = scan.next().charAt(0);
                }while(validateTransactionType(transaction));

                // get transaction amount
                do{
                    System.out.println("Enter the amount:  ");
                    amount = scan.nextDouble();
                }while(validateAmount(amount));

                // complete transaction
                if (transaction == 'w' || transaction == 'W')
                    customers.get(indexOf).withdraw(amount);
                else if (transaction == 'd' || transaction == 'D')
                    customers.get(indexOf).deposit(amount);

                // prompt for more transactions
                System.out.println("Would you like more transactions?  Enter 1 for yes or 2 for no.");
                keepGoing = scan.nextInt();
            }

            System.out.println("Summary of transactions for day " + count + ":");
            System.out.println("Number of deposits: " + Account.getNumDeposits());
            System.out.println("Number of withdrawals: " + Account.getNumWithdrawals());
            System.out.println("Total deposited: $" + Account.getTotalDeposits());
            System.out.println("Total withdrawn: $" + Account.getTotalWithdrawals());

            System.out.println();
            System.out.println("Would you like to enter transactions for another day?  Enter 1 for yes or 2 for no.");
            anotherDay = scan.nextInt();
            count++;
            keepGoing = 1;

            Account.resetTransactions();
        }
        System.out.println("Final account balances:");
        for(Account temp: customers)
            System.out.println(temp.toString() + "\n");
    }

    public static int validateAccountNumber(ArrayList<Account> tempArrayList,int acctNumber)
    {
        int indexOfAccount = -1;
        indexOfAccount = linearSearch (tempArrayList,acctNumber);

        if(indexOfAccount == -1)
            System.out.println("Sorry, invalid account number.");

        return indexOfAccount;
    }

    public static int linearSearch (ArrayList<Account> numbers, int target)
    {
        for (int index = 0; index < numbers.size(); index++)
        {
            if (target == numbers.get(index).getAcctNum())
            {
                return index;
            }
        }
        return -1;
    }

    public static boolean validateAmount(double amount)
    {
        if (amount > 0)
            return false;
        else
        {
            System.out.println("Sorry, amount must be > 0.");
            return true;
        }
    }

    public static boolean validateTransactionType(char transaction)
    {
        if (!(transaction == 'w' || transaction == 'W'||transaction == 'd' || transaction == 'D') )
        {
            System.out.println("Sorry, invalid action.");
            return true;
        }
        else
            return false;
    }
}
