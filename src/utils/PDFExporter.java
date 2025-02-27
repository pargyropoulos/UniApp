package utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import java.io.FileOutputStream;
/**
 * 
 * Converts a jatable table to PDF document
 */

public class PDFExporter {
    public static void exportToPDF(JTable table, String filePath) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // Προσθήκη τίτλου
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
            Paragraph title = new Paragraph("University Statistics", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("\n"));

            // Δημιουργία πίνακα με βάση τις στήλες του JTable
            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());

            // Προσθήκη επικεφαλίδων στηλών
            for (int col = 0; col < table.getColumnCount(); col++) {
                pdfTable.addCell(new PdfPCell(new Phrase(table.getColumnName(col))));
            }

            // Προσθήκη δεδομένων από το JTable
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    pdfTable.addCell(new PdfPCell(new Phrase(table.getValueAt(row, col).toString())));
                }
            }

            // Προσθήκη πίνακα στο PDF
            document.add(pdfTable);
            document.close();

            System.out.println("PDF saved successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
