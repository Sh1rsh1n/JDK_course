package src.main.seminar_4.models.handbooks;


import src.main.seminar_4.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHandbook implements Handbook<Employee> {

    private final List<Employee> employees;

    public EmployeeHandbook() {
        employees = new ArrayList<>();
    }

    @Override
    public boolean addElement(Employee employee) {
        return employees.add(employee);
    }

    @Override
    public boolean removeElement(Employee employee) {
        return false;
    }

    @Override
    public Employee getElementById(int id) {
        return employees.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }
}