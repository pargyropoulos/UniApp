/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import constants.ColorConstants;
import java.awt.Desktop;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.JButton;
import utils.CustomEventSource;
import static view.Utils.customizeButton;
import static view.Utils.customizeButtonsInsidePanel;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
public class AboutView extends javax.swing.JPanel {
    /**
     * Creates new form About
     */
    public AboutView() {
        initComponents();
        closelBtn.setBackground(ColorConstants.buttonBackgroundColor);
        closelBtn.setForeground(ColorConstants.buttonForegroundColor);
        customizeButtonsInsidePanel(this.mainPanel);     
    }

    public void addCloseButtonListener(ActionListener listener) {
        closelBtn.addActionListener(listener);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        closelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panagiotisLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        panagiotisLabel1 = new javax.swing.JLabel();
        constantinaLabel = new javax.swing.JLabel();
        tasosLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        closelBtn.setBackground(new java.awt.Color(45, 45, 48));
        closelBtn.setForeground(new java.awt.Color(255, 255, 255));
        closelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/cancel.png"))); // NOI18N
        closelBtn.setText("Close");
        closelBtn.setAlignmentY(0.0F);
        closelBtn.setFocusPainted(false);
        closelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        closelBtn.setIconTextGap(32);
        closelBtn.setInheritsPopupMenu(true);
        closelBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        closelBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        closelBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        closelBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Argyropoulos Panagiotis");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("University App");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/eap.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Al Fadel Konstantina");

        panagiotisLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panagiotisLabel.setText("<html>(<a href='mailto:pargyropoulos@gmail.com' style='color: blue; text-decoration: underline;'>pargyropoulos@gmail.com</a>)</html> ");
        panagiotisLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panagiotisLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panagiotisLabelMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Botsialas Athanasios");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Scrum Master:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Scrum Team:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("HOU - Computer Science - 2024-25");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Argyropoulos Panagiotis");

        panagiotisLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panagiotisLabel1.setText("<html>(<a href='mailto:pargyropoulos@gmail.com' style='color: blue; text-decoration: underline;'>pargyropoulos@gmail.com</a>)</html> ");
        panagiotisLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panagiotisLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panagiotisLabel1MouseClicked(evt);
            }
        });

        constantinaLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        constantinaLabel.setText("<html>(<a href='mailto:k.al.fantel@gmail.com' style='color: blue; text-decoration: underline;'>k.al.fantel@gmail.com</a>)</html> ");
        constantinaLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        constantinaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                constantinaLabelMouseClicked(evt);
            }
        });

        tasosLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tasosLabel.setText("<html>(<a href='mailto:botsialas.a@gmail.com' style='color: blue; text-decoration: underline;'>botsialas.a@gmail.com</a>)</html> ");
        tasosLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tasosLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tasosLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)
                        .addComponent(closelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panagiotisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panagiotisLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(constantinaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tasosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(constantinaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(panagiotisLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tasosLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(panagiotisLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(closelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panagiotisLabel.getAccessibleContext().setAccessibleName("<html><a href='' style='color: blue; text-decoration: underline;'>Click here to visit Google</a></html> ");
        panagiotisLabel.getAccessibleContext().setAccessibleDescription("<html><a href='' style='color: blue; text-decoration: underline;'>Click here to visit Google</a></html> ");

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void panagiotisLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panagiotisLabelMouseClicked
        try {
            Desktop.getDesktop().mail(new URI("mailto:pargyropoulos@gmail.com"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_panagiotisLabelMouseClicked

    private void panagiotisLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panagiotisLabel1MouseClicked
        panagiotisLabelMouseClicked(evt);
    }//GEN-LAST:event_panagiotisLabel1MouseClicked

    private void constantinaLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_constantinaLabelMouseClicked
        try {
            Desktop.getDesktop().mail(new URI("mailto:k.al.fantel@gmail.com"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_constantinaLabelMouseClicked

    private void tasosLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tasosLabelMouseClicked
        try {
            Desktop.getDesktop().mail(new URI("mailto:botsialas.a@gmail.com"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_tasosLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closelBtn;
    private javax.swing.JLabel constantinaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel panagiotisLabel;
    private javax.swing.JLabel panagiotisLabel1;
    private javax.swing.JLabel tasosLabel;
    // End of variables declaration//GEN-END:variables
}
