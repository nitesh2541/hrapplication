package hr.model;


import hrejbapp.Employees;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeList {

    List<Employees> employeesList = new ArrayList<Employees>();

    @XmlElement(name="allemployees")
    public List<Employees> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(List<Employees> employeesList) {
        this.employeesList = employeesList;
    };
}