package src.main.seminar_4.services;

import src.main.seminar_4.models.Employee;
import src.main.seminar_4.models.handbooks.Handbook;
import java.util.List;
import java.util.ArrayList;

public class EmployeeHandbookService extends Service<Employee> implements ServiceUtils {

    public EmployeeHandbookService(Handbook<Employee> handbook){
        super(handbook);
    }
    
    @Override
    public List<Employee> findEmployeesByExperience(int experience) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : handbook.getAll()) {
            if (employee.getExperience() == experience) {
                list.add(employee);
            }
        }
        return list;
    }

    
    
}


