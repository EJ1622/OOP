
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;


public class DailySalesCalculator extends JFrame {
    private JTextField phoneNameField, phonePriceField, phoneQuantityField;
    private JTextField repairNameField, repairPriceField, repairHoursField;
    private JLabel phoneTotalLabel, repairTotalLabel;
    
    public DailySalesCalculator() {
        setTitle("Daily Sales Calculator");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10)); // Improved Layout
        
        // Phone Sales Section
        add(new JLabel("Phone Sales:"));
        JPanel phonePanel = new JPanel(new GridLayout(3, 2));
        phonePanel.add(new JLabel("Item Name:"));
        phoneNameField = new JTextField();
        
        phonePanel.add(phoneNameField);
        phonePanel.add(new JLabel("Price (PHP):"));
        phonePriceField = new JTextField();
        
        phonePanel.add(phonePriceField);
        phonePanel.add(new JLabel("Quantity Sold:"));
        phoneQuantityField = new JTextField();
        
        phonePanel.add(phoneQuantityField);
        add(phonePanel);
        
        // Repair Service Section
        add(new JLabel("Repair Service:"));
        JPanel repairPanel = new JPanel(new GridLayout(3, 2));
        repairPanel.add(new JLabel("Item Name:"));
        repairNameField = new JTextField();
        
        repairPanel.add(repairNameField);
        repairPanel.add(new JLabel("Price per hour (PHP):"));
        repairPriceField = new JTextField();
        
        repairPanel.add(repairPriceField);
        repairPanel.add(new JLabel("Hours;"));
        repairHoursField = new JTextField();
        
        repairPanel.add(repairHoursField);
        add(repairPanel);
        
        // Calculate and Display Button
        JButton calculateButton = new JButton("Calculate Sales");
        
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                calculateAndDisplaySales();
            }
        });
        add(calculateButton);
        
        // Total Sales Labels
        phoneTotalLabel = new JLabel();
        repairTotalLabel = new JLabel();
        add(phoneTotalLabel);
        add(repairTotalLabel);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void calculateAndDisplaySales() {
        try {
            // Phone sales calculation
            String phoneName = phoneNameField.getText();
            double phonePrice = Double.parseDouble(phonePriceField.getText());
            int phoneQuantity = Integer.parseInt(phoneQuantityField.getText());
            Phone phone = new Phone(phoneName, phonePrice, phoneQuantity);
            double phoneTotalSales = phone.calculateTotalSales();
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("fil", "PH"));
            
            phoneTotalLabel.setText("Phone Total Sales: " + currencyFormatter.format(phoneTotalSales));
            
            // Repair service calculation
            String repairName = repairNameField.getText();
            double repairPrice = Double.parseDouble(repairPriceField.getText());
            double repairHours = Double.parseDouble(repairHoursField.getText());
            RepairService repair = new RepairService(repairName, repairPrice, repairHours);
            double repairTotalSales = repair.calculateTotalSales();
            
            repairTotalLabel.setText("Repair Total Sales: " + currencyFormatter.format(repairTotalSales));
        } catch (NumberFormatException ex) {
            
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numbers only.");
        }
    }
    
    public static void main (String[] args) {
        new DailySalesCalculator();
    }    
}
