package src.main.seminar_4.handlers;

src.main.seminar_4.model.handbooks.Handbook;

public class EmployeeHandbookHandler implements HandbookHandler{

    private Handbook handbook;
    
    public EmployeeHandbookHandler(Handbook handbook) {
        this.handbook = handbook;
    }
    
    
}