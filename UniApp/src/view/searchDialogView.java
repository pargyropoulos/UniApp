/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
public class searchDialogView extends javax.swing.JDialog {
    private String[] countriesArray={"","Afghanistan","Albania","Algeria","Andorra","Angola","Antigua and Barbuda","Argentina","Armenia","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia, Plurinational State of","Bosnia and Herzegovina","Botswana","Brazil","Brunei Darussalam","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central African Republic","Chad","Chile","China","Colombia","Congo","Congo, the Democratic Republic of the","Costa Rica","Côte d'Ivoire","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Faroe Islands","Fiji","Finland","France","French Guiana","French Polynesia","Gabon","Gambia","Georgia","Germany","Ghana","Greece","Greenland","Grenada","Guadeloupe","Guam","Guatemala","Guinea","Guyana","Haiti","Holy See (Vatican City State)","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Israel","Italy","Jamaica","Japan","Jordan","Kazakhstan","Kenya","Korea, Democratic People's Republic of","Korea, Republic of","Kosovo","Kuwait","Kyrgyzstan","Lao People's Democratic Republic","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macao","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Mauritania","Mauritius","Mexico","Moldova, Republic of","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nepal","Netherlands","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","Niue","North Macedonia","Norway","Oman","Pakistan","Palestine, State of","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Réunion","Romania","Russian Federation","Rwanda","Saint Kitts and Nevis","Saint Lucia","Saint Vincent and the Grenadines","Samoa","San Marino","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syrian Arab Republic","Taiwan, Province of China","Tajikistan","Tanzania, United Republic of","Thailand","Togo","Trinidad and Tobago","Tunisia","Turkey","Turkmenistan","Turks and Caicos Islands","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States","Uruguay","Uzbekistan","Venezuela, Bolivarian Republic of","Viet Nam","Vietnam","Virgin Islands, British","Yemen","Zambia","Zimbabwe"};

    public void addSearchBtnActionListener(ActionListener listener){
        searchBtn.addActionListener(listener);
    }
    public void addCancelBtnActionListener(ActionListener listener){
        cancelBtn.addActionListener(listener);
    }
    
    public void addUniversityNameTextBoxActionListener(ActionListener listener){
        universityName.addActionListener(listener);
    }    
    
    public void addUniversityNameTextBoxFocusListener(FocusListener listener){
        universityName.addFocusListener(listener);
    }
    
    public void addCountryComboBoxFocusListener(FocusListener listener){
        countryComboBox.addFocusListener(listener);
    }
    
    public String getUniversityName(){
        return this.universityName.getText();
    }
    
    public String getCountry(){
        return this.countryComboBox.getSelectedItem().toString();
    }

    public void setErrorLabelVisible(Boolean visibility){
        universityNameErrorLabel.setVisible(visibility);
    }

    public void setInfoLabelVisible(Boolean visibility){
        infoLabel.setVisible(visibility);
    }    
   
    public void setInfoLabelText(String text){
        infoLabel.setText(text);
    }     
    
    /**
     * Creates new form searchDialogVidew
     * @param parent
     * @param modal
     */
    public searchDialogView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        universityNameErrorLabel.setVisible(false);
        infoLabel.setVisible(false);
        //customize buttons to change color on hover event
        for (var component : mainPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                view.utils.customizeButton(button, new Color(0, 122, 204), new Color(45, 45, 48));
                button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1));        
            }
        }
        for (var item: countriesArray){
            countryComboBox.addItem(item);
        }

        countryComboBox.setRenderer(new view.utils.CustomComboBoxRenderer());
        
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
        universityName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        universityNameErrorLabel = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        countryComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        universityName.setToolTipText(null);
        universityName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityNameFocusLost(evt);
            }
        });

        jLabel1.setText("University Name:");

        jLabel2.setText("University Country:");

        searchBtn.setBackground(new java.awt.Color(45, 45, 48));
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/search.png"))); // NOI18N
        searchBtn.setText("Search");
        searchBtn.setAlignmentY(0.0F);
        searchBtn.setFocusPainted(false);
        searchBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        searchBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        searchBtn.setIconTextGap(32);
        searchBtn.setInheritsPopupMenu(true);
        searchBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        searchBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        searchBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        searchBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        cancelBtn.setBackground(new java.awt.Color(45, 45, 48));
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/cancel.png"))); // NOI18N
        cancelBtn.setText("Close");
        cancelBtn.setAlignmentY(0.0F);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        cancelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        cancelBtn.setIconTextGap(32);
        cancelBtn.setInheritsPopupMenu(true);
        cancelBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        cancelBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        cancelBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        cancelBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        universityNameErrorLabel.setForeground(new java.awt.Color(255, 0, 0));
        universityNameErrorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/error.png"))); // NOI18N

        infoLabel.setText("info text label....");

        countryComboBox.setBackground(new java.awt.Color(255, 255, 255));
        countryComboBox.setForeground(new java.awt.Color(0, 0, 0));
        countryComboBox.setBorder(null);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(universityName, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                            .addComponent(countryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(infoLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(universityNameErrorLabel)
                .addGap(15, 15, 15))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(universityName, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(universityNameErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(countryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(infoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void universityNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityNameFocusLost

    private void universityNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityNameFocusGained



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox<String> countryComboBox;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField universityName;
    private javax.swing.JLabel universityNameErrorLabel;
    // End of variables declaration//GEN-END:variables
}
