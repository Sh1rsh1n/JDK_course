package src.main.seminar_4.model.handbooks;

import java.util.List;



public abstract class Handbook<E>{
    
    protected List<E> handbooks;
    
    public Handbook(){
        handbooks = new ArrayList<>();
    }
    
    protected List<E> getHandbooks(){
        return handbooks;
    }
    
    protected void setHandbook(List<E> handbooks){
        this.handbooks = handbooks;
    }
}