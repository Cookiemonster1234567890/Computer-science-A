import java.awt.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class OVHaarlemmerbus {
    public static void main(String[] args) {
        System.out.println("OV Haarlemmerbus");

        //INITIALIZING ALL THE VARIABLES
        int revenue = 0;
        int currentPrice = 0;
        int currentLoad41 = 0;
        int currentLoad67 = 0;
        int passengersMoved = 0;
        int discountedBoardings = 0;
        int preventedBoardings = 0;
        int peakRides = 0;
        int offPeakRides = 0;
        int prevPeakRides = 0;

        while (true) { //STARTING ASK LOOP
            System.out.println("R u a customer or an employee");
            Scanner scan = new Scanner(System.in);
            String choice = scan.next();

            if (choice.equals("customer")) { //CUSTOMER LOOP
                System.out.println("Very good, we are going to validate your ticket rn");
                System.out.print("name? > ");
                String name = scan.next();
                System.out.print("Age? > ");
                int age = scan.nextInt();
                System.out.print("what ticket do you want: day v single > ");
                String ticketType = scan.next();
                if (ticketType.equals("day")) {
                    currentPrice = 7;
                } else if (ticketType.equals("single")) {
                    if (age < 19) {
                        currentPrice = 3 - (3 / 2);
                    } else if (age > 64) {
                        currentPrice = 3 - (3 / 10 * 3);
                    }
                } else {
                    System.out.println("Invalid ticket type");
                }
                System.out.print("hour? (0 - 23) > ");
                int currentHour = scan.nextInt();
                if (currentHour < 0 && currentHour > 24) {
                }
                if (currentHour > 6 && currentHour < 10) {
                    currentPrice += 0.5;
                } else if (currentHour > 15 && currentHour < 19) {
                    currentPrice += 0.5;
                }
                System.out.println("Price: " + currentPrice + " ");
                revenue += currentPrice;
            }


            else if (choice.equals("employee")) {
                System.out.println("Please fill in the password");
                    String password = scan.next();
                    if(password.equals("ILOVE67")) {
                        System.out.println("would you like to add a new trip or close the day? (closeday/newtrip)");
                        String employeeChoice =  scan.next();
                        if(employeeChoice.equals("newtrip")) {
                            System.out.print("route (r41 or r67) > ");
                            String route = scan.next();
                            System.out.print("Hour > ");
                            int hour = scan.nextInt();
                            System.out.print("Amount boarding > ");
                            int amountBoarding = scan.nextInt();
                            System.out.print("Alighting > ");
                            int alighting = scan.nextInt();
                            if(route.equals("r41")) {
                                currentLoad41 -= alighting;
                                currentLoad41 += amountBoarding;
                                if (currentLoad41 > 41) {
                                    preventedBoardings += currentLoad41 - 41;
                                    currentLoad41= 41;
                                }
                                if (hour > 6 && hour < 10) {
                                    peakRides += 1;
                                } else if (hour > 15 && hour < 19) {
                                    peakRides += 1;
                                } else {
                                    offPeakRides += 1;
                                }
                                System.out.println("Current load r41: " + currentLoad41 + "/41");

                            } else if (route.equals("r67")) {
                                currentLoad67 -= alighting;
                                currentLoad67 += amountBoarding;
                                if (currentLoad67 > 67) {
                                    preventedBoardings += currentLoad67 - 67;
                                    currentLoad67 = 67;
                                }
                                if (hour > 6 && hour < 10) {
                                    peakRides += 1;
                                } else if (hour > 15 && hour < 19) {
                                    peakRides += 1;
                                } else {
                                    offPeakRides += 1;
                                }
                                System.out.println("Current load r67: " + currentLoad67 + "/67");
                            }
                        }
                        else if(employeeChoice.equals("closeday")) {

                        }
                    }
                    else {
                        while (true) {
                            System.out.println("ERROR 67 - SCAMMER REPORTED. THEY ARE TRYING TO HACK US!!!!!!!");
                        }
                }
            }
        }
    }
}
