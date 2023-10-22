package src.main.seminar_4.models.handbooks;


import src.main.seminar_4.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHandbook implements Handbook<Employee> {

    public EmployeeHandbook() {
        super();
    }

    @Override
    public boolean addElement(Employee employee) {
        return super.list.add(employee);
    }

    @Override
    public boolean removeElement(Employee employee) {
        return super.list.remove(employee);
    }

    @Override
    public Employee getElementById(int id) {
        return super.list.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return super.list;
    }
}