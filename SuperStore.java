/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uk.ac.richmond;

/**
 *
 * @author karan
 */

import java.util.Set;
import java.util.TreeSet;

public class SuperStore implements Comparable<SuperStore> {
    private String name;
    private String address;
    private String telNo;
    private Set<Employee> employees;

    public SuperStore(String name, String address, String telNo) {
        this.name = name;
        this.address = address;
        this.telNo = telNo;
        this.employees = new TreeSet<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public int compareTo(SuperStore other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
    public Set<Employee> searchEmployees(String keyword) {
    Set<Employee> matchedEmployees = new TreeSet<>();
    for (Employee employee : this.employees) {
        if (employee.getFullName().toLowerCase().contains(keyword.toLowerCase())) {
            matchedEmployees.add(employee);
        }
    }
    return matchedEmployees;
}
   
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SuperStore that = (SuperStore) obj;
        return name.equals(that.name);
    }
}