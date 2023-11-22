/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estateagentgui;
import javax.swing.JFrame;

/**
 *
 * @author nicholasphillips
 */
// run class that launches the program
public class RunAgent {
     public static void main(String[] args) {
         EstateAgentGUI agent = new EstateAgentGUI();
         agent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         agent.setBounds(500,500,500,500);
         agent.setVisible(true);
     }
         
     }

