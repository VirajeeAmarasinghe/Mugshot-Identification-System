package UserInterface;

import BusinessLogic.UserLevel;
import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        changeImage();
        setLocationRelativeTo(null);
        setAccessPrivileges();
    }

    //this method is for establishing access privileges
    private void setAccessPrivileges() {
        if (!UserLevel.userLevel.equals("Administrator")) {
            menuitem_changePass.setEnabled(false);
            menuItem_criminalRegi.setEnabled(false);
            menuitem_deleteUser.setEnabled(false);
            menuItem_newOffenseRecord.setEnabled(false);
            menuitem_newUser.setEnabled(false);
            menuItem_offenseTypeEntering.setEnabled(false);
            menuItem_searchOriginalPhot.setEnabled(false);
        }        
    }

    //this method is for changing image of the Frame
    private void changeImage() {
        ImageIcon imageicon = new ImageIcon(getClass().getResource("/Icon/home_icon.gif"));
        Image image = imageicon.getImage();
        setIconImage(image);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_main = new javax.swing.JPanel();
        pnl_second = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        menu_bar_1 = new javax.swing.JMenuBar();
        menu_file = new javax.swing.JMenu();
        menuItem_criminalRegi = new javax.swing.JMenuItem();
        menuItem_newOffenseRecord = new javax.swing.JMenuItem();
        menuItem_offenseTypeEntering = new javax.swing.JMenuItem();
        menuItem_searchOriginalPhot = new javax.swing.JMenuItem();
        menuItem_exit = new javax.swing.JMenuItem();
        menu_login = new javax.swing.JMenu();
        menuitem_newUser = new javax.swing.JMenuItem();
        menuitem_changePass = new javax.swing.JMenuItem();
        menuitem_deleteUser = new javax.swing.JMenuItem();
        menu_help = new javax.swing.JMenu();
        menuItem_userManual = new javax.swing.JMenuItem();
        menuitem_about = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Home");
        setResizable(false);

        pnl_main.setBackground(new java.awt.Color(0, 153, 255));
        pnl_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_second.setBackground(new java.awt.Color(255, 255, 255));
        pnl_second.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/House.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 260, 270));

        pnl_second.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 310));

        pnl_main.add(pnl_second, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, 330));

        menu_file.setText("File");

        menuItem_criminalRegi.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        menuItem_criminalRegi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user.gif"))); // NOI18N
        menuItem_criminalRegi.setText("Criminal Registration");
        menuItem_criminalRegi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_criminalRegiActionPerformed(evt);
            }
        });
        menu_file.add(menuItem_criminalRegi);

        menuItem_newOffenseRecord.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        menuItem_newOffenseRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/handcuff - small.png"))); // NOI18N
        menuItem_newOffenseRecord.setText("New Offense Record");
        menuItem_newOffenseRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_newOffenseRecordActionPerformed(evt);
            }
        });
        menu_file.add(menuItem_newOffenseRecord);

        menuItem_offenseTypeEntering.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        menuItem_offenseTypeEntering.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/book-edit-icon.png"))); // NOI18N
        menuItem_offenseTypeEntering.setText("Offense Type Entering");
        menuItem_offenseTypeEntering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_offenseTypeEnteringActionPerformed(evt);
            }
        });
        menu_file.add(menuItem_offenseTypeEntering);

        menuItem_searchOriginalPhot.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        menuItem_searchOriginalPhot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/stack-of-photos-xxl.png"))); // NOI18N
        menuItem_searchOriginalPhot.setText("Search Original Photo");
        menuItem_searchOriginalPhot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_searchOriginalPhotActionPerformed(evt);
            }
        });
        menu_file.add(menuItem_searchOriginalPhot);

        menuItem_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItem_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/close.gif"))); // NOI18N
        menuItem_exit.setText("Exit");
        menuItem_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_exitActionPerformed(evt);
            }
        });
        menu_file.add(menuItem_exit);

        menu_bar_1.add(menu_file);

        menu_login.setText("Login");

        menuitem_newUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuitem_newUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/user.gif"))); // NOI18N
        menuitem_newUser.setText("New User Registration");
        menuitem_newUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_newUserActionPerformed(evt);
            }
        });
        menu_login.add(menuitem_newUser);

        menuitem_changePass.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuitem_changePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/pass.png"))); // NOI18N
        menuitem_changePass.setText("Change Password");
        menuitem_changePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_changePassActionPerformed(evt);
            }
        });
        menu_login.add(menuitem_changePass);

        menuitem_deleteUser.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuitem_deleteUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_2.png"))); // NOI18N
        menuitem_deleteUser.setText("Delete User");
        menuitem_deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_deleteUserActionPerformed(evt);
            }
        });
        menu_login.add(menuitem_deleteUser);

        menu_bar_1.add(menu_login);

        menu_help.setText("Help");

        menuItem_userManual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItem_userManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/book-edit-icon.png"))); // NOI18N
        menuItem_userManual.setText("User Manual");
        menuItem_userManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_userManualActionPerformed(evt);
            }
        });
        menu_help.add(menuItem_userManual);

        menuitem_about.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuitem_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/questionMark.jpg"))); // NOI18N
        menuitem_about.setText("About");
        menuitem_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_aboutActionPerformed(evt);
            }
        });
        menu_help.add(menuitem_about);

        menu_bar_1.add(menu_help);

        setJMenuBar(menu_bar_1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItem_userManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_userManualActionPerformed
        Desktop desktop = Desktop.getDesktop();
        try {
            File userManual = new File("D:\\Assignments\\Final Project");
            userManual.mkdir();
            File f = new File(userManual, "User Manual.pdf");
            desktop.open(f);
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_menuItem_userManualActionPerformed

    private void menuItem_offenseTypeEnteringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_offenseTypeEnteringActionPerformed
        OffenseTypeEntering d = new OffenseTypeEntering();
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItem_offenseTypeEnteringActionPerformed

    private void menuItem_searchOriginalPhotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_searchOriginalPhotActionPerformed
        SearchOriginalPhoto p = new SearchOriginalPhoto();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItem_searchOriginalPhotActionPerformed

    private void menuItem_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItem_exitActionPerformed

    private void menuitem_changePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_changePassActionPerformed
        ChangePassword c = new ChangePassword();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuitem_changePassActionPerformed

    private void menuItem_criminalRegiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_criminalRegiActionPerformed
        CriminalRegistration e = new CriminalRegistration();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItem_criminalRegiActionPerformed

    private void menuItem_newOffenseRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_newOffenseRecordActionPerformed
        NewOffenseRecord c = new NewOffenseRecord();
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuItem_newOffenseRecordActionPerformed

    private void menuitem_newUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_newUserActionPerformed
        NewUserRegistration n = new NewUserRegistration();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuitem_newUserActionPerformed

    private void menuitem_deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_deleteUserActionPerformed
        DeleteUser d = new DeleteUser();
        d.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuitem_deleteUserActionPerformed

    private void menuitem_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_aboutActionPerformed
        About a = new About();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_menuitem_aboutActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuItem_criminalRegi;
    private javax.swing.JMenuItem menuItem_exit;
    private javax.swing.JMenuItem menuItem_newOffenseRecord;
    private javax.swing.JMenuItem menuItem_offenseTypeEntering;
    private javax.swing.JMenuItem menuItem_searchOriginalPhot;
    private javax.swing.JMenuItem menuItem_userManual;
    private javax.swing.JMenuBar menu_bar_1;
    private javax.swing.JMenu menu_file;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_login;
    private javax.swing.JMenuItem menuitem_about;
    private javax.swing.JMenuItem menuitem_changePass;
    private javax.swing.JMenuItem menuitem_deleteUser;
    private javax.swing.JMenuItem menuitem_newUser;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JPanel pnl_second;
    // End of variables declaration//GEN-END:variables
}
