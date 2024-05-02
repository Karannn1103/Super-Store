/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author karan
 */
package uk.ac.richmond;

public class Employee implements Comparable<Employee> {
    private int number;
    private String firstName;
    private String lastName;
    private String employmentStarted;
    private String mobile;
    private boolean fullTime;

    public Employee(int number, String firstName, String lastName, String employmentStarted, String mobile, boolean fullTime) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentStarted = employmentStarted;
        this.mobile = mobile;
        this.fullTime = fullTime;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Employee other) {
        int firstNameComparison = this.firstName.compareTo(other.firstName);
        return (firstNameComparison != 0) ? firstNameComparison : this.lastName.compareTo(other.lastName);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return number == employee.number;
    }
}