import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        System.out.println("unlock fee is $2");
        System.out.println("VAT is 21%");
        System.out.println("per minute rate: 50 cents a minute");
        System.out.println("fill in the amount of minutes below:");
        Scanner scan = new Scanner(System.in);

        int tripMinutes = scan.nextInt();
        int unlockFee = 2;
        double perMinute = 0.5;
        double total;
        double deviceFee = 0.01;
        double vAT = 1.21;

        if (tripMinutes < 0)
            tripMinutes = 0;

        total = (unlockFee + (perMinute * tripMinutes) + (perMinute * deviceFee)) * vAT;


        System.out.println("you have used " + tripMinutes + " minutes this trip.");
        System.out.print("this means your total is: $");
        total = (int)(total + 0.5);
        System.out.print(total);
        scan.close();
    }
}