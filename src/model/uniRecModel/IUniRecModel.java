package model.uniRecModel;

import repository.Department;
import repository.School;
import java.util.List;
import repository.Country;
import utils.ICustomEventListener;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 * 
 */
public interface IUniRecModel {
    void addSchool(School school);
    void deleteSchool(int index);
    List<School> getSchools();
    School getSchool(int index);
    List<Department> getDepartments();
    Department getDepartment(int index);    
    void populateSchoolList();
    void saveData() throws Exception;
    void addDataUpdatedEventListener(ICustomEventListener<List<Country>> listener);
}
