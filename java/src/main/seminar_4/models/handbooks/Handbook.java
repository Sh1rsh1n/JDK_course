package src.main.seminar_4.model.handbooks;

import java.util.List;
import java.util.ArrayList;


public abstract class Handbook<E> {
    
    protected List<E> handbooks;
    
    public Handbook(){
        handbooks = new ArrayList<>();
    }
    
    public List<E> getHandbooks(){
        return handbooks;
    }
    
    public void setHandbook(List<E> handbooks){
        this.handbooks = handbooks;
    }
}