package mazeproject;

public class FrmMainMenu extends javax.swing.JFrame {
    //attributes
    private String username;
    
    public FrmMainMenu(String username) {
        //assign values to attributes
        this.username = username;
        
        //set properties of the frame
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnVisualise = new javax.swing.JButton();
        btnSignout = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(378, 505));

        pnlMain.setPreferredSize(new java.awt.Dimension(378, 505));
        pnlMain.setRequestFocusEnabled(false);
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbutton.png"))); // NOI18N
        btnExit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbuttonlight.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlMain.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 12, 50, 50));

        btnStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/statisticsbutton.png"))); // NOI18N
        btnStatistics.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/statisticsbuttonlight.png"))); // NOI18N
        btnStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatisticsActionPerformed(evt);
            }
        });
        pnlMain.add(btnStatistics, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 320, 310, 60));

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/playbutton.png"))); // NOI18N
        btnPlay.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/playbuttonlight.png"))); // NOI18N
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        pnlMain.add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 250, 310, 60));

        btnVisualise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visualisebutton.png"))); // NOI18N
        btnVisualise.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visualisebuttonlight.png"))); // NOI18N
        btnVisualise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualiseActionPerformed(evt);
            }
        });
        pnlMain.add(btnVisualise, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 180, 310, 60));

        btnSignout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/signoutbutton.png"))); // NOI18N
        btnSignout.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/signoutbuttonlight.png"))); // NOI18N
        btnSignout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignoutActionPerformed(evt);
            }
        });
        pnlMain.add(btnSignout, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 435, 190, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/mainmenubackground.png"))); // NOI18N
        pnlMain.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignoutActionPerformed
        //close menu and open login form
        this.dispose();
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_btnSignoutActionPerformed

    private void btnVisualiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualiseActionPerformed
        //close menu and open visualiser
        this.dispose();
        MazeVisualiser visualiser = new MazeVisualiser(80, 80, username);
    }//GEN-LAST:event_btnVisualiseActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        //close entire program
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        //close menu and open player
        this.dispose();
        FrmNewGame newGame = new FrmNewGame(username);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatisticsActionPerformed
        //close menu and open statistics
        this.dispose();
        FrmSelectLeaderboard statistics = new FrmSelectLeaderboard(username);
    }//GEN-LAST:event_btnStatisticsActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMainMenu("jai").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSignout;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JButton btnVisualise;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
