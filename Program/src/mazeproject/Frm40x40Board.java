package mazeproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Frm40x40Board extends javax.swing.JFrame {

    //attributes
    private String username;
    private String fileName;
    private String boardSize;
    private StandardFunctions functions;

    public Frm40x40Board(String username) throws IOException {
        //assign values to attributes
        this.username = username;
        this.fileName = "src/mazeproject/textfiles/scores.txt";
        this.boardSize = "40x40";

        //get functions instance
        this.functions = new StandardFunctions();

        //set properties of the frame
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        //display stats to the screen
        displayStats();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnReturn = new javax.swing.JButton();
        lblTime5 = new javax.swing.JLabel();
        lblTime4 = new javax.swing.JLabel();
        lblTime3 = new javax.swing.JLabel();
        lblTime2 = new javax.swing.JLabel();
        lblTime1 = new javax.swing.JLabel();
        lblUser5 = new javax.swing.JLabel();
        lblUser4 = new javax.swing.JLabel();
        lblUser3 = new javax.swing.JLabel();
        lblUser2 = new javax.swing.JLabel();
        lblUser1 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(324, 467));

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbutton.png"))); // NOI18N
        btnExit.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/exitbuttonlight.png"))); // NOI18N
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlMain.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 50, 50));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/returnred.png"))); // NOI18N
        btnReturn.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/returnredlight.png"))); // NOI18N
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        pnlMain.add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 405, 190, 50));

        lblTime5.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblTime5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblTime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 358, 120, 30));

        lblTime4.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblTime4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblTime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 311, 120, 30));

        lblTime3.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblTime3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 263, 120, 30));

        lblTime2.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblTime2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 215, 120, 30));

        lblTime1.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblTime1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 120, 30));

        lblUser5.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblUser5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblUser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 358, 120, 30));

        lblUser4.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblUser4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblUser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 311, 120, 30));

        lblUser3.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblUser3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblUser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 263, 120, 30));

        lblUser2.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblUser2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 215, 120, 30));

        lblUser1.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        lblUser1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlMain.add(lblUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 170, 120, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mazeproject/images/40x40board.PNG"))); // NOI18N
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

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        //close entire program
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        //close menu and open statistics
        this.dispose();
        FrmSelectLeaderboard statistics = new FrmSelectLeaderboard(username);
    }//GEN-LAST:event_btnReturnActionPerformed

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
            java.util.logging.Logger.getLogger(Frm40x40Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm40x40Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm40x40Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm40x40Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Frm40x40Board("jai").setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Frm40x40Board.class.getName()).log(
                            Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblTime1;
    private javax.swing.JLabel lblTime2;
    private javax.swing.JLabel lblTime3;
    private javax.swing.JLabel lblTime4;
    private javax.swing.JLabel lblTime5;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JLabel lblUser2;
    private javax.swing.JLabel lblUser3;
    private javax.swing.JLabel lblUser4;
    private javax.swing.JLabel lblUser5;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables

    private void displayStats() throws IOException {
        //initialsie array & retrieve stored values
        String[] details = this.functions.loadDetails(this.fileName);
        String[] splits;
        String[] timeParts;

        //declare count variable
        int count = 0;
        int totalSeconds;

        //highest 5 score array - set out of bound values
        int[] highestSeconds = {1000000, 1000000, 1000000, 1000000, 1000000};
        String[] highestDetails = new String[5];
        //times specific to this leaderboard
        ArrayList<String> localTimes = new ArrayList<>();

        //get all scores 20x20
        for (String detail : details) {
            //access each value
            splits = detail.split(",");
            if (this.boardSize.equals(splits[2])) {
                //add to array list
                localTimes.add(detail);
            }
        }

        //get highest 5 scores
        for (String localTime : localTimes) {
            //get individual times
            splits = localTime.split(",");
            timeParts = splits[1].split(":");
            //get total number of centiseconds
            totalSeconds = Integer.parseInt(timeParts[0]) * 6000
                    + Integer.parseInt(timeParts[1]) * 100
                    + Integer.parseInt(timeParts[2]);
            //check high scores
            for (int i = 0; i < highestSeconds.length; i++) {
                if (highestSeconds[i] > totalSeconds) {
                    //replace value and break out the loop
                    highestSeconds[i] = totalSeconds;
                    break;
                }
            }
            //sort array in descending order
            Arrays.sort(highestSeconds);
            highestSeconds = functions.reverseArr(highestSeconds);
        }

        //reverse array to regain sense
        highestSeconds = functions.reverseArr(highestSeconds);

        //get corresponding username and formatted times
        for (String detail : details) {
            //access each value
            splits = detail.split(",");
            timeParts = splits[1].split(":");
            //get total number of centiseconds
            totalSeconds = Integer.parseInt(timeParts[0]) * 6000
                    + Integer.parseInt(timeParts[1]) * 100
                    + Integer.parseInt(timeParts[2]);
            //match details to times
            for (int i = 0; i < highestSeconds.length; i++) {
                if (highestSeconds[i] == totalSeconds) {
                    //assign detail in position
                    highestDetails[i] = detail;
                }
            }

        }

        //display the details to the screen
        for (int i = 0; i < highestDetails.length; i++) {
            //create splits
            splits = highestDetails[i].split(",");
            String user = splits[0];
            String time = splits[1];
            //switch case for labels
            switch (i) {
                case 0:
                    //1st place
                    this.lblUser1.setText(user);
                    this.lblTime1.setText(time);
                    break;
                case 1:
                    //2nd place
                    this.lblUser2.setText(user);
                    this.lblTime2.setText(time);
                    break;
                case 2:
                    //3rd place
                    this.lblUser3.setText(user);
                    this.lblTime3.setText(time);
                    break;
                case 3:
                    //4th place
                    this.lblUser4.setText(user);
                    this.lblTime4.setText(time);
                    break;
                case 4:
                    //5th place
                    this.lblUser5.setText(user);
                    this.lblTime5.setText(time);
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
