/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import repository.service.UniversityDTO;

/**
 *
 * @author xe-di
 */
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UniversityTableModel extends AbstractTableModel {

    private final List<UniversityDTO> universities;
    private final String[] columnNames = {"Universities", "Visits"};

    public UniversityTableModel(List<UniversityDTO> universities) {
        this.universities = universities;
    }

    @Override
    public int getRowCount() {
        return universities.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        UniversityDTO university = universities.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return university.getName(); // University name
            case 1:
                return university.getCounter(); // Visits (counter)
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
