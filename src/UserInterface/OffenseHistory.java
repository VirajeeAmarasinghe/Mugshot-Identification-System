package UserInterface;

import BusinessLogic.Offense;
import DatabaseConnection.OffenseDB;
import DatabaseConnection.OffenseTypeDB;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class OffenseHistory extends javax.swing.JFrame {

    private ArrayList<Offense> offenseArray=null;
    private DefaultTableModel dtm=null;
    private OffenseDB odb=null;
    
    public OffenseHistory() {
        initComponents();
        setLocationRelativeTo(null);
        offenseArray=new ArrayList<>();
        dtm = new DefaultTableModel();
        tbl_offense.setModel(dtm);
        dtm.addColumn("Offense ID");
        dtm.addColumn("Description");
        dtm.addColumn("Date & Time");
        dtm.addColumn("Type");
        odb=new OffenseDB();
        displayData();
        txt_criminalID.setText(SearchOriginalPhoto.highestPercentageID+"");
    }

    private void displayData(){
       dtm.setRowCount(0);
        ArrayList<Offense> ar =odb.getOffenseAccordingToID(SearchOriginalPhoto.highestPercentageID);
        if (ar != null) {
            for (Offense cl : ar) {
                int oId = cl.getOffenseId();
                String des = cl.getDescription();
                Timestamp dateTime = cl.getOffenseDate();
                int typeId = cl.getOffenseTypeID();
                String type=new OffenseTypeDB().getTypeAccordingToTypeID(typeId);                
                dtm.addRow(new Object[]{oId,des,dateTime,type});
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_offense = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_criminalID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAr_description = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txt_offenseID = new javax.swing.JTextField();
        txt_dateTime = new javax.swing.JTextField();
        txt_type = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_offense.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Offense ID", "Description", "Date & Time", "Type"
            }
        ));
        tbl_offense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_offenseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_offense);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 520, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Criminal ID:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Offense ID:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Date and Time:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Type:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txt_criminalID.setEditable(false);
        txt_criminalID.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_criminalID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 180, -1));

        txtAr_description.setEditable(false);
        txtAr_description.setColumns(20);
        txtAr_description.setRows(5);
        jScrollPane2.setViewportView(txtAr_description);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 260, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Offense Description:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txt_offenseID.setEditable(false);
        txt_offenseID.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_offenseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 180, -1));

        txt_dateTime.setEditable(false);
        txt_dateTime.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_dateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 180, -1));

        txt_type.setEditable(false);
        txt_type.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 180, -1));

        btn_exit.setText("Exit");
        btn_exit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel2.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 70, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void tbl_offenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_offenseMouseClicked
        int i = tbl_offense.getSelectedRow();
        int id =  (int) dtm.getValueAt(i, 0);
        String des = (String) dtm.getValueAt(i, 1);
        Timestamp dateTime =  (Timestamp) dtm.getValueAt(i, 2);
        String type = (String) dtm.getValueAt(i, 3);
        
        txt_offenseID.setText(id+"");
        txtAr_description.setText(des);
        txt_dateTime.setText(dateTime.toString());
        txt_type.setText(type);
    }//GEN-LAST:event_tbl_offenseMouseClicked

    
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
            java.util.logging.Logger.getLogger(OffenseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OffenseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OffenseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OffenseHistory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OffenseHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_offense;
    private javax.swing.JTextArea txtAr_description;
    private javax.swing.JTextField txt_criminalID;
    private javax.swing.JTextField txt_dateTime;
    private javax.swing.JTextField txt_offenseID;
    private javax.swing.JTextField txt_type;
    // End of variables declaration//GEN-END:variables
}
