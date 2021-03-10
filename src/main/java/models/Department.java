package models;

import java.util.List;

public class Department {
        private int id;
        private String nameOfDepartment;
        private String detail;
        private int numberEmployees;

        public Department(String nameOfDepartment, String detail, int numberEmployees) {
            this.nameOfDepartment = nameOfDepartment;
            this.detail = detail;
            this.numberEmployees = numberEmployees;
        }

    public static List<Department> getAll() {
            return getAll();
    }

    public String getNameOfDepartment() {
            return nameOfDepartment;
        }

        public void setDNameOfDepartment(String nameOfDepartment) {
            this.nameOfDepartment = nameOfDepartment;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public int getNumberEmployees() {
            return numberEmployees;
        }

        public void setNumberEmployees(int numberEmployees) {
            this.numberEmployees = numberEmployees;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

    public void save(Department newDepartment) {
    }
}
