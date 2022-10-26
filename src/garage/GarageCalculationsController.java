package garage;

public class GarageCalculationsController {
	protected double income=0;
	protected int carNum=0;

	/**
	 * @return the total income of tha garage */
	public double calcIncome(double cost) {
		income=income+cost;
		return income;
	}

	/**
	 * @param num is the number of new vehicles that have parked in the garage
	 * @return the total number of vehicles that have parked in the garage */
	public int calcVehiclesNum(int num) {
		carNum=carNum+num;
		return carNum;
	}

	/**
	 * @param arrHour is the arrival time of the vehicle owner in the garage
	 * @param leaveHour is the departure time of the vehicle out of the garage
	 * @return the parking fees for the parked vehicle */
	public double CalculateFees(int arrHour,int arrMin,int leaveHour,int leaveMin) {
		double hour=leaveHour-arrHour;
		double min=leaveMin-arrMin;
		if(min>0 && hour==0) {
			hour+=1;
		}
		else if(min>0) {
			min=min/60;
			hour+=min;
		}
		double cost=hour*5;
		return cost;
	}

	/**
	 * @param cost is the parking fees that should be paid
	 * @param paid is the amount of money given by the vehicle driver to the garage owner
	 * @return the change */
	public double checkChange(double cost,double paid) {
		return paid-cost;
	}
}
