package controller;

import java.awt.event.ActionListener;
import view.Utils;
import model.uniRecModel.UniRecDialogModel;
import view.UniRecDialogView;
import repository.Department;
import repository.School;

/**
 *
 * @author  Anastasios Botsialas std150497@ac.eap.gr - botsialas.a@devs-od.com
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
*/
public class UniRecDialogController {
    private final UniRecDialogModel model;
    private final UniRecDialogView view;
    
    public UniRecDialogController(UniRecDialogView view, UniRecDialogModel model) {
        this.model = model;
        this.view = view;
        view.setUniversityData(model.getWebData());
        view.populateDomainsGrid(model.getWebData().getDomains());
        view.populateWebPagesGrid(model.getWebPages());
        view.setDescriptionField(model.getDescription());
        view.setInfoField(model.getInfo());
        view.populateSchoolsGrid(model.getSchoolsList());
        view.populateDepartmentGrid(model.getDepartments());

        //Map Listeners
        view.addExitButtonListener(e -> this.view.dispose());
        view.addSaveButtonListener(e->saveData());

        view.addInsertSchoolButtonListener(e -> {
            if (this.view.getSchoolText().isEmpty()) return;
            addSchool(this.view.getSchoolText());
        });
        view.addInsertDepartmentButtonListener(e -> {
            if (this.view.getDepartmentText().isEmpty()) return;
            if (this.view.getSelectedSchoolRowIndex()<0) return;
            addDepartment(this.view.getDepartmentText());
        });        
        
        view.addDeleteSchoolButtonListener(e ->{
            if (this.view.getSelectedSchoolRowIndex()<0) return;
            deleteSchool(this.view.getSelectedSchoolRowIndex());
        });
        
        view.addDeleteDepartmentButtonListener(e->deleteDepartment(this.view.getSelectedDepartmentRowIndex()));
        
        view.addSchoolSelectedEventListener(e-> model.getDeparmentList(e.getEventMessage()));
        
        model.addDepartmentListUpdatedEventListener(e->view.populateDepartmentGrid(model.getDepartments()));
        
        model.addSchoolListUpdatedEventListener(e-> {
            view.populateSchoolsGrid(model.getSchoolsList());
            view.populateDepartmentGrid(model.getDepartments());
            });
    }


    private void addSchool(String schoolName) {
        School school=new School();
        school.setName(schoolName);
        school.setId(schoolName.hashCode());
        school.setUniversityName(model.getUniversity());
        model.addSchool(school);
        view.setSchoolTextField(null);
    }
    
    
    private void deleteSchool(int rowIndex) {
        if (rowIndex<0) return;
        this.model.deleteSchool(rowIndex);
        this.view.populateDepartmentGrid(model.getDepartments());
    }


    private void addDepartment(String departmentName){
        if (model.getSchoolsList().isEmpty()) return;
        Department department=new Department();
        department.setName(departmentName);
        department.setSchoolId(model.getSchoolsList().get(view.getSelectedSchoolRowIndex()));
        department.setId((departmentName).hashCode());
        model.addDepartment(department);
        view.setDepartmentTextField(null);
    }

    private void deleteDepartment(int rowIndex){
        if (rowIndex<0) return;
        this.model.deleteDepartment(rowIndex);
        this.view.populateDepartmentGrid(model.getDepartments());        
    }
    
    public void run() {
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view));
        view.setVisible(true);
    }

    private void saveData() {
        model.setDescription(view.getDescriptionText());
        model.setInfo(view.getInfoText());
        this.model.saveData();
    }


}
