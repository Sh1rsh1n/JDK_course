package src.main.seminar_4.handlers;

import src.main.seminar_4.model.handbooks.Handbook;
import src.main.seminar_4.models.Employee;

public class EmployeeHandbookHandler implements Handler{

    private Handbook<Employee> handbook;
    
    public EmployeeHandbookHandler(Handbook handbook) {
        this.handbook = handbook;
    }
    
    
}