package garage;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class GarageSlotsController {

	/**
	 * checking the availability of each slot in the garage
	 * @param gar the garage to be checked
	 * @return the availability of the slot */
	public boolean checkAvailability(@NotNull Garage gar) {
		 for (int i = 0; i < gar.getSlotsNumber(); i++) {		
	          boolean status = gar.getSlot()[i].getStatus();
	          if(!status) {
	        	  return false;
	          }
	     }
		 return true;
	}

	/**
	 * Editing the slot status to available after parking out of it
	 * @param slot the slot number to search for
	 * @param carId the car id that was entered by the driver to check if it matches the car id in the slot
	 * @return true if the system found a slot that matches the entered slot number and car id, else return false
	 */
	public boolean setFreedSlot(@NotNull Garage garage, int slot, int carId) {

		for(int i=0;i<garage.getSlotsNumber();i++) {
			if(slot==garage.getSlot()[i].getSlotNumber() &&garage.getSlot()[i].getStatus()==false && garage.getSlot()[i].carId==carId) {
				garage.getSlot()[i].setStatus(true);
				return true;
			}
		}
		return false;
	}
}
