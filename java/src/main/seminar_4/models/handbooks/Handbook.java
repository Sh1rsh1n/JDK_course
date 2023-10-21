package src.main.seminar_4.models.handbooks;


import java.util.List;

public interface Handbook<E> {

    boolean addElement(E element);
    
    boolean removeElement(E element);
    
    E getElementById(int id);

    List<E> getAll();
}