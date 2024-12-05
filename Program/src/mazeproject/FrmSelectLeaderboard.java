package mazeproject;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmSelectLeaderboard extends javax.swing.JFrame {

    //attributes
    private String username;

    public FrmSelectLeaderboard(String username) {
        //assign values to attributes
        this.username = username;

        //set properties of the frame
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btn20x20 = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        btn80x80 = new javax.swing.JButton();
        btn40x40 = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(415, 442));

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn20x20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/20x20.png"))); // NOI18N
        btn20x20.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/20x20light.png"))); // NOI18N
        btn20x20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20x20ActionPerformed(evt);
            }
        });
        pnlMain.add(btn20x20, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 160, 310, 58));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/mainmenubutton.png"))); // NOI18N
        btnMenu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/mainmenubuttonlight.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        pnlMain.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 200, 57));

        btn80x80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/80x80.png"))); // NOI18N
        btn80x80.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/80x80light.png"))); // NOI18N
        btn80x80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn80x80ActionPerformed(evt);
            }
        });
        pnlMain.add(btn80x80, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 310, 58));

        btn40x40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/40x40.png"))); // NOI18N
        btn40x40.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/40x40light.png"))); // NOI18N
        btn40x40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn40x40ActionPerformed(evt);
            }
        });
        pnlMain.add(btn40x40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 310, 58));

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbutton.png"))); // NOI18N
        btnExit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbuttonlight.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlMain.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 13, 50, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/leaderboardbackground.PNG"))); // NOI18N
        pnlMain.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -1, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        //close entire program
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        //open menu, close form
        this.dispose();
        FrmMainMenu menu = new FrmMainMenu(this.username);
        menu.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btn80x80ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn80x80ActionPerformed
        //30x30 maze leaderboard
        this.dispose();
        try {
            Frm80x80Board stats = new Frm80x80Board(this.username);
        } catch (IOException ex) {
            Logger.getLogger(FrmSelectLeaderboard.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn80x80ActionPerformed

    private void btn40x40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn40x40ActionPerformed
        //40x40 maze leaderboard
        this.dispose();
        try {
            Frm40x40Board stats = new Frm40x40Board(this.username);
        } catch (IOException ex) {
            Logger.getLogger(FrmSelectLeaderboard.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn40x40ActionPerformed

    private void btn20x20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn20x20ActionPerformed
        //20x20 maze leaderboard
        this.dispose();
        try {
            Frm20x20Board stats = new Frm20x20Board(this.username);
        } catch (IOException ex) {
            Logger.getLogger(FrmSelectLeaderboard.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn20x20ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSelectLeaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSelectLeaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSelectLeaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSelectLeaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSelectLeaderboard("jai").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn20x20;
    private javax.swing.JButton btn40x40;
    private javax.swing.JButton btn80x80;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMenu;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
