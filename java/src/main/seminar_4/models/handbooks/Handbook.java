package src.main.seminar_4.models.handbooks;


import java.util.List;

public abstract class Handbook<E> {

    private final List<E> list;

    public Handbook() {
        list = new ArrayList<>();
    }

    public abstract boolean addElement(E element);
    
    public abstract boolean removeElement(E element);
    
    public abstract E getElementById(int id);

    public abstract List<E> getAll();
}