package src.main.seminar_4.services;

import src.main.seminar_4.models.handbooks.Handbook;

public class HandbookService<E> {

    private Handbook<E> handbook;

    public HandbookService(Handbook<E> handbook){
        this.handbook = handbook;
    }
    
    public boolean add(E e) {
        return handbook.addElement(e);
    }

    public E getById(int id) {
        return handbook.getElementById(id);
    }
    
    public List<E> getAll() {
        return handbook.getAll();
    }
    
    public boolean remove(E e) {
        return handbook.remove(e);
    }
    
    public Handbook<E> getHandbook() {
        return handbook;
    }
}


