package view;


import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import HTTP.WebData;
import java.util.ArrayList;
import repository.entities.Department;
import repository.entities.School;
import utils.CustomEventSource;
import utils.ICustomEventListener;
import static view.Utils.customizeButtonsInsidePanel;

public class UniRecDialogView extends javax.swing.JDialog {
        
    private final CustomEventSource<Integer> currentSchoolEventSource = new CustomEventSource<>();
    private final CustomEventSource<Integer> currentDepartmentEventSource = new CustomEventSource<>();
    
    public void addcurrentSchoolEventSourceEventListener (ICustomEventListener<Integer> listener){
        currentSchoolEventSource.addEventListener(listener);
    }    
    public void addcurrentDepartmentEventSourceEventListener (ICustomEventListener<Integer> listener){
        currentDepartmentEventSource.addEventListener(listener);
    }    

    public int getSelectedSchoolRowIndex() {
        return this.schoolGrid.getSelectedRow();     
    }
    
    public int getSelectedDepartmentRowIndex(){
        return this.departmentGrid.getSelectedRow();     
    }
    
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
            universityNameTextBox.setText(universityData.getName());
            countryTextBox.setText(universityData.getCountry());
            alphaCodeTextBox.setText(universityData.getAlpha_two_code());
        }
    }

    
    // Για να γεμίσει το Grid -> gridDomains
    public void populateDomainsGrid(List<String> domains) {
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
        } 
    }

    public void setInfoField(String info) {
        if (info != null) {
            uniInfoTextField.setText(info);
        }
    }

    public void populateSchoolsGrid(List<School> list) {
        DefaultTableModel model = (DefaultTableModel) schoolGrid.getModel();
        model.setRowCount(0); // Καθαρίζουμε τον πίνακα
        if (list == null || list.isEmpty()){
            populateDepartmentGrid(new ArrayList<Department>()) ;
        }else {
            for (var item : list) {
                model.addRow(new Object[]{item.getName()});
            }
            populateDepartmentGrid(new ArrayList<Department>()) ;
        }        
        this.revalidate();
        this.repaint();;
    }

    public void populateDepartmentGrid(List<Department> list) {
        DefaultTableModel model = (DefaultTableModel) departmentGrid.getModel();
        model.setRowCount(0); // Καθαρίζουμε τον πίνακα

        if (list == null || list.isEmpty()) {
        }else{
            for (var item : list) {
                model.addRow(new Object[]{item.getName()});
            }
        }
        this.revalidate();
        this.repaint();;        
    }    
    
    public String getSelectedSchool() {
        int selectedRow = schoolGrid.getSelectedRow();
        if (selectedRow != -1) {
            return schoolGrid.getValueAt(selectedRow, 0).toString();
        }
        return null; // Αν δεν έχει επιλεγεί γραμμή, επιστρέφουμε null
    }

    public void addDeleteSchoolButtonListener(ActionListener listener) {
        delSchoolsBtn.addActionListener(listener);
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
        return schoolTextField.getText().trim();
    }

    public String getDepartmentText() {
        return departmentTextField.getText().trim();
    }

    public void setSchoolTextField(String text) {
        schoolTextField.setText(text);
    }

    public void setDepartmentTextField(String text) {
        departmentTextField.setText(text);
    }

    public void addInsertSchoolButtonListener(ActionListener listener) {
        addSchoolsBtn.addActionListener(listener);
    }

    public void addInsertDepartmentButtonListener(ActionListener listener) {
        addDepartmentBtn.addActionListener(listener);
    }
    
    public void addDeleteDepartmentButtonListener(ActionListener listener) {
        delDepartmentBtn.addActionListener(listener);
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
        saveBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        universityNameTextBox = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        gridWebPages = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        gridDomains = new javax.swing.JTable();
        alphaCodeTextBox = new javax.swing.JTextField();
        countryTextBox = new javax.swing.JTextField();
        uniDescrTextField = new javax.swing.JTextField();
        schoolsScrol = new javax.swing.JScrollPane();
        schoolGrid = new javax.swing.JTable();
        uniInfoTextField = new javax.swing.JTextField();
        infoLabel = new javax.swing.JLabel();
        addSchoolsBtn = new javax.swing.JButton();
        delSchoolsBtn = new javax.swing.JButton();
        schoolTextField = new javax.swing.JTextField();
        addDepartmentBtn = new javax.swing.JButton();
        delDepartmentBtn = new javax.swing.JButton();
        departmentTextField = new javax.swing.JTextField();
        departScrol = new javax.swing.JScrollPane();
        departmentGrid = new javax.swing.JTable();
        universityName3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("University");
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        mainPanel.setAlignmentX(0.0F);

        jLabel1.setText("Name:");

        jLabel2.setText("Country:");

        jLabel4.setText("Alpha-two-code:");

        jLabel7.setText("Description:");

        saveBtn.setBackground(new java.awt.Color(45, 45, 48));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/save.png"))); // NOI18N
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

        exitBtn.setBackground(new java.awt.Color(45, 45, 48));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/cancel.png"))); // NOI18N
        exitBtn.setText("Close");
        exitBtn.setAlignmentY(0.0F);
        exitBtn.setFocusPainted(false);
        exitBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        exitBtn.setIconTextGap(32);
        exitBtn.setInheritsPopupMenu(true);
        exitBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        exitBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        exitBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        exitBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        universityNameTextBox.setToolTipText(null);
        universityNameTextBox.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        universityNameTextBox.setEnabled(false);

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
        gridWebPages.setRowSelectionAllowed(false);
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
        gridDomains.setRowSelectionAllowed(false);
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

        alphaCodeTextBox.setToolTipText(null);
        alphaCodeTextBox.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        alphaCodeTextBox.setEnabled(false);

        countryTextBox.setToolTipText(null);
        countryTextBox.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        countryTextBox.setEnabled(false);

        uniDescrTextField.setToolTipText(null);

        schoolGrid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        schoolGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        schoolGrid.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        schoolGrid.setFocusable(false);
        schoolGrid.setMinimumSize(new java.awt.Dimension(400, 600));
        schoolGrid.setRowHeight(32);
        schoolGrid.setSelectionBackground(new java.awt.Color(0, 120, 215));
        schoolGrid.setSelectionForeground(new java.awt.Color(255, 255, 255));
        schoolGrid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        schoolGrid.setShowGrid(false);
        schoolGrid.getTableHeader().setResizingAllowed(false);
        schoolGrid.getTableHeader().setReorderingAllowed(false);
        schoolGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schoolGridMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                schoolGridMousePressed(evt);
            }
        });
        schoolsScrol.setViewportView(schoolGrid);

        uniInfoTextField.setToolTipText(null);

        infoLabel.setText("Info:");

        addSchoolsBtn.setBackground(new java.awt.Color(45, 45, 48));
        addSchoolsBtn.setForeground(new java.awt.Color(255, 255, 255));
        addSchoolsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        addSchoolsBtn.setAlignmentY(0.0F);
        addSchoolsBtn.setFocusPainted(false);
        addSchoolsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addSchoolsBtn.setIconTextGap(0);
        addSchoolsBtn.setInheritsPopupMenu(true);
        addSchoolsBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addSchoolsBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        addSchoolsBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        addSchoolsBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        delSchoolsBtn.setBackground(new java.awt.Color(45, 45, 48));
        delSchoolsBtn.setForeground(new java.awt.Color(255, 255, 255));
        delSchoolsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/delete.png"))); // NOI18N
        delSchoolsBtn.setAlignmentY(0.0F);
        delSchoolsBtn.setFocusPainted(false);
        delSchoolsBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delSchoolsBtn.setIconTextGap(0);
        delSchoolsBtn.setInheritsPopupMenu(true);
        delSchoolsBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        delSchoolsBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        delSchoolsBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        delSchoolsBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        schoolTextField.setToolTipText(null);

        addDepartmentBtn.setBackground(new java.awt.Color(45, 45, 48));
        addDepartmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        addDepartmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        addDepartmentBtn.setAlignmentY(0.0F);
        addDepartmentBtn.setFocusPainted(false);
        addDepartmentBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addDepartmentBtn.setIconTextGap(0);
        addDepartmentBtn.setInheritsPopupMenu(true);
        addDepartmentBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addDepartmentBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        addDepartmentBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        addDepartmentBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        delDepartmentBtn.setBackground(new java.awt.Color(45, 45, 48));
        delDepartmentBtn.setForeground(new java.awt.Color(255, 255, 255));
        delDepartmentBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/delete.png"))); // NOI18N
        delDepartmentBtn.setAlignmentY(0.0F);
        delDepartmentBtn.setFocusPainted(false);
        delDepartmentBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delDepartmentBtn.setIconTextGap(0);
        delDepartmentBtn.setInheritsPopupMenu(true);
        delDepartmentBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        delDepartmentBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        delDepartmentBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        delDepartmentBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        departmentTextField.setToolTipText(null);
        departmentTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmentTextFieldMouseClicked(evt);
            }
        });

        departmentGrid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        departmentGrid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        departmentGrid.setAlignmentX(0.0F);
        departmentGrid.setAlignmentY(0.0F);
        departmentGrid.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        departmentGrid.setFocusable(false);
        departmentGrid.setMinimumSize(new java.awt.Dimension(400, 600));
        departmentGrid.setRowHeight(32);
        departmentGrid.setSelectionBackground(new java.awt.Color(0, 120, 215));
        departmentGrid.setSelectionForeground(new java.awt.Color(255, 255, 255));
        departmentGrid.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        departmentGrid.setShowGrid(false);
        departmentGrid.getTableHeader().setResizingAllowed(false);
        departmentGrid.getTableHeader().setReorderingAllowed(false);
        departmentGrid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                departmentGridMouseClicked(evt);
            }
        });
        departScrol.setViewportView(departmentGrid);

        universityName3.setBackground(new java.awt.Color(60, 63, 65));
        universityName3.setToolTipText(null);
        universityName3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        universityName3.setEnabled(false);
        universityName3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                universityNameTextBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                universityNameTextBoxFocusLost(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(countryTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(alphaCodeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(universityNameTextBox)))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(infoLabel)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(uniDescrTextField)
                                    .addComponent(uniInfoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addSchoolsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delSchoolsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(schoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departmentTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(schoolsScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(departScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(universityNameTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alphaCodeTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(countryTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(33, 33, 33)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(delSchoolsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addSchoolsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(schoolsScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(delDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addDepartmentBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(departScrol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departmentTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(schoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(mainPanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void universityNameTextBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameTextBoxFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_universityNameTextBoxFocusLost

    private void universityNameTextBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_universityNameTextBoxFocusGained
       // TODO add your handling code here:
    }//GEN-LAST:event_universityNameTextBoxFocusGained

    private void schoolGridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schoolGridMouseClicked
        System.out.println("Grind has index: "+ schoolGrid.getSelectedRow());
        currentSchoolEventSource.notifyEventListeners(schoolGrid.getSelectedRow());
    }//GEN-LAST:event_schoolGridMouseClicked

    private void departmentGridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentGridMouseClicked
        currentDepartmentEventSource.notifyEventListeners(departmentGrid.getSelectedRow());
    }//GEN-LAST:event_departmentGridMouseClicked

    private void departmentTextFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_departmentTextFieldMouseClicked
        if  (schoolGrid.getSelectedRow()<0){
            schoolGrid.setRowSelectionInterval(0, 0);
        }
    }//GEN-LAST:event_departmentTextFieldMouseClicked

    private void schoolGridMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schoolGridMousePressed
        if  (schoolGrid.getSelectedRow()<0){    
            currentSchoolEventSource.notifyEventListeners(schoolGrid.getSelectedRow());
        }
    }//GEN-LAST:event_schoolGridMousePressed





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
    private javax.swing.JButton addDepartmentBtn;
    private javax.swing.JButton addSchoolsBtn;
    private javax.swing.JTextField alphaCodeTextBox;
    private javax.swing.JTextField countryTextBox;
    private javax.swing.JButton delDepartmentBtn;
    private javax.swing.JButton delSchoolsBtn;
    private javax.swing.JScrollPane departScrol;
    private javax.swing.JTable departmentGrid;
    private javax.swing.JTextField departmentTextField;
    private javax.swing.JButton exitBtn;
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
    private javax.swing.JTable schoolGrid;
    private javax.swing.JTextField schoolTextField;
    private javax.swing.JScrollPane schoolsScrol;
    private javax.swing.JTextField uniDescrTextField;
    private javax.swing.JTextField uniInfoTextField;
    private javax.swing.JTextField universityName3;
    private javax.swing.JTextField universityNameTextBox;
    // End of variables declaration//GEN-END:variables
}
