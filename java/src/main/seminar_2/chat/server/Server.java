

public class Server {

  private ServerGUI serverGUI;
  private Repository repository;
  private List<Client> clientList;
  private boolean work;

  public Server(){
    clientList = new ArrayList<>();

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(WIDTH, HEIGHT);
    setResizable(false);
    setTitle("Chat server");
    setLocationRelativeTo(null);

    createPanel();

    setVisible(true);
  }

    public boolean connectUser(Client client){
      if (!work){
          return false;
      }
      clientList.add(client);
      return true;
    }

    public String getHistory() {
        return readLog();
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
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
        for (Client client: clientList){}
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private void appendLog(String text){
        log.append(text + "\n");
    }

    
}
