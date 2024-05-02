/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uk.ac.richmond;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import org.json.JSONException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = null; // Declare the Scanner object outside the try block
        try {
            FileReader fr = new FileReader("src//uk//ac//richmond//abc.json");
            JSONTokener tokener = new JSONTokener(fr);
            JSONArray storesArray = new JSONArray(tokener);

            Set<SuperStore> superStores = new TreeSet<>();

            for (int i = 0; i < storesArray.length(); i++) {
                JSONObject storeObject = storesArray.getJSONObject(i);
                SuperStore store = new SuperStore(
                        storeObject.getString("name"),
                        storeObject.getString("address"),
                        storeObject.getString("tel_no")
                );

                JSONArray employeesArray = storeObject.getJSONArray("employees");
                for (int j = 0; j < employeesArray.length(); j++) {
                    JSONObject employeeObject = employeesArray.getJSONObject(j);
                    String[] nameParts = employeeObject.getString("name").split(" ");
                    Employee employee = new Employee(
                            employeeObject.getInt("no"),
                            nameParts[0],
                            nameParts.length > 1 ? nameParts[1] : "",
                            employeeObject.getString("employement_started"),
                            employeeObject.getString("mobile"),
                            employeeObject.getBoolean("full_time")
                    );
                    store.addEmployee(employee);
                }

                superStores.add(store);
            }
             for (SuperStore store : superStores) {
                System.out.println("Superstore: " + store.getName());
                for (Employee employee : store.getEmployees()) {
                    System.out.println(" - " + employee.getFullName());
                }
            }
                
            scanner = new Scanner(System.in); 
            System.out.println("Please enter the search keyword to find matching employees: ");
            String searchKeyword = scanner.next(); 
            // Search for and print matching employees in all stores
            for (SuperStore store : superStores) {
                Set<Employee> matchedEmployees = store.searchEmployees(searchKeyword);
                if (!matchedEmployees.isEmpty()) {
                    System.out.println("Matching employees in store: " + store.getName());
                    for (Employee employee : matchedEmployees) {
                        System.out.println(" - " + employee.getFullName());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (JSONException e) {
            System.err.println("JSON Parsing error: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close(); 
            }
        }
    }
}