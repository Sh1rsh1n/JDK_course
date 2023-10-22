package src.main.seminar_4.models.handbooks;


import java.util.List;
import java.util.ArrayList;

/**
 * абстрактный класс Справочник
 * имеет стандартные методы, CRUD операций
 * @param <E>
 */
public abstract class Handbook<E> {

    protected List<E> list;

    public Handbook() {
        list = new ArrayList<>();
    }

    public abstract boolean addElement(E element);
    
    public abstract boolean removeElement(E element);
    
    public abstract E getElementById(int id);

    public abstract List<E> getAll();
}