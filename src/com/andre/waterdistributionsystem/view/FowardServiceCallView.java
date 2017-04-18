
package com.andre.waterdistributionsystem.view;
import com.andre.waterdistributionsystem.model.MailSender;
import com.andre.waterdistributionsystem.controller.ServiceCallDAO;
import com.andre.waterdistributionsystem.dao.DataSource;
import javax.swing.JOptionPane;
/**
 * @author Andre Luis Sabino
 * @version 1.3
 * @since 12/04/2017
 */
public class FowardServiceCallView extends javax.swing.JFrame {
    /**
     * Creates new form FowardServiceCall
     */
    public FowardServiceCallView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        closeButton = new javax.swing.JButton();
        fowardServiceCallButton = new javax.swing.JButton();
        serviceCallNumberLabel = new javax.swing.JLabel();
        serviceCallNumberTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        descriptionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        closeButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        closeButton.setText("Sair");
        closeButton.setToolTipText("");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        fowardServiceCallButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        fowardServiceCallButton.setText("Encaminhar Chamado");
        fowardServiceCallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fowardServiceCallButtonActionPerformed(evt);
            }
        });

        serviceCallNumberLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        serviceCallNumberLabel.setText("Digite o número do caso: ");

        serviceCallNumberTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        descriptionLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        descriptionLabel.setText("Descrisão: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(serviceCallNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(serviceCallNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fowardServiceCallButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serviceCallNumberLabel)
                    .addComponent(serviceCallNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descriptionLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fowardServiceCallButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /* Implementação da ação do botão, o mesmo deve enviar um e-mail com os dados do formulario, 
    verificar para qual equipe mandar o e-mail e realizar update no status do chamado
    */
    private void fowardServiceCallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fowardServiceCallButtonActionPerformed
        try {
        DataSource dataSource = new DataSource();
        ServiceCallDAO controlDao = new ServiceCallDAO(dataSource);
        int id = Integer.parseInt(serviceCallNumberTextField.getText());
        controlDao.updateStatus(id);
        String teamMail = controlDao.teamMailSelector(id);
        String mailSubject = controlDao.mailSubject(id);
        String mailDescription = descriptionTextArea.getText();
        MailSender sendService = new MailSender(teamMail,mailSubject, mailDescription);
            
        } catch (NumberFormatException numex) {
            JOptionPane.showMessageDialog(null, "Preencha o campo com o valor númerico referente ao chamado");
        }
        
        
    }//GEN-LAST:event_fowardServiceCallButtonActionPerformed
    /* Implementação da ação do botão, deve apenas fechar a tela */
    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
          setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FowardServiceCallView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FowardServiceCallView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FowardServiceCallView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FowardServiceCallView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FowardServiceCallView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JButton fowardServiceCallButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel serviceCallNumberLabel;
    private javax.swing.JTextField serviceCallNumberTextField;
    // End of variables declaration//GEN-END:variables
}
