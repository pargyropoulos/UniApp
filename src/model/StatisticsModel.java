package model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import repository.entities.University;
import repository.service.UniversityService;

public final class StatisticsModel extends AbstractTableModel {

    private final List<University> universities;
    private final String[] columnNames = {"University", "Views"};

    public StatisticsModel() {
        this.universities=new UniversityService().getTop10UniversitiesOrderByCounterDescNameAsc();
    }
    
    public List<University> getUniversities(){
        return this.universities;
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
        University university = universities.get(rowIndex);
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
