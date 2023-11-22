/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estateagentgui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author nicholasphillips
 */
public class EstateAgentGUI extends JFrame {
    
    private JComboBox<String> lCB; // lCB= location combo box
    private JTextField aNF, pF, cF;// aNF = agent name field, pF= price field, cF= commission field
    private JTextArea rTA; // rTA = report text area
    private IEstateAgent estateAgent;
    
    
    public EstateAgentGUI(){
        // main frame
        super("Estate Agent GUI");
      
        
        estateAgent = new EstateAgent(); // creating an instance of the estate agent class
        
        // creating panels
        JPanel iP = createInputPanel();// iP= input panel
        JPanel rP =createReportPanel();// rP = report panel
        
        // layout
        setLayout( new BorderLayout());
        add(iP, BorderLayout.NORTH);
        add(rP,BorderLayout.CENTER);
        
        // menu 
        JMenuBar menu = new JMenuBar();
        setJMenuBar(menu);
        
        //file menu
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        file.add(exit);
        
        // tools
        JMenu tools = new JMenu("Tools");
        JMenuItem pRI = new JMenuItem("Print Process Report");//pRI = print report item
        pRI.addActionListener((ActionEvent e) -> {
            printProcessReport();
        });
        // clear fields feature
        JMenuItem cFI = new JMenuItem("Clear Fields"); // cFI = clear fileds item
        cFI.addActionListener((ActionEvent e) -> {
            clearFields();
        });
        //save report feature
        JMenuItem sRI = new JMenuItem("Save Report"); //sRI = save report item
        sRI.addActionListener((ActionEvent e) -> {
            saveReportToFile();
        });
        
        tools.add(pRI);
        tools.add(cFI);
        tools.add(sRI);
        
        //add menus to the menu bar
        JMenuBar bar = new JMenuBar();
        setJMenuBar(bar);
        bar.add(file);
        bar.add(tools);
        
        // visibility set to true to view the GUI
        setVisible(true);    
    }
        
    // panel for the GUI
    private JPanel createInputPanel(){
        JPanel inputPanel = new JPanel(new GridLayout(4,2,5,5));
        
        // estate agent location combobox, location of the agent
        JLabel location = new JLabel ("Estate Agent Location: ");
        String[] locations = {"Cape Town", "Durban", "Pretoria"};
        lCB = new JComboBox<>(locations);
        
        // agent's name
        JLabel agentName = new JLabel("Estate Agent Name: ");
        aNF = new JTextField();
        
        //price of the property
        JLabel price = new JLabel("Property Price: ");
        pF = new JTextField();
        
        // commisson percentage for the calculation
        JLabel commission = new JLabel("Commission Percentage: ");
        cF = new JTextField();
        
        inputPanel.add(location);
        inputPanel.add(lCB);
        inputPanel.add(agentName);
        inputPanel.add(aNF);
        inputPanel.add(price);
        inputPanel.add(pF);
        inputPanel.add(commission);
        inputPanel.add(cF);
        
        return inputPanel;
    }
    // second panel that displays the calculated and inputted inforamation
    private JPanel createReportPanel(){
        JPanel reportPanel = new JPanel(new BorderLayout());
        JLabel reportLabel = new JLabel("Agent Report: ");
        rTA = new JTextArea();
        rTA.setEditable(false);
        
        JScrollPane scroll = new JScrollPane(rTA);
        reportPanel.add(reportLabel, BorderLayout.NORTH);
        reportPanel.add(scroll, BorderLayout.CENTER);
        
        return reportPanel;
    }
    // function that prints the calculated and inputted information
    private void printProcessReport(){
        String agentName= aNF.getText();
        String location = (String) lCB.getSelectedItem();
        
        String priceStr = pF.getText().replaceAll("[^\\d.]","");
        String commissionStr = cF.getText().replaceAll("[^\\d.]","");
        
        double price = Double.parseDouble(priceStr);
        double commission= Double.parseDouble(commissionStr);
        
        double tC = (commission/100)* price;
        
        rTA.setText("Agent Name:"+ agentName+
                "\n"+ "Location: " + location +
                "\n"+ "Property Price:R "+ price+
                "\n"+ "Commission Percentage" + commission+
                "%\n"+ "Total Commission: R"+ tC);
        System.out.println(rTA.getText());
    }
    // feature that removes all inputted information
    private void clearFields(){
        aNF.setText("");
        pF.setText("");
        cF.setText("");
        rTA.setText("");
        lCB.setSelectedIndex(0);
    }
    // feature the saves the report to the file report.txt.
    private void saveReportToFile(){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))){
            writer.write(rTA.getText());
            writer.flush();
            JOptionPane.showInternalMessageDialog(null, "Report save to report.txt.");
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving report: "+
                    e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
        } 
        }
}
   