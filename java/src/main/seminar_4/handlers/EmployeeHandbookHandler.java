package src.main.seminar_4.handlers;

import src.main.seminar_4.model.handbooks.Handbook;
import src.main.seminar_4.models.Employee;

public class EmployeeHandbookHandler implements HandbookHandler{

    private src.main.seminar_4.models.handbooks.Handbook<E> handbook;
    
    public EmployeeHandbookHandler(Handbook handbook) {
        this.handbook = handbook;
    }
    
    public void addEmployee(Employee employee){
        handbook.getHandbooks().
    }
}