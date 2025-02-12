package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import static view.Utils.customizeButtonsInsidePanel;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
public class MainView extends javax.swing.JFrame {
    /**
     * Creates the main dashboard
     */
    public MainView() {
        initComponents();
        for (var component : this.sidePanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 24, 1, 24));   
            }
        }
        customizeButtonsInsidePanel(this.sidePanel);
    }
    
    public void addPanel(JPanel panel){
        this.mainPanel.add(panel);
        this.revalidate();
        this.repaint();
    }

    public void removePanel(JPanel panel){
        this.mainPanel.remove(panel);
        this.revalidate();
        this.repaint();
    }
    
    public void addUniBtnListener(ActionListener listener){
        uniBtn.addActionListener(listener);
    }

    public void addExitBtnListener(ActionListener listener){
        exitBtn.addActionListener(listener);
    }
    
    public void addAboutBtnListener(ActionListener listener){
        aboutBtn.addActionListener(listener);
    }    

    public void addSettingsBtnListener(ActionListener listener){
        settingsBtn.addActionListener(listener);
    }    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        uniBtn = new javax.swing.JButton();
        statisticsBtn = new javax.swing.JButton();
        settingsBtn = new javax.swing.JButton();
        aboutBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setLocation(new java.awt.Point(0, 0));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setName("mainFrame"); // NOI18N

        sidePanel.setBackground(new java.awt.Color(0, 122, 204));
        sidePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        sidePanel.setAlignmentX(0.0F);
        sidePanel.setAlignmentY(0.0F);
        sidePanel.setMinimumSize(new java.awt.Dimension(200, 457));
        sidePanel.setPreferredSize(new java.awt.Dimension(200, 457));

        jPanel1.setBackground(new java.awt.Color(0, 122, 204));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(0, 122, 204));
        jLabel1.setFont(new java.awt.Font("Dubai", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("University App");
        jLabel1.setAlignmentY(0.0F);
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        uniBtn.setBackground(new java.awt.Color(0, 122, 204));
        uniBtn.setForeground(new java.awt.Color(255, 255, 255));
        uniBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/uni.png"))); // NOI18N
        uniBtn.setText("Universities");
        uniBtn.setAlignmentY(0.0F);
        uniBtn.setFocusPainted(false);
        uniBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        uniBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        uniBtn.setIconTextGap(32);
        uniBtn.setInheritsPopupMenu(true);
        uniBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        uniBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        statisticsBtn.setBackground(new java.awt.Color(0, 122, 204));
        statisticsBtn.setForeground(new java.awt.Color(255, 255, 255));
        statisticsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/stats.png"))); // NOI18N
        statisticsBtn.setText("Statistics");
        statisticsBtn.setFocusPainted(false);
        statisticsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        statisticsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        statisticsBtn.setIconTextGap(32);
        statisticsBtn.setInheritsPopupMenu(true);
        statisticsBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        statisticsBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        settingsBtn.setBackground(new java.awt.Color(0, 122, 204));
        settingsBtn.setForeground(new java.awt.Color(255, 255, 255));
        settingsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/settings.png"))); // NOI18N
        settingsBtn.setText("Settings");
        settingsBtn.setFocusPainted(false);
        settingsBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        settingsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        settingsBtn.setIconTextGap(32);
        settingsBtn.setInheritsPopupMenu(true);
        settingsBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        settingsBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        aboutBtn.setBackground(new java.awt.Color(0, 122, 204));
        aboutBtn.setForeground(new java.awt.Color(255, 255, 255));
        aboutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/info.png"))); // NOI18N
        aboutBtn.setText("About");
        aboutBtn.setFocusPainted(false);
        aboutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        aboutBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        aboutBtn.setIconTextGap(32);
        aboutBtn.setInheritsPopupMenu(true);
        aboutBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        aboutBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        exitBtn.setBackground(new java.awt.Color(0, 122, 204));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/logout.png"))); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.setFocusPainted(false);
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        exitBtn.setIconTextGap(32);
        exitBtn.setInheritsPopupMenu(true);
        exitBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        exitBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statisticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uniBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aboutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uniBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statisticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settingsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(sidePanel, java.awt.BorderLayout.LINE_START);

        mainPanel.setBackground(new java.awt.Color(240, 240, 240));
        mainPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aboutBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton settingsBtn;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JButton statisticsBtn;
    private javax.swing.JButton uniBtn;
    // End of variables declaration//GEN-END:variables
}
