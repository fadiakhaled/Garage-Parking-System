package garage;

public class Garage {
    private int slotsNumber;
    protected slot[] slots = new slot[slotsNumber];
    private int configuration;
    Garage()
    {
        slots = new slot[slotsNumber];
        for (int i = 0; i < slotsNumber; i++)
            slots[i] = new slot();
    }

    public void setSlotsNumber(int num)
    {
        slotsNumber = num;
        slots = new slot[slotsNumber];
        for (int i = 0; i < slotsNumber; i++)
            slots[i] = new slot();
    }

    /**
     * @return returns the number of slots in the garage */
    public int getSlotsNumber() {
        return slotsNumber;
    }

    /**
     * set the dimension of each slot in the garage
     * @param dep is an array that contains the depth of each slot in order
     * @param wid is an array that contains the width of each slot in order
     */
    public void setDimension(double [] dep, double [] wid)
    {
        for (int i = 0; i < slotsNumber; i++)
            slots[i].setSlotDimension(dep[i],wid[i]);
    }

    public void setConfiguration(int config)
    {
        configuration = config;
    }

    public int check_config() {
        return configuration;
    }

    /**
     * @return returns array of slots of the garage */
    public slot [] getSlot ()
    {
        return slots;
    }



}
