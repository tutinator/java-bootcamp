/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Aldi Vaca
 */
public class FrmAudioPlayer extends javax.swing.JFrame {

    /**
     * Creates new form FrmAudioPlayer
     */
    public FrmAudioPlayer() {
        personalizeGUI();
        initComponents();
    }

    private Clip clip;
    private DefaultListModel mdlList = new DefaultListModel();
    private boolean isPlaying = false;
    private Long actualPosition;
    private String actualSong;
    private AudioInputStream audioInputStream;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        songsList = new javax.swing.JList();
        btnRemove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        actualStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AudioPlayer");
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PlayList", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        songsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                songsListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(songsList);

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/minus.png"))); // NOI18N
        btnRemove.setText("Remove Song");
        btnRemove.setBorderPainted(false);
        btnRemove.setContentAreaFilled(false);
        btnRemove.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnRemove.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnRemove.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnRemoveFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnRemoveFocusLost(evt);
            }
        });
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/plus.png"))); // NOI18N
        btnAdd.setText("Add Song");
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnAdd.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnAdd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnAddFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnAddFocusLost(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRemove)
                    .addComponent(btnAdd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemove)
                        .addGap(13, 13, 13))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/play.png"))); // NOI18N
        btnPlay.setToolTipText("Play");
        btnPlay.setBorderPainted(false);
        btnPlay.setContentAreaFilled(false);
        btnPlay.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnPlay.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnPlayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnPlayFocusLost(evt);
            }
        });
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnPause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/pause.png"))); // NOI18N
        btnPause.setToolTipText("Pause");
        btnPause.setBorderPainted(false);
        btnPause.setContentAreaFilled(false);
        btnPause.setEnabled(false);
        btnPause.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnPause.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnPauseFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnPauseFocusLost(evt);
            }
        });
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/stop.png"))); // NOI18N
        btnStop.setToolTipText("Stop");
        btnStop.setBorderPainted(false);
        btnStop.setContentAreaFilled(false);
        btnStop.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnStop.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnStopFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnStopFocusLost(evt);
            }
        });
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        actualStatus.setText("Stopped");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnPlay)
                        .addGap(40, 40, 40)
                        .addComponent(btnPause)
                        .addGap(40, 40, 40)
                        .addComponent(btnStop)))
                .addGap(4, 4, 4))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(actualStatus)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPause)
                    .addComponent(btnPlay)
                    .addComponent(btnStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(actualStatus))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed

        int index = this.songsList.getSelectedIndex();
        if (songsList.getModel().getSize() > 0) {
            if (actualSong.equals((String) mdlList.elementAt(index))) {
                stopSound();
                actualSong = "";
            }
            mdlList.removeElementAt(index);
        } else {
            JOptionPane.showMessageDialog(null, "No hay archivos para remover de la lista", "Error!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        JFileChooser fc = new JFileChooser();

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de audio WAV (*.wav)", "wav");
        fc.setFileFilter(filter);
        fc.setAcceptAllFileFilterUsed(false);
        String workingDir = System.getProperty("user.dir");
        fc.setCurrentDirectory(new File(workingDir));

        if (!fc.isMultiSelectionEnabled()) {
            fc.setMultiSelectionEnabled(true);
        }

        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File[] files = fc.getSelectedFiles();
            for (int i = 0; i < files.length; i++) {
                File f = new File(files[i].getAbsolutePath());
                mdlList.addElement(files[i].getAbsolutePath());
                songsList.setModel(mdlList);
                songsList.setSelectedIndex(0);
            }
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnAddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddFocusGained
        btnAdd.setContentAreaFilled(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnAddFocusGained

    private void btnAddFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnAddFocusLost
        btnAdd.setContentAreaFilled(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnAddFocusLost

    private void btnRemoveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnRemoveFocusGained
        btnRemove.setContentAreaFilled(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveFocusGained

    private void btnRemoveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnRemoveFocusLost
        btnRemove.setContentAreaFilled(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveFocusLost

    private void btnPlayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPlayFocusGained
        btnPlay.setContentAreaFilled(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnPlayFocusGained

    private void btnPlayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPlayFocusLost
        btnPlay.setContentAreaFilled(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnPlayFocusLost

    private void btnPauseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPauseFocusGained
        btnPause.setContentAreaFilled(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnPauseFocusGained

    private void btnPauseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnPauseFocusLost
        btnPause.setContentAreaFilled(false);// TODO add your handling code here:
    }//GEN-LAST:event_btnPauseFocusLost

    private void btnStopFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnStopFocusGained
        btnStop.setContentAreaFilled(true);// TODO add your handling code here:
    }//GEN-LAST:event_btnStopFocusGained

    private void btnStopFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnStopFocusLost
        btnStop.setContentAreaFilled(false);
    }//GEN-LAST:event_btnStopFocusLost

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed

        if (!isPlaying) {
            playSound(actualSong);
        } else {
            if (actualSong.equals((String) songsList.getSelectedValue())) {
                resumeSound();
            } else {
                playSound(actualSong);
            }
        }

    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        if (isPlaying) {
            stopSound();
        }

    }//GEN-LAST:event_btnStopActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        pauseSound();
    }//GEN-LAST:event_btnPauseActionPerformed

    private void songsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_songsListMouseClicked
        actualSong = (String) songsList.getSelectedValue();

    }//GEN-LAST:event_songsListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAudioPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualStatus;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnStop;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList songsList;
    // End of variables declaration//GEN-END:variables

    private void personalizeGUI() {
        javax.swing.UIManager.put("Button.background", UIManager.getColor("control"));
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAudioPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void playSound(String file) {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(file).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            isPlaying = true;
            actualStatus.setText("Playing song " + new File(actualSong).getName());
            btnPause.setEnabled(true);
            btnPlay.setEnabled(false);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public void stopSound() {
        clip.stop();
        isPlaying = false;
        btnPlay.setEnabled(true);
        actualStatus.setText("Stopped");
    }

    public void pauseSound() {
        actualPosition = clip.getMicrosecondPosition();
        clip.stop();
        btnPlay.setEnabled(true);
        btnPause.setEnabled(false);
        actualStatus.setText("Paused song " + new File(actualSong).getName());
    }

    public void resumeSound() {
        clip.setMicrosecondPosition(actualPosition);
        clip.start();
        btnPlay.setEnabled(false);
        btnPause.setEnabled(true);
        actualStatus.setText("Playing song " + new File(actualSong).getName());
    }
}
