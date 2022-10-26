package garage;


public class FirstComeAlgorithm implements systemParkingInController{

    /**
     * the parkingAlgorithm method overrides the parkingAlgorithm method in the main interface.
     * It is used to search for an available slot according to the (first come, first served) configuration
     * and changes the selected slot's status into false which means that this slot is reserved
     * and assigns the slot's car id to the vehicle which wants to park in
     * @param vehicle the vehicle to search for a slot according to its dimensions
     * @param garage the garage that has the slots to be compared
     * @return returns the selected slot's number  */
    @Override
    public int parkingAlgorithm(Vehicle vehicle, Garage garage) {
		double v_dep = vehicle.getDep();
        double v_wid = vehicle.getWid();

        for (int i = 0; i < garage.getSlotsNumber(); i++)
        {
            boolean status =garage.getSlot()[i].getStatus();
            double s_dep = garage.getSlot()[i].getSlotDep();
            double s_wid = garage.getSlot()[i].getSlotWidth();
            //boolean com = compareDimensions(s_dep,s_wid,v_dep,v_wid);

            if (status && (s_dep >= v_dep) && (s_wid >=v_wid)) //the slot is available and its dimensions is greater than or equal to the vehicle
            {
                garage.getSlot()[i].setStatus(false); // mark the slot chosen as taken
                garage.getSlot()[i].carId=vehicle.id;
                vehicle.setSlotNum(garage.getSlot()[i].getSlotNumber());
                return garage.getSlot()[i].getSlotNumber();
            }
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
