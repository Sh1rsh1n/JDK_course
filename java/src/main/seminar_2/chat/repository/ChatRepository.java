


public abstract class ChatRepository implements Repository {

  @Override
  public void saveMessage(String message);

  @Override
  public String getLastMessage();

  @Override
  public List<String> getAllMessages() {
    return null;
  }
}