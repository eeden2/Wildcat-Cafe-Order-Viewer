/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.orderviewer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class orderDetails extends javax.swing.JFrame {

    public int identifier;
    public Connection databaseConnection;
    /**
     * Creates new form orderDetails
     */
    public orderDetails()
    {
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


    }

    public void setIdentifier(int i) {identifier = i;
        initComponents();}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Statement s = null;
        try{
            s = databaseConnection.createStatement();
        }catch(Exception e){e.printStackTrace();}

        staticTitle = new javax.swing.JLabel();
        orderNumber = new javax.swing.JLabel();
        coffeeNumber = new javax.swing.JLabel();
        coffeeCreamerType = new javax.swing.JLabel();
        cocoaNumber = new javax.swing.JLabel();
        danishNumber = new javax.swing.JLabel();
        danishType = new javax.swing.JLabel();
        muffinNumber = new javax.swing.JLabel();
        muffinType = new javax.swing.JLabel();
        barNumber = new javax.swing.JLabel();
        roomNumber = new javax.swing.JLabel();
        deliveryDay = new javax.swing.JLabel();
        completeOrder = new javax.swing.JButton();
        moneyTotal = new javax.swing.JLabel();
        orderSpecifications = new javax.swing.JLabel();
        detailsTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        staticTitle.setFont(new java.awt.Font("Roboto", 0, 36)); // NOI18N
        staticTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        staticTitle.setText("Order Details");
        ResultSet rs = null;
        try{
            System.out.println(identifier);
            rs = s.executeQuery("SELECT * FROM orders WHERE identifier = "+identifier+";");
            if(rs.next())
            {
                orderNumber.setText("Order #: "+rs.getInt("identifier"));
                orderNumber.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                orderNumber.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

                coffeeNumber.setText("# of Coffee's:"+rs.getString("coffeeamount"));

                coffeeCreamerType.setText("Coffee Creamer: "+rs.getString("coffeecreamer"));

                cocoaNumber.setText("# of Cocoa: "+rs.getString("cocoa"));

                danishNumber.setText("# of Danishes: "+rs.getString("danish"));

                danishType.setText("Danish Type: "+rs.getString("danishflavor"));

                muffinNumber.setText("# of Muffins: "+rs.getString("muffin"));

                muffinType.setText("Muffin Type:"+rs.getString("muffinflavor"));

                barNumber.setText("# of Nature Valley Bars: "+rs.getString("bar"));

                roomNumber.setText("Room #: "+rs.getString("room"));

                deliveryDay.setText("Delivery Day: "+rs.getString("date"));

                completeOrder.setText("Complete this Order");

                moneyTotal.setText("Total: " + rs.getString("total"));

                detailsTitle.setText("Order Details");

                orderSpecifications.setText(rs.getString("specifications"));
                orderSpecifications.setVerticalAlignment(javax.swing.SwingConstants.TOP);

            }



        }catch(Exception e){e.printStackTrace();}
        completeOrder.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    Statement s = databaseConnection.createStatement();
                    s.executeUpdate("INSERT INTO completedorders SELECT * FROM orders WHERE identifier = "+identifier+";");
                    s.executeUpdate("DELETE FROM orders WHERE identifier = "+identifier+";");
                    dispose();
                }catch(Exception i){i.printStackTrace();}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(completeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(orderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(coffeeCreamerType, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(cocoaNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(detailsTitle))
                                                        .addComponent(coffeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(84, 84, 84))
                                        .addComponent(staticTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(danishNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(barNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(danishType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(muffinType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(muffinNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(45, 45, 45)
                                                .addComponent(orderSpecifications, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(roomNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deliveryDay, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(moneyTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(staticTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(roomNumber))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deliveryDay)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(moneyTotal)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(orderNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(coffeeNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(coffeeCreamerType)
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cocoaNumber)
                                                        .addComponent(detailsTitle))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(danishNumber)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(danishType)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(muffinNumber)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(muffinType)
                                                                .addGap(0, 70, Short.MAX_VALUE))
                                                        .addComponent(orderSpecifications, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(barNumber)
                                                        .addComponent(completeOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(orderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barNumber;
    private javax.swing.JLabel cocoaNumber;
    private javax.swing.JLabel coffeeCreamerType;
    private javax.swing.JLabel coffeeNumber;
    private javax.swing.JButton completeOrder;
    private javax.swing.JLabel danishNumber;
    private javax.swing.JLabel danishType;
    private javax.swing.JLabel deliveryDay;
    private javax.swing.JLabel detailsTitle;
    private javax.swing.JLabel moneyTotal;
    private javax.swing.JLabel muffinNumber;
    private javax.swing.JLabel muffinType;
    private javax.swing.JLabel orderNumber;
    private javax.swing.JLabel orderSpecifications;
    private javax.swing.JLabel roomNumber;
    private javax.swing.JLabel staticTitle;
    // End of variables declaration//GEN-END:variables
}
