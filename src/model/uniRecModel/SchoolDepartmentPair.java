package model.uniRecModel;

import java.util.List;
import repository.entities.Department;
import repository.entities.School;

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
