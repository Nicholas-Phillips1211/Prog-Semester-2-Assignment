/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package estateagentgui;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicholasphillips
 */
public class EstateAgentTest {
    
    @Test
    public void testCC() {
        System.out.println("cC");
        String pP = "";
        String aC = "500";
        EstateAgent instance = new EstateAgent();
        double expResult = 0.0;
        double result = instance.cC(pP, aC);
        assertEquals(expResult, result, 0);
      
       
    }

    @Test
    public void testValData() {
        System.out.println("valData");
        Data dataToVal = new Data("Cape Town","John Doe",150000,5.0 );
        EstateAgent instance = new EstateAgent();
        boolean expResult = true;
        boolean result = instance.valData(dataToVal);
        assertEquals(expResult, result);
       
    }
    
}
