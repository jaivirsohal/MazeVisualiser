package mazeproject;

public class FrmWinMenu extends javax.swing.JFrame {

    //attributes
    private String username;

    public FrmWinMenu(String time, String type, String username) {
        //assign values to attributes
        this.username = username;

        //set properties of the frame
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        //set text of the solve time and maze type
        lblTime.setText(time);
        lblMaze.setText(type);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnNewGame = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        lblMaze = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnNewGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/newgamebutton.png"))); // NOI18N
        btnNewGame.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/newgamebuttonlight.png"))); // NOI18N
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });
        pnlMain.add(btnNewGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 320, 70));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/mainmenubutton.png"))); // NOI18N
        btnMenu.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/mainmenubuttonlight.png"))); // NOI18N
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        pnlMain.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 330, 200, 57));

        lblMaze.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        lblMaze.setForeground(new java.awt.Color(0, 51, 0));
        lblMaze.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMaze.setText("40x40");
        pnlMain.add(lblMaze, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 160, 50));

        lblTime.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 51, 0));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTime.setText("00:01:23");
        pnlMain.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 160, 50));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/winmenubackground.png"))); // NOI18N
        pnlMain.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        //close menu and open player
        this.dispose();
        FrmNewGame newGame = new FrmNewGame(this.username);
    }//GEN-LAST:event_btnNewGameActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        //open menu, close form
        this.dispose();
        FrmMainMenu menu = new FrmMainMenu(this.username);
        menu.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

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
            java.util.logging.Logger.getLogger(FrmWinMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmWinMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmWinMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmWinMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmWinMenu("00:00:00", "0x0", "jai")
                        .setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnNewGame;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblMaze;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
