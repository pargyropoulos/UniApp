package model.uniRecModel;

import repository.entities.Department;
import repository.entities.School;
import HTTP.WebData;
import java.util.ArrayList;
import java.util.HashSet;
import repository.entities.University;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.CustomEventSource;
import utils.ICustomEventListener;

public class UniRecDialogModel {
    private final WebData webData;
    private final University university;
    private final UniRecDAO dao;

    private final List<School> schools;
    private final List<School> deletedSchools = new ArrayList<>();
    private final Set<School> insertedSchools = new HashSet<>();
    
    private List<Department> departments;
    private final List<Department> deletedDepartments = new ArrayList<>();
    private final Set<Department> insertedDepartments = new HashSet<>();
    
    private List<SchoolDepartmentPair> schoolDepartmentPairList=new ArrayList<>();
    private final CustomEventSource<List<Department>> departmentsListUpdatedEventSource = new CustomEventSource<>();
    private final CustomEventSource<List<School>> schoolsListUpdatedEventSource= new CustomEventSource<>();
    private int currentSchoolIndex=0;
    
    public void upDateCurrentSchoolIndex(int index){
        System.out.println("School index is:" +index);
        this.departments=schoolDepartmentPairList.get(index).getDepartmentList();
        this.currentSchoolIndex=index;
    }
              
    
    public UniRecDialogModel(WebData webData){  // Constructor με WebData
        this.webData=webData;
        this.dao=new UniRecDAO();
        this.university=createUniversityObj(webData);
        this.schools=dao.findSchools(this.university.getName());
        if (this.schools.isEmpty()){
            this.departments=new ArrayList<>();
        }else{
            this.schoolDepartmentPairList=createSchoolDepartmentPairObj();
            this.departments=schoolDepartmentPairList.get(0).getDepartmentList();
        }
        updateUniversityCounter(this.university);
    }
    
    private University createUniversityObj(WebData webData){
        // Αναζητούμε αν υπάρχει πανεπιστήμιο ήδη στη βάση και ενημερώνουμε τον μετρητή του αλλιώς το δημιουργούμε
        if (dao.findUniversity(webData.getName())!=null){
            return dao.findUniversity(webData.getName());
        }else {
                University uni=new University();
                uni.setName(webData.getName());
                uni.setCounter(0);            
            try {
                System.out.println("Creating new entry...");
                dao.createUniversity(uni);    
                return uni;
            } catch (Exception ex) {
                System.out.println("University counter could not be updated");
            }
            return uni;
        }        
    }

    private void updateUniversityCounter(University university){
        university.setCounter(university.getCounter()+1);
        try {
            this.dao.updateUniversity(university);
        } catch (Exception ex) {
            Logger.getLogger(UniRecDialogModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("university counter="+this.university.getCounter());
    }
    
 
    /**
     * Creates the Shool-Department pair Object
     * @param schoolRowIndex
     * @return The departments that belong to the current school
     */
    private List<SchoolDepartmentPair> createSchoolDepartmentPairObj() {
        List<SchoolDepartmentPair> schoolDepartmentPairList = new ArrayList<>();
    
        for (School item : schools) {
            List<Department> departmentList = dao.findDepartments(item.getId());
            SchoolDepartmentPair pair = new SchoolDepartmentPair(item, departmentList);
            schoolDepartmentPairList.add(pair);
        }
        return schoolDepartmentPairList;
    }
            
    /**
     * Returns the current Department list
     * @return current Department list
     */
    public List<Department> getDepartments() {
        return this.departments;
    }

    public List<School> getSchoolsList() {
        return this.schools;
    }
    
    public void addSchool(School school){
        if (schools.contains(school)) return;
        this.schools.add(school);
        this.insertedSchools.add(school);
        schoolDepartmentPairList.add(new SchoolDepartmentPair(school,new ArrayList<>()));
        schoolsListUpdatedEventSource.notifyEventListeners(this.schools);        
    }
    
    public void deleteSchool(int rowIndex){
        School school=schools.get(rowIndex);
        if (insertedSchools.contains(school)){
            insertedSchools.remove(school);
        }else {
            deletedSchools.add(school);
        }
        
        schools.remove(school);
        schoolDepartmentPairList.remove(rowIndex);
        this.departments=new ArrayList<>();
        schoolsListUpdatedEventSource.notifyEventListeners(this.schools);      
        
    }

    public void addDepartment(Department department){
        if( schools.isEmpty() ||departments.contains(department)) return;
        departments.add(department);
        insertedDepartments.add(department);
        //departmentsListUpdatedEventSource.notifyEventListeners(this.departments);        
    }

    public void deleteDepartment(int rowIndex){
        Department department=departments.get(rowIndex);
        if (insertedDepartments.contains(department)){
            insertedDepartments.remove(department);
        }else {
            deletedDepartments.add(departments.get(rowIndex));
        }
        departments.remove(department);
        departmentsListUpdatedEventSource.notifyEventListeners(this.departments);      
    }    
    
    public void addDepartmentListUpdatedEventListener(ICustomEventListener<List<Department>> listener) {
        departmentsListUpdatedEventSource.addEventListener(listener);
    }
    
    public void addSchoolListUpdatedEventListener(ICustomEventListener<List<School>> listener) {
        schoolsListUpdatedEventSource.addEventListener(listener);
    }

    
    ///<----P.A.
    public University getUniversity() {
        return university;
    }
    public WebData getWebData() {  // Getter για να το χρησιμοποιήσω η View
        return webData;
    }
//
    //λιστα για domains
    public List<String> getDomains() {
        return webData.getDomains();
    }
//    //Λιστα για Web_Pages
    public List<String> getWebPages() {
        return webData.getWeb_pages();
    }

//    //Για να εμφανίσω τα στοιχεία στο description
//    //απο την βάδη δεδομενων
    public String getDescription() {
        return university.getDescription();
    }

    public void setDescription(String description) {
        this.university.setDescription(description);
    }

//
//    //Για να εμφανίσω τα στοιχεία στο info
//    //απο την βάδη δεδομενων
    public String getInfo() {
        return university.getInfo();
    }

    public void setInfo(String info) {
        this.university.setInfo(info);
    }
    
    
    public void saveData(){
        dao.updateInsert(this.university,this.insertedSchools,this.insertedDepartments);
        dao.deleteSchoolsAndDepartments(this.deletedSchools,this.deletedDepartments);
        
    }
}
