package garage;

import java.util.Calendar;

public class systemTimeController {

	public int captureDepartureHour() {
		Calendar now = Calendar.getInstance();
		int hours= now.get(Calendar.HOUR_OF_DAY);
        return hours;
	}
	public int captureDepartureMin() {
		Calendar now = Calendar.getInstance();
		int min =now.get(Calendar.MINUTE);
        return min;
	}
	public int captureArrivalHour() {
		Calendar now = Calendar.getInstance();
		int hours= now.get(Calendar.HOUR_OF_DAY);
	    return hours;
	}
	public int captureArrivalMin() {
		Calendar now = Calendar.getInstance();
		int min =now.get(Calendar.MINUTE);
        return min;
	}
}
