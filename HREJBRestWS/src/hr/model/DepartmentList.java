package hr.model;

import hrejbapp.Departments;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DepartmentList {

    List<Departments> departmentsList = new ArrayList<Departments>();

    @XmlElement(name="alldepartments")
    public List<Departments> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(List<Departments> departmentsList) {
        this.departmentsList = departmentsList;
    };
}
