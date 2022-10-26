package garage;

import org.jetbrains.annotations.NotNull;

public class systemDisplayController {

    /**
     * printing all the available slots by looping through all the slots' status
     * @param gar the garage to be checked
     */
	public void display(@NotNull Garage gar) {
		int av = 0;
        if (gar.getSlotsNumber() == 0) {
            System.out.println("No slots are entered yet, please activate the system first");
        }
        else {
            for (int i = 0; i < gar.getSlotsNumber(); i++) {
                if (gar.getSlot()[i].getStatus()) {
                    System.out.println("Slot [" + gar.getSlot()[i].getSlotNumber() + "] ");
                    av++;
                }
            }
            if (av == 0) {
                System.out.println("No Available parking slot ... ");
            }
        }
	}
}
