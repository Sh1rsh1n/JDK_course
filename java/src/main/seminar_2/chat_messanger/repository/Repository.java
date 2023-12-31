package src.main.seminar_2.chat_messanger.repository;

import java.util.List;

/*
 * интерфейс репозиторий, предоставляет стандартные операции
 * обработки данных
 */
public interface Repository<T> {

  void add(T t);
  
  void remove(T t);
  
  T getByIndex(int index);
  
  List<T> getAll();
  
}