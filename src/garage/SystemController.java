package garage;

public class SystemController {

    /**
     * the createVehicle method creates the vehicle form that will be filled by the vehicle owner
     * @return returns the vehicle that will park in the garage */
    public Vehicle createVehicle()
    {
        VehicleForm vf = new VehicleForm();
        vf.fillDetails();
        return vf.setVehicle();
    }

    /**
     * the createGarage method creates the garage form that will be filled by the garage owner
     * @return returns the garage with the needed details */
    public  Garage createGarage(){
        GarageBoundry garB = new GarageBoundry();
        garB.fillDetails();
        return garB.setDetails();
    }
}
