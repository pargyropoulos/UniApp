package view.settingsForm;

import constants.ColorConstants;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import model.SettingsModel.Country;
import static view.Utils.customizeButtonsInsidePanel;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
public class SettingsView extends javax.swing.JPanel implements ISettingsView{

    public SettingsView() {
        initComponents();
        customizeButtonsInsidePanel(mainPanel);
        grid.setSelectionBackground(ColorConstants.gridLineSelectionBackgroundColor);
        grid.setSelectionForeground(ColorConstants.gridLineSelectionForegroundColor);
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
        jLabel11 = new javax.swing.JLabel();
        deleteEntryBtn = new javax.swing.JButton();
        addEntryBtn = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();
        countryTextBox = new javax.swing.JTextField();
        saveBtn = new javax.swing.JButton();
        clearDbBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        closelBtn.setBackground(new java.awt.Color(45, 45, 48));
        closelBtn.setForeground(new java.awt.Color(255, 255, 255));
        closelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/cancel.png"))); // NOI18N
        closelBtn.setText("Close");
        closelBtn.setFocusPainted(false);
        closelBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        closelBtn.setIconTextGap(32);
        closelBtn.setInheritsPopupMenu(true);
        closelBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        closelBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        closelBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        closelBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel11.setText("Insert/Delete country (search combo box):");

        deleteEntryBtn.setBackground(new java.awt.Color(45, 45, 48));
        deleteEntryBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteEntryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/delete.png"))); // NOI18N
        deleteEntryBtn.setToolTipText("Delete entry");
        deleteEntryBtn.setAlignmentY(0.0F);
        deleteEntryBtn.setFocusPainted(false);
        deleteEntryBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteEntryBtn.setIconTextGap(0);
        deleteEntryBtn.setInheritsPopupMenu(true);
        deleteEntryBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        deleteEntryBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        deleteEntryBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        deleteEntryBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        addEntryBtn.setBackground(new java.awt.Color(45, 45, 48));
        addEntryBtn.setForeground(new java.awt.Color(255, 255, 255));
        addEntryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/add.png"))); // NOI18N
        addEntryBtn.setToolTipText("Insert entry");
        addEntryBtn.setAlignmentY(0.0F);
        addEntryBtn.setFocusPainted(false);
        addEntryBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addEntryBtn.setIconTextGap(0);
        addEntryBtn.setInheritsPopupMenu(true);
        addEntryBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addEntryBtn.setMaximumSize(new java.awt.Dimension(50, 50));
        addEntryBtn.setMinimumSize(new java.awt.Dimension(50, 50));
        addEntryBtn.setPreferredSize(new java.awt.Dimension(50, 50));

        grid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Country Name "
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
        jScrollPane.setViewportView(grid);

        countryTextBox.setToolTipText(null);

        saveBtn.setBackground(new java.awt.Color(45, 45, 48));
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/save.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.setAlignmentY(0.0F);
        saveBtn.setFocusPainted(false);
        saveBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        saveBtn.setIconTextGap(32);
        saveBtn.setInheritsPopupMenu(true);
        saveBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        saveBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        saveBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        saveBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        clearDbBtn.setBackground(new java.awt.Color(45, 45, 48));
        clearDbBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearDbBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/delete.png"))); // NOI18N
        clearDbBtn.setText("Clear DB");
        clearDbBtn.setAlignmentY(0.0F);
        clearDbBtn.setFocusPainted(false);
        clearDbBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        clearDbBtn.setIconTextGap(32);
        clearDbBtn.setInheritsPopupMenu(true);
        clearDbBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        clearDbBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        clearDbBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        clearDbBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel1.setText("Insert new entry:");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(clearDbBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(closelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(countryTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countryTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearDbBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(mainPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEntryBtn;
    private javax.swing.JButton clearDbBtn;
    private javax.swing.JButton closelBtn;
    private javax.swing.JTextField countryTextBox;
    private javax.swing.JButton deleteEntryBtn;
    private javax.swing.JTable grid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addSaveEventListener(ActionListener listener) {this.saveBtn.addActionListener(listener);}

    @Override
    public void addCloseEventListener(ActionListener listener) {this.closelBtn.addActionListener(listener);}

    @Override
    public void addClearDbEventListener(ActionListener listener) {this.clearDbBtn.addActionListener(listener);}

    @Override
    public void addDeleteEntryEventListener(ActionListener listener) {this.deleteEntryBtn.addActionListener(listener);}

    @Override
    public void addAddEntryEventListener(ActionListener listener) {this.addEntryBtn.addActionListener(listener);}

    @Override
    public void show() {
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    @Override
    public JPanel getView() {return this;}

    private void populateGrid(List<Country> data) {
        int size=data!=null ? data.size():0;
        Object[][] countries = new Object[size][6];
        if (size!=0){
            for (int i = 0; i < size; i++) {
                countries[i][0] = data.get(i).getName();
            }        
        }
        setGridModel(countries);
        grid.revalidate();
        grid.repaint();
    }
    
    private void setGridModel(Object[][] data){
        String[] columnNames={"Country Name"};
        DefaultTableModel model = new DefaultTableModel(data, columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing
            }
        };
        grid.setModel(model);           
        grid.getTableHeader().setPreferredSize(new Dimension(grid.getWidth(), 32)); // Set height to 30
        grid.getTableHeader().setBackground(ColorConstants.gridHeaderBackgroundColor); // Set background color
        grid.getTableHeader().setForeground(ColorConstants.gridHeaderForegroundColor); // Set text color to white for contrast    
        grid.setIntercellSpacing(new Dimension(0, 0));
        grid.getTableHeader().setResizingAllowed(true);
        grid.enableInputMethods(false);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }  
  
    @Override
    public int getSelectedRowIndex() {
        return this.grid.getSelectedRow();
    }

    @Override
    public String getCountryTextBox() {
        return this.countryTextBox.getText();
    }

    @Override
    public void setCountryTextBox(String countryName) {
        this.countryTextBox.setText(countryName);
    }


    @Override
    public void updateGrid(List<Country> data) {
        populateGrid(data);
    }
    
}
