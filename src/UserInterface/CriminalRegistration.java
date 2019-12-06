package UserInterface;

import BusinessLogic.Validator;
import BusinessLogic.Criminal;
import DatabaseConnection.CriminalDB;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class CriminalRegistration extends javax.swing.JFrame {
    DefaultListModel listModel=new DefaultListModel();
    
    public CriminalRegistration() {
        initComponents();
        setLocationRelativeTo(null);
        setClientID();
        list_nickName.setModel(listModel);
        txt_first_name.grabFocus();
    }

    private void setClientID() {
        CriminalDB cdb = new CriminalDB();
        long id = cdb.getNextID();
        if (id > 0) {
            txt_criminal_id.setText(id + "");
        } else {
            JOptionPane.showMessageDialog(null, "Error Accessing the ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txt_first_name, "First Name")) {
            return false;
        } else if (!v.isSelectedGender(rb_male, rb_female, "Gender")) {
            return false;
        } else if (!v.isPresent(txt_dob, "Date of Birth")) {
            return false;
        } else if (!v.isPresent(txt_nic, "NIC")) {
            return false;
        } else if (!v.isDate(txt_dob, "Date of Birth")) {
            return false;
        } else if (!v.isValidNic(txt_nic, "NIC No")) {
            return false;
        }
        return true;
    }

    private void clearFields() {
        txt_add_city.setText("");
        txt_add_no.setText("");
        txt_add_street.setText("");
        txt_criminal_id.setText(new CriminalDB().getNextID() + "");
        txt_first_name.setText("");
        txt_last_name.setText("");
        txt_middle_name.setText("");
        txt_nic.setText("");
        rb_male.setSelected(true);
        lbl_photo.setIcon(null);
        txt_first_name.grabFocus();
        txt_dob.setText("");
        listModel.removeAllElements();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_criminal_id = new javax.swing.JTextField();
        txt_first_name = new javax.swing.JTextField();
        txt_middle_name = new javax.swing.JTextField();
        txt_last_name = new javax.swing.JTextField();
        rb_male = new javax.swing.JRadioButton();
        rb_female = new javax.swing.JRadioButton();
        txt_nic = new javax.swing.JTextField();
        txt_add_no = new javax.swing.JTextField();
        txt_add_street = new javax.swing.JTextField();
        txt_add_city = new javax.swing.JTextField();
        lbl_photo = new javax.swing.JLabel();
        btn_browse = new javax.swing.JButton();
        btn_cam = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_dob = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_nickName = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_nickName = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Criminal ID:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("First Name*: ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Middle Name:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Last Name:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel6.setText("Name");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Gender*:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Date of Birth*:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("NIC*:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        jLabel13.setText("Address");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("No:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Street:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 290, 100));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("City:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 290, 110));

        txt_criminal_id.setEditable(false);
        txt_criminal_id.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_criminal_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 180, -1));
        jPanel2.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 180, -1));
        jPanel2.add(txt_middle_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 180, -1));
        jPanel2.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 180, -1));

        buttonGroup1.add(rb_male);
        rb_male.setText("Male");
        jPanel2.add(rb_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        buttonGroup1.add(rb_female);
        rb_female.setText("Female");
        jPanel2.add(rb_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        txt_nic.setToolTipText("Format:XXXXXXXXXV");
        jPanel2.add(txt_nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 180, -1));
        jPanel2.add(txt_add_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 180, -1));
        jPanel2.add(txt_add_street, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 180, -1));
        jPanel2.add(txt_add_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 180, -1));

        lbl_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        jPanel2.add(lbl_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 110, 120));

        btn_browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/upload_image.gif"))); // NOI18N
        btn_browse.setText("Browse");
        btn_browse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_browse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });
        jPanel2.add(btn_browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 80, 30));

        btn_cam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cam_icon.png"))); // NOI18N
        btn_cam.setText("Cam");
        btn_cam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_cam.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_camActionPerformed(evt);
            }
        });
        jPanel2.add(btn_cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 80, 30));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 90, 30));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/clear.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 90, 30));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/close.gif"))); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_exit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 370, 90, 30));

        jLabel18.setText("photograph");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, -1, -1));

        txt_dob.setToolTipText("Date format YYYY-MM-DD");
        jPanel2.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 180, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Nick Name:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, -1));
        jPanel2.add(txt_nickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 180, -1));

        btn_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/plus22.gif"))); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel2.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 90, 30));

        btn_remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/multiply34.gif"))); // NOI18N
        btn_remove.setText("Remove");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        jPanel2.add(btn_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 430, -1, -1));

        jScrollPane1.setViewportView(list_nickName);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 180, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 520, 510));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NEW CRIMINAL REGISTRATION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/handcuff.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        int option = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Exit?");
        if (option == JOptionPane.OK_OPTION) {
            this.dispose();
            new Home().setVisible(true);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (isValidForm()) {
            String firstName = txt_first_name.getText();
            String middleName = "";
            if (txt_middle_name.getText().length() > 0) {
                middleName = txt_middle_name.getText();
            }
            String lastName = "";
            if (txt_last_name.getText().length() > 0) {
                lastName = txt_last_name.getText();
            }
            String gender = "M";
            if (rb_female.isSelected()) {
                gender = "F";
            }
            Date dob = Date.valueOf(txt_dob.getText());
            String nic = txt_nic.getText();
            String addNo = "";
            if (txt_nic.getText().length() > 0) {
                addNo = txt_add_no.getText();
            }
            String addStreet = "";
            if (txt_add_street.getText().length() > 0) {
                addStreet = txt_add_street.getText();
            }
            String addCity = "";
            if (txt_add_city.getText().length() > 0) {
                addCity = txt_add_city.getText();
            }
            String photoPath = "";
            if (lbl_photo.getIcon() != null) {
                photoPath = "D:\\Assignments\\Final Project\\MugshotIdentificationSystem\\Criminal Original Photos\\" + "img+" + txt_criminal_id.getText() + ".jpg";
            }
            Criminal c = new Criminal(firstName, middleName, lastName, gender, dob, nic, addNo, addStreet, addCity, photoPath);
            
            ArrayList<Integer> resultArray=new ArrayList<>();
            if(list_nickName.getModel().getSize()!=0){                  
                  for(int i=0;i<list_nickName.getModel().getSize();i++){
                     String nickName=(String)listModel.getElementAt(i);
                     int result=new CriminalDB().addNickName(Integer.parseInt(txt_criminal_id.getText()), nickName);
                     resultArray.add(result);
                  }                                   
            }
            int result = new CriminalDB().addData(c);
            int result2=1;
            for(int i:resultArray){
                if(i==0){
                   result2=0;
                }
            }
            if (result == 1 && result2==1) {
                JOptionPane.showMessageDialog(btn_save, "New Criminal added successfully");
                clearFields();
            } else if (result == 0) {
                JOptionPane.showMessageDialog(btn_save, "Some Error Occurred.New Criminal was not added");
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        File f = fc.getSelectedFile();
        if (f != null) {
            String path = f.getAbsolutePath();
            lbl_photo.setIcon(new ImageIcon(path));
        }
    }//GEN-LAST:event_btn_browseActionPerformed

    private void btn_camActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_camActionPerformed
        new newWebCamOpenCV().setVisible(true);
    }//GEN-LAST:event_btn_camActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        if(!txt_nickName.getText().equals("")){
            listModel.addElement(txt_nickName.getText());
            txt_nickName.setText("");
        }
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        if(!txt_nickName.getText().equals("")){
            listModel.removeElement(txt_nickName.getText());
        }
    }//GEN-LAST:event_btn_removeActionPerformed

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
            java.util.logging.Logger.getLogger(CriminalRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CriminalRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CriminalRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CriminalRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CriminalRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_cam;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_save;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbl_photo;
    private javax.swing.JList list_nickName;
    private javax.swing.JRadioButton rb_female;
    private javax.swing.JRadioButton rb_male;
    private javax.swing.JTextField txt_add_city;
    private javax.swing.JTextField txt_add_no;
    private javax.swing.JTextField txt_add_street;
    public static javax.swing.JTextField txt_criminal_id;
    private javax.swing.JTextField txt_dob;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_middle_name;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JTextField txt_nickName;
    // End of variables declaration//GEN-END:variables
}
