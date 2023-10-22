package src.main.seminar_4.models.handbooks;


import src.main.seminar_4.models.Employee;

import java.util.List;

public class EmployeeHandbook extends Handbook<Employee> {

    public EmployeeHandbook() {
        super();
    }

    @Override
    public boolean addElement(Employee employee) {
        return list.add(employee);
    }

    @Override
    public boolean removeElement(Employee employee) {
        return list.remove(employee);
    }

    @Override
    public Employee getElementById(int id) {
        return list.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return list;
    }
}