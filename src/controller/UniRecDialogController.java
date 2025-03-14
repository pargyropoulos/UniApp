package controller;

import view.Utils;
import model.uniRecModel.UniRecDialogModel;
import view.UniRecDialogView;
import repository.entities.Department;
import repository.entities.School;

/**
 * Controller part of the UniRec MVC
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
        view.addcurrentSchoolEventSourceEventListener(e-> {
            model.upDateCurrentSchoolIndex(e.getEventMessage());
            view.populateDepartmentGrid(model.getDepartments());
        });
        view.addExitButtonListener(e -> this.view.dispose());
        view.addSaveButtonListener(e->saveData());

        view.addInsertSchoolButtonListener(e ->addSchool(this.view.getSchoolText()));
        view.addInsertDepartmentButtonListener(e ->addDepartment(this.view.getDepartmentText()));
        
        view.addDeleteSchoolButtonListener(e ->deleteSchool(this.view.getSelectedSchoolRowIndex()));
        view.addDeleteDepartmentButtonListener(e->deleteDepartment(this.view.getSelectedDepartmentRowIndex()));
        
        model.addDepartmentListUpdatedEventListener(e->view.populateDepartmentGrid(model.getDepartments()));
        
        model.addSchoolListUpdatedEventListener(e-> {
            view.populateSchoolsGrid(model.getSchoolsList());
            view.populateDepartmentGrid(model.getDepartments());
            });        
    }


    /**
     * Adds a school to the grid
     * @param schoolName 
     */
    private void addSchool(String schoolName) {
        if (this.view.getSchoolText().isEmpty()) return;
        School school=new School();
        school.setName(schoolName);
        school.setId(schoolName.hashCode());
        school.setUniversityName(model.getUniversity());
        model.addSchool(school);
        view.setSchoolTextField(null);
    }
    
    /**
     * Deletes a school from the grid
     * @param rowIndex 
     */
    private void deleteSchool(int rowIndex) {
        if (this.view.getSelectedSchoolRowIndex()<0) return;
        if (rowIndex<0) return;
        this.model.deleteSchool(rowIndex);
        this.view.populateDepartmentGrid(model.getDepartments());
    }

    /**
     * Adds a department to the grid
     * @param rowIndex 
     */
    private void addDepartment(String departmentName){
        if (this.view.getSelectedSchoolRowIndex()<0 || view.getDepartmentText().isEmpty()) return;
        if (model.getSchoolsList().isEmpty()) return;
        Department department=new Department();
        department.setName(departmentName);
        department.setSchoolId(model.getSchoolsList().get(view.getSelectedSchoolRowIndex()));
        department.setId((departmentName).hashCode());
        model.addDepartment(department);
        view.setDepartmentTextField(null);
        view.populateDepartmentGrid(model.getDepartments());
    }

     /**
     * Deletes a departmentl from the grid
     * @param rowIndex 
     */
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
        this.view.dispose();
    }


}
