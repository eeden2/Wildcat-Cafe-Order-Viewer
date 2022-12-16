/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.orderviewer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author mrglade
 */
public class searchItem extends javax.swing.JFrame {

    public Connection databaseConnection;
    public searchItem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        instructionsText = new javax.swing.JLabel();
        exampleText = new javax.swing.JLabel();
        formatText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputText = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        instructionsText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        instructionsText.setText("Enter the dates that you would like to collect the total amount of money for.");
        instructionsText.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        exampleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exampleText.setText("E.g. (11/2/2022,10/2/2022,2/3/2023)");

        formatText.setText("Format: (mm/dd/yyyy)");

        inputText.setColumns(20);
        inputText.setRows(5);
        jScrollPane1.setViewportView(inputText);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(formatText)
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(exampleText, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(instructionsText, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instructionsText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exampleText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Connection c = null;
        //Data type statement actually feeds the statement into the postGre server;
        Statement s = null;
        String box = inputText.getText();
        String[] eachInput = box.split(",");
        String[][] fullInput = new String[eachInput.length][3];
        for(int i = 0;i< eachInput.length;i++)
        {
            String[] top = eachInput[i].split("/");
            for(int x = 0;x<3;x++)
            {
                fullInput[i][x] = top[x];
            }
        }

        String state = "SELECT total, month, day, year FROM completedorders WHERE";



        try {
            //First setup a connection to the database
            c = DriverManager
                    .getConnection("jdbc:postgresql://10.2.33.178:5432/wildcatcafe",
                            "postgres", "1234");
            //Instantiates a statement input
            s = c.createStatement();

            ResultSet moneyData;
            Double individualDayTotal = 0.0;
            Object[] actualMoney = new Object[eachInput.length + 1];
            int moneyIterator = 0;
            Double total = 0.0;

            for(String[] str : fullInput)
            {
                moneyData = s.executeQuery("SELECT total FROM completedorders WHERE month = '"+str[0] + "' AND day = '" + str[1] + "' AND year = '"+ str[2] + "';");
                individualDayTotal = 0.0;
                while(moneyData.next())
                {
                    individualDayTotal += moneyData.getDouble("total");
                }
                actualMoney[moneyIterator] = (Object) individualDayTotal;
                total+=individualDayTotal;
                moneyIterator++;


            }
            actualMoney[actualMoney.length-1] = (Object) total;


            // workbook object
            XSSFWorkbook workbook = new XSSFWorkbook();

            // spreadsheet object
            XSSFSheet spreadsheet = workbook.createSheet(" Profit Sheet ");

            // creating a row object
            XSSFRow row;

            Map<String,Object[]> data = new TreeMap<>();
            Object[] length = new Object[eachInput.length + 1];


            for(int i = 0; i<length.length-1;i++)
            {
                length[i] = eachInput[i];
            }



            length[length.length-1] = (Object) "Total";
            data.put("1", length);
            data.put("2",actualMoney);



            int rowid = 0;

            // writing the data into the sheets...

            for (String key : data.keySet()) {

                row = spreadsheet.createRow(rowid++);
                Object[] objectArr = data.get(key);
                int cellid = 0;

                for (Object obj : objectArr) {
                    Cell cell = row.createCell(cellid++);
                    cell.setCellValue((obj.toString()));
                }
            }

            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if(option == JFileChooser.APPROVE_OPTION) {
                String file = fileChooser.getSelectedFile().getAbsolutePath();
                if(file.indexOf(".xlsx")==-1) file+=".xlsx";

                // .xlsx is the format for Excel Sheets...
                // writing the workbook into the file...
                FileOutputStream out = new FileOutputStream(
                        new File(file));

                workbook.write(out);
                instructionsText.setText("Your File has been written to your Save Location");
                exampleText.setText("");
                formatText.setText("If your Data was in the Proper Format");
            }
            else
            {
                FileOutputStream out = new FileOutputStream(
                    new File("~/"));
                workbook.write(out);
                instructionsText.setText("Your File has been written.");}





        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        databaseConnection = c;






    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel exampleText;
    private javax.swing.JLabel formatText;
    private javax.swing.JTextArea inputText;
    private javax.swing.JLabel instructionsText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
