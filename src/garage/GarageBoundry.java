package garage;
import java.util.Scanner;

public class GarageBoundry {
    private int slotsNumber;
    private int config;
    private Garage gar = new Garage();
    private double [] dep;
    private double [] wid;


    public void fillDetails() {
        Scanner get = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the Garage setup");
        System.out.print("Enter the number of slots: ");
        slotsNumber = get.nextInt();
        while (slotsNumber<0)
        {
            System.out.println("invalid number .. enter number of slots: ");
            slotsNumber = get.nextInt();
        }

        System.out.println("Enter the garage configuration: ");
        System.out.println("[1] First-come first-serve configuration ");
        System.out.println("[2] Best-fit  configuration ");
        config = get.nextInt();

        while (config != 1 && config != 2)
        {
            System.out.println("invalid choice");
            System.out.print("[1] best fit configuration ");
            System.out.print("[2] first-come first-serve configuration ");
            config = get.nextInt();
        }


        dep = new double[slotsNumber];
        wid = new double[slotsNumber];

        System.out.print("Enter each slot dimensions");
        for (int i = 0; i < slotsNumber; i++)
        {
            System.out.print("\nenter slot [" + (i+1) + "] depth: ");
            dep[i] = get.nextDouble();
            System.out.print("enter slot [" + (i+1) + "] width: ");
            wid[i] = get.nextDouble();
        }


    }

    /**
     * @return the garage after setting the details*/
    public Garage setDetails()
    {
        gar.setSlotsNumber(slotsNumber);
        gar.setDimension(dep,wid);
        gar.setConfiguration(config);
        return gar;
    }
    
}
