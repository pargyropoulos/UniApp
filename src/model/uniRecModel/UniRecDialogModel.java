package model.uniRecModel;

import repository.Department;
import repository.School;
import HTTP.WebData;
import java.util.ArrayList;
import java.util.HashSet;
import repository.University;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.CustomEventSource;
import utils.ICustomEventListener;

/**
 *
 * @author tasos
 */
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
    
    public UniRecDialogModel(WebData webData){  // Constructor με WebData
        this.webData=webData;
        this.dao=new UniRecDAO();
        this.university=createUniversityObj(webData);
        this.schools=dao.findSchools(this.university.getName());
        if (this.schools.isEmpty()){
            this.departments=new ArrayList<>();
        }else{
            this.schoolDepartmentPairList=findAllDepartments();
            this.departments=schoolDepartmentPairList.get(0).getDepartmentList();
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
    
 
    public List<Department> getDeparmentList(int schoolRowIndex){
        //check if row index is newly added and has no id
        if (schools.get(schoolRowIndex).getId()==null) {
            departmentsListUpdatedEventSource.notifyEventListeners(null);
            return null;
        }
        this.departments=schoolDepartmentPairList.get(schoolRowIndex).getDepartmentList();
        departmentsListUpdatedEventSource.notifyEventListeners(this.departments);
        return this.departments;
    }
 
    /**
     * Retrieves from DB the departments for the current school
     * @param schoolRowIndex
     * @return The departments that belong to the current school
     */
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
        this.schools.add(school);
        this.insertedSchools.add(school);
        schoolDepartmentPairList.add(new SchoolDepartmentPair(school,new ArrayList<>()));
        System.out.println("-".repeat(10));
        for (var item:insertedSchools){
            System.out.println(item);
        }
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
//        for (int i=0 ;i<deletedDepartments.size();i++){
//            if (deletedDepartments.get(i).getSchoolId().getId().equals(school.getId())){
//                deletedDepartments.remove(i);
////                System.out.println("deleted "+item.getName());
//            }
//        }
        schoolDepartmentPairList.remove(rowIndex);
        this.departments=null;
        schoolsListUpdatedEventSource.notifyEventListeners(this.schools);      
        
    }

    public void addDepartment(Department department){
        System.out.println(department);
        if( schools.isEmpty() ||departments.contains(department)) return;
        departments.add(department);
        insertedDepartments.add(department);
        System.out.println("-".repeat(10));
        for (var item:insertedDepartments){
            System.out.println(item);
        }
        departmentsListUpdatedEventSource.notifyEventListeners(this.departments);        
    }

    public void deleteDepartment(int rowIndex){
        Department department=departments.get(rowIndex);
        if (insertedDepartments.contains(department)){
            insertedDepartments.remove(department);
        }else {
            deletedDepartments.add(departments.get(rowIndex));
        }
        departments.remove(department);
//        schoolDepartmentPairList.remove(rowIndex);
//        this.departments=null;
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
        for (var item: schoolDepartmentPairList){
            System.out.println(item.getSchool());
            for (var department:item.getDepartmentList()){
                System.out.println("-".repeat(10)+department.getName());    
            }
        }
        
        System.out.println("-".repeat(10) + " Deleted Schools "+"-".repeat(10));    
        for (var item:deletedSchools){
            System.out.println(item.getName());
        }
        System.out.println("-".repeat(10) + " Inserted Schools "+"-".repeat(10));    
        for (var item:insertedSchools){
            System.out.println(item.getName());
        }
        System.out.println("-".repeat(10) + " Deleted Departments "+"-".repeat(10));    
        for (var item:deletedDepartments){
            System.out.println(item.getName());
        }
        System.out.println("-".repeat(10) + " Inserted Departments "+"-".repeat(10));    
        for (var item:insertedDepartments){
            System.out.println(item.getName());
        }
        dao.deleteDepartments(deletedDepartments);
        dao.deleteSchools(deletedSchools);
        dao.createSchools(insertedSchools);
        dao.createDepartments(insertedDepartments);
        dao.updateUniversity(university);
        
        
    }
    ////ok up to here
//
////    public List<String> getSchools() {
////        if (university != null) {
////            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
////            List<School> schoolList = schoolController.findSchoolsByUniversity(university.getName());
////
////            //debugging
////            System.out.println("Loaded schools: " + schoolList.size());
////
////            // Μετατρέπουμε τη λίστα σε Strings
////            return schoolList.stream()
////                    .map(School::getName)
////                    .collect(Collectors.toList());
////        }
////        return List.of(); // Αν δεν υπάρχουν σχολές, επιστρέφουμε κενή λίστα
////    }
//
//    public void updateUniversityInfo(String newDescription, String newInfo) {
//        if (university != null) {
//            university.setDescription(newDescription);
//            university.setInfo(newInfo);
//
//            try {
//                universityController.edit(university);
//                System.out.println("University info updated: " + university.getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("Failed to update university info.");
//            }
//        } else {
//            System.out.println("No university found to update.");
//        }
//    }
//
//    public boolean addSchoolToDatabase(String schoolName) {
//        if (university == null) {
//            System.out.println("Error: No university selected.");
//            return false;
//        }
//
//        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
//        EntityTransaction transaction = em.getTransaction();
//
//        try {
//            transaction.begin();
//
//            // ✅ Ελέγχουμε αν υπάρχει ήδη η σχολή
//            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
//            List<School> existingSchools = schoolController.findSchoolsByUniversity(university.getName());
//
//            for (School s : existingSchools) {
//                if (s.getName().equalsIgnoreCase(schoolName)) {
//                    System.out.println("School already exists in database: " + schoolName);
//                    return false; // Αν υπάρχει ήδη, δεν προσθέτουμε ξανά
//                }
//            }
//
//            // ✅ Δημιουργούμε και αποθηκεύουμε τη νέα σχολή
//            School newSchool = new School();
//            newSchool.setName(schoolName);
//            newSchool.setUniversityName(university); // Σύνδεση με το πανεπιστήμιο
//
//            em.persist(newSchool);
//            transaction.commit();
//            return true;
//
//        } catch (Exception e) {
//            transaction.rollback();
//            e.printStackTrace();
//            return false;
//        } finally {
//            em.close();
//        }
//    }
//    
//    public boolean deleteSchoolFromDatabase(String schoolName) {
//    if (university == null) {
//        System.out.println("Error: No university selected.");
//        return false;
//    }
//
//    EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
//    EntityTransaction transaction = em.getTransaction();
//
//    try {
//        transaction.begin();
//
//       
//        SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
//        School school = schoolController.findSchoolByNameAndUniversity(schoolName, university.getName());
//
//        if (school == null) {
//            System.out.println("No school found with name: " + schoolName);
//            return false;
//        }
//
//        em.remove(em.contains(school) ? school : em.merge(school));
//        transaction.commit();
//        return true;
//
//        } catch (Exception e) {
//            transaction.rollback();
//            e.printStackTrace();
//            return false;
//        } finally {
//            em.close();
//        }
//    }

}
