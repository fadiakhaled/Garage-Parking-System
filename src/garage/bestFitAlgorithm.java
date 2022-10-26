package garage;

import java.util.LinkedList;

public class bestFitAlgorithm implements systemParkingInController{

    /**
     * the parkingAlgorithm method overrides the parkingAlgorithm method in the main interface.
     * It is used to search for an available slot according to the (best-fit) configuration
     * and changes the selected slot's status into false which means that this slot is reserved
     * and assigns the slot's car id to the vehicle which wants to park in
     * @param vehicle the vehicle to search for a slot according to its dimensions
     * @param garage the garage that has the slots to be compared
     * @return returns the selected slot's number  */
    @Override
	public int parkingAlgorithm(Vehicle vehicle, Garage garage) {
		LinkedList<slot> avSlots = new LinkedList<>();
        double v_dep = vehicle.getDep();
        double v_wid = vehicle.getWid();
        for (int i = 0; i < garage.getSlotsNumber(); i++) {

            boolean status = garage.getSlot()[i].getStatus();
            double S_dep = garage.getSlot()[i].getSlotDep();
            double S_wid = garage.getSlot()[i].getSlotWidth();

            if (status && (S_dep >= v_dep) && (S_wid >= v_wid)) // if the slot is empty and its dimensions is greater than or equal to the vehicle's dimensions
            {
                avSlots.add(garage.getSlot()[i]); // ad the slot mentioned in the list that contains the availabe slots
            }
        }

        slot best = null; // getting the best-fit slot which would have the minimum dimensions that fits to a vehicle
        // setting it to null so that it doesn't point to any random slot
        for (int i = 0; i <= avSlots.size() - 1; i++) {

            if (best == null) {
                best = avSlots.get(i);

            } // assign the best slot to the first available slot
            else if(avSlots.get(i).getSlotDep()<=best.getSlotDep() && avSlots.get(i).getSlotWidth()<=best.getSlotWidth()){
                //we should compare the next slot dimensions in the list to the present best-slot in order to get the minimum best slot
                best = avSlots.get(i); // assign the best slot to the
            }
        }
        if (best != null) {
            best.setStatus(false); // mark the selected slot taken as taken
            best.carId=vehicle.id;
            vehicle.setSlotNum(best.getSlotNumber());
            return best.getSlotNumber();
        }
        return -1;
	}
    /*
	public int captureArrivaleHour() {
		Calendar now = Calendar.getInstance();
		int hours= now.get(Calendar.HOUR_OF_DAY);
	    return hours;
	}
	public int captureArrivalMin() {
		Calendar now = Calendar.getInstance();
		int min =now.get(Calendar.MINUTE);
        return min;
	}
    */
}
