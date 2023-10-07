package src.main.seminar_2.chat_messanger.repository;


import java.util.LinkedList;
import java.util.List;


/*
 * абстрактный класс ChatRepository, реализует интерфейс Repository
 */
public abstract class MessageRepository implements Repository<String> {

  protected List<String> listMessage;
  
  public MessageRepository(){
    listMessage = new LinkedList<>();
  }
  
  @Override
  public void add(String message){
    listMessage.add(message);
  }
  
  @Override
  public void remove(String message){
    listMessage.remove(message);
  }
  
  @Override
  public String getByIndex(int index) {
    return listMessage.get(index);
  }

  @Override
  public List<String> getAll(){
    return listMessage;
  }
  
}