/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sales;

import java.util.Scanner;

/**
 *
 * @author nicholasphillips
 */


public class Sales {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        final int numAgents = 2; // number of agents
        final int numMonths = 3; // number of months
        final double cR = 0.02; // commission rate

        //  2D array for sales
         double[][] sales = new double[numAgents][numMonths];
        String[] monthNames = {"Jan", "Feb", "Mar"}; // months
        String[] agentNames = {"Joe Bloggs", "Jane Doe"}; // agent names
        
        
        
         
        // Input property sales data
        for (int i = 0; i < numAgents; i++) {
            for (int j = 0; j < numMonths; j++) {
                System.out.print("Enter property sales for " + agentNames[i] +
                                 " in " + monthNames[j] + ": ");
                sales[i][j] = scanner.nextDouble();
            }
        }
        
        //EstateAgent_ estateAgent= new EstateAgent_();

        // Calculate total property sales and commission for each agent
        double[] tS = new double[numAgents]; // tS = total sales
        double[] cE = new double[numAgents]; // cE = commission earned

        for (int i = 0; i < numAgents; i++) {
            for (int j = 0; j < numMonths; j++) {
                tS[i] += sales[i][j];
            }
            cE[i] = tS[i] * cR;
        }

        // Find the top-selling estate agent
        int tAI = 0; // tAI = top agent index
        for (int i = 1; i < numAgents; i++) {
            if (tS[i] > tS[tAI]) {
                tAI = i;
            }
        }

        // Display results
        System.out.println("\nTotal Property Sales and Commission Earned:");
        for (int i = 0; i < numAgents; i++) {
            System.out.println(agentNames[i] +
                    ": Total Sales = R " + tS[i] +
                    ", Commission Earned = R " + cE[i]);
        }

        System.out.println("\nTop-Selling Estate Agent: " + agentNames[tAI]);

        // Close the scanner
        scanner.close();
    }
}
