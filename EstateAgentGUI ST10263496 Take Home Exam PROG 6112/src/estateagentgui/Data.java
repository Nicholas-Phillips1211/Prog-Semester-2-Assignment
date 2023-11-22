/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estateagentgui;

/**
 *
 * @author nicholasphillips
 */
public class Data {
    
    private String location;
    private String agentName;
    private double propertyPrice;
    private double commissionPercentage;
    
   public Data(String location, String agentName, double propertyPrice, double commissionPercentage){
       this.location = location;
       this.agentName = agentName;
       this.propertyPrice= propertyPrice;
       this.commissionPercentage = commissionPercentage;
       
   }

    public String getLocation() {
        return location;
    }

    public String getAgentName() {
        return agentName;
    }

    public double getPropertyPrice() {
        return propertyPrice;
    }

    public double getCommissionPercentage() {
        return commissionPercentage;
    }

}