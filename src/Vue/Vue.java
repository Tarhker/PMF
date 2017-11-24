package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import Controlleur.Controlleur;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Vue extends JFrame{

	 Controlleur mycontrolleur;

	    public Vue(Controlleur controlleur) {
	        mycontrolleur = controlleur;
	        initComponents();
	        
	    }

	    
	    private void initComponents() {

	        plusconsigne = new javax.swing.JButton();
	        moinsconsigne = new javax.swing.JButton();
	        jLabel1 = new javax.swing.JLabel();
	        jLabel2 = new javax.swing.JLabel();
	        jLabel3 = new javax.swing.JLabel();
	        tempValue = new javax.swing.JLabel();
	        humidityValue = new javax.swing.JLabel();
	        consigne = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        plusconsigne.setText("+");
	        plusconsigne.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                plusconsigneActionPerformed(evt);
	            }
	        });

	        moinsconsigne.setText("-");
	        moinsconsigne.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                moinsconsigneActionPerformed(evt);
	            }
	        });

	        jLabel1.setText("Humidité en % :");

	        jLabel2.setText("Température en °C : ");

	        jLabel3.setText("Température de consigne :");

	        tempValue.setText("0 °C");

	        humidityValue.setText("0 %");

	        consigne.setText("10 °C");

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        layout.setHorizontalGroup(
	        	layout.createParallelGroup(Alignment.LEADING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGap(58)
	        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        				.addGroup(layout.createSequentialGroup()
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
	        						.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        						.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
	        					.addPreferredGap(ComponentPlacement.RELATED)
	        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
	        						.addComponent(tempValue)
	        						.addComponent(humidityValue)))
	        				.addGroup(layout.createSequentialGroup()
	        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
	        						.addGroup(layout.createSequentialGroup()
	        							.addComponent(plusconsigne)
	        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	        							.addComponent(moinsconsigne))
	        						.addComponent(jLabel3, Alignment.LEADING))
	        					.addGap(18)
	        					.addComponent(consigne)))
	        			.addContainerGap(35, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	        	layout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(layout.createSequentialGroup()
	        			.addGap(46)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(tempValue))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(humidityValue))
	        			.addPreferredGap(ComponentPlacement.RELATED)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(consigne))
	        			.addGap(30)
	        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(plusconsigne)
	        				.addComponent(moinsconsigne))
	        			.addContainerGap(33, Short.MAX_VALUE))
	        );
	        getContentPane().setLayout(layout);

	        pack();
	    }// </editor-fold>//GEN-END:initComponents

	    private void plusconsigneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusconsigneActionPerformed
	        // TODO add your handling code here:
	        
	       mycontrolleur.plusConsigne(consigne.getText());
	      // oldTemp[0]
	    }//GEN-LAST:event_plusconsigneActionPerformed

	    private void moinsconsigneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moinsconsigneActionPerformed
	        // TODO add your handling code here:
	        mycontrolleur.moinsConsigne(consigne.getText());
	    }//GEN-LAST:event_moinsconsigneActionPerformed

	    /**
	     * @param args the command line arguments
	     */

	    public javax.swing.JLabel getHumidityValue() {
	        return humidityValue;
	    }

	    public void setHumidityValue(double newValue) {
	        this.humidityValue.setText(newValue+" %");
	    }

	    public javax.swing.JLabel getTempValue() {
	        return tempValue;
	    }

	    public void setTempValue(double newValue) {
	        tempValue.setText(newValue+" °C");
	    }
	    

	    // Variables declaration - do not modify//GEN-BEGIN:variables
	    private javax.swing.JLabel consigne;
	    private javax.swing.JLabel humidityValue;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JButton moinsconsigne;
	    private javax.swing.JButton plusconsigne;
	    private javax.swing.JLabel tempValue;
	    // End of variables declaration//GEN-END:variables

	    public javax.swing.JLabel getConsigne() {
	        return consigne;
	    }

	    public void setConsigne(double newConsigne) {
	        consigne.setText(newConsigne + " °C");
	}
}
