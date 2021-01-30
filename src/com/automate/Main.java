package com.automate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int identifier=1;
    private static final Scanner sc= new Scanner(System.in);
    private static final List<Employee> employees=new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            int userChoice =getAskUserChoice();
            processUserChoice(userChoice);


        }
    }

    private static int getAskUserChoice() {
        System.out.println("1.Add an Employee");
        System.out.println("2.Update Employee");
        System.out.println("3.Delete Employee");
        System.out.println("4.List Employee ");
        System.out.println("Enter your choice");
        return sc.nextInt();
    }

    private static void processUserChoice(int userChoice) {
        switch (userChoice){
            case 1:
                    final Employee employee = createEmployee();
                    employees.add(employee);
                    employee.displayInrotmation();
                    break;
            case 2:
                System.out.println("Which employee need to be updated");
                updateEmployee(sc.nextInt());
                break;
            case 3:
                System.out.println("Enter employee id to delete!");
                int employeeId=sc.nextInt();
                deleteEmployeeById(employeeId);
                break;
            case 4:
                listEmployee();
                break;
        }
    }

    private static void updateEmployee(int employeeId) {
        System.out.println("Enter the updated information with employee id");
        final String name = takeName();
        final int salary = takeSalary();
        final int age = takeAge();
        for (int i=0;i<employees.size();i++){
            if (employees.get(i).getUniqueIdentifier()==employeeId){
                employees.get(i).update(name,salary,age);
                break;
            }
        }
    }

    private static Employee createEmployee(){
        System.out.println("Provide Employee details");
        final String name = takeName();
        final int salary = takeSalary();
        final int age = takeAge();
        Employee employee = createEmployeeObject(name, salary, age);
        return employee;
    }

    private static Employee createEmployeeObject(String name, int salary,int age){
        return new Employee(name,salary, identifier++,age);
    }

   static void deleteEmployeeById(int employeeId){
        for (int i=0;i<employees.size();i++){
           if (employees.get(i).getUniqueIdentifier()==employeeId){
               employees.remove(i);
               System.out.println("Employee with id: "+employeeId+"is deleted");
               break;
           }
        }
    }

    private static void listEmployee() {
        for (Employee e:employees)
            e.displayInrotmation();
    }

    private static String takeName(){
        System.out.println("Name:");
        return sc.next();
    }

    private static int takeSalary(){
        System.out.println("Salary:");
        return sc.nextInt();
    }

    private static int takeAge(){
        System.out.println("Age:");
        return sc.nextInt();
    }
}
