/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import constants.colorConstants;
import javax.swing.JButton;

/**
 *
 * @author tasos
 */
public class UniRecDialogView extends javax.swing.JDialog {

    /**
     * Creates new form uniRec
     */
    public UniRecDialogView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        for (var component : mainPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                view.utils.customizeButton(button, colorConstants.buttonBackgroundColor,colorConstants.buttonHoverColor);
                button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1));        
            }
        }        
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
        universityName = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        grid1 = new javax.swing.JTable();
        universityName1 = new javax.swing.JTextField();
        universityName2 = new javax.swing.JTextField();
        universityName3 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        grid3 = new javax.swing.JTable();
        universityName4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        exitBtn1 = new javax.swing.JButton();
        exitBtn2 = new javax.swing.JButton();
        universityName5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        universityName6 = new javax.swing.JTextField();
        jScrollPane10 = new javax.swing.JScrollPane();
        grid4 = new javax.swing.JTable();
        exitBtn3 = new javax.swing.JButton();
        exitBtn4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("University");

        jLabel1.setText("Name");

        jLabel2.setText("Country:");

        jLabel4.setText("Alpha-two-code:");

        jLabel7.setText("Description:");

        editBtn.setBackground(new java.awt.Color(45, 45, 48));
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/edit.png"))); // NOI18N
        editBtn.setText("Edit");
        editBtn.setAlignmentY(0.0F);
        editBtn.setFocusPainted(false);
        editBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        editBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        editBtn.setIconTextGap(32);
        editBtn.setInheritsPopupMenu(true);
        editBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        editBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        editBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        editBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        saveBtn.setBackground(new java.awt.Color(45, 45, 48));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/okIcon.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.setAlignmentY(0.0F);
        saveBtn.setFocusPainted(false);
        saveBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        saveBtn.setIconTextGap(32);
        saveBtn.setInheritsPopupMenu(true);
        saveBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        saveBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        saveBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        saveBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        exitBtn.setBackground(new java.awt.Color(45, 45, 48));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/cancel.png"))); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.setAlignmentY(0.0F);
        exitBtn.setFocusPainted(false);
        exitBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        exitBtn.setIconTextGap(32);
        exitBtn.setInheritsPopupMenu(true);
        exitBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        exitBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        exitBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        exitBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        universityName.setToolTipText(null);
        universityName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityNameFocusLost(evt);
            }
        });

        grid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        grid.setModel(new javax.swing.table.DefaultTableModel(
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
        grid.setAlignmentX(0.0F);
        grid.setAlignmentY(0.0F);
        grid.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grid.setFocusable(false);
        grid.setMinimumSize(new java.awt.Dimension(400, 600));
        grid.setRowHeight(32);
        grid.setSelectionBackground(new java.awt.Color(0, 120, 215));
        grid.setSelectionForeground(new java.awt.Color(255, 255, 255));
        grid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        grid.setShowGrid(false);
        grid.getTableHeader().setResizingAllowed(false);
        grid.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(grid);

        grid1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        grid1.setModel(new javax.swing.table.DefaultTableModel(
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
        grid1.setAlignmentX(0.0F);
        grid1.setAlignmentY(0.0F);
        grid1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        grid1.setFocusable(false);
        grid1.setMinimumSize(new java.awt.Dimension(400, 600));
        grid1.setRowHeight(32);
        grid1.setSelectionBackground(new java.awt.Color(0, 120, 215));
        grid1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        grid1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        grid1.setShowGrid(false);
        grid1.getTableHeader().setResizingAllowed(false);
        grid1.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(grid1);

        universityName1.setToolTipText(null);
        universityName1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName1FocusLost(evt);
            }
        });

        universityName2.setToolTipText(null);
        universityName2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName2FocusLost(evt);
            }
        });

        universityName3.setToolTipText(null);
        universityName3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName3FocusLost(evt);
            }
        });

        grid3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        grid3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(grid3);

        universityName4.setToolTipText(null);
        universityName4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName4FocusLost(evt);
            }
        });

        jLabel5.setText("Communication info:");

        exitBtn1.setBackground(new java.awt.Color(45, 45, 48));
        exitBtn1.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/DeleteIcon.png"))); // NOI18N
        exitBtn1.setAlignmentY(0.0F);
        exitBtn1.setFocusPainted(false);
        exitBtn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitBtn1.setIconTextGap(0);
        exitBtn1.setInheritsPopupMenu(true);
        exitBtn1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exitBtn1.setMaximumSize(new java.awt.Dimension(50, 50));
        exitBtn1.setMinimumSize(new java.awt.Dimension(50, 50));
        exitBtn1.setPreferredSize(new java.awt.Dimension(50, 50));

        exitBtn2.setBackground(new java.awt.Color(45, 45, 48));
        exitBtn2.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        exitBtn2.setAlignmentY(0.0F);
        exitBtn2.setFocusPainted(false);
        exitBtn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitBtn2.setIconTextGap(0);
        exitBtn2.setInheritsPopupMenu(true);
        exitBtn2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exitBtn2.setMaximumSize(new java.awt.Dimension(50, 50));
        exitBtn2.setMinimumSize(new java.awt.Dimension(50, 50));
        exitBtn2.setPreferredSize(new java.awt.Dimension(50, 50));

        universityName5.setToolTipText(null);
        universityName5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName5FocusLost(evt);
            }
        });

        jLabel6.setText("Communication info:");

        universityName6.setToolTipText(null);
        universityName6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityName6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityName6FocusLost(evt);
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
        jScrollPane10.setViewportView(grid4);

        exitBtn3.setBackground(new java.awt.Color(45, 45, 48));
        exitBtn3.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/DeleteIcon.png"))); // NOI18N
        exitBtn3.setAlignmentY(0.0F);
        exitBtn3.setFocusPainted(false);
        exitBtn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitBtn3.setIconTextGap(0);
        exitBtn3.setInheritsPopupMenu(true);
        exitBtn3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exitBtn3.setMaximumSize(new java.awt.Dimension(50, 50));
        exitBtn3.setMinimumSize(new java.awt.Dimension(50, 50));
        exitBtn3.setPreferredSize(new java.awt.Dimension(50, 50));

        exitBtn4.setBackground(new java.awt.Color(45, 45, 48));
        exitBtn4.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        exitBtn4.setAlignmentY(0.0F);
        exitBtn4.setFocusPainted(false);
        exitBtn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exitBtn4.setIconTextGap(0);
        exitBtn4.setInheritsPopupMenu(true);
        exitBtn4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exitBtn4.setMaximumSize(new java.awt.Dimension(50, 50));
        exitBtn4.setMinimumSize(new java.awt.Dimension(50, 50));
        exitBtn4.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(24, 24, 24)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                                    .addComponent(jScrollPane9)
                                    .addComponent(universityName5)
                                    .addComponent(universityName6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(exitBtn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(exitBtn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(exitBtn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(exitBtn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(universityName3)
                            .addComponent(universityName4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(92, 92, 92)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(universityName)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(universityName2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(universityName1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(universityName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(universityName1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(universityName2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(universityName3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(universityName4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                                .addComponent(universityName5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(exitBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel6)))
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(exitBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(42, 42, 42)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(universityName6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exitBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(120, 120, 120)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void universityNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityNameFocusGained

    private void universityNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityNameFocusLost

    private void universityName1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName1FocusGained

    private void universityName1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName1FocusLost

    private void universityName2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName2FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName2FocusGained

    private void universityName2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName2FocusLost

    private void universityName3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName3FocusGained

    private void universityName3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName3FocusLost

    private void universityName4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName4FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName4FocusGained

    private void universityName4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName4FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName4FocusLost

    private void universityName5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName5FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName5FocusGained

    private void universityName5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName5FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName5FocusLost

    private void universityName6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName6FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName6FocusGained

    private void universityName6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityName6FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityName6FocusLost

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
    private javax.swing.JButton editBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton exitBtn1;
    private javax.swing.JButton exitBtn2;
    private javax.swing.JButton exitBtn3;
    private javax.swing.JButton exitBtn4;
    private javax.swing.JTable grid;
    private javax.swing.JTable grid1;
    private javax.swing.JTable grid3;
    private javax.swing.JTable grid4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField universityName;
    private javax.swing.JTextField universityName1;
    private javax.swing.JTextField universityName2;
    private javax.swing.JTextField universityName3;
    private javax.swing.JTextField universityName4;
    private javax.swing.JTextField universityName5;
    private javax.swing.JTextField universityName6;
    // End of variables declaration//GEN-END:variables
}
