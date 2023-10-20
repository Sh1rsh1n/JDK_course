package src.main.seminar_4.model.handbooks;

import java.util.List;
import java.util.ArrayList;


public abstract class Handbook<E> {
    
    protected List<E> handbooks;
    
    public Handbook(){
        handbooks = new ArrayList<>();
    }
    
    protected List<E> getHandbooks(){
        return List.of(handbooks);
    }
    
    protected void setHandbook(List<E> handbooks){
        this.handbooks = handbooks;
    }
    
    protected boolean addElement(E element) {
        return handbooks.add(element);
    }
    
    protected boolean removeElement(E element) {
        return handbooks.removeIf(e -> e.equals(element));
    }
    
    protected E getElementById(int id){
        return handbooks.get(id);
    }
}