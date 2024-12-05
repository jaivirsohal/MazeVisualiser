package mazeproject;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmSignup extends javax.swing.JFrame {

    //attributes
    private final StandardFunctions functions;
    private final String detailFile;
    private boolean tfUserClick;
    private boolean tfPassClick;
    private boolean tfConfirmClick;
    private boolean passHidden;
    private boolean confirmHidden;

    public FrmSignup() {
        //assign values to attributes
        this.tfUserClick = false;
        this.tfPassClick = false;
        this.tfConfirmClick = false;
        this.passHidden = false;
        this.confirmHidden = false;
        this.functions = new StandardFunctions();
        this.detailFile = "src/mazeproject/textfiles/login_details.txt";
        
        this.setUndecorated(true);
        //initialise components
        initComponents();

        //edits to form
        //select all hint text initially
        this.tfUser.selectAll();
        //unhide hint text
        this.tfPass.setEchoChar((char) 0);
        this.tfConfirm.setEchoChar((char) 0);
        //hide tick labels
        this.lblUserTick.setVisible(false);
        this.lblPassTick.setVisible(false);
        this.lblConfirmTick.setVisible(false);
        //set location to centre
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        lblSignup = new javax.swing.JLabel();
        lblConfirmTick = new javax.swing.JLabel();
        lblPassTick = new javax.swing.JLabel();
        lblUserTick = new javax.swing.JLabel();
        btnView2 = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        tfUser = new javax.swing.JTextField();
        tfPass = new javax.swing.JPasswordField();
        tfConfirm = new javax.swing.JPasswordField();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblConfirm = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        lblOutput = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setResizable(false);

        pnlMain.setPreferredSize(new java.awt.Dimension(600, 800));
        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbutton.png"))); // NOI18N
        btnExit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbuttonlight.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlMain.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 13, 50, 50));

        lblSignup.setFont(new java.awt.Font("Courier New", 1, 48)); // NOI18N
        lblSignup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSignup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/signuptxt.png"))); // NOI18N
        lblSignup.setPreferredSize(new java.awt.Dimension(250, 100));
        pnlMain.add(lblSignup, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 500, 100));

        lblConfirmTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/tick.png"))); // NOI18N
        pnlMain.add(lblConfirmTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 349, -1, -1));

        lblPassTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/tick.png"))); // NOI18N
        pnlMain.add(lblPassTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 259, -1, -1));

        lblUserTick.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/tick.png"))); // NOI18N
        pnlMain.add(lblUserTick, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 169, -1, -1));

        btnView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visible.png"))); // NOI18N
        btnView2.setContentAreaFilled(false);
        btnView2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visiblelight.png"))); // NOI18N
        btnView2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView2ActionPerformed(evt);
            }
        });
        pnlMain.add(btnView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 375, 50, 30));

        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visible.png"))); // NOI18N
        btnView.setContentAreaFilled(false);
        btnView.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/visiblelight.png"))); // NOI18N
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        pnlMain.add(btnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 285, 50, 30));

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfUserKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfUserKeyTyped(evt);
            }
        });
        pnlMain.add(tfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 438, 40));

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
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPassKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPassKeyTyped(evt);
            }
        });
        pnlMain.add(tfPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 440, 40));

        tfConfirm.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        tfConfirm.setForeground(new java.awt.Color(204, 204, 204));
        tfConfirm.setText("Confirm your password here");
        tfConfirm.setToolTipText("");
        tfConfirm.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEtchedBorder()));
        tfConfirm.setSelectionColor(new java.awt.Color(51, 102, 0));
        tfConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tfConfirmMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfConfirmMouseExited(evt);
            }
        });
        tfConfirm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfConfirmKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfConfirmKeyTyped(evt);
            }
        });
        pnlMain.add(tfConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 440, 40));

        lblUser.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/usernametxt.png"))); // NOI18N
        pnlMain.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 121, 18));

        lblPass.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/passwordtxt.png"))); // NOI18N
        pnlMain.add(lblPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 260, -1, -1));

        lblConfirm.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        lblConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/confirmpasswordtxt.png"))); // NOI18N
        pnlMain.add(lblConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 349, -1, -1));

        btnRegister.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/registerbutton.png"))); // NOI18N
        btnRegister.setPreferredSize(new java.awt.Dimension(300, 100));
        btnRegister.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/registerbuttonlight.png"))); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        pnlMain.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 525, 320, 60));

        lblOutput.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        lblOutput.setForeground(new java.awt.Color(102, 0, 0));
        lblOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOutput.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(175, 165, 165)), "OUTPUT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Courier New", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N
        lblOutput.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblOutput.setPreferredSize(new java.awt.Dimension(250, 50));
        pnlMain.add(lblOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 450, 70));

        btnReturn.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/returnbutton.png"))); // NOI18N
        btnReturn.setToolTipText("");
        btnReturn.setPreferredSize(new java.awt.Dimension(300, 100));
        btnReturn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/returnbuttonlight.png"))); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        pnlMain.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 340, 60));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/background.png"))); // NOI18N
        lblBackground.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        pnlMain.add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        //temporary variables storing text field data
        String userEnter = tfUser.getText();
        String passEnter = new String(tfPass.getPassword());
        String passConfirm = new String(tfConfirm.getPassword());

        //check valid through function
        boolean valid = validateAll(userEnter, passEnter, passConfirm);

        if (valid) {
            try {
                //write details to file
                String detail = userEnter + "," + passEnter;
                functions.writeToFile(detail, detailFile);
            } catch (IOException ex) {
                Logger.getLogger(FrmSignup.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            //Allow access onto main menus
            this.dispose();
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
        }else{
            this.lblOutput.setForeground(new Color(102, 0, 0));
            this.lblOutput.setText("Details are not valid");
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        //close register and return to login
        this.dispose();
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
    }//GEN-LAST:event_btnReturnActionPerformed

    private void tfPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfPassMouseClicked
        //update password live validation
        String passEnter = new String(tfPass.getPassword());
        String passConfirm = new String(tfConfirm.getPassword());
        checkTfPass(passEnter, passConfirm);
        //only edit if the hint text is present
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

    private void tfConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfConfirmMouseClicked
        //update password live validation
        String passEnter = new String(tfPass.getPassword());
        String passConfirm = new String(tfConfirm.getPassword());
        checkTfPass(passEnter, passConfirm);
        //only edit if the hint text is present
        if (passConfirm.equals("Confirm your password here")) {
            //clear the text field
            tfConfirm.setText("");
            tfConfirmClick = false;
        }
        if (tfConfirmClick) {
            //highlight all text
            tfConfirm.selectAll();
            //disable select all
            tfConfirmClick = false;
        }
    }//GEN-LAST:event_tfConfirmMouseClicked

    private void tfConfirmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfConfirmMouseExited
        //reset pass mouse click
        tfConfirmClick = true;
    }//GEN-LAST:event_tfConfirmMouseExited

    private void tfConfirmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfConfirmKeyTyped
        //change text colour to black
        tfConfirm.setForeground(Color.BLACK);
        //hide text when typing
        tfConfirm.setEchoChar('*');
        confirmHidden = false;
    }//GEN-LAST:event_tfConfirmKeyTyped

    private void tfUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfUserMouseClicked
        //update username live validation
        checkTfUser(tfUser.getText());
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

    private void btnView2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView2ActionPerformed
        //toggle state of confirmHidden
        confirmHidden = !confirmHidden;
        //handle viewing state
        if (confirmHidden) {
            //unhide text
            this.tfConfirm.setEchoChar((char) 0);
        } else {
            //hide text
            this.tfConfirm.setEchoChar('*');
        }
    }//GEN-LAST:event_btnView2ActionPerformed

    private void tfUserKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfUserKeyReleased
        //update username live validation
        checkTfUser(tfUser.getText());
    }//GEN-LAST:event_tfUserKeyReleased

    private void tfPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyReleased
        //update password live validation
        String passEnter = new String(tfPass.getPassword());
        String passConfirm = new String(tfConfirm.getPassword());
        checkTfPass(passEnter, passConfirm);
    }//GEN-LAST:event_tfPassKeyReleased

    private void tfConfirmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfConfirmKeyReleased
        //update password live validation
        String passEnter = new String(tfPass.getPassword());
        String passConfirm = new String(tfConfirm.getPassword());
        checkTfPass(passEnter, passConfirm);
    }//GEN-LAST:event_tfConfirmKeyReleased

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
            java.util.logging.Logger.getLogger(FrmSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSignup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmSignup().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnView2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblConfirmTick;
    private javax.swing.JLabel lblOutput;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblPassTick;
    private javax.swing.JLabel lblSignup;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUserTick;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPasswordField tfConfirm;
    private javax.swing.JPasswordField tfPass;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables

    private boolean validateAll(String userEnter, String passEnter,
            String passConfirm) {
        //validation booleans
        boolean isUserLength = checkUserLength(userEnter);
        boolean isUniqueUser = false;
        try {
            isUniqueUser = checkUniqueUser(userEnter);
        } catch (IOException ex) {
            Logger.getLogger(FrmSignup.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        boolean isUserFormat = checkUserFormat(userEnter);
        boolean isPassLength = checkPassLength(passEnter);
        boolean isPassFormat = checkPassFormat(passEnter);
        boolean isPassEqual = checkEqual(passEnter, passConfirm);

        //conditions for each validation step
        return (isUserLength && isUserFormat && isUniqueUser
                && isPassLength && isPassFormat && isPassEqual);
    }

    private boolean checkUniqueUser(String user) throws IOException {
        //initialsie array & retrieve stored values
        String[] storedDetails = functions.loadDetails(detailFile);
        String[] splits;
        //validate user
        for (String storedDetail : storedDetails) {
            //split username and password
            splits = storedDetail.split(",");
            //return false if not unique (found)
            if (user.equals(splits[0])) {
                return false;
            }
        }
        //returns true if user not found
        return true;
    }

    private boolean checkUserLength(String user) {
        //check length of username
        return !(user.length() < 4 || user.length() > 10);
    }

    private boolean checkUserFormat(String user) {
        //convert to lower case to work with one case
        user = user.toLowerCase();

        //iterate through string
        for (int i = 0; i < user.length(); i++) {
            char c = user.charAt(i);
            //check if username consists only of letters and numbers
            if (!(Character.isDigit(c) || Character.isLetter(c))) {
                return false;
            }
        }
        //if end reached - correct format
        return true;
    }

    private boolean checkPassLength(String pass) {
        //return false if less than 8 characters or greater than 20
        return !(pass.length() < 8 || pass.length() > 20);
    }

    private boolean checkPassFormat(String pass) {
        //convert to lower case to work with one case
        pass = pass.toLowerCase();

        //variables to track special chars and numbers
        boolean hasSpecial = false;
        boolean hasNum = false;

        //iterate through password
        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            //check if username consists only of letters and numbers
            if (c == ' ') {
                return false;
            } else if (Character.isDigit(c)) {
                hasNum = true;
            } else if (!Character.isLetter(c)) {
                hasSpecial = true;
            }
        }

        //returns true or false according to if pass has num/special
        return hasSpecial && hasNum;
    }

    private boolean checkEqual(String passEnter, String passConfirm) {
        return passEnter.equals(passConfirm);
    }

    private void checkTfUser(String user) {
        //hide tick label
        this.lblUserTick.setVisible(false);
        //set text to red initially
        this.lblOutput.setForeground(new Color(102, 0, 0));
        //create alidation booleans
        boolean isUserLength = checkUserLength(user);
        boolean isUniqueUser = false;
        try {
            isUniqueUser = checkUniqueUser(user);
        } catch (IOException ex) {
            Logger.getLogger(FrmSignup.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        boolean isUserFormat = checkUserFormat(user);

        if (isUserLength) {
            if (isUserFormat) {
                if (isUniqueUser) {
                    //show tick label
                    this.lblUserTick.setVisible(true);
                    //set text to green to indicate allowed username
                    this.lblOutput.setForeground(new Color(0, 102, 0));
                    lblOutput.setText("Username is allowed");
                } else {
                    //output for unique username
                    lblOutput.setText("<html><body style='text-align: "
                            + "center;'>Username is not unique!<body/><html/>");
                }
            } else {
                //output for format
                lblOutput.setText("<html><body style='text-align: center;'>"
                        + "Username must only contain letters and numbers!"
                        + "<body/><html/>");
            }
        } else {
            //output for length
            lblOutput.setText("<html><body style='text-align: center;'>"
                    + "Username must be length 4-10 inclusive!<body/><html/>");
        }
    }

    private void checkTfPass(String pass, String passConfirm) {
        //hide tick labels
        this.lblPassTick.setVisible(false);
        this.lblConfirmTick.setVisible(false);
        //set output text to red intially
        this.lblOutput.setForeground(new Color(102, 0, 0));
        //create alidation booleans
        boolean isPassLength = checkPassLength(pass);
        boolean isPassFormat = checkPassFormat(pass);
        boolean isPassEqual = checkEqual(pass, passConfirm);

        //hierarchy of selection
        if (isPassLength) {
            if (isPassFormat) {
                //show tick labels
                this.lblPassTick.setVisible(true);
                if (isPassEqual) {
                    this.lblConfirmTick.setVisible(true);
                    //set text to green to indicate allowed username
                    this.lblOutput.setForeground(new Color(0, 102, 0));
                    lblOutput.setText("Passwords are valid");
                } else {
                    //output for unique username
                    lblOutput.setText("<html><body style='text-align:"
                            + " center;'>Passwords are not equal!"
                            + "<body/><html/>");
                }
            } else {
                //output for format
                lblOutput.setText("<html><body style='text-align: center;'>"
                        + "Password should contain 1 special char and 1 "
                        + "num!<body/><html/>");
            }
        } else {
            //output for length
            lblOutput.setText("<html><body style='text-align: center;'>"
                    + "Password must be length 8-20 inclusive!"
                    + "<body/><html/>");
        }
    }
}
