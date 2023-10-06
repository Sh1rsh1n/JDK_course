

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