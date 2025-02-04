package view;


import constants.ColorConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import HTTP.WebData;
import utils.CustomEvent;
import utils.ICustomEventListener;
        
/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
public class UniGridView extends javax.swing.JPanel{ // implements ICustomEventListener<Object>
   
    private final String[] columnNames={"University Name", "Country", "Alpha-two-code", "State-Province","Web Pages","Domains"}; //grid header names

    /**
     * Public method for adding action listeners to the Search Button
     * @param listener 
     */
    public void addSearchButtonListener(ActionListener listener) {
        searchBtn.addActionListener(listener);
    }

    /**
     * Public method for adding action listeners to the Search Button
     * @param listener 
     */    
    public void addViewEditButtonListener(ActionListener listener) {
        viewEditBtn.addActionListener(listener);
    }

    /**
     * Public method for adding action listeners to the Search Button
     * @param listener 
     */    
    public void addCloseButtonListener(ActionListener listener) {
        closeBtn.addActionListener(listener);
    }

    /**
     * Returns the grid's selected row's index
     * @return grid.getSelectedRow();
     */
    public int getSelecedRowIndex() {
        return grid.getSelectedRow();
    }

    /**
     * Creates new form uniView
     */
    public UniGridView() {
        initComponents();

        //custimize buttons to change color on hover event
        for (var component : mainPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                view.Utils.customizeButton(button, new Color(0, 122, 204), new Color(45, 45, 48));
                button.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 8, 1, 1));        
            }
        }
        populateGrid(null);
    }
    
    public void populateGrid(List<WebData> universityList){
        int size=universityList!=null ? universityList.size():0;
        Object[][] data = new Object[size][6];
        if (size!=0){
            for (int i = 0; i < size; i++) {
                data[i][0] = universityList.get(i).getName();
                data[i][1] = universityList.get(i).getCountry();
                data[i][2] = universityList.get(i).getAlpha_two_code();
                data[i][3] = universityList.get(i).getState_province();
                data[i][4] = universityList.get(i).getWeb_pages();
                data[i][5] = universityList.get(i).getDomains();
            }        
        }
        setGridModel(data);
        grid.revalidate();
        grid.repaint();
    }
    
    private void setGridModel(Object[][] data){
        DefaultTableModel model = new DefaultTableModel(data, this.columnNames){
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
        setColumnAlignment(JLabel.CENTER, 2);
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    }
    
    private void setColumnAlignment(int alignment, int columnIndex) {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(alignment);  // Set the alignment
        grid.getColumnModel().getColumn(columnIndex).setCellRenderer(renderer);  // Apply the renderer to the column
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
        viewEditBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        grid = new javax.swing.JTable();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        viewEditBtn.setBackground(new java.awt.Color(45, 45, 48));
        viewEditBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewEditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/edit.png"))); // NOI18N
        viewEditBtn.setText("View/Edit");
        viewEditBtn.setAlignmentY(0.0F);
        viewEditBtn.setFocusPainted(false);
        viewEditBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        viewEditBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        viewEditBtn.setIconTextGap(32);
        viewEditBtn.setInheritsPopupMenu(true);
        viewEditBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        viewEditBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        viewEditBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        viewEditBtn.setPreferredSize(new java.awt.Dimension(200, 50));

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

        closeBtn.setBackground(new java.awt.Color(45, 45, 48));
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/cancel.png"))); // NOI18N
        closeBtn.setText("Close");
        closeBtn.setAlignmentY(0.0F);
        closeBtn.setFocusPainted(false);
        closeBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        closeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        closeBtn.setIconTextGap(32);
        closeBtn.setInheritsPopupMenu(true);
        closeBtn.setMargin(new java.awt.Insets(0, 30, 0, 0));
        closeBtn.setMaximumSize(new java.awt.Dimension(200, 50));
        closeBtn.setMinimumSize(new java.awt.Dimension(200, 50));
        closeBtn.setPreferredSize(new java.awt.Dimension(200, 50));

        grid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        grid.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1.setViewportView(grid);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewEditBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
        );

        add(mainPanel);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JTable grid;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton viewEditBtn;
    // End of variables declaration//GEN-END:variables

//    @Override
//    public void onCustomEvent(CustomEvent e) {
////        @SuppressWarnings("unchecked")
//        List<webDataPOJO> data= (List<webDataPOJO>) e.getEventMessage();
//        populateGrid(data);
//    }
}
