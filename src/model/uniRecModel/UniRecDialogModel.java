package model.uniRecModel;

import repository.Department;
import repository.School;
import HTTP.WebData;
import java.util.ArrayList;
import java.util.HashSet;
import repository.UniversityJpaController;
import repository.Emf;
import repository.University;
import repository.SchoolJpaController;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import utils.CustomEventSource;
import utils.ICustomEventListener;

/**
 *
 * @author tasos
 */
public class UniRecDialogModel {
    private WebData webData;
    private final University university;
    private final UniRecDAO dao;
    private UniversityJpaController universityController;
    private Integer schoolRowIndex;

    private final List<School> schools;
    private final List<School> deletedSchools = new ArrayList<>();
    private final Set<School> insertedSchools = new HashSet<>();
    private List<Department> departments;
    private final List<Department> deletedDepartments = new ArrayList<>();
    private final Set<Department> insertedDepartments = new HashSet<>();
    private List<SchoolDepartmentPair> schoolDepartmentPairList=new ArrayList<>();
    
    private final CustomEventSource<List<Department>> departmentsListUpdatedEventSource = new CustomEventSource<>();
    private final CustomEventSource<List<School>> schoolsListUpdatedEventSource= new CustomEventSource<>();
    
    public UniRecDialogModel(WebData webData){  // Constructor με WebData
        this.webData=webData;
        this.dao=new UniRecDAO();
        this.university=createUniversityObj(webData);
        this.schools=dao.findSchools(this.university.getName());
        if (this.schools.isEmpty()){
            this.departments=new ArrayList<>();
            schoolRowIndex=-1;
        }else{
            schoolRowIndex=0;
            this.schoolDepartmentPairList=findAllDepartments();
            this.departments=schoolDepartmentPairList.get(0).getDepartmentList();
//            this.departments=dao.findDepartments(this.schools.get(0).getId());
        }
         
        System.out.println(this.university);
        System.out.println(this.schools);
        System.out.println(this.departments);
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
     * Retrieves from DB the departments for the current school
     * @param rowIndex
     * @return The departments that belong to the current school
     */
    public List<Department> getDeparmentList(Integer rowIndex){
        //check if row index is newly added and has no id
        if (schools.get(rowIndex).getId()==null) {
            departmentsListUpdatedEventSource.notifyEventListeners(null);
            return null;
        }
            
//        this.departments=dao.findDepartments(this.schools.get(rowIndex).getId());
//        departmentsListUpdatedEventSource.notifyEventListeners(this.departments);
//        return this.departments;
    }
    
    private List<SchoolDepartmentPair> findAllDepartments() {
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
        schools.add(school);
        insertedSchools.add(school);
        System.out.println("-".repeat(10));
        schoolRowIndex=schools.size()-1;
        System.out.println("Model has schoolrowinde:"+schoolRowIndex);
        for (var item:insertedSchools){
            System.out.println(item);
        }
        schoolsListUpdatedEventSource.notifyEventListeners(this.schools);        
    }
    
    public void deleteSchool(Integer rowIndex){
        School school=schools.get(rowIndex);
        if (insertedSchools.contains(school)){
            insertedSchools.remove(school);
        }else {
            deletedSchools.add(schools.get(rowIndex));
        }
        schools.remove(school);
        if (!schools.isEmpty()){
            this.schoolRowIndex=rowIndex>0 ? rowIndex-1:0;
            this.departments=getDeparmentList(schoolRowIndex);
        }else {
            this.departments=null;
            schoolRowIndex=-1;
        }
        schoolsListUpdatedEventSource.notifyEventListeners(this.schools);      
    }

    public void addDepartment(Department department){
        System.out.println(department);
        if (departments.contains(department)) return;
        departments.add(department);
        insertedDepartments.add(department);
        System.out.println("-".repeat(10));
        for (var item:insertedDepartments){
            System.out.println(item);
        }
        departmentsListUpdatedEventSource.notifyEventListeners(this.departments);        
    }
    
    public void addDepartmentListUpdatedEventListener(ICustomEventListener<List<Department>> listener) {
        departmentsListUpdatedEventSource.addEventListener(listener);
    }
    
    public void addSchoolListUpdatedEventListener(ICustomEventListener<List<School>> listener) {
        schoolsListUpdatedEventSource.addEventListener(listener);
    }

    public Integer getSchoolRowIndex(){
        return this.schoolRowIndex;
    }
    
    public class SchoolDepartmentPair {
        private School school;
        private final List<Department> departmentList;

        public SchoolDepartmentPair(School school, List<Department> departmentList) {
            this.school = school;
            this.departmentList = departmentList;
        }

        public School getSchool() {
            return school;
        }

        public void setSchool(School school) {
            this.school = school;
        }

        public List<Department> getDepartmentList() {
            return departmentList;
        }

        public void addDepartment(Department department) {
            this.departmentList.add(department);
        }       

        public void deleteDepartment(Department department) {
            this.departmentList.remove(department);
        }       
}
    
    ///<----P.A.
    public University getUniversity() {
        return university;
    }

    public WebData getWebData() {  // Getter για να το χρησιμοποιήσω η View
        return webData;
    }

    //λιστα για domains
    public List<String> getDomains() {
//        if (webData != null) {
            return webData.getDomains();
//        }
//        return null; // Αν δεν υπάρχει πανεπιστήμιο, επιστρέφουμε null
    }

    //Λιστα για Web_Pages
    public List<String> getWebPages() {
//        if (webData != null) {
            return webData.getWeb_pages();
//        }
//        return null; // Αν δεν υπάρχει πανεπιστήμιο, επιστρέφουμε null
    }

    //Για να εμφανίσω τα στοιχεία στο description
    //απο την βάδη δεδομενων
    public String getDescription() {
//        if (university != null) {
            return university.getDescription();
//        }
//        return "No description available";
    }

    //Για να εμφανίσω τα στοιχεία στο info
    //απο την βάδη δεδομενων
    public String getInfo() {
//        if (university != null) {
            return university.getInfo();
//        }
//        return "No description available";
    }

//    public List<String> getSchools() {
//        if (university != null) {
//            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
//            List<School> schoolList = schoolController.findSchoolsByUniversity(university.getName());
//
//            //debugging
//            System.out.println("Loaded schools: " + schoolList.size());
//
//            // Μετατρέπουμε τη λίστα σε Strings
//            return schoolList.stream()
//                    .map(School::getName)
//                    .collect(Collectors.toList());
//        }
//        return List.of(); // Αν δεν υπάρχουν σχολές, επιστρέφουμε κενή λίστα
//    }

    public void updateUniversityInfo(String newDescription, String newInfo) {
        if (university != null) {
            university.setDescription(newDescription);
            university.setInfo(newInfo);

            try {
                universityController.edit(university);
                System.out.println("University info updated: " + university.getName());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to update university info.");
            }
        } else {
            System.out.println("No university found to update.");
        }
    }

    public boolean addSchoolToDatabase(String schoolName) {
        if (university == null) {
            System.out.println("Error: No university selected.");
            return false;
        }

        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // ✅ Ελέγχουμε αν υπάρχει ήδη η σχολή
            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
            List<School> existingSchools = schoolController.findSchoolsByUniversity(university.getName());

            for (School s : existingSchools) {
                if (s.getName().equalsIgnoreCase(schoolName)) {
                    System.out.println("School already exists in database: " + schoolName);
                    return false; // Αν υπάρχει ήδη, δεν προσθέτουμε ξανά
                }
            }

            // ✅ Δημιουργούμε και αποθηκεύουμε τη νέα σχολή
            School newSchool = new School();
            newSchool.setName(schoolName);
            newSchool.setUniversityName(university); // Σύνδεση με το πανεπιστήμιο

            em.persist(newSchool);
            transaction.commit();
            return true;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
    
    public boolean deleteSchoolFromDatabase(String schoolName) {
    if (university == null) {
        System.out.println("Error: No university selected.");
        return false;
    }

    EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
        transaction.begin();

       
        SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
        School school = schoolController.findSchoolByNameAndUniversity(schoolName, university.getName());

        if (school == null) {
            System.out.println("No school found with name: " + schoolName);
            return false;
        }

        em.remove(em.contains(school) ? school : em.merge(school));
        transaction.commit();
        return true;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

}
