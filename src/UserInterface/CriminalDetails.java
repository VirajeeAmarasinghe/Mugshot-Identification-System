package UserInterface;

import BusinessLogic.Criminal;
import DatabaseConnection.CriminalDB;
import javax.swing.ImageIcon;


public class CriminalDetails extends javax.swing.JFrame {

    
    public CriminalDetails() {
        initComponents();
        setValues();
        setLocationRelativeTo(null);
    }

    private void setValues(){
        Criminal c=new Criminal();       
        c=new CriminalDB().getCriminalDetailsAccordingToID(SearchOriginalPhoto.highestPercentageID);
        txt_criminalID.setText(c.getCriminal_id()+"");
        txt_criminal_name.setText(c.getFirst_name()+" "+c.getMiddle_name()+" "+c.getLast_name());
        txt_gender.setText(c.getGender());
        txt_dateOfBirth.setText(c.getDob().toString());
        txt_nic.setText(c.getNic());
        txt_no.setText(c.getAddNo());
        txt_street.setText(c.getAddStreet());
        txt_city.setText(c.getAddCity());
        String imagePath="D:\\Assignments\\Final Project\\MugshotIdentificationSystem\\Criminal Original Photos\\"+"img+"+c.getCriminal_id()+".jpg";
        lb_original_photo.setIcon(new ImageIcon(imagePath));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_criminalID = new javax.swing.JTextField();
        txt_criminal_name = new javax.swing.JTextField();
        txt_gender = new javax.swing.JTextField();
        txt_dateOfBirth = new javax.swing.JTextField();
        txt_nic = new javax.swing.JTextField();
        txt_no = new javax.swing.JTextField();
        txt_street = new javax.swing.JTextField();
        txt_city = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lb_original_photo = new javax.swing.JLabel();
        btn_viewHistory = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Criminal ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Criminal Name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Gender:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Date Of Birth:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("NIC:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel6.setText("Address");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("No:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Street:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("City:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        txt_criminalID.setEditable(false);
        txt_criminalID.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_criminalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 170, -1));

        txt_criminal_name.setEditable(false);
        txt_criminal_name.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_criminal_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 170, -1));

        txt_gender.setEditable(false);
        txt_gender.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 170, -1));

        txt_dateOfBirth.setEditable(false);
        txt_dateOfBirth.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_dateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 170, -1));

        txt_nic.setEditable(false);
        txt_nic.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 170, -1));

        txt_no.setEditable(false);
        txt_no.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 170, -1));

        txt_street.setEditable(false);
        txt_street.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_street, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 170, -1));

        txt_city.setEditable(false);
        txt_city.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 170, -1));

        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 290, 100));

        lb_original_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jPanel2.add(lb_original_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 300, 440));

        btn_viewHistory.setText("View Offense History");
        btn_viewHistory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_viewHistory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_viewHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewHistoryActionPerformed(evt);
            }
        });
        jPanel2.add(btn_viewHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        btn_exit.setText("Exit");
        btn_exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 120, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_viewHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewHistoryActionPerformed
        new OffenseHistory().setVisible(true);
    }//GEN-LAST:event_btn_viewHistoryActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    
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
            java.util.logging.Logger.getLogger(CriminalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriminalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriminalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriminalDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriminalDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_viewHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_original_photo;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_criminalID;
    private javax.swing.JTextField txt_criminal_name;
    private javax.swing.JTextField txt_dateOfBirth;
    private javax.swing.JTextField txt_gender;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JTextField txt_no;
    private javax.swing.JTextField txt_street;
    // End of variables declaration//GEN-END:variables
}
