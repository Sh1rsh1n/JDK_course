package src.main.seminar_4.services;

import src.main.seminar_4.models.handbooks.Handbook;
import java.util.List;

/**
 * интерфейс Справочник Сервис,
 * имеет описание стандартных методов обращения к справочнику
 * @param <E>
 */
public interface HandbookService<E> {

    boolean add(E e);

    E getById(int id);
    
    List<E> getAll();
    
    boolean remove(E e);
    
    Handbook<E> getHandbook();
}


