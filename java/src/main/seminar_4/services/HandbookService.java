package src.main.seminar_4.services;

import src.main.seminar_4.models.handbooks.Handbook;

public class HandbookService<E> {

    private Handbook<E> handbook;

    public HandbookService(Handbook<E> handbook){
        this.handbook = handbook;
    }

    public Handbook<E> getHandbook() {
        return handbook;
    }
}


