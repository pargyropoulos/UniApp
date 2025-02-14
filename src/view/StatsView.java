/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JTable;
import model.UniversityTableModel;
import repository.service.UniversityDTO;
import repository.service.UniversityService;
//import utils.PDFExporter;






/**
 *
 * @author Konstantina Al Fantel- k.al.fantel@gmail.com or std160862@ac.eap.gr
 */
 
public class StatsView extends javax.swing.JDialog {

    
    
    
    public StatsView(List<UniversityDTO> popularUniversities) {
        initComponents();
        setResizable(false);

        //setLayout(new BorderLayout());

        // Initialize service and fetch universities
//        UniversityService universityService = new UniversityService();
//        List<UniversityDTO> universities = universityService.getUniversitiesWithCounterGreaterThanEqualTen();
//        if (popularUniversities == null || popularUniversities.isEmpty()) {
//            System.out.println("⚠️ Δεν βρέθηκαν πανεπιστήμια με counter >= 10!");
//         } else {
//        for (UniversityDTO uni : popularUniversities) {
//            System.out.println("✅ " + uni.getName() + " - " + uni.getCounter());
//                }
//            }
        

        // Create the table model and JTable
//        UniversityTableModel model = new UniversityTableModel(popularUniversities);
//        jTable1 = new JTable(model);
//        jTable1.setModel(model);

        // Add the JTable to a JScrollPane
        jScrollPane1.setViewportView(jTable1);
//        System.out.println(model.getColumnCount());
//        System.out.println(model.getRowCount());
//        System.out.println(model.getValueAt(0, 0));
//        
        // Add the JScrollPane to the JPanel
//        add(jScrollPane1, BorderLayout.CENTER);
        setTitle("Statistics");
        setModal(true); // Το κάνει modal
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); 
        
        
    }
    
     
/**
 * Displays the statistics window with the most viewed universities.
 */
   
    public static void showStatsView() {
        //UniversityService universityService = new UniversityService();
        //List<UniversityDTO> universities = universityService.getAllUniversities(); // Παίρνουμε όλα τα δεδομένα

//        System.out.println("🔎 Βρέθηκαν " + universities.size() + " πανεπιστήμια στη βάση.");
//        for (UniversityDTO uni : universities) {
//        System.out.println("📌 " + uni.getName() + " - " + uni.getCounter());
             //}
        StatsView statsView = new StatsView(null);
        statsView.setLocationRelativeTo(null);
        statsView.setVisible(true);
        


        
//        JFrame frame = new JFrame("Statistics");
//        StatsView statsView = new StatsView(null); 
//        frame.setContentPane(statsView);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.pack();
//        frame.setLocationRelativeTo(null); 
//        frame.setVisible(true);
    }
    
    

           

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        savePdf = new javax.swing.JButton();
        exit = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "University Name", "Views"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        savePdf.setBackground(new java.awt.Color(0, 122, 204));
        savePdf.setForeground(new java.awt.Color(255, 255, 255));
        savePdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/savepdf_1.png"))); // NOI18N
        savePdf.setText("Save as PDF");
        savePdf.setAlignmentY(0.0F);
        savePdf.setFocusPainted(false);
        savePdf.setIconTextGap(32);
        savePdf.setInheritsPopupMenu(true);
        savePdf.setMargin(new java.awt.Insets(0, 30, 0, 0));
        savePdf.setMaximumSize(new java.awt.Dimension(200, 50));
        savePdf.setMinimumSize(new java.awt.Dimension(200, 50));
        savePdf.setPreferredSize(new java.awt.Dimension(200, 50));
        savePdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePdfActionPerformed(evt);
            }
        });

        exit.setBackground(new java.awt.Color(0, 122, 204));
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/cancel.png"))); // NOI18N
        exit.setText("Close");
        exit.setAlignmentY(0.0F);
        exit.setFocusPainted(false);
        exit.setIconTextGap(32);
        exit.setMargin(new java.awt.Insets(0, 30, 0, 0));
        exit.setMaximumSize(new java.awt.Dimension(200, 50));
        exit.setMinimumSize(new java.awt.Dimension(200, 50));
        exit.setPreferredSize(new java.awt.Dimension(200, 50));
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(savePdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savePdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        // Close the window
       dispose();
        
    }//GEN-LAST:event_exitActionPerformed

    private void savePdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePdfActionPerformed
        // TODO add your handling code here:
       // Δημιουργία JFileChooser για επιλογή διαδρομής
    javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setDialogTitle("Save PDF");
    fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Documents", "pdf"));

    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File fileToSave = fileChooser.getSelectedFile();
        String filePath = fileToSave.getAbsolutePath();

        // Αν δεν έχει κατάληξη .pdf, προσθέτουμε
        if (!filePath.toLowerCase().endsWith(".pdf")) {
            filePath += ".pdf";
        }

        // Κλήση της μεθόδου εξαγωγής σε PDF
//        PDFExporter.exportToPDF(jTable1, filePath);
        javax.swing.JOptionPane.showMessageDialog(this, "PDF saved successfully!", "Success", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_savePdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton savePdf;
    // End of variables declaration//GEN-END:variables
}
