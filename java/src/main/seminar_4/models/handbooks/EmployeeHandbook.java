package src.main.seminar_4.models.handbooks;


import src.main.seminar_4.models.Employee;

import java.util.List;
import java.util.Optional;

/**
 * Класс, справочник сотрудников
 */
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
        Optional<Employee> employee = list.stream().filter(e -> e.getTableNo() == id).findFirst();
        if (employee.isEmpty()) {
            throw new RuntimeException("Incorrect Employee TableNo");
        }
        return employee.get();
    }

    @Override
    public List<Employee> getAll() {
        return list;
    }
}