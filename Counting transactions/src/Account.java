public class Account
{
    // data fields
    private String name;
    private double balance;
    private int acctNum;

    private static int numDeposits = 0;
    private static double totalDeposits = 0.0;
    private static int numWithdrawals = 0;
    private static double totalWithdrawals = 0.0;

    // constructors
    public Account()
    {
        name = "";
        balance = 0.00;
        acctNum = 0;
    }

    public Account(String n, double b, int acctNum)
    {
        name = n;
        balance = b;
        this.acctNum = acctNum;
    }

    // accessors
    public String getName()
    {
        return name;
    }

    public double getBalance()
    {
        return balance;
    }

    public int getAcctNum()
    {
        return acctNum;
    }

    public static int getNumDeposits()
    {
        return numDeposits;
    }

    public static int getNumWithdrawals()
    {
        return numWithdrawals;
    }

    public static double getTotalDeposits()
    {
        return totalDeposits;
    }

    public static double getTotalWithdrawals()
    {
        return totalWithdrawals;
    }

    // mutators
    public void setName(String newName)
    {
        name = newName;
    }

    public void setBalance(double newBalance)
    {
        balance = newBalance;
    }

    public void setAcctNum(int acctNum)
    {
        this.acctNum = acctNum;
    }

    // deposit adds deposits to the current balance
    public void deposit (double amount)
    {
        balance = balance + amount;
        numDeposits++;
        totalDeposits += amount;
    }

    // withdraw subtracts from the current balance if there are sufficient funds
    public void withdraw (double amount)
    {
        if (amount <= balance)
        {
            balance = balance - amount;
            numWithdrawals++;
            totalWithdrawals += amount;
        }
        else
            System.out.println ("Insufficient funds.");
    }

    public static void resetTransactions()
    {
        numDeposits = 0;
        totalDeposits = 0.0;
        numWithdrawals = 0;
        totalWithdrawals = 0.0;
    }

    // toString represents the objects state as a String
    public String toString()
    {
        return "Name: " + name +
                "\nAccount Number: " + acctNum +
                "\nBalance: $" + String.format("%.02f", balance);
    }
}
