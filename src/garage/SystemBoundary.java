package garage;

import java.util.Scanner;


public class SystemBoundary {
    private SystemController controller = new SystemController();

    Vehicle veh = new Vehicle();
    Garage gar = new Garage();

	private systemTimeController Time=new systemTimeController();
	private GarageSlotsController Gar=new GarageSlotsController();
    private GarageCalculationsController profit_carN=new  GarageCalculationsController();

    protected int arrivalHour;
    protected int arrivalMin;
    protected int leavingHour;
    protected int leavingMin;
    protected double cost;
    protected double income;
    protected double paid;
    protected int carSlot;
    protected int carNum;
    protected int carId;
    
    Scanner get = new Scanner(System.in);  // Create a Scanner object

    /**
     * activateSystem method call the system controller to create the garage form and get the garage details*/
    public void activateSystem() {
        gar = controller.createGarage();
    }

    /**
     * DisplayAvailableSlots method call the systemDisplay controller to display all the available slots*/
    public void DisplayAvailableSlots() {
    	systemDisplayController show=new systemDisplayController();
    	show.display(gar);
    }


    /**
     * park_in method is used to park in a vehicle according to the chosen configuration algorithm chosen by
     * the garage owner and call the function that captures the arrival time
     * @return the number of the selected slot
     */
    public int park_in() {
        veh = controller.createVehicle();

        int selectedSlot= Integer.MAX_VALUE; // nothing is selected yet

        if (gar.check_config() == 1) { //call first come, first served configuration
            systemParkingInController firstController=new FirstComeAlgorithm();
        	selectedSlot = firstController.parkingAlgorithm(veh,gar);
        	arrivalHour = Time.captureArrivalHour();
        	arrivalMin = Time.captureArrivalMin();
        }

        else if (gar.check_config() == 2) { // best-fit configuration
        	systemParkingInController bestController=new bestFitAlgorithm();
            selectedSlot = bestController.parkingAlgorithm(veh,gar);
            arrivalHour = Time.captureArrivalHour();
            arrivalMin = Time.captureArrivalMin();
        }

        carNum=profit_carN.calcVehiclesNum(1);
        return selectedSlot;
    }

    /**
     * park_out method is used to park out the vehicle out of the garage, call the required functions
     * to get the slot details, calculate the parking fees, and enter the money taken from the driver
     * @return returns false if there's no vehicles parked in the garage, else returns true
     */
    public boolean park_out ()
    {
    	if(Gar.checkAvailability(gar)) {
    		System.out.println("There's no vehicles in the garage!");
    		return false;
    	}

        EnterSlotNumber();
        while(!(Gar.setFreedSlot(gar,carSlot,carId))) {
        	System.out.println("Error wrong slot number or wrong id");
        	System.out.print("Enter slot number: ");
        	carSlot = get.nextInt();
        	System.out.print("Enter car id: ");
        	carId =get.nextInt();
        };
        leavingHour = Time.captureDepartureHour();
        leavingMin = Time.captureDepartureMin();
        cost = profit_carN.CalculateFees(arrivalHour, arrivalMin, leavingHour, leavingMin);
        income=profit_carN.calcIncome(cost);

        enterPaidAmount();
        return true;
    }

    public void enterPaidAmount() {
        System.out.println("Cost is: " + cost);
        System.out.println("Enter the amount paid: ");
        Scanner get = new Scanner(System.in);
        paid = get.nextDouble();
        while (paid < cost) {
            System.out.println("The paid amount is less than the cost please enter the paid amount: ");
            paid = get.nextDouble();
        }
        double change = profit_carN.checkChange(cost, paid);
        System.out.println("The change is: " + change);
    }

    public void EnterSlotNumber() {
        System.out.print("Enter slot number: ");
        carSlot = get.nextInt();
        System.out.print("Enter car id: ");
        carId =get.nextInt();
    }

    public void total_income_Vnum()
    {	
    	System.out.println("Total Income is: "+income);
    	System.out.println("Number of cars: "+carNum);
    }



}
