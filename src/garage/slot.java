package garage;

public class slot{
    public static int count;
    protected int slot_num;
    protected double Dep;
    protected double width;
    protected boolean status;
    protected int carId;
    slot(){
        status=true;
        count++;
        slot_num=count;
    }

    public double getSlotDep() {
        return Dep;
    }

    public double getSlotWidth() {
        return width;
    }

    public int getSlotNumber() {
        return slot_num;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean newStatus) {
        status=newStatus;
    }

    public void setSlotDimension(double d,double wid) {
        Dep=d;
        width=wid;
    }

}
