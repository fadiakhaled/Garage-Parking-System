package garage;


public interface systemParkingInController {
	/**
	 * @param vehicle the vehicle to be parked in
	 * @param garage the garage that the vehicle will enter
	 * @return the number of the available slot
	 */
	public int parkingAlgorithm(Vehicle vehicle, Garage garage);
	
}
