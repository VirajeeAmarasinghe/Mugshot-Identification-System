package UserInterface;

import BusinessLogic.Offense;
import BusinessLogic.Validator;
import DatabaseConnection.CriminalDB;
import DatabaseConnection.OffenseDB;
import DatabaseConnection.OffenseTypeDB;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class NewOffenseRecord extends javax.swing.JFrame {

    DefaultListModel listModel = new DefaultListModel();
    CriminalDB c = new CriminalDB();

    public NewOffenseRecord() {
        initComponents();
        setOffenseID();
        txtAr_description.grabFocus();
        setLocationRelativeTo(null);
        list_criminalIDs.setModel(listModel);
        loadCriminalNames();
        loadOffenseTypes();
    }

    private void setOffenseID() {
        OffenseDB cdb = new OffenseDB();
        long id = cdb.getNextID();
        if (id > 0) {
            txt_offenseID.setText(id + "");
        } else {
            JOptionPane.showMessageDialog(null, "Error Accessing the ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadOffenseTypes() {
        Vector v = new OffenseTypeDB().getAllOffenseTypes();
        combo_type.setModel(new DefaultComboBoxModel(v));
    }

    private void loadCriminalNames() {
        ArrayList<Integer> ids = c.getAllCriminalIDS();
        for (int id : ids) {
            listModel.addElement(id);
        }
    }

    private boolean isValidForm() {
        Validator v = new Validator();
        if (!v.isPresent(txtAr_description, "Offense Description")) {
            return false;
        } else if (!v.isPresent(txt_date, "Offense Date")) {
            return false;
        } else if (combo_hr.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Hour should be selected!!!!");
            return false;
        } else if (combo_min.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Hour should be selected!!!!");
            return false;
        } else if (list_criminalIDs.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "Criminal should be selected");
            return false;
        } else if (!v.isDate(txt_date, "Offense Date")) {
            return false;
        }
        return true;
    }

    private void clearFields() {
        setOffenseID();
        list_criminalIDs.setSelectedIndex(0);
        txtAr_description.setText("");
        txt_date.setText("");
        combo_hr.setSelectedIndex(0);
        combo_min.setSelectedIndex(0);
        combo_type.setSelectedIndex(0);
        list_criminalIDs.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAr_description = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        combo_hr = new javax.swing.JComboBox();
        combo_min = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        combo_type = new javax.swing.JComboBox();
        btn_save = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        txt_offenseID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_criminalIDs = new javax.swing.JList();
        txt_date = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Offense ID: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Criminal(s) ID(s):");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Description:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Date:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtAr_description.setColumns(20);
        txtAr_description.setRows(5);
        jScrollPane2.setViewportView(txtAr_description);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 320, 130));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Time:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, -1, -1));

        combo_hr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hour", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        combo_hr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_hrActionPerformed(evt);
            }
        });
        jPanel2.add(combo_hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, -1, -1));

        combo_min.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Min", "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        jPanel2.add(combo_min, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 60, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Offense Type:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jPanel2.add(combo_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 140, -1));

        btn_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save.png"))); // NOI18N
        btn_save.setText("Save");
        btn_save.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel2.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 90, 30));

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/clear.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel2.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 90, 30));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/close.gif"))); // NOI18N
        btn_exit.setText("Exit");
        btn_exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 90, 30));

        txt_offenseID.setEditable(false);
        txt_offenseID.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_offenseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 200, -1));

        jScrollPane1.setViewportView(list_criminalIDs);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 200, 30));

        txt_date.setToolTipText("Date Format YYYY-MM-DD");
        jPanel2.add(txt_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 480, 410));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NEW OFFENSE RECORD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo_hrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_hrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_hrActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFields();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        try {
            if (isValidForm()) {
                ArrayList<Integer> ids = (ArrayList<Integer>) list_criminalIDs.getSelectedValuesList();
                ArrayList<Integer> resultArray = new ArrayList<>();

                for (int id : ids) {
                    int criminalId = id;
                    int offenseId = Integer.parseInt(txt_offenseID.getText());
                    int result0 = new OffenseDB().addOffenseIDCriminalIDs(offenseId, criminalId);
                    resultArray.add(result0);
                }
                String offenseDes = txtAr_description.getText();

                String offenseDate = txt_date.getText();
                String hr = (String) combo_hr.getSelectedItem();
                String min = (String) combo_min.getSelectedItem();
                String DateTime = offenseDate + " " + hr + ":" + min + ":00";
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date fullDate = sdf.parse(DateTime);
                Timestamp date = new Timestamp(fullDate.getTime());

                int typeiID = new OffenseTypeDB().getTypeIdAccordingToType(String.valueOf(combo_type.getSelectedItem()));
                Offense o = new Offense(offenseDes, date, typeiID);
                int result1 = new OffenseDB().addOffense(o);

                int result2 = 1;
                for (int i : resultArray) {
                    if (i == 0) {
                        result2 = 0;
                    }
                }

                if (result1 == 1 && result2 == 1) {
                    JOptionPane.showMessageDialog(btn_save, "New Offense added successfully");
                    clearFields();
                } else if (result1 == 0) {
                    JOptionPane.showMessageDialog(btn_save, "Some Error Occurred.New Offense was not added");
                }
            }
        } catch (NumberFormatException | ParseException | SQLException e) {
            JOptionPane.showMessageDialog(btn_save, "Some Error Occurred.New Offense was not added", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btn_saveActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewOffenseRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NewOffenseRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox combo_hr;
    private javax.swing.JComboBox combo_min;
    private javax.swing.JComboBox combo_type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList list_criminalIDs;
    private javax.swing.JTextArea txtAr_description;
    private javax.swing.JTextField txt_date;
    private javax.swing.JTextField txt_offenseID;
    // End of variables declaration//GEN-END:variables
}
