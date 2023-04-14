package Arina;

public class Agents extends Persons{
    private final double RATE = 0.05;
    private double commission = 0;
    private static int numAgents = 0;

    Agents(){
    numAgents++;
    }
    Agents(String name, String contactNumber, String address){
         setName(name);
         setContactNumber(contactNumber);
         setAddress(address);
         numAgents++;
    }
    public double getRate(){
        return RATE;
    }
    public double getCommission(){
        return commission;
    }
    public void updateCommission(double commission){
        this.commission += commission;
    }
    public static int getNumAgents(){
        return numAgents;
    }
}
