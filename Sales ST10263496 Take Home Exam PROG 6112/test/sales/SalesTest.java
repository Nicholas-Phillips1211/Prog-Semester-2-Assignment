/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sales;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author nicholasphillips
 */
public class SalesTest {
    
    @Test
    public void calculateTotalSales_ReturnsTotalSales(){
        EstateAgent_ agent = new EstateAgent_();
        double[] pS= {10, 30, 50};
        double tS = agent.eAS(pS);
        assertEquals(90, tS, 0.1);
        
        //test passed
    }
    
    @Test
    public void calculateTotalCommission_ReturnCommission(){
        EstateAgent_ agent = new EstateAgent_();
        double pS = 50000.0;
        double commission = agent.eAC(pS);
        assertEquals(1000.0, commission, 0.001);
        
        //test passed
    }
    
    @Test
    public void topAgent_ReturnTopPosition(){
        EstateAgent_ agent = new EstateAgent_();
        double[] tS ={ 60000.0, 50000.0, 70000.0};
        int topPosition = agent.tEA(tS);
        assertEquals(2,topPosition);
        
        //test passed
    }
  
    
}
