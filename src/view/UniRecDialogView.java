/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import javax.swing.JButton;
import constants.ColorConstants;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import HTTP.WebData;
import static view.Utils.customizeButtonsInsidePanel;
/**
 *
 * @author tasos
 */
public class UniRecDialogView extends javax.swing.JDialog {

    /**
     * Creates new form uniRec
     *
     * @param parent
     * @param modal
     */
    public UniRecDialogView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        customizeButtonsInsidePanel(this.mainPanel);

    }

    public void addExitButtonListener(ActionListener listener) {
        exitBtn.addActionListener(listener);
    }

    public void setUniversityData(WebData universityData) {
        if (universityData != null) {
            universityName.setText(universityData.getName());
//            universityName.setEditable(false);
            // ισως να του αλλάξω χρώμα
            //universityName.setBackground(Color.LIGHT_GRAY);
//            universityName.setBorder(null);


            universityName2.setText(universityData.getCountry());
//            universityName2.setEditable(false);
//            universityName2.setBorder(null);

            universityName1.setText(universityData.getAlpha_two_code());
//            universityName1.setEditable(false);
//            universityName1.setBorder(null);
            //universityName3.setText(universityData.getDescription());  // Αν υπάρχει πεδίο περιγραφής
        }
    }

    
    // Για να γεμίσει το Grid -> gridDomains
    public void populateDomainsGrid(List<String> domains) {
        // Ελέγχω αν η λίστα είναι κενή - ίσως να μην χρειαζεται, η τροποποιηση 
        // για εμφάνιση μήνυμα λάθους
        if (domains == null || domains.isEmpty()) {
            System.out.println("No domains to display.");
            return;
        }
        // Παίρνουμε το μοντέλο του πίνακα
        DefaultTableModel model = (DefaultTableModel) gridDomains.getModel();
        // Καθαρίζουμε τα προηγούμενα δεδομένα του πίνακα
        model.setRowCount(0);
        // Προσθέτουμε κάθε domain ως νέα γραμμή στον πίνακα
        for (String domain : domains) {
            model.addRow(new Object[]{domain});
        }

    }

    // Όμοια για grid -> gridWebPages
    public void populateWebPagesGrid(List<String> webPages) {
        if (webPages == null || webPages.isEmpty()) {
            System.out.println("No Web Pages  to display.");
            return;
        }

        // Παίρνουμε το μοντέλο του πίνακα
        DefaultTableModel model = (DefaultTableModel) gridWebPages.getModel();
        // Καθαρίζουμε τα προηγούμενα δεδομένα του πίνακα
        model.setRowCount(0);
        // Προσθέτουμε κάθε domain ως νέα γραμμή στον πίνακα
        for (String webPage : webPages) {
            model.addRow(new Object[]{webPage});
        }

    }

    public void setDescriptionField(String description) {
        if (description != null) {
            uniDescrTextField.setText(description);
        } else {
            uniDescrTextField.setText("No description available");
        }

    }

    public void setInfoField(String info) {
        if (info != null) {
            uniInfoTextField.setText(info);
        } else {
            uniInfoTextField.setText("No info available");
        }

    }

    public void populateSchoolsGrid(List<String> schools) {
        if (schools == null || schools.isEmpty()) {
            System.out.println("No schools to display.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) grid3.getModel();
        model.setRowCount(0); // Καθαρίζουμε τον πίνακα

        for (String school : schools) {
            model.addRow(new Object[]{school});
        }
    }

    public String getSelectedSchool() {
        int selectedRow = grid3.getSelectedRow();
        if (selectedRow != -1) {
            return grid3.getValueAt(selectedRow, 0).toString();
        }
        return null; // Αν δεν έχει επιλεγεί γραμμή, επιστρέφουμε null
    }

    public void addDeleteSchoolButtonListener(ActionListener listener) {
        delBtnSchools.addActionListener(listener);
    }

    public String getDescriptionText() {
        return uniDescrTextField.getText();
    }

    public String getInfoText() {
        return uniInfoTextField.getText();
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveBtn.addActionListener(listener);
    }

    public String getSchoolText() {
        return schoolsTextField.getText().trim();
    }

    public void clearSchoolTextField() {
        schoolsTextField.setText("");
    }

    public void addAddSchoolButtonListener(ActionListener listener) {
        addBtnSchools.addActionListener(listener);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        gridWebPages = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        gridDomains = new javax.swing.JTable();
        universityName1 = new javax.swing.JTextField();
        universityName2 = new javax.swing.JTextField();
        uniDescrTextField = new javax.swing.JTextField();
        schoolsScrol = new javax.swing.JScrollPane();
        grid3 = new javax.swing.JTable();
        uniInfoTextField = new javax.swing.JTextField();
        infoLabel = new javax.swing.JLabel();
        addBtnSchools = new javax.swing.JButton();
        delBtnSchools = new javax.swing.JButton();
        schoolsTextField = new javax.swing.JTextField();
        addBtnDepart = new javax.swing.JButton();
        delBtnDepart = new javax.swing.JButton();
        departTextField = new javax.swing.JTextField();
        departScrol = new javax.swing.JScrollPane();
        grid4 = new javax.swing.JTable();
        universityName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("University");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Name:");

        jLabel2.setText("Country:");

        jLabel4.setText("Alpha-two-code:");

        jLabel7.setText("Description:");

        editBtn.setBackground(new java.awt.Color(45, 45, 48));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));

        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/edit_cancel.png"))); // NOI18N
        editBtn.setText("Edit");
        editBtn.setAlignmentY(0.0F);
        editBtn.setFocusPainted(false);
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        editBtn.setIconTextGap(32);
        editBtn.setInheritsPopupMenu(true);
        editBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        editBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        editBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        editBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        saveBtn.setBackground(new java.awt.Color(45, 45, 48));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/okIcon.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.setAlignmentY(0.0F);
        saveBtn.setFocusPainted(false);
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        saveBtn.setIconTextGap(32);
        saveBtn.setInheritsPopupMenu(true);
        saveBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        saveBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        saveBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        saveBtn.setPreferredSize(new java.awt.Dimension(200, 50));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(45, 45, 48));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/logout.png"))); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.setAlignmentY(0.0F);
        exitBtn.setFocusPainted(false);
        exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        exitBtn.setIconTextGap(32);
        exitBtn.setInheritsPopupMenu(true);
        exitBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exitBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        exitBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        exitBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        universityName.setToolTipText(null);
        universityName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        universityName.setEnabled(false);
        universityName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityNameFocusLost(evt);
            }
        });

        gridWebPages.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridWebPages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                "Web Pages"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridWebPages.setAlignmentX(0.0F);
        gridWebPages.setAlignmentY(0.0F);
        gridWebPages.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridWebPages.setFocusable(false);
        gridWebPages.setMinimumSize(new java.awt.Dimension(400, 600));
        gridWebPages.setRowHeight(32);
        gridWebPages.setSelectionBackground(new java.awt.Color(0, 120, 215));
        gridWebPages.setSelectionForeground(new java.awt.Color(255, 255, 255));
        gridWebPages.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gridWebPages.setShowGrid(false);
        gridWebPages.getTableHeader().setResizingAllowed(false);
        gridWebPages.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(gridWebPages);

        gridDomains.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridDomains.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null}
            },
            new String [] {
                "Domains"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gridDomains.setAlignmentX(0.0F);
        gridDomains.setAlignmentY(0.0F);
        gridDomains.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        gridDomains.setFocusable(false);
        gridDomains.setMinimumSize(new java.awt.Dimension(400, 600));
        gridDomains.setRowHeight(32);
        gridDomains.setSelectionBackground(new java.awt.Color(0, 120, 215));
        gridDomains.setSelectionForeground(new java.awt.Color(255, 255, 255));
        gridDomains.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gridDomains.setShowGrid(false);
        gridDomains.getTableHeader().setResizingAllowed(false);
        gridDomains.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(gridDomains);
        if (gridDomains.getColumnModel().getColumnCount() > 0) {
            gridDomains.getColumnModel().getColumn(0).setHeaderValue("Domains");
        }

        universityName1.setBackground(new java.awt.Color(60, 63, 65));
        universityName1.setToolTipText(null);
        universityName1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        universityName1.setEnabled(false);
        universityName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName1FocusLost(evt);
            }
        });

        universityName2.setBackground(new java.awt.Color(60, 63, 65));
        universityName2.setToolTipText(null);
        universityName2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        universityName2.setEnabled(false);
        universityName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName2FocusLost(evt);
            }
        });

        uniDescrTextField.setToolTipText(null);
        uniDescrTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uniDescrTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                uniDescrTextFieldFocusLost(evt);
            }
        });

        grid3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        grid3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null}
            },
            new String [] {
                "Schools"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grid3.setAlignmentX(0.0F);
        grid3.setAlignmentY(0.0F);
        grid3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grid3.setFocusable(false);
        grid3.setMinimumSize(new java.awt.Dimension(400, 600));
        grid3.setRowHeight(32);
        grid3.setSelectionBackground(new java.awt.Color(0, 120, 215));
        grid3.setSelectionForeground(new java.awt.Color(255, 255, 255));
        grid3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        grid3.setShowGrid(false);
        grid3.getTableHeader().setResizingAllowed(false);
        grid3.getTableHeader().setReorderingAllowed(false);
        schoolsScrol.setViewportView(grid3);

        uniInfoTextField.setToolTipText(null);
        uniInfoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                uniInfoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                uniInfoTextFieldFocusLost(evt);
            }
        });

        infoLabel.setText("Info:");

        addBtnSchools.setBackground(new java.awt.Color(45, 45, 48));
        addBtnSchools.setForeground(new java.awt.Color(255, 255, 255));
        addBtnSchools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        addBtnSchools.setAlignmentY(0.0F);
        addBtnSchools.setFocusPainted(false);
        addBtnSchools.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtnSchools.setIconTextGap(0);
        addBtnSchools.setInheritsPopupMenu(true);
        addBtnSchools.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addBtnSchools.setMaximumSize(new java.awt.Dimension(50, 50));
        addBtnSchools.setMinimumSize(new java.awt.Dimension(50, 50));
        addBtnSchools.setPreferredSize(new java.awt.Dimension(50, 50));

        delBtnSchools.setBackground(new java.awt.Color(45, 45, 48));
        delBtnSchools.setForeground(new java.awt.Color(255, 255, 255));
        delBtnSchools.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/delete.png"))); // NOI18N
        delBtnSchools.setAlignmentY(0.0F);
        delBtnSchools.setFocusPainted(false);
        delBtnSchools.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delBtnSchools.setIconTextGap(0);
        delBtnSchools.setInheritsPopupMenu(true);
        delBtnSchools.setMargin(new java.awt.Insets(0, 0, 0, 0));
        delBtnSchools.setMaximumSize(new java.awt.Dimension(50, 50));
        delBtnSchools.setMinimumSize(new java.awt.Dimension(50, 50));
        delBtnSchools.setPreferredSize(new java.awt.Dimension(50, 50));
        delBtnSchools.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnSchoolsActionPerformed(evt);
            }
        });

        schoolsTextField.setToolTipText(null);
        schoolsTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                schoolsTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                schoolsTextFieldFocusLost(evt);
            }
        });

        addBtnDepart.setBackground(new java.awt.Color(45, 45, 48));
        addBtnDepart.setForeground(new java.awt.Color(255, 255, 255));
        addBtnDepart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        addBtnDepart.setAlignmentY(0.0F);
        addBtnDepart.setEnabled(false);
        addBtnDepart.setFocusPainted(false);
        addBtnDepart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBtnDepart.setIconTextGap(0);
        addBtnDepart.setInheritsPopupMenu(true);
        addBtnDepart.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addBtnDepart.setMaximumSize(new java.awt.Dimension(50, 50));
        addBtnDepart.setMinimumSize(new java.awt.Dimension(50, 50));
        addBtnDepart.setPreferredSize(new java.awt.Dimension(50, 50));

        delBtnDepart.setBackground(new java.awt.Color(45, 45, 48));
        delBtnDepart.setForeground(new java.awt.Color(255, 255, 255));
        delBtnDepart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/delete.png"))); // NOI18N
        delBtnDepart.setAlignmentY(0.0F);
        delBtnDepart.setEnabled(false);
        delBtnDepart.setFocusPainted(false);
        delBtnDepart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delBtnDepart.setIconTextGap(0);
        delBtnDepart.setInheritsPopupMenu(true);
        delBtnDepart.setMargin(new java.awt.Insets(0, 0, 0, 0));
        delBtnDepart.setMaximumSize(new java.awt.Dimension(50, 50));
        delBtnDepart.setMinimumSize(new java.awt.Dimension(50, 50));
        delBtnDepart.setPreferredSize(new java.awt.Dimension(50, 50));

        departTextField.setToolTipText(null);
        departTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                departTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                departTextFieldFocusLost(evt);
            }
        });

        grid4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        grid4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Departments"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grid4.setAlignmentX(0.0F);
        grid4.setAlignmentY(0.0F);
        grid4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grid4.setFocusable(false);
        grid4.setMinimumSize(new java.awt.Dimension(400, 600));
        grid4.setRowHeight(32);
        grid4.setSelectionBackground(new java.awt.Color(0, 120, 215));
        grid4.setSelectionForeground(new java.awt.Color(255, 255, 255));
        grid4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        grid4.setShowGrid(false);
        grid4.getTableHeader().setResizingAllowed(false);
        grid4.getTableHeader().setReorderingAllowed(false);
        departScrol.setViewportView(grid4);

        universityName.setBackground(new java.awt.Color(60, 63, 65));
        universityName.setToolTipText(null);
        universityName.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        universityName.setEnabled(false);
        universityName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityNameFocusLost(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addBtnSchools, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delBtnSchools, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(schoolsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(departTextField))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(schoolsScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(departScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addBtnDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delBtnDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(universityName2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(universityName1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(universityName)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(infoLabel)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(uniDescrTextField)
                                    .addComponent(uniInfoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(universityName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(universityName1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(universityName2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uniDescrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uniInfoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoLabel))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(schoolsScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                    .addComponent(departScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(13, 13, 13)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(departTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(schoolsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(delBtnSchools, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(addBtnSchools, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(delBtnDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(addBtnDepart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uniInfoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uniInfoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_uniInfoTextFieldFocusLost

    private void uniInfoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uniInfoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_uniInfoTextFieldFocusGained

    private void uniDescrTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uniDescrTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_uniDescrTextFieldFocusLost

    private void uniDescrTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_uniDescrTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_uniDescrTextFieldFocusGained

    private void universityName2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName2FocusLost

    private void universityName2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName2FocusGained

    private void universityName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName1FocusLost

    private void universityName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName1FocusGained


    private void universityNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityNameFocusLost

    private void universityNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityNameFocusGained

    private void schoolsTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_schoolsTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_schoolsTextFieldFocusGained

    private void schoolsTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_schoolsTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_schoolsTextFieldFocusLost

    private void departTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_departTextFieldFocusGained

    private void departTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_departTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_departTextFieldFocusLost

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveBtnActionPerformed


    private void delBtnSchoolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnSchoolsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delBtnSchoolsActionPerformed



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
            java.util.logging.Logger.getLogger(UniRecDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UniRecDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UniRecDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UniRecDialogView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UniRecDialogView dialog = new UniRecDialogView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtnDepart;
    private javax.swing.JButton addBtnSchools;
    private javax.swing.JButton delBtnDepart;
    private javax.swing.JButton delBtnSchools;
    private javax.swing.JScrollPane departScrol;
    private javax.swing.JTextField departTextField;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JTable grid3;
    private javax.swing.JTable grid4;
    private javax.swing.JTable gridDomains;
    private javax.swing.JTable gridWebPages;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JScrollPane schoolsScrol;
    private javax.swing.JTextField schoolsTextField;
    private javax.swing.JTextField uniDescrTextField;
    private javax.swing.JTextField uniInfoTextField;
    private javax.swing.JTextField universityName;
    private javax.swing.JTextField universityName1;
    private javax.swing.JTextField universityName2;
    // End of variables declaration//GEN-END:variables
}
