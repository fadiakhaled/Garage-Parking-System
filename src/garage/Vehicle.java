package garage;
import java.util.LinkedList;
import java.util.Vector;
public class Vehicle {
    private String name;
    private int year;
    private int slotNum;
    protected int id;
    private double Dep;
    private double wid;
    public void setModelName (String name){
        this.name=name;
    }
    public void setModelYear (int year){
        this.year=year;
    }
    public void setID (int id){
        this.id = id;
    }
    public void setSlotNum(int slot) {
    	slotNum=slot;
    }
    public void setDimensions (double Dep, double wid){
        this.Dep = Dep;
        this.wid = wid;
    }

    public double getDep() {
        return Dep;
    }
    public int getSlotNum() {
        return slotNum;
    }
    public double getWid(){
        return wid;
    }
    public int getVehicleId() {
    	return id;
    }
}
