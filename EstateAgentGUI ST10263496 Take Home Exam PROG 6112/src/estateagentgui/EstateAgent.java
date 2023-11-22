/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estateagentgui;

/**
 *
 * @author nicholasphillips
 */
class EstateAgent implements IEstateAgent {

    @Override
    public double cC(String pP, String aC) { // cC = calculate commission, pP= property price, aC= agent commission
        try{
            double price = Double.parseDouble(pP);
            double commissionPercentage = Double.parseDouble(aC);
            return (commissionPercentage/100)* price;
        }catch (NumberFormatException ex){
            return 0;
        }
        
    }
 
    // validate if the data has been inputted correctly
    @Override
    public boolean valData(Data dataToVal) {
           return !dataToVal.getLocation().isEmpty() &&
                !dataToVal.getAgentName().isEmpty()&&
                dataToVal.getPropertyPrice()>0 &&
                dataToVal.getCommissionPercentage()>0;
    }
    
}
