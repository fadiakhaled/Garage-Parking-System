package garage;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        SystemBoundary system = new SystemBoundary();
        Scanner scan = new Scanner(System.in);
        System.out.println("Activate system .. ");
        system.activateSystem();

        boolean valid=true;
        while (valid) {
            System.out.println("\nChoose an option: ");
            System.out.println("[1] Park in");
            System.out.println("[2] Park out");
            System.out.println("[3] Display available parking slots.");
            System.out.println("[4] Display Total income and number of vehicles.");
            System.out.println("[5] Exit program");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    int s = system.park_in();
                    if (s != -1) {
                        System.out.println("Your slot number is: slot[" + s +"] ");
                        break;
                    }
                    else { System.out.println("There's no parking slot for your vehilce");
                        break;
                    }
                case 2:
                    system.park_out();
                    break;
                case 3:
                	system.DisplayAvailableSlots();
                    break;
                case 4:
                	system.total_income_Vnum();
                	break;
                case 5:
                	valid=false;
                	break;
            }
        }
    }
}
