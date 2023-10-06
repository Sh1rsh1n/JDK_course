

/*
 * абстрактный класс ChatRepository, реализует интерфейс Repository
 */
public abstract class MessageRepository implements Repository<String> {

  protected List<String> listMessage;
  
  public ChatRepository(){
    listMessage = new ArrayList<>();
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