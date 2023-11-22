/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sales;

/**
 *
 * @author nicholasphillips
 */
public class EstateAgent_ implements IEstateAgent {
    
    //eAS = estate agent sales
    //eAC = estate agent commission
    //tEA = top estate agent
    // eAC = estate agent commission
    
    private final double cR = 0.02; // cR= commission rate

    @Override
    public double eAS(double[] pS) {
        double tS= 0;
        for(double sale : pS){
            tS += sale;
        }
        return tS;
        
    }

    @Override
    public double eAC(double pS) {
        return pS*cR;
        
    }

    @Override
    public int tEA(double[] tS) {
        int tAI = 0;
        for (int i= 1; i< tS.length;i++){
            if(tS[i]>tS[tAI]){
                tAI = i;
            }
        }
        return tAI;
        
        
    }
    
    
    
    
    
}
