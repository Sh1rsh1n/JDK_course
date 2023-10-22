package src.main.seminar_4.services;

import src.main.seminar_4.models.handbooks.Handbook;
import java.util.List;

public class HandbookService extends Service<E> {

    public HandbookService(Handbook<E> handbook){
        super(handbook);
    }
    
    public List<E> findEmployeesByExperience(int experience) {
        List<Employee> list = new ArrayList<>();
        for (Employee employee : handbook.getAll()) {
            if (employee.getExperience() == experience) {
                list.add(employee);
            }
        }
        return list;
    }

    
    
}


