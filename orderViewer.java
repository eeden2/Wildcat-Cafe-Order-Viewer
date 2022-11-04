/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.orderviewer;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author eason
 */


public class orderViewer extends javax.swing.JFrame {

    public Connection databaseConnection;

    public orderViewer() {

        Connection c = null;
        //Data type statement actually feeds the statement into the postGre server;
        Statement s = null;
        try {
            //First setup a connection to the database
            c = DriverManager
                    .getConnection("jdbc:postgresql://10.2.33.178:5432/wildcatcafe",
                            "postgres", "1234");
            //Instantiates a statement input
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        databaseConnection = c;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        borderLayout1 = new java.awt.BorderLayout();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        completeOrder = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        refreshList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        try{
            Statement s = databaseConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM orders;");
            rs.last();
            int rows = rs.getRow();
            rs.first();
            String[][] dataSet = new String[rows][4];
            int iterator = 0;
            while(rs.next())
            {
                dataSet[iterator][0] = rs.getString("room");
                dataSet[iterator][1] = rs.getString("date");
                dataSet[iterator][2] = rs.getString("total");
                dataSet[iterator][3] = rs.getString("identifier");
                iterator++;
            }

            orderTable.setModel(new javax.swing.table.DefaultTableModel(
                    dataSet ,
                    new String [] {
                             "Room", "Deliver", "Total", "Identifier"
                    }
            ) {
                Class[] types = new Class [] {
                        java.lang.String.class, java.lang.Short.class, java.lang.String.class, java.lang.Short.class, java.lang.Integer.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });




        }catch(Exception e)
        {
            e.printStackTrace();

            orderTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null},
                            {null, null, null, null, null}
                    },
                    new String [] {
                            "Date", "Room", "Deliver", "Total", "Identifier"
                    }
            ) {
                Class[] types = new Class [] {
                        java.lang.String.class, java.lang.Short.class, java.lang.String.class, java.lang.Short.class, java.lang.Integer.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });

        }


        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 832;
        gridBagConstraints.ipady = 436;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 6);
        getContentPane().add(jScrollPane1, gridBagConstraints);

        completeOrder.setText("Complete Selected Order");
        completeOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeOrderActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 71;
        gridBagConstraints.ipady = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 47, 15, 6);
        getContentPane().add(completeOrder, gridBagConstraints);

        printButton.setText("Print Total Amount");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 104;
        gridBagConstraints.ipady = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 53, 15, 0);
        getContentPane().add(printButton, gridBagConstraints);

        refreshList.setText("Refresh Order List");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 107;
        gridBagConstraints.ipady = 74;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 15, 0);
        getContentPane().add(refreshList, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void completeOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_completeOrderActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        int row = orderTable.getSelectedRow();
        int identifier = Integer.parseInt((String) orderTable.getValueAt(row, 4));
        //orderDetails od = new orderDetails();

    }//GEN-LAST:event_orderTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(orderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.BorderLayout borderLayout1;
    private javax.swing.JButton completeOrder;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable orderTable;
    private javax.swing.JButton printButton;
    private javax.swing.JButton refreshList;
    // End of variables declaration//GEN-END:variables
}
