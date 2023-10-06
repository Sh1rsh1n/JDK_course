

public class Server {

  private ServerGUI serverGUI;
  private MessageRepository messageRepository;
  private ClientRepository clientRepository;
  private boolean work;

  public Server(ServerGUI serverGUI) {
  
    this.serverGUI = serverGUI;
    messageRepository = new TextFileRepository();
    clientRepository = new ClientRepository();
  }
  
  public ClientRepository getClientRepository(){
    return clientRepository;
  }
  
  public MessageRepository getMessageRepository(){
    return messageRepository;
  }

    public boolean connectUser(ClientGUI client){
      if (!work){
          return false;
      }
      clientRepository.add(client);
      return true;
    }

    public String getHistory() {
        return readLog();
    }

    public void disconnectUser(ClientGUI client){
        if (client != null){
          clientRepository.remove(client);
          client.disconnectFromServer();
        }
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void answerAll(String text){
        for (ClientGUI client: getClientRepository.getAll()){}
            client.answer(text);
        }
    }

    private void saveInLog(String text){
        messageRepository.add(text);
    }

    private String readLog(){
        StringBuilder sb = new StringBuilder();
        for (String str : messageRepository.getAll()) {
          sb.append(str);
        }
        return sb.toString();
    }
}