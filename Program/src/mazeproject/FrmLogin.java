  package mazeproject;

import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

public class FrmLogin extends javax.swing.JFrame {

    //attributes
    private int attempts;
    private int time;
    private final StandardFunctions functions;
    private final String detailFile;
    private boolean tfUserClick;
    private boolean tfPassClick;
    private boolean passHidden;
    private int timeOutNum;

    public FrmLogin() {
        //assign values to attributes
        this.timeOutNum = 0;
        this.passHidden = true;
        this.attempts = 2;
        this.time = 30;
        this.tfUserClick = false;
        this.tfPassClick = false;
        this.detailFile = "src/mazeproject/textfiles/login_details.txt";
        this.functions = new StandardFunctions();

        this.setUndecorated(true);
        initComponents();
        //select all hint text initially
        this.tfUser.selectAll();
        //unhide hint text
        this.tfPass.setEchoChar((char) 0);

        //set location to centre
        this.setLocationRelativeTo(null);

        //set label to a dark red color
        this.lblOutput.setForeground(new Color(102, 0, 0));
        this.lblHint.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnHint = new javax.swing.JButton();
        lblHint = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        lblLogin = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        tfPass = new javax.swing.JPasswordField();
        lblPass = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        lblSignup = new javax.swing.JLabel();
        btnSignup = new javax.swing.JButton();
        lblOutput = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setIconImages(null);
        setResizable(false);

        pnlMain.setBackground(new java.awt.Color(187, 183, 183));
        pnlMain.setPreferredSize(new java.awt.Dimension(505, 758));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbutton.png"))); // NOI18N
        btnExit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbuttonlight.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlMain.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 13, 50, 50));

        btnHint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/hintbutton.png"))); // NOI18N
        btnHint.setContentAreaFilled(false);
        btnHint.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/hintbuttonlight.png"))); // NOI18N
        btnHint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHintMouseExited(evt);
            }
        });
        pnlMain.add(btnHint, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 346, 70, 60));

        lblHint.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblHint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/hinttext.png"))); // NOI18N
        pnlMain.add(lblHint, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 346, 410, 60));

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visible.png"))); // NOI18N
        btnView.setContentAreaFilled(false);
        btnView.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visiblelight.png"))); // NOI18N
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        pnlMain.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 285, 50, 30));

        lblLogin.setFont(new java.awt.Font("Courier New", 1, 48)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/loginimg.png"))); // NOI18N
        lblLogin.setPreferredSize(new java.awt.Dimension(250, 100));
        pnlMain.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        tfUser.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        tfUser.setForeground(new java.awt.Color(204, 204, 204));
        tfUser.setText("Type your username here");
        tfUser.setToolTipText("");
        tfUser.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEtchedBorder()));
        tfUser.setPreferredSize(new java.awt.Dimension(500, 50));
        tfUser.setSelectionColor(new java.awt.Color(51, 102, 0));
        tfUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfUserMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfUserMouseExited(evt);
            }
        });
        tfUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUserKeyTyped(evt);
            }
        });
        pnlMain.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 438, 40));

        lblUser.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/usernametxt.png"))); // NOI18N
        pnlMain.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 121, 18));

        tfPass.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        tfPass.setForeground(new java.awt.Color(204, 204, 204));
        tfPass.setText("Type your password here");
        tfPass.setToolTipText("");
        tfPass.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEtchedBorder()));
        tfPass.setSelectionColor(new java.awt.Color(51, 102, 0));
        tfPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfPassMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfPassMouseExited(evt);
            }
        });
        tfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPassKeyTyped(evt);
            }
        });
        pnlMain.add(tfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 440, 40));

        lblPass.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/passwordtxt.png"))); // NOI18N
        pnlMain.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        btnSubmit.setBackground(new java.awt.Color(56, 87, 34));
        btnSubmit.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/submitbtn.png"))); // NOI18N
        btnSubmit.setBorder(null);
        btnSubmit.setPreferredSize(new java.awt.Dimension(300, 50));
        btnSubmit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/submitbtnlight.png"))); // NOI18N
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        pnlMain.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 420, 321, 61));

        lblSignup.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        lblSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/signbelow.png"))); // NOI18N
        lblSignup.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblSignup.setPreferredSize(new java.awt.Dimension(250, 50));
        pnlMain.add(lblSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, -1, 70));

        btnSignup.setBackground(new java.awt.Color(56, 87, 34));
        btnSignup.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        btnSignup.setForeground(new java.awt.Color(255, 255, 255));
        btnSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/signupbtn.png"))); // NOI18N
        btnSignup.setBorder(null);
        btnSignup.setPreferredSize(new java.awt.Dimension(300, 50));
        btnSignup.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/signupbtnlight.png"))); // NOI18N
        btnSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupActionPerformed(evt);
            }
        });
        pnlMain.add(btnSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 318, -1));

        lblOutput.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        lblOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 165, 165)), "OUTPUT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N
        lblOutput.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblOutput.setPreferredSize(new java.awt.Dimension(250, 50));
        pnlMain.add(lblOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 450, 70));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/background.png"))); // NOI18N
        lblBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        pnlMain.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        //temporary variables storing text field data
        String userEnter = tfUser.getText();
        //convert char array to string
        String passEnter = new String(tfPass.getPassword());

        //boolean for acceptable input
        boolean validUsername = checkInput(userEnter);
        boolean validPassword = checkInput(passEnter);

        //validate details
        boolean isValid = false;
        try {
            isValid = validateDetails(userEnter, passEnter);
        } catch (IOException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null,
                    ex);
        }

        //Allow access if valid
        if (isValid) {
            //close login - access menus
            this.dispose();
            FrmMainMenu menu = new FrmMainMenu(userEnter);
            menu.setVisible(true);
        } else if (!validUsername || !validPassword) {
            //suitable error messahe
            lblOutput.setText("No blank spaces allowed");
        } else {
            //decrement attempts
            if (this.attempts > 0) {
                //clear text boxes
                tfUser.setText("");
                tfPass.setText("");
                this.attempts -= 1;
                if (this.attempts == 0) {
                    lblOutput.setText("<html><body style='text-align: center;'>"
                            + "Username or Password incorrect " + (this.attempts
                            + 1) + " attempt remaining</body></html>");
                } else {
                    lblOutput.setText("<html><body style='text-align: center;'>"
                            + "Username or Password incorrect " + (this.attempts
                            + 1) + " attempts remaining</body></html>");
                }

            } else {
                //timout user for 30 seconds if 0 attempts left
                //Swing worker to correctly work with threads
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        //calls the timeout
                        for (Component component : pnlMain.getComponents()) {
                            //disables every component except for output
                            if (!(component == lblOutput)) {
                                component.setEnabled(false);
                            }
                        }
                        timeout();
                        return null;
                    }

                    @Override
                    protected void done() {
                        //disables every component in the main panel
                        for (Component component : pnlMain.getComponents()) {
                            component.setEnabled(true);
                        }
                    }
                };
                worker.execute();
                //reset timer
                this.attempts = 2;
                //increment times timed out
                this.timeOutNum += 1;
            }
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupActionPerformed
        //close login frame
        this.dispose();
        //call the signup form and set it to visible
        FrmSignup signup = new FrmSignup();
        signup.setVisible(true);
    }//GEN-LAST:event_btnSignupActionPerformed

    private void tfUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUserMouseClicked
        //only edit if the hint text is present
        if (tfUser.getText().equals("Type your username here")) {
            //clear the text field
            tfUser.setText("");
        }
        if (tfUserClick) {
            //highlight all text
            tfUser.selectAll();
            //disable select all
            tfUserClick = false;
        }
    }//GEN-LAST:event_tfUserMouseClicked

    private void tfUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUserMouseExited
        //reset user mouse click
        tfUserClick = true;
    }//GEN-LAST:event_tfUserMouseExited

    private void tfUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUserKeyTyped
        //change text colour to black
        tfUser.setForeground(Color.BLACK);
    }//GEN-LAST:event_tfUserKeyTyped

    private void tfPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPassMouseClicked
        //only edit if the hint text is present
        String passEnter = new String(tfPass.getPassword());
        if (passEnter.equals("Type your password here")) {
            //clear the text field
            tfPass.setText("");
            tfPassClick = false;
        }
        if (tfPassClick) {
            //highlight all text
            tfPass.selectAll();
            //disable select all
            tfPassClick = false;
        }
    }//GEN-LAST:event_tfPassMouseClicked

    private void tfPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPassMouseExited
        //reset pass mouse click
        tfPassClick = true;
    }//GEN-LAST:event_tfPassMouseExited

    private void tfPassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyTyped
        //change text colour to black
        tfPass.setForeground(Color.BLACK);
        //hide text when typing
        tfPass.setEchoChar('*');
        passHidden = false;
    }//GEN-LAST:event_tfPassKeyTyped

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        //toggle state of passHidden
        passHidden = !passHidden;
        //handle viewing state
        if (passHidden) {
            //unhide text
            this.tfPass.setEchoChar((char) 0);
        } else {
            //hide text
            this.tfPass.setEchoChar('*');
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnHintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHintMouseEntered
        //show hint text
        lblHint.setVisible(true);
    }//GEN-LAST:event_btnHintMouseEntered

    private void btnHintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHintMouseExited
        //hide hint text when exiting icon
        lblHint.setVisible(false);
    }//GEN-LAST:event_btnHintMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        //close entire program
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHint;
    private javax.swing.JButton btnSignup;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblHint;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblSignup;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPasswordField tfPass;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables

    private boolean validateDetails(String userEnter, String passEnter)
            throws IOException {
        //initialsie array & retrieve stored values
        String[] storedDetails = functions.loadDetails(detailFile);
        String[] splits;

        //validate user
        for (String storedDetail : storedDetails) {
            //split username and password
            splits = storedDetail.split(",");
            //compare login details
            if (userEnter.equals(splits[0]) && passEnter.equals(splits[1])) {
                return true;
            }
        }
        //not valid if end reached
        return false;
    }

    private void timeout() throws InterruptedException {
        //increment time in increasing amounts
        int tempTime = time * timeOutNum;
        time *= timeOutNum;
        int displayTime = time;
        for (int i = 0; i < tempTime; i++) {
            //decrement time - custom output
            if (time == 1) {
                lblOutput.setText("Timed out for " + displayTime + " second");
            } else {
                lblOutput.setText("Timed out for " + displayTime + " seconds");
            }
            displayTime -= 1;
            Thread.sleep(1000);
        }
        //clear the text
        tfUser.setText("");
        tfPass.setText("");
        lblOutput.setText("");
    }

    private boolean checkInput(String text) {
        //returns a boolean indicating whether text is validF
        return !(text.contains(" ") || text.equals(""));
    }
}
