package garage;
import java.util.Scanner;  // Import the Scanner class


public class VehicleForm {
    private String name;
    private int year;
    private int id;
    private double dep;
    private double wid;

    public void fillDetails()
    {
        Scanner get = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Enter the vehicle's details .. ");
        System.out.print("Enter the vehicle's model name: ");
        name = get.nextLine();
        System.out.print("Enter the vehicle's model year: ");
        year = get.nextInt();
        while (year > 2022 || year <= 1900)
        {
            System.out.print("invalid year .. enter vehicle's model year: ");
            year = get.nextInt();
        }
        System.out.print("Enter the vehicle's ID: ");
        id = get.nextInt();
        while (id < 0)
        {
            System.out.print("invalid id.. enter vehicle's id: ");
            id = get.nextInt();
        }
        System.out.println("Enter the vehicle's Dimensions in meters");
        System.out.print("Depth: ");
        dep = get.nextDouble();
        while (dep <= 0)
        {
            System.out.print("invalid depth .. enter depth: ");
            dep = get.nextDouble();
        }
        System.out.print("Width: ");
        wid = get.nextDouble();
        while (wid <= 0 || wid >= dep)
        {
            System.out.print("invalid width.. enter width: ");
            wid = get.nextDouble();
        }
    }

    public Vehicle setVehicle()
    {
        Vehicle v = new Vehicle();
        v.setModelName(name);
        v.setModelYear(year);
        v.setID(id);
        v.setDimensions(dep, wid);
        return v;
    }
}
