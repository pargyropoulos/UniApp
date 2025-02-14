package controller;

import view.Utils;
import model.uniRecModel.UniRecDialogModel;
import HTTP.WebData;
import view.UniRecDialogView;
import repository.University;
import java.util.List;
import repository.Department;
import repository.School;
import utils.CustomEventSource;
import utils.ICustomEventListener;

/**
 *
 * @author tasos
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
        view.addExitButtonListener(e -> closeDialog());
        view.addSaveButtonListener(e -> saveUniversityInfo());
        view.addInsertSchoolButtonListener(e -> {
            if (this.view.getSchoolText().isEmpty()) return;
            addSchool(this.view.getSchoolText());
        });
        view.addInsertDepartmentButtonListener(e -> {
            if (this.view.getDepartmentText().isEmpty()) return;
            addDepartment(this.view.getDepartmentText());
        });        
        view.addDeleteSchoolButtonListener(e ->{
            System.out.println("Row index" + this.view.getSelectedSchoolRowIndex());
            if (this.view.getSelectedSchoolRowIndex()<0) return;
            deleteSchool(this.view.getSelectedSchoolRowIndex());
        });
        view.addSchoolSelectedEventListener(e-> model.getDeparmentList(e.getEventMessage()));
        model.addDepartmentListUpdatedEventListener(e->view.populateDepartmentGrid(model.getDepartments()));
        model.addSchoolListUpdatedEventListener(e-> {
            view.setSelectedSchoolRowIndex(model.getSchoolRowIndex());
            view.populateSchoolsGrid(model.getSchoolsList());
            });
    }

    private void saveUniversityInfo() {
//        String newDescription = view.getDescriptionText();
//        String newInfo = view.getInfoText();
//        model.updateUniversityInfo(newDescription, newInfo);
        System.out.println("Saved new description and info.");
    }

    private void addSchool(String schoolName) {
        School school=new School();
        school.setName(schoolName);
        school.setId(schoolName.hashCode());
        school.setUniversityName(model.getUniversity());
        model.addSchool(school);
        view.setSchoolTextField(null);
    }
    
    
    private void deleteSchool(Integer rowIndex) {
        this.model.deleteSchool(rowIndex);
        this.view.setSelectedSchoolRowIndex(this.model.getSchoolRowIndex());
        this.view.populateDepartmentGrid(model.getDepartments());
        System.out.println("ctrl-delete-row index: "+view.getSelectedSchoolRowIndex());
    }


    private void addDepartment(String departmentName){
        if (model.getSchoolRowIndex()<0) return;
        Department department=new Department();
        department.setName(departmentName);
        department.setSchoolId(model.getSchoolsList().get(view.getSelectedSchoolRowIndex()));
        department.setId((departmentName).hashCode());
        System.out.println("ctrl-add-row index: "+view.getSelectedSchoolRowIndex());
        model.addDepartment(department);
        view.setDepartmentTextField(null);
        view.setSelectedSchoolRowIndex(model.getDepartments().size()-1);
    }

    private void deleteDepartment(){
        
    }
    
    public void run() {
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view));
        view.setVisible(true);
    }

    public void closeDialog() {
        System.out.println("Closing frame...");
        view.dispose();
    }

}
